package cn.iocoder.yudao.module.im.controller.admin.conversation;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.conversation.vo.ImConversationReadRespVO;
import cn.iocoder.yudao.module.im.dal.dataobject.conversation.ImConversationReadDO;
import cn.iocoder.yudao.module.im.service.conversation.ImConversationReadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - IM conversation read position.")
@RestController
@RequestMapping("/im/conversation-read")
@Validated
public class ImConversationReadController {

    @Resource
    private ImConversationReadService conversationReadService;

    @GetMapping("/pull")
    @Operation(summary = "Incrementally fetch the current user's conversation read positions (reconnect / offline catch-up).")
    @Parameters({
            @Parameter(name = "lastUpdateTime", description = "Last update time in ms. Omit on the first fetch."),
            @Parameter(name = "lastId", description = "Last record ID. Omit on the first fetch."),
            @Parameter(name = "limit", description = "Page size.", required = true)
    })
    public CommonResult<List<ImConversationReadRespVO>> pullMyConversationRead(
            @RequestParam(value = "lastUpdateTime", required = false) Long lastUpdateTime,
            @RequestParam(value = "lastId", required = false) Long lastId,
            @RequestParam("limit") @Min(1) @Max(200) Integer limit) {
        List<ImConversationReadDO> list = conversationReadService.pullConversationReadList(
                getLoginUserId(), lastUpdateTime, lastId, limit);
        return success(BeanUtils.toBean(list, ImConversationReadRespVO.class));
    }

}
