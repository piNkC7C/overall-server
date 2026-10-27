package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.subjectbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Admin - FMS account balance response.")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class FmsLedgerSubjectBalanceRespVO {

    public static final int NODE_TYPE_SUBJECT = 1;
    public static final int NODE_TYPE_AUXILIARY_COMBINATION = 2;

    @Schema(description = "Node unique key.", example = "S:1024")
    private String nodeKey;

    @Schema(description = "Node type.", example = "1")
    private Integer nodeType;

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Auxiliary combination ID.", example = "2048")
    private Long assistCombinationId;

    @Schema(description = "Account code.", example = "1001")
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "Account name.", example = "Cash on hand")
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "Account Level", example = "1")
    private Integer level;

    @Schema(description = "Is not Enabled quantity accounting.")
    private Boolean quantityAccounting;

    @Schema(description = "Unit of measure.", example = "Pcs.")
    private String quantityUnit;

    @Schema(description = "OpeningDebitbalance.")
    @ExcelProperty("Opening Debit")
    private BigDecimal openingDebitAmount;

    @Schema(description = "OpeningCreditbalance.")
    @ExcelProperty("Opening Credit")
    private BigDecimal openingCreditAmount;

    @Schema(description = "Opening BalanceDirection.", example = "Debit")
    private String openingBalanceDirection;

    @Schema(description = "Opening quantity.")
    private BigDecimal openingQuantity;

    @Schema(description = "OpeningUnit price.")
    private BigDecimal openingUnitPrice;

    @Schema(description = "Current periodDebitturnover.")
    @ExcelProperty("Period Debit")
    private BigDecimal periodDebitAmount;

    @Schema(description = "Current periodCreditturnover.")
    @ExcelProperty("Period Credit")
    private BigDecimal periodCreditAmount;

    @Schema(description = "Current periodDebitQuantity.")
    private BigDecimal periodDebitQuantity;

    @Schema(description = "Current periodCreditQuantity.")
    private BigDecimal periodCreditQuantity;

    @Schema(description = "YTD debit turnover.")
    @ExcelProperty("YTD Debit")
    private BigDecimal yearDebitAmount;

    @Schema(description = "YTD credit turnover.")
    @ExcelProperty("YTD Credit")
    private BigDecimal yearCreditAmount;

    @Schema(description = "YTD debit quantity.")
    private BigDecimal yearDebitQuantity;

    @Schema(description = "YTD credit quantity.")
    private BigDecimal yearCreditQuantity;

    @Schema(description = "EndingDebitbalance.")
    @ExcelProperty("Ending Debit")
    private BigDecimal endingDebitAmount;

    @Schema(description = "EndingCreditbalance.")
    @ExcelProperty("Ending Credit")
    private BigDecimal endingCreditAmount;

    @Schema(description = "Ending BalanceDirection.", example = "Debit")
    private String endingBalanceDirection;

    @Schema(description = "EndingQuantity.")
    private BigDecimal endingQuantity;

    @Schema(description = "EndingUnit price.")
    private BigDecimal endingUnitPrice;

    @Schema(description = "Child accounts.")
    private List<FmsLedgerSubjectBalanceRespVO> children = new ArrayList<>();

}
