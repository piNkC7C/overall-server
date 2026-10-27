package cn.iocoder.yudao.module.im.controller.admin.message;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.channel.ImChannelMessagePullRespVO;
import cn.iocoder.yudao.module.im.dal.dataobject.message.ImChannelMessageDO;
import cn.iocoder.yudao.module.im.enums.message.ImMessageReceiptStatusEnum;
import cn.iocoder.yudao.module.im.service.message.ImChannelMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils.getLoginUserId;

@Tag(name = "User APP - IM Channelmessage.")
@RestController
@RequestMapping("/im/channel/message")
@Validated
public class ImChannelMessageController {

    @Resource
    private ImChannelMessageService channelMessageService;

    @GetMapping("/pull")
    @Operation(summary = "Fetch channel messages incrementally. Page by minId cursor.")
    public CommonResult<List<ImChannelMessagePullRespVO>> pullChannelMessageList(
            @RequestParam(value = "minId", defaultValue = "0") @PositiveOrZero(message = "MinId cannot be less than 0.") Long minId,
            @RequestParam(value = "size", defaultValue = "100")
            @Min(value = 1, message = "Size must be greater than 0.")
            @Max(value = 200, message = "Size cannot exceed 200 items.") Integer size) {
        // 1. 拉取消息列表
        Long userId = getLoginUserId();
        List<ImChannelMessageDO> list = channelMessageService.pullChannelMessageList(userId, minId, size);
        if (CollUtil.isEmpty(list)) {
            return success(Collections.emptyList());
        }
        // 2. 按已读游标补 receiptStatus（已读 DONE / 未读 PENDING）
        Map<Long, Long> readMaxByChannel = channelMessageService.getChannelReadMaxMessageIdMap(
                userId, convertSet(list, ImChannelMessageDO::getChannelId));
        return success(BeanUtils.toBean(list, ImChannelMessagePullRespVO.class, vo -> {
            Long readMax = readMaxByChannel.get(vo.getChannelId());
            vo.setReceiptStatus(readMax != null && readMax >= vo.getId()
                    ? ImMessageReceiptStatusEnum.DONE.getStatus()
                    : ImMessageReceiptStatusEnum.PENDING.getStatus());
        }));
    }

    @PutMapping("/read")
    @Operation(summary = "MarkChannelmessageRead.")
    @Parameter(name = "channelId", description = "Channel ID", required = true, example = "1")
    @Parameter(name = "messageId", description = "Read to message code.", required = true, example = "100")
    public CommonResult<Boolean> readChannelMessages(@RequestParam("channelId") Long channelId,
                                                     @RequestParam("messageId") Long messageId) {
        channelMessageService.readChannelMessages(getLoginUserId(), channelId, messageId);
        return success(true);
    }

}
