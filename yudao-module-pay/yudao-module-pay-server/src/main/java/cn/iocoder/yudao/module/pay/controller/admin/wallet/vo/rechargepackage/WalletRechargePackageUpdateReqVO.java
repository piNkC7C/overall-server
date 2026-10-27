package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.rechargepackage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Top-up plan update request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WalletRechargePackageUpdateReqVO extends WalletRechargePackageBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9032")
    @NotNull(message = "Code is required.")
    private Long id;

}
