package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 质检方案-检测指标项 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateIndicatorRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "质检方案ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long templateId;

    @Schema(description = "质检指标ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long indicatorId;

    @Schema(description = "检测方法", example = "Visual appearance check")
    @ExcelProperty("Check Method")
    private String checkMethod;

    @Schema(description = "标准值", example = "10.0000")
    @ExcelProperty("Standard Value")
    private BigDecimal standardValue;

    @Schema(description = "计量单位ID", example = "1")
    private Long unitMeasureId;

    @Schema(description = "误差上限", example = "10.5000")
    @ExcelProperty("Upper Tolerance")
    private BigDecimal thresholdMax;

    @Schema(description = "误差下限", example = "9.5000")
    @ExcelProperty("Lower Tolerance")
    private BigDecimal thresholdMin;

    @Schema(description = "说明图URL", example = "https://example.com/doc.png")
    private String docUrl;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== JOIN mes_qc_indicator ==========

    @Schema(description = "检测项编码", example = "QI001")
    @ExcelProperty("Checkpoint Code")
    private String indicatorCode;

    @Schema(description = "检测项名称", example = "Length.")
    @ExcelProperty("Checkpoint Name")
    private String indicatorName;

    @Schema(description = "检测项类型", example = "1")
    @ExcelProperty("Checkpoint Type")
    private Integer indicatorType;

    @Schema(description = "检测工具", example = "Caliper")
    @ExcelProperty("Inspection Tool")
    private String indicatorTool;

    // ========== JOIN mes_md_unit_measure ==========

    @Schema(description = "计量单位名称", example = "mm")
    @ExcelProperty("Unit")
    private String unitMeasureName;

}
