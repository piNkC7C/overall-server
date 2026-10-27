package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.recharge;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User top-up plan response VO.")
@Data
public class AppPayWalletPackageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;
    @Schema(description = "Plan name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Small package")
    private String name;

    @Schema(description = "Payment amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer payPrice;
    @Schema(description = "Bonus amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer bonusPrice;

}
