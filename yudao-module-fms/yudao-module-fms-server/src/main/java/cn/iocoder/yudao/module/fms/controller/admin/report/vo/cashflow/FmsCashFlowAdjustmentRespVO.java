package cn.iocoder.yudao.module.fms.controller.admin.report.vo.cashflow;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Cash-flow support data response VO.")
@Data
public class FmsCashFlowAdjustmentRespVO {

    @Schema(description = "Data code.", example = "1024")
    private Long id;

    @Schema(description = "Item name.", example = "Wages paid to employees")
    private String name;

    @Schema(description = "Line No.", example = "1")
    private Integer rowNo;

    @Schema(description = "Formula.")
    private String formula;

    @Schema(description = "Notes")
    private String remark;

    @Schema(description = "Is not can edit.", example = "true")
    private Boolean editable;

    @Schema(description = "Period amount.", example = "100.00")
    private BigDecimal currentAmount;

    @Schema(description = "YTD amount.", example = "200.00")
    private BigDecimal yearAmount;

    @Schema(description = "Level.", example = "1")
    private Integer level;

}
