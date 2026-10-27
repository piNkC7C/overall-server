package cn.iocoder.yudao.module.pay.framework.pay.core.client.dto.refund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 统一 退款 Request DTO
 *
 * @author jason
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayRefundUnifiedReqDTO {

    /**
     * 外部订单号
     *
     * 对应 PayOrderExtensionDO 的 no 字段
     */
    @NotEmpty(message = "External order number cannot be empty.")
    private String outTradeNo;

    /**
     * 外部退款号
     *
     * 对应 PayRefundDO 的 no 字段
     */
    @NotEmpty(message = "Refund request number cannot be empty.")
    private String outRefundNo;

    /**
     * 退款原因
     */
    @NotEmpty(message = "Refund reason is required.")
    private String reason;

    /**
     * 支付金额，单位：分
     *
     * 目前微信支付在退款的时候，必须传递该字段
     */
    @NotNull(message = "Payment amount is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Payment amount must be greater than 0.")
    private Integer payPrice;
    /**
     * 退款金额，单位：分
     */
    @NotNull(message = "Refund amount is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Payment amount must be greater than 0.")
    private Integer refundPrice;

    /**
     * 退款结果的 notify 回调地址
     */
    @NotEmpty(message = "Payment callback URL cannot be empty.")
    @URL(message = "Payment notify URL must be a valid URL.")
    private String notifyUrl;

}
