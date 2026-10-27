package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES quality inspection plan - inspect metric item response.")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateIndicatorRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Quality inspection plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long templateId;

    @Schema(description = "Quality inspection metric ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long indicatorId;

    @Schema(description = "Inspection Method", example = "Visual appearance check")
    @ExcelProperty("Check Method")
    private String checkMethod;

    @Schema(description = "Standard value.", example = "10.0000")
    @ExcelProperty("Standard Value")
    private BigDecimal standardValue;

    @Schema(description = "Unit of measure ID.", example = "1")
    private Long unitMeasureId;

    @Schema(description = "Upper tolerance.", example = "10.5000")
    @ExcelProperty("Upper Tolerance")
    private BigDecimal thresholdMax;

    @Schema(description = "Lower tolerance.", example = "9.5000")
    @ExcelProperty("Lower Tolerance")
    private BigDecimal thresholdMin;

    @Schema(description = "Illustration URL.", example = "https://example.com/doc.png")
    private String docUrl;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== JOIN mes_qc_indicator ==========

    @Schema(description = "Inspect item code.", example = "QI001")
    @ExcelProperty("Checkpoint Code")
    private String indicatorCode;

    @Schema(description = "Inspect item name.", example = "Length.")
    @ExcelProperty("Checkpoint Name")
    private String indicatorName;

    @Schema(description = "Inspect item type.", example = "1")
    @ExcelProperty("Checkpoint Type")
    private Integer indicatorType;

    @Schema(description = "Inspect tool.", example = "Caliper")
    @ExcelProperty("Inspection Tool")
    private String indicatorTool;

    // ========== JOIN mes_md_unit_measure ==========

    @Schema(description = "Unit of measure name.", example = "mm")
    @ExcelProperty("Unit")
    private String unitMeasureName;

}
