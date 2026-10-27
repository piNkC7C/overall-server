package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.rechargepackage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 充值套餐 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class WalletRechargePackageBaseVO {

    @Schema(description = "Plan name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Plan name is required.")
    private String name;

    @Schema(description = "Payment amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16454")
    @NotNull(message = "Payment amount is required.")
    private Integer payPrice;

    @Schema(description = "Bonus amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20887")
    @NotNull(message = "Bonus amount cannot be empty.")
    private Integer bonusPrice;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Status is required.")
    private Byte status;

}
