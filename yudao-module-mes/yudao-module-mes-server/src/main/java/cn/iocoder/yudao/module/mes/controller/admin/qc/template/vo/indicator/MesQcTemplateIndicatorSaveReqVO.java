package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES quality inspection plan - inspect metric item create / edit request.")
@Data
public class MesQcTemplateIndicatorSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Quality inspection plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quality inspection plan ID is required.")
    private Long templateId;

    @Schema(description = "Quality inspection metric ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quality inspection metric is required.")
    private Long indicatorId;

    @Schema(description = "Inspection Method", example = "Visual appearance check")
    private String checkMethod;

    @Schema(description = "Standard value.", example = "10.0000")
    private BigDecimal standardValue;

    @Schema(description = "Unit of measure ID.", example = "1")
    private Long unitMeasureId;

    @Schema(description = "Upper tolerance.", example = "10.5000")
    private BigDecimal thresholdMax;

    @Schema(description = "Lower tolerance.", example = "9.5000")
    private BigDecimal thresholdMin;

    @Schema(description = "Illustration URL.", example = "https://example.com/doc.png")
    private String docUrl;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
