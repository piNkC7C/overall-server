package cn.iocoder.yudao.module.pay.controller.admin.order.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 支付订单 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author aquan
 */
@Data
public class PayOrderBaseVO {

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "App code is required.")
    private Long appId;

    @Schema(description = "Channel code.", example = "2048")
    private Long channelId;

    @Schema(description = "Channel code.", example = "wx_app")
    private String channelCode;

    @Schema(description = "Merchant order number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @NotNull(message = "Merchant order number cannot be empty.")
    private String merchantOrderId;

    @Schema(description = "Product title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    @NotNull(message = "Product title is required.")
    private String subject;

    @Schema(description = "ProductDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is potato.")
    @NotNull(message = "ProductDescription is required.")
    private String body;

    @Schema(description = "AsyncnotificationAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "http://127.0.0.1:48080/pay/notify")
    @NotNull(message = "AsyncnotificationAddress is required.")
    private String notifyUrl;

    @Schema(description = "Payment amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Payment amount, order characters ：Min is required.")
    private Long price;

    @Schema(description = "Channel handling fee in percent.", example = "10")
    private Double channelFeeRate;

    @Schema(description = "Channel expense amount, unit: cents.", example = "100")
    private Integer channelFeePrice;

    @Schema(description = "Payment status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Payment status is required.")
    private Integer status;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotNull(message = "User IP is required.")
    private String userIp;

    @Schema(description = "Order expired time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Order expired time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime expireTime;

    @Schema(description = "Order payment succeeded time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime successTime;

    @Schema(description = "Successful-payment extension order ID.", example = "50")
    private Long extensionId;

    @Schema(description = "Payment no.", example = "2048888")
    private String no;

    @Schema(description = "Refund Total amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Refund total, in cents cannot be empty.")
    private Long refundPrice;

    @Schema(description = "Channel user ID.", example = "2048")
    private String channelUserId;

    @Schema(description = "Channelorder no.", example = "4096")
    private String channelOrderNo;

}
