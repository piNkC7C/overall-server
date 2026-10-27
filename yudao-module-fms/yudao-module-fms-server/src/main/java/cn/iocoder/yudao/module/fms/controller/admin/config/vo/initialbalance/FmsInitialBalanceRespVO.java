package cn.iocoder.yudao.module.fms.controller.admin.config.vo.initialbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS initial balance response.")
@Data
public class FmsInitialBalanceRespVO {

    @Schema(description = "Initial balance code.", example = "1024")
    private Long id;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long subjectId;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String subjectCode;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String subjectName;

    @Schema(description = "Parent account ID.", example = "1024")
    private Long parentId;

    @Schema(description = "Account type.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;

    @Schema(description = "Balance Direction.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer balanceDirection;

    @Schema(description = "Is not Enabled quantity accounting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean quantityAccounting;

    @Schema(description = "Quantity order characters.")
    private String quantityUnit;

    @Schema(description = "Is not Enabled auxiliary accounting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean auxiliaryAccounting;

    @Schema(description = "Opening amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000.00")
    private BigDecimal openingAmount;

    @Schema(description = "Opening quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.0000")
    private BigDecimal openingQuantity;

    @Schema(description = "YTD debit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal yearDebitAmount;

    @Schema(description = "YTD debit quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
    private BigDecimal yearDebitQuantity;

    @Schema(description = "YTD credit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50.00")
    private BigDecimal yearCreditAmount;

    @Schema(description = "YTD credit quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
    private BigDecimal yearCreditQuantity;

    @Schema(description = "Opening amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "950.00")
    private BigDecimal yearOpeningAmount;

    @Schema(description = "Opening quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.0000")
    private BigDecimal yearOpeningQuantity;

    @Schema(description = "Actual P&L amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.00")
    private BigDecimal profitLossAmount;

    @Schema(description = "Actual P&L quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
    private BigDecimal profitLossQuantity;

    @Schema(description = "Auxiliary accounting settingArray.")
    private List<AuxiliaryConfig> auxiliaryConfigs;

    @Schema(description = "Auxiliary accounting balance Array.")
    private List<AssistBalance> assistBalances;

    @Schema(description = "Admin - FMS initial balance auxiliary accounting setting.")
    @Data
    public static class AuxiliaryConfig {

        @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long auxiliaryTypeId;

        @Schema(description = "Auxiliary accounting type.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer type;

        @Schema(description = "Auxiliary accounting typename.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String name;

    }

    @Schema(description = "Admin - FMS initial balance auxiliary accounting balance.")
    @Data
    public static class AssistBalance {

        @Schema(description = "Auxiliary combination ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long assistCombinationId;

        @Schema(description = "Auxiliary accounting item Array.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<AuxiliaryItem> auxiliaries;

        @Schema(description = "Opening amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000.00")
        private BigDecimal openingAmount;

        @Schema(description = "Opening quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.0000")
        private BigDecimal openingQuantity;

        @Schema(description = "YTD debit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal yearDebitAmount;

        @Schema(description = "YTD debit quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
        private BigDecimal yearDebitQuantity;

        @Schema(description = "YTD credit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50.00")
        private BigDecimal yearCreditAmount;

        @Schema(description = "YTD credit quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
        private BigDecimal yearCreditQuantity;

        @Schema(description = "Opening amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "950.00")
        private BigDecimal yearOpeningAmount;

        @Schema(description = "Opening quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.0000")
        private BigDecimal yearOpeningQuantity;

        @Schema(description = "Actual P&L amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.00")
        private BigDecimal profitLossAmount;

        @Schema(description = "Actual P&L quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0000")
        private BigDecimal profitLossQuantity;

    }

    @Schema(description = "Admin - FMS initial balance auxiliary accounting item.")
    @Data
    public static class AuxiliaryItem {

        @Schema(description = "Auxiliary accounting type.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer type;

        @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long typeId;

        @Schema(description = "Auxiliary accounting item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long itemId;

        @Schema(description = "Auxiliary accounting item name.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String name;

    }

}
