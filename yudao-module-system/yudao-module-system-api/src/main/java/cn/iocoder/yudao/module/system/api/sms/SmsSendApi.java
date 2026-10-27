package cn.iocoder.yudao.module.system.api.sms;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - SMS send.")
public interface SmsSendApi {

    String PREFIX = ApiConstants.PREFIX + "/sms/send";

    @PostMapping(PREFIX + "/send-single-admin")
    @Operation(summary = "Send one SMS to Admin user.", description = "In mobile is empty time, used userId Loading matching Admin phone number.")
    CommonResult<Long> sendSingleSmsToAdmin(@Valid @RequestBody SmsSendSingleToUserReqDTO reqDTO);

    @PostMapping(PREFIX + "/send-single-member")
    @Operation(summary = "Send one SMS to Member user.", description = "In mobile is empty time, used userId Loading matching Member phone number.")
    CommonResult<Long> sendSingleSmsToMember(@Valid @RequestBody SmsSendSingleToUserReqDTO reqDTO);

}
