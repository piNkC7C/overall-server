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

    @Schema(description = "应用编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "App code is required.")
    private Long appId;

    @Schema(description = "渠道编号", example = "2048")
    private Long channelId;

    @Schema(description = "渠道编码", example = "wx_app")
    private String channelCode;

    @Schema(description = "商户订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @NotNull(message = "Merchant order number cannot be empty.")
    private String merchantOrderId;

    @Schema(description = "商品标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    @NotNull(message = "Product title is required.")
    private String subject;

    @Schema(description = "商品描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is potato.")
    @NotNull(message = "ProductDescription is required.")
    private String body;

    @Schema(description = "异步通知地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "http://127.0.0.1:48080/pay/notify")
    @NotNull(message = "AsyncnotificationAddress is required.")
    private String notifyUrl;

    @Schema(description = "支付金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Payment amount, order characters ：Min is required.")
    private Long price;

    @Schema(description = "渠道手续费，单位：百分比", example = "10")
    private Double channelFeeRate;

    @Schema(description = "渠道手续金额，单位：分", example = "100")
    private Integer channelFeePrice;

    @Schema(description = "支付状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Payment status is required.")
    private Integer status;

    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotNull(message = "User IP is required.")
    private String userIp;

    @Schema(description = "订单失效时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Order expired time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime expireTime;

    @Schema(description = "订单支付成功时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime successTime;

    @Schema(description = "支付成功的订单拓展单编号", example = "50")
    private Long extensionId;

    @Schema(description = "支付订单号", example = "2048888")
    private String no;

    @Schema(description = "退款总金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Refund total, in cents cannot be empty.")
    private Long refundPrice;

    @Schema(description = "渠道用户编号", example = "2048")
    private String channelUserId;

    @Schema(description = "渠道订单号", example = "4096")
    private String channelOrderNo;

}
