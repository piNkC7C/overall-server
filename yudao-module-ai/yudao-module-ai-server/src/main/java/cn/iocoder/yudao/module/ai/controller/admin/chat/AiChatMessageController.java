package cn.iocoder.yudao.module.ai.controller.admin.chat;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message.AiChatMessagePageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message.AiChatMessageRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message.AiChatMessageSendReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message.AiChatMessageSendRespVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.chat.AiChatConversationDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.chat.AiChatMessageDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledge.AiKnowledgeDocumentDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledge.AiKnowledgeSegmentDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiChatRoleDO;
import cn.iocoder.yudao.module.ai.service.chat.AiChatConversationService;
import cn.iocoder.yudao.module.ai.service.chat.AiChatMessageService;
import cn.iocoder.yudao.module.ai.service.knowledge.AiKnowledgeDocumentService;
import cn.iocoder.yudao.module.ai.service.knowledge.AiKnowledgeSegmentService;
import cn.iocoder.yudao.module.ai.service.model.AiChatRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - chat message.")
@RestController
@RequestMapping("/ai/chat/message")
@Slf4j
public class AiChatMessageController {

    @Resource
    private AiChatMessageService chatMessageService;
    @Resource
    private AiChatConversationService chatConversationService;
    @Resource
    private AiChatRoleService chatRoleService;
    @Resource
    private AiKnowledgeSegmentService knowledgeSegmentService;
    @Resource
    private AiKnowledgeDocumentService knowledgeDocumentService;

    @Operation(summary = "Send a message (segmented).", description = "Returns in one response. May be slow.")
    @PostMapping("/send")
    public CommonResult<AiChatMessageSendRespVO> sendMessage(@Valid @RequestBody AiChatMessageSendReqVO sendReqVO) {
        return success(chatMessageService.sendMessage(sendReqVO, getLoginUserId()));
    }

    @Operation(summary = "Send a message (streaming).", description = "Streaming response.")
    @PostMapping(value = "/send-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CommonResult<AiChatMessageSendRespVO>> sendChatMessageStream(@Valid @RequestBody AiChatMessageSendReqVO sendReqVO) {
        return chatMessageService.sendChatMessageStream(sendReqVO, getLoginUserId());
    }

    @Operation(summary = "Get specified conversation message list.")
    @GetMapping("/list-by-conversation-id")
    @Parameter(name = "conversationId", required = true, description = "Conversation ID.", example = "1024")
    public CommonResult<List<AiChatMessageRespVO>> getChatMessageListByConversationId(
            @RequestParam("conversationId") Long conversationId) {
        AiChatConversationDO conversation = chatConversationService.getChatConversation(conversationId);
        if (conversation == null || ObjUtil.notEqual(conversation.getUserId(), getLoginUserId())) {
            return success(Collections.emptyList());
        }
        // 1. get message list
        List<AiChatMessageDO> messageList = chatMessageService.getChatMessageListByConversationId(conversationId);
        if (CollUtil.isEmpty(messageList)) {
            return success(Collections.emptyList());
        }

        // 2. 拼接数据，主要是知识库段落信息
        Map<Long, AiKnowledgeSegmentDO> segmentMap = knowledgeSegmentService.getKnowledgeSegmentMap(convertListByFlatMap(messageList,
                message -> CollUtil.isEmpty(message.getSegmentIds()) ? null : message.getSegmentIds().stream()));
        Map<Long, AiKnowledgeDocumentDO> documentMap = knowledgeDocumentService.getKnowledgeDocumentMap(
                convertList(segmentMap.values(), AiKnowledgeSegmentDO::getDocumentId));
        List<AiChatMessageRespVO> messageVOList = BeanUtils.toBean(messageList, AiChatMessageRespVO.class);
        for (int i = 0; i < messageList.size(); i++) {
            AiChatMessageDO message = messageList.get(i);
            if (CollUtil.isEmpty(message.getSegmentIds())) {
                continue;
            }
            // 设置知识库段落信息
            messageVOList.get(i).setSegments(convertList(message.getSegmentIds(), segmentId -> {
                AiKnowledgeSegmentDO segment = segmentMap.get(segmentId);
                if (segment == null) {
                    return null;
                }
                AiKnowledgeDocumentDO document = documentMap.get(segment.getDocumentId());
                if (document == null) {
                    return null;
                }
                return new AiChatMessageRespVO.KnowledgeSegment().setId(segment.getId()).setContent(segment.getContent())
                        .setDocumentId(segment.getDocumentId()).setDocumentName(document.getName());
            }));
        }
        return success(messageVOList);
    }

    @Operation(summary = "Deletemessage.")
    @DeleteMapping("/delete")
    @Parameter(name = "id", required = true, description = "Message code.", example = "1024")
    public CommonResult<Boolean> deleteChatMessage(@RequestParam("id") Long id) {
        chatMessageService.deleteChatMessage(id, getLoginUserId());
        return success(true);
    }

    @Operation(summary = "Delete specified conversation message.")
    @DeleteMapping("/delete-by-conversation-id")
    @Parameter(name = "conversationId", required = true, description = "Conversation ID.", example = "1024")
    public CommonResult<Boolean> deleteChatMessageByConversationId(@RequestParam("conversationId") Long conversationId) {
        chatMessageService.deleteChatMessageByConversationId(conversationId, getLoginUserId());
        return success(true);
    }

    // ========== 对话管理 ==========

    @GetMapping("/page")
    @Operation(summary = "Get message page.", description = "Used by the Conversation menu.")
    @PreAuthorize("@ss.hasPermission('ai:chat-message:query')")
    public CommonResult<PageResult<AiChatMessageRespVO>> getChatMessagePage(AiChatMessagePageReqVO pageReqVO) {
        PageResult<AiChatMessageDO> pageResult = chatMessageService.getChatMessagePage(pageReqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }
        // 拼接数据
        Map<Long, AiChatRoleDO> roleMap = chatRoleService.getChatRoleMap(
                convertSet(pageResult.getList(), AiChatMessageDO::getRoleId));
        return success(BeanUtils.toBean(pageResult, AiChatMessageRespVO.class,
                respVO -> MapUtils.findAndThen(roleMap, respVO.getRoleId(),
                        role -> respVO.setRoleName(role.getName()))));
    }

    @GetMapping("/get")
    @Operation(summary = "Get message.", description = "Used by the Conversation menu.")
    @Parameter(name = "id", required = true, description = "Message code.", example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:chat-message:query')")
    public CommonResult<AiChatMessageRespVO> getChatMessage(@RequestParam("id") Long id) {
        AiChatMessageDO message = chatMessageService.getChatMessage(id);
        AiChatMessageRespVO respVO = BeanUtils.toBean(message, AiChatMessageRespVO.class);
        if (respVO != null && respVO.getRoleId() != null) {
            AiChatRoleDO role = chatRoleService.getChatRole(respVO.getRoleId());
            respVO.setRoleName(role != null ? role.getName() : null);
        }
        return success(respVO);
    }

    @Operation(summary = "Admindeletemessage.")
    @DeleteMapping("/delete-by-admin")
    @Parameter(name = "id", required = true, description = "Message code.", example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:chat-message:delete')")
    public CommonResult<Boolean> deleteChatMessageByAdmin(@RequestParam("id") Long id) {
        chatMessageService.deleteChatMessageByAdmin(id);
        return success(true);
    }

}
