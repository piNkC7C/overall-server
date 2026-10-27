package cn.iocoder.yudao.module.pay.controller.admin.refund.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - refund details response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayRefundDetailsRespVO extends PayRefundBaseVO {

    @Schema(description = "Payment refund code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is Overall.")
    private String appName;

    @Schema(description = "Payment.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Order order;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Update time.")
    private LocalDateTime updateTime;

    @Schema(description = "Admin - payment.")
    @Data
    public static class Order {

        @Schema(description = "Product title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
        private String subject;

    }

}
