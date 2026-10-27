package cn.iocoder.yudao.module.system.api.sms;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeValidateReqDTO;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - SMS Verification code.")
public interface SmsCodeApi {

    String PREFIX = ApiConstants.PREFIX + "/oauth2/sms/code";

    @PostMapping(PREFIX + "/send")
    @Operation(summary = "Create SMS Verification code, and send.")
    CommonResult<Boolean> sendSmsCode(@Valid @RequestBody SmsCodeSendReqDTO reqDTO);

    @PutMapping(PREFIX + "/use")
    @Operation(summary = "Verify SMS Verification code, and used.")
    CommonResult<Boolean> useSmsCode(@Valid @RequestBody SmsCodeUseReqDTO reqDTO);

    @GetMapping(PREFIX + "/validate")
    @Operation(summary = "Check verification code is valid.")
    CommonResult<Boolean> validateSmsCode(@Valid @RequestBody SmsCodeValidateReqDTO reqDTO);

}
