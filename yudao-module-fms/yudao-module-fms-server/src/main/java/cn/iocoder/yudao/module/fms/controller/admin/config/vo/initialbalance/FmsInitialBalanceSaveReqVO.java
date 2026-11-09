package cn.iocoder.yudao.module.fms.controller.admin.config.vo.initialbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "管理后台 - FMS 初始余额保存 Request VO")
@Data
public class FmsInitialBalanceSaveReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "科目余额数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Account balance is required.")
    private List<Balance> balances;

    @Data
    public static class Balance extends Amounts {

        @Schema(description = "科目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account code is required.")
        private Long subjectId;

        @Schema(description = "辅助核算余额数组")
        @Valid
        private List<AssistBalance> assistBalances;

    }

    @Data
    public static class AssistBalance extends Amounts {

        @Schema(description = "辅助核算项目编号数组", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotEmpty(message = "Auxiliary accounting item is required.")
        private List<Long> auxiliaryItemIds;
    }

    @Data
    public static class Amounts {

        @Schema(description = "期初金额", example = "1000.00")
        @DecimalMin(value = "0", message = "Opening amount cannot be less than 0.")
        private BigDecimal openingAmount;

        @Schema(description = "期初数量", example = "10.0000")
        @DecimalMin(value = "0", message = "Opening quantity cannot be less than 0.")
        private BigDecimal openingQuantity;

        @Schema(description = "本年累计借方金额", example = "100.00")
        @DecimalMin(value = "0", message = "YTD debit amount cannot be less than 0.")
        private BigDecimal yearDebitAmount;

        @Schema(description = "本年累计借方数量", example = "1.0000")
        @DecimalMin(value = "0", message = "YTD debit quantity cannot be less than 0.")
        private BigDecimal yearDebitQuantity;

        @Schema(description = "本年累计贷方金额", example = "50.00")
        @DecimalMin(value = "0", message = "YTD credit amount cannot be less than 0.")
        private BigDecimal yearCreditAmount;

        @Schema(description = "本年累计贷方数量", example = "1.0000")
        @DecimalMin(value = "0", message = "YTD credit quantity cannot be less than 0.")
        private BigDecimal yearCreditQuantity;

        @Schema(description = "年初金额", example = "950.00")
        @DecimalMin(value = "0", message = "Opening amount cannot be less than 0.")
        private BigDecimal yearOpeningAmount;

        @Schema(description = "年初数量", example = "10.0000")
        @DecimalMin(value = "0", message = "Opening quantity cannot be less than 0.")
        private BigDecimal yearOpeningQuantity;

        @Schema(description = "实际损益发生额", example = "0.00")
        @DecimalMin(value = "0", message = "Actual P&L amount cannot be less than 0.")
        private BigDecimal profitLossAmount;

        @Schema(description = "实际损益发生数量", example = "1.0000")
        @DecimalMin(value = "0", message = "Actual P&L quantity cannot be less than 0.")
        private BigDecimal profitLossQuantity;
    }

}
