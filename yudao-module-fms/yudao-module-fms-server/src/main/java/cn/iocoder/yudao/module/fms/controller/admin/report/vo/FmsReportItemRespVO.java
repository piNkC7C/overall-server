package cn.iocoder.yudao.module.fms.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "Financial-statement item response VO.")
@Data
@ExcelIgnoreUnannotated
public class FmsReportItemRespVO {

    @Schema(description = "Setting code.", example = "1024")
    private Long id;

    @Schema(description = "Item name.", example = "Cash and cash equivalents")
    @ExcelProperty("Project")
    private String name;

    @Schema(description = "Line No.", example = "1")
    @ExcelProperty("Line No")
    private Integer rowNo;

    @Schema(description = "Level.", example = "2")
    private Integer level;

    @Schema(description = "Is not can edit.", example = "true")
    private Boolean editable;

    @Schema(description = "Formula.")
    private String formula;

    @Schema(description = "Opening amount.", example = "100.00")
    private BigDecimal openingAmount;

    @Schema(description = "EndingAmount.", example = "200.00")
    private BigDecimal closingAmount;

    @Schema(description = "YTD amount.", example = "200.00")
    @ExcelProperty("YTD Amount")
    private BigDecimal yearAmount;

    @Schema(description = "Period amount.", example = "100.00")
    @ExcelProperty("Period Amount")
    private BigDecimal currentAmount;

}
