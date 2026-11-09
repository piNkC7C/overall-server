package cn.iocoder.yudao.module.system.controller.admin.sms.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 短信渠道创建/修改 Request VO")
@Data
public class SmsChannelSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "短信签名", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "SMS signature is required.")
    private String signature;

    @Schema(description = "渠道编码，参见 SmsChannelEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN")
    @NotNull(message = "Channel code is required.")
    private String code;

    @Schema(description = "启用状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enabled status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Tasty!")
    private String remark;

    @Schema(description = "短信 API 的账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "SMS API account is required.")
    private String apiKey;

    @Schema(description = "短信 API 的密钥", example = "yuanma")
    private String apiSecret;

    @Schema(description = "短信发送回调 URL", example = "http://www.iocoder.cn")
    @URL(message = "Callback URL format is invalid.")
    private String callbackUrl;

}
