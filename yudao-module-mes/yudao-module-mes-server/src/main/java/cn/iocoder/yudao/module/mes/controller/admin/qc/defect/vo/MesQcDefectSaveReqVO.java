package cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcDefectLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES defect type create / edit request.")
@Data
public class MesQcDefectSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Defect code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "DF001")
    @NotEmpty(message = "Defect code is required.")
    private String code;

    @Schema(description = "Defect Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Appearance defect")
    @NotEmpty(message = "Defect Description is required.")
    private String name;

    @Schema(description = "Inspect item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Inspect item type is required.")
    private Integer type;

    @Schema(description = "Defect level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Defect level is required.")
    @InEnum(MesQcDefectLevelEnum.class)
    private Integer level;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
