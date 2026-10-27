package cn.iocoder.yudao.module.fms.controller.admin.config.vo.initialbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS initial balance save request.")
@Data
public class FmsInitialBalanceSaveReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Account balance Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Account balance is required.")
    private List<Balance> balances;

    @Data
    public static class Balance extends Amounts {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account code is required.")
        private Long subjectId;

        @Schema(description = "Auxiliary accounting balance Array.")
        @Valid
        private List<AssistBalance> assistBalances;

    }

    @Data
    public static class AssistBalance extends Amounts {

        @Schema(description = "Auxiliary accounting item ID list.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotEmpty(message = "Auxiliary accounting item is required.")
        private List<Long> auxiliaryItemIds;
    }

    @Data
    public static class Amounts {

        @Schema(description = "Opening amount.", example = "1000.00")
        @DecimalMin(value = "0", message = "Opening amount cannot be less than 0.")
        private BigDecimal openingAmount;

        @Schema(description = "Opening quantity.", example = "10.0000")
        @DecimalMin(value = "0", message = "Opening quantity cannot be less than 0.")
        private BigDecimal openingQuantity;

        @Schema(description = "YTD debit amount.", example = "100.00")
        @DecimalMin(value = "0", message = "YTD debit amount cannot be less than 0.")
        private BigDecimal yearDebitAmount;

        @Schema(description = "YTD debit quantity.", example = "1.0000")
        @DecimalMin(value = "0", message = "YTD debit quantity cannot be less than 0.")
        private BigDecimal yearDebitQuantity;

        @Schema(description = "YTD credit amount.", example = "50.00")
        @DecimalMin(value = "0", message = "YTD credit amount cannot be less than 0.")
        private BigDecimal yearCreditAmount;

        @Schema(description = "YTD credit quantity.", example = "1.0000")
        @DecimalMin(value = "0", message = "YTD credit quantity cannot be less than 0.")
        private BigDecimal yearCreditQuantity;

        @Schema(description = "Opening amount.", example = "950.00")
        @DecimalMin(value = "0", message = "Opening amount cannot be less than 0.")
        private BigDecimal yearOpeningAmount;

        @Schema(description = "Opening quantity.", example = "10.0000")
        @DecimalMin(value = "0", message = "Opening quantity cannot be less than 0.")
        private BigDecimal yearOpeningQuantity;

        @Schema(description = "Actual P&L amount.", example = "0.00")
        @DecimalMin(value = "0", message = "Actual P&L amount cannot be less than 0.")
        private BigDecimal profitLossAmount;

        @Schema(description = "Actual P&L quantity.", example = "1.0000")
        @DecimalMin(value = "0", message = "Actual P&L quantity cannot be less than 0.")
        private BigDecimal profitLossQuantity;
    }

}
