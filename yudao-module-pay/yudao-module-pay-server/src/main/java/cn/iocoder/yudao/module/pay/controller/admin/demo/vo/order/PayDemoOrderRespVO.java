package cn.iocoder.yudao.module.pay.controller.admin.demo.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
* 示例订单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PayDemoOrderRespVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23199")
    private Long userId;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17682")
    private Long spuId;

    @Schema(description = "Merchant notes.", example = "Jane.")
    private String spuName;

    @Schema(description = "Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30381")
    private Integer price;

    @Schema(description = "Is not already payment.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean payStatus;

    @Schema(description = "Payment code.", example = "16863")
    private Long payOrderId;

    @Schema(description = "Order payment time.")
    private LocalDateTime payTime;

    @Schema(description = "Payment channel.", example = "alipay_qr")
    private String payChannelCode;

    @Schema(description = "Payment refund code.", example = "23366")
    private Long payRefundId;

    @Schema(description = "Refund amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "14039")
    private Integer refundPrice;

    @Schema(description = "Refund time.")
    private LocalDateTime refundTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
