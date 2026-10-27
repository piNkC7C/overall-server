package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.recharge;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import java.util.Objects;

@Schema(description = "User APP - createwallet top-up request.")
@Data
public class AppPayWalletRechargeCreateReqVO {

    @Schema(description = "Payment amount.",  example = "1000")
    @Min(value = 1,  message = "Payment amount must be greater than 0.")
    private Integer payPrice;

    @Schema(description = "Top-up Plan ID.", example = "1024")
    private Long packageId;

    @AssertTrue(message = "Top-up amount and package cannot both be empty.")
    public boolean isValidPayPriceAndPackageId() {
        return Objects.nonNull(payPrice) || Objects.nonNull(packageId);
    }

}
