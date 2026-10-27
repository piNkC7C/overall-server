package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Payment detail info response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayOrderDetailsRespVO extends PayOrderBaseVO {

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String appName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

    /**
     * 支付订单扩展
     */
    private PayOrderExtension extension;

    @Data
    @Schema(description = "Payment extension.")
    public static class PayOrderExtension {

        @Schema(description = "Payment no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private String no;

        @Schema(description = "Payment Asyncnotification content.")
        private String channelNotifyData;

    }

}
