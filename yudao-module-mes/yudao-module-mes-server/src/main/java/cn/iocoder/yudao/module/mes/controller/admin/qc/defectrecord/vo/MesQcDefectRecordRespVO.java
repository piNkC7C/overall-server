package cn.iocoder.yudao.module.mes.controller.admin.qc.defectrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES quality inspection defect record response.")
@Data
public class MesQcDefectRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer qcType;

    @Schema(description = "Inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long qcId;

    @Schema(description = "Inspection line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Long lineId;

    @Schema(description = "Defect Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Surface scratch")
    private String name;

    @Schema(description = "Defect level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Defect quantity.", example = "1")
    private Integer quantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
