package cn.iocoder.yudao.module.mes.controller.admin.qc.oqc.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "MES outgoing inspection line response VO.")
@Data
@Accessors(chain = true)
public class MesQcOqcLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Outgoing inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long oqcId;

    @Schema(description = "Inspect metric ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long indicatorId;

    @Schema(description = "Inspect metric code.", example = "IND001")
    private String indicatorCode;

    @Schema(description = "Inspect metric name.", example = "Appearance")
    private String indicatorName;

    @Schema(description = "Inspect metric type.", example = "1")
    private Integer indicatorType;

    @Schema(description = "Inspect tool.", example = "Caliper")
    private String tool;

    @Schema(description = "Inspection Method", example = "Visual")
    private String checkMethod;

    @Schema(description = "Standard value.", example = "10.5000")
    private BigDecimal standardValue;

    @Schema(description = "Unit of measure ID.", example = "3")
    private Long unitMeasureId;

    @Schema(description = "Unit of measure name.", example = "mm")
    private String unitMeasureName;

    @Schema(description = "Upper tolerance.", example = "11.0000")
    private BigDecimal maxThreshold;

    @Schema(description = "Lower tolerance.", example = "10.0000")
    private BigDecimal minThreshold;

    @Schema(description = "Critical defect count", example = "0")
    private Integer criticalQuantity;

    @Schema(description = "Major defect count", example = "0")
    private Integer majorQuantity;

    @Schema(description = "Minor defect count", example = "1")
    private Integer minorQuantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
