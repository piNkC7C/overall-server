package cn.iocoder.yudao.module.system.api.sms.dto.code;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "RPC service - SMS Verification code send Request DTO.")
@Data
public class SmsCodeSendReqDTO {

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @Mobile
    @NotEmpty(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "Send scene", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Send scene is required")
    @InEnum(SmsSceneEnum.class)

    private Integer scene;
    @Schema(description = "Send IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.20.30.40")
    @NotEmpty(message = "Send IP is required.")
    private String createIp;

}
