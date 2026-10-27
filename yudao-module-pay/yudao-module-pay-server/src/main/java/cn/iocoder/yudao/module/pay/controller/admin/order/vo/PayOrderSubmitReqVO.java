package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "Admin - payment submit request.")
@Data
public class PayOrderSubmitReqVO {

    @Schema(description = "Payment order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Payment order code is required.")
    private Long id;

    @Schema(description = "Payment channel.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx_pub")
    @NotEmpty(message = "Payment channel is required.")
    private String channelCode;

    @Schema(description = "Payment channel extra params, for example, WeChat official account must pass openid parameter.")
    private Map<String, String> channelExtras;

    @Schema(description = "Display mode.", example = "url") // 参见 {@link PayDisplayModeEnum} 枚举。如果不传递，则每个支付渠道使用默认的方式
    private String displayMode;

    @Schema(description = "Return URL.")
    @URL(message = "Return URL must be a valid URL.")
    private String returnUrl;

}
