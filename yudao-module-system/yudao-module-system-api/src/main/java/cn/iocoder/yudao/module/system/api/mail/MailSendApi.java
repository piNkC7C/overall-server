package cn.iocoder.yudao.module.system.api.mail;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.mail.dto.MailSendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - email send.")
public interface MailSendApi {

    String PREFIX = ApiConstants.PREFIX + "/mail/send";

    @PostMapping(PREFIX + "/send-single-admin")
    @Operation(summary = "Send one email to Admin user.", description = "In mail is empty time, used userId Loading matching Admin email.")
    CommonResult<Long> sendSingleMailToAdmin(@Valid @RequestBody MailSendSingleToUserReqDTO reqDTO);

    @PostMapping(PREFIX + "/send-single-member")
    @Operation(summary = "Send one email to Member user.", description = "In mail is empty time, used userId Loading matching Member email.")
    CommonResult<Long> sendSingleMailToMember(@Valid @RequestBody MailSendSingleToUserReqDTO reqDTO);

}
