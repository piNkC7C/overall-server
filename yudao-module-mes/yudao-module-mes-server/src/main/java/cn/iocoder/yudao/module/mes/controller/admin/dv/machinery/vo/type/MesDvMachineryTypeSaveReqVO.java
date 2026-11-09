package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 设备类型新增/修改 Request VO")
@Data
public class MesDvMachineryTypeSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "类型编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "MT-001")
    @NotEmpty(message = "Type code is required.")
    private String code;

    @Schema(description = "类型名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC machine")
    @NotEmpty(message = "Type name is required.")
    private String name;

    @Schema(description = "父类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Parent type code is required.")
    private Long parentId;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "显示排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
