package cn.iocoder.yudao.module.mes.controller.admin.qc.defectrecord.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcDefectLevelEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES quality inspection defect record create / edit request.")
@Data
public class MesQcDefectRecordSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    @InEnum(MesQcTypeEnum.class)
    private Integer qcType;

    @Schema(description = "Inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspection ID is required.")
    private Long qcId;

    @Schema(description = "Inspection line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Inspection line ID is required.")
    private Long lineId;

    @Schema(description = "Defect Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Surface scratch")
    @NotEmpty(message = "Defect Description is required.")
    private String name;

    @Schema(description = "Defect level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Defect level is required.")
    @InEnum(MesQcDefectLevelEnum.class)
    private Integer level;

    @Schema(description = "Defect quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Defect quantity is required.")
    private Integer quantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
