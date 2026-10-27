package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES device type create / edit request.")
@Data
public class MesDvMachineryTypeSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MT-001")
    @NotEmpty(message = "Type code is required.")
    private String code;

    @Schema(description = "Type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC machine")
    @NotEmpty(message = "Type name is required.")
    private String name;

    @Schema(description = "Parent type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Parent type code is required.")
    private Long parentId;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Show sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
