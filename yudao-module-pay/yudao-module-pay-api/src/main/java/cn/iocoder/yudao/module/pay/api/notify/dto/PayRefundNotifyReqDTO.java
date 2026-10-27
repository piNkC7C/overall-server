package cn.iocoder.yudao.module.pay.api.notify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 退款单的通知 Request DTO
 *
 * @author 芋道源码
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayRefundNotifyReqDTO {

    /**
     * 商户退款单编号
     */
    @NotEmpty(message = "Merchant refund number cannot be empty.")
    private String merchantOrderId;

    /**
     * 商户退款编号
     */
    @NotEmpty(message = "Merchant refund number cannot be empty.")
    private String merchantRefundId;

    /**
     * 支付退款编号
     */
    @NotNull(message = "Payment refund code is required.")
    private Long payRefundId;

}
