package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.quantitygeneral;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnore;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Admin - FMS QuantityAmountgeneral ledger response.")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerQuantityGeneralRespVO {

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Account code.", example = "1405")
    @ExcelProperty({"Account", "Code"})
    private String subjectCode;

    @Schema(description = "Account name.", example = "Inventoryproduct.")
    @ExcelProperty({"Account", "Name"})
    private String subjectName;

    @Schema(description = "Account Level", example = "1")
    private Integer level;

    @Schema(description = "Is not Enabled quantity accounting.")
    private Boolean quantityAccounting;

    @Schema(description = "Unit of measure.", example = "Pcs.")
    @ExcelProperty({"Basic Info", "Unit"})
    private String quantityUnit;

    @Schema(description = "Opening BalanceDirection.", example = "Debit")
    @ExcelProperty({"Opening Balance", "Direction"})
    private String openingBalanceDirection;

    @Schema(description = "Opening quantity.")
    @ExcelProperty({"Opening Balance", "Quantity"})
    private BigDecimal openingQuantity;

    @Schema(description = "OpeningUnit price.")
    @ExcelProperty({"Opening Balance", "Unit Price"})
    private BigDecimal openingUnitPrice;

    @Schema(description = "OpeningDebitbalance.")
    @ExcelIgnore
    private BigDecimal openingDebitAmount;

    @Schema(description = "OpeningCreditbalance.")
    @ExcelIgnore
    private BigDecimal openingCreditAmount;

    @ExcelProperty({"Opening Balance", "Amount"})
    private BigDecimal openingAmount;

    @Schema(description = "Current periodDebitQuantity.")
    @ExcelProperty({"Period Debit", "Quantity"})
    private BigDecimal periodDebitQuantity;

    @Schema(description = "Current periodDebitturnover.")
    @ExcelProperty({"Period Debit", "Amount"})
    private BigDecimal periodDebitAmount;

    @Schema(description = "Current periodCreditQuantity.")
    @ExcelProperty({"Period Credit", "Quantity"})
    private BigDecimal periodCreditQuantity;

    @Schema(description = "Current periodCreditturnover.")
    @ExcelProperty({"Period Credit", "Amount"})
    private BigDecimal periodCreditAmount;

    @Schema(description = "YTD debit quantity.")
    @ExcelProperty({"YTD Debit", "Quantity"})
    private BigDecimal yearDebitQuantity;

    @Schema(description = "YTD debit turnover.")
    @ExcelProperty({"YTD Debit", "Amount"})
    private BigDecimal yearDebitAmount;

    @Schema(description = "YTD credit quantity.")
    @ExcelProperty({"YTD Credit", "Quantity"})
    private BigDecimal yearCreditQuantity;

    @Schema(description = "YTD credit turnover.")
    @ExcelProperty({"YTD Credit", "Amount"})
    private BigDecimal yearCreditAmount;

    @Schema(description = "Ending BalanceDirection.", example = "Debit")
    @ExcelProperty({"Ending Balance", "Direction"})
    private String endingBalanceDirection;

    @Schema(description = "EndingQuantity.")
    @ExcelProperty({"Ending Balance", "Quantity"})
    private BigDecimal endingQuantity;

    @Schema(description = "EndingUnit price.")
    @ExcelProperty({"Ending Balance", "Unit Price"})
    private BigDecimal endingUnitPrice;

    @Schema(description = "EndingDebitbalance.")
    @ExcelIgnore
    private BigDecimal endingDebitAmount;

    @Schema(description = "EndingCreditbalance.")
    @ExcelIgnore
    private BigDecimal endingCreditAmount;

    @ExcelProperty({"Ending Balance", "Amount"})
    private BigDecimal endingAmount;

    @Schema(description = "Child accounts.")
    private List<FmsLedgerQuantityGeneralRespVO> children = new ArrayList<>();

}
