package cn.iocoder.yudao.module.assistant.controller.admin.message;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.config.SecurityProperties;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantDecisionReqVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageRespVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageSendReqVO;
import cn.iocoder.yudao.module.assistant.service.message.AssistantMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - AI 助手消息")
@RestController
@RequestMapping("/assistant/message")
@Validated
public class AssistantMessageController {

    @Resource
    private AssistantMessageService messageService;
    @Resource
    private SecurityProperties securityProperties;

    @GetMapping("/my-list")
    @Operation(summary = "获得我的对话消息列表")
    @Parameter(name = "conversationId", description = "对话编号", required = true, example = "1024")
    public CommonResult<List<AssistantMessageRespVO>> getMyList(@RequestParam("conversationId") Long conversationId) {
        return success(messageService.getMyList(conversationId, getLoginUserId()));
    }

    @PostMapping("/stop-my")
    @Operation(summary = "停止我正在生成的回复")
    @Parameter(name = "conversationId", description = "对话编号", required = true, example = "1024")
    public CommonResult<Boolean> stopMy(@RequestParam("conversationId") Long conversationId) {
        messageService.stopMy(conversationId, getLoginUserId());
        return success(true);
    }

    @PostMapping(value = "/send-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "发送消息（流式）", description = "后端转发算法 messages，事件含 thinking/content/tool_*/approval_required/done/error")
    public SseEmitter sendStream(@Valid @RequestBody AssistantMessageSendReqVO reqVO,
                                 HttpServletRequest request, HttpServletResponse response) {
        prepareSse(response);
        return messageService.sendStream(reqVO, getLoginUserId(), resolveAccessToken(request), reqVO.getLanguage());
    }

    @PostMapping(value = "/decision-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "确认/拒绝写操作（流式）", description = "后端转发算法 decision")
    public SseEmitter decisionStream(@Valid @RequestBody AssistantDecisionReqVO reqVO,
                                     HttpServletRequest request, HttpServletResponse response) {
        prepareSse(response);
        return messageService.decisionStream(reqVO, getLoginUserId(), resolveAccessToken(request), reqVO.getLanguage());
    }

    private void prepareSse(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-transform");
        response.setHeader("X-Accel-Buffering", "no");
    }

    private String resolveAccessToken(HttpServletRequest request) {
        return SecurityFrameworkUtils.obtainAuthorization(request,
                securityProperties.getTokenHeader(), securityProperties.getTokenParameter());
    }

}
