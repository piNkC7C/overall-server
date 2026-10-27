package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 用户钱包 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class PayWalletBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20020")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User type is required.")
    private Integer userType;

    @Schema(description = "Balance, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Balance, order characters Min is required.")
    private Integer balance;

    @Schema(description = "Total spend, in cents.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Total spend, in cents cannot be empty.")
    private Integer totalExpense;

    @Schema(description = "Total top-up, in cents.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Total top-up, in cents cannot be empty.")
    private Integer totalRecharge;

    @Schema(description = "Freeze amount, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20737")
    @NotNull(message = "Freeze amount, order characters Min is required.")
    private Integer freezePrice;

}