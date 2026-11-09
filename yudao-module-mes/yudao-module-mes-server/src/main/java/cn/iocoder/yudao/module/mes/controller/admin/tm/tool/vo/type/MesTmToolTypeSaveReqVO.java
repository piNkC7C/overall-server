package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - MES 工具类型新增/修改 Request VO")
@Data
public class MesTmToolTypeSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "类型编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "TT-001")
    @NotEmpty(message = "Type code is required.")
    @Size(max = 64, message = "Type code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "类型名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Milling cutter")
    @NotEmpty(message = "Type name is required.")
    @Size(max = 255, message = "Type name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "是否编码管理", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not code admin is required.")
    private Boolean codeFlag;

    @Schema(description = "保养维护类型", example = "1")
    private Integer maintenType;

    @Schema(description = "保养周期", example = "30")
    private Integer maintenPeriod;

    @Schema(description = "备注", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}