package cn.iocoder.yudao.module.pay.controller.admin.refund.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
* 退款订单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PayRefundBaseVO {

    @Schema(description = "External refund no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "110")
    private String no;

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long appId;

    @Schema(description = "Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long channelId;

    @Schema(description = "Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx_app")
    private String channelCode;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderId;

    // ========== 商户相关字段 ==========

    @Schema(description = "Merchant order number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "225")
    private String merchantOrderId;

    @Schema(description = "Merchant refund no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "512")
    private String merchantRefundId;

    @Schema(description = "AsyncnotificationAddress.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String notifyUrl;

    // ========== 退款相关字段 ==========

    @Schema(description = "Refund status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Payment amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long payPrice;

    @Schema(description = "Refund amount, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Long refundPrice;

    @Schema(description = "Refund reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I want a return")
    private String reason;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

    // ========== 渠道相关字段 ==========

    @Schema(description = "Channelorder no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "233")
    private String channelOrderNo;

    @Schema(description = "Channelrefund no.", example = "2022")
    private String channelRefundNo;

    @Schema(description = "Refund succeeded time.")
    private LocalDateTime successTime;

    @Schema(description = "Channel error code.")
    private String channelErrorCode;

    @Schema(description = "Call channel ErrorTip.")
    private String channelErrorMsg;

    @Schema(description = "Payment channel extra params.")
    private String channelNotifyData;

}
