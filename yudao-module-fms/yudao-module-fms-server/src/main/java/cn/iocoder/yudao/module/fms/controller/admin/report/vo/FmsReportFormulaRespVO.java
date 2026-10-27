package cn.iocoder.yudao.module.fms.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "FMS report Formula item response VO.")
@Data
public class FmsReportFormulaRespVO {

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Account name.", example = "Cash on hand")
    private String subjectName;

    @Schema(description = "Account code.", example = "1001")
    private String subjectNumber;

    @Schema(description = "Operator.", example = "+")
    private String operator;

    @Schema(description = "Fetch Rule", example = "0")
    private Integer rules;

    @Schema(description = "Opening amount.", example = "100.00")
    private BigDecimal openingAmount;

    @Schema(description = "EndingAmount.", example = "200.00")
    private BigDecimal closingAmount;

    @Schema(description = "Period amount.", example = "100.00")
    private BigDecimal currentAmount;

    @Schema(description = "YTD amount.", example = "200.00")
    private BigDecimal yearAmount;

}
