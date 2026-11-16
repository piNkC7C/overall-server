package cn.iocoder.yudao.module.assistant.controller.admin.conversation;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.assistant.controller.admin.conversation.vo.AssistantConversationRespVO;
import cn.iocoder.yudao.module.assistant.service.conversation.AssistantConversationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - AI 助手对话")
@RestController
@RequestMapping("/assistant/conversation")
@Validated
public class AssistantConversationController {

    @Resource
    private AssistantConversationService conversationService;

    @GetMapping("/my-list")
    @Operation(summary = "获得我的对话列表")
    public CommonResult<List<AssistantConversationRespVO>> getMyList() {
        return success(BeanUtils.toBean(conversationService.getMyList(getLoginUserId()), AssistantConversationRespVO.class));
    }

    @DeleteMapping("/delete-my")
    @Operation(summary = "删除我的对话")
    @Parameter(name = "id", description = "对话编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteMy(@RequestParam("id") Long id) {
        conversationService.deleteMy(id, getLoginUserId());
        return success(true);
    }

}
