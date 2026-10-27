package cn.iocoder.yudao.module.fms.controller.admin.report.vo.balance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "Balance-sheet line response VO.")
@Data
@ExcelIgnoreUnannotated
public class FmsBalanceSheetRowRespVO {

    @Schema(description = "Line code.", example = "1")
    private Integer rowId;

    @Schema(description = "Asset item setting code.", example = "1024")
    private Long assetId;

    @Schema(description = "Asset item name.", example = "Cash and cash equivalents")
    @ExcelProperty("Assets")
    private String assetName;

    @Schema(description = "Asset item Line No.", example = "1")
    @ExcelProperty("Line No")
    private Integer assetRowNo;

    @Schema(description = "Asset item Ending Balance.", example = "200.00")
    @ExcelProperty("Ending Balance")
    private BigDecimal assetClosingAmount;

    @Schema(description = "AssetsProjectOpening-year balance.", example = "100.00")
    @ExcelProperty("Opening-year Balance")
    private BigDecimal assetOpeningAmount;

    @Schema(description = "Asset item level.", example = "2")
    private Integer assetLevel;

    @Schema(description = "Asset item is not can edit.", example = "true")
    private Boolean assetEditable;

    @Schema(description = "AssetsProjectFormula.")
    private String assetFormula;

    @Schema(description = "Liabilities and equity item setting ID.", example = "1024")
    private Long liabilityId;

    @Schema(description = "Liabilities and equityProject name.", example = "Short-term loan")
    @ExcelProperty("Liabilities And Equity")
    private String liabilityName;

    @Schema(description = "Liabilities and equityProjectLine no.", example = "31")
    @ExcelProperty("Line No")
    private Integer liabilityRowNo;

    @Schema(description = "Liabilities and equityProjectEnding balance.", example = "200.00")
    @ExcelProperty("Ending Balance")
    private BigDecimal liabilityClosingAmount;

    @Schema(description = "Liabilities and equityProjectOpening-year balance.", example = "100.00")
    @ExcelProperty("Opening-year Balance")
    private BigDecimal liabilityOpeningAmount;

    @Schema(description = "Liabilities and equity item level.", example = "2")
    private Integer liabilityLevel;

    @Schema(description = "Liabilities and equity item is editable.", example = "true")
    private Boolean liabilityEditable;

    @Schema(description = "Liabilities and equityProjectFormula.")
    private String liabilityFormula;

}
