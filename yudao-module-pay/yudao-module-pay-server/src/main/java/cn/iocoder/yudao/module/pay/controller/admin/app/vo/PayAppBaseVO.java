package cn.iocoder.yudao.module.pay.controller.admin.app.vo;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.*;

/**
* 支付应用信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PayAppBaseVO {

    @Schema(description = "App key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotEmpty(message = "App key is required.")
    private String appKey;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bean")
    @NotNull(message = "App name is required.")
    private String name;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Enable status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Notes.", example = "I am a test app")
    private String remark;

    @Schema(description = "Payment callback URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "http://127.0.0.1:48080/pay-callback")
    @NotNull(message = "Payment callback URL cannot be empty.")
    @URL(message = "Payment callback URL must be a valid URL.")
    private String orderNotifyUrl;

    @Schema(description = "Refund callback URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "http://127.0.0.1:48080/refund-callback")
    @NotNull(message = "Refund callback URL cannot be empty.")
    @URL(message = "Refund callback URL must be a valid URL.")
    private String refundNotifyUrl;

    @Schema(description = "Transfer callback URL.", example = "http://127.0.0.1:48080/transfer-callback")
    @URL(message = "Transfer callback URL must be a valid URL.")
    private String transferNotifyUrl;

}
