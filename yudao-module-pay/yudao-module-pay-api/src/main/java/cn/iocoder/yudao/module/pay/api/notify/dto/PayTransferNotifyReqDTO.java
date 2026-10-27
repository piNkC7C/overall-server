package cn.iocoder.yudao.module.pay.api.notify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 转账单的通知 Request DTO
 *
 * @author jason
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayTransferNotifyReqDTO {

    /**
     * 商户转账单号
     */
    @NotEmpty(message = "Merchant transfer number cannot be empty.")
    private String merchantTransferId;

    /**
     * 转账订单编号
     */
    @NotNull(message = "Transfer code is required.")
    private Long payTransferId;

}
