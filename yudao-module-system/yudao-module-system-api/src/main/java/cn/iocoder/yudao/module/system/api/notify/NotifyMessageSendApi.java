package cn.iocoder.yudao.module.system.api.notify;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - inbox message send.")
public interface NotifyMessageSendApi {

    String PREFIX = ApiConstants.PREFIX + "/notify/send";

    @PostMapping(PREFIX + "/send-single-admin")
    @Operation(summary = "Send one inbox message to Admin user.")
    CommonResult<Long> sendSingleMessageToAdmin(@Valid @RequestBody NotifySendSingleToUserReqDTO reqDTO);

    @PostMapping(PREFIX + "/send-single-member")
    @Operation(summary = "Send one inbox message to Member user.")
    CommonResult<Long> sendSingleMessageToMember(@Valid @RequestBody NotifySendSingleToUserReqDTO reqDTO);

}
