package cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - WMS 仓库新增/修改 Request VO")
@Data
public class WmsWarehouseSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @NotEmpty(message = "Warehouse code is required.")
    @Size(max = 20, message = "Warehouse code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "仓库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw Materials.")
    @NotEmpty(message = "Warehouse name is required.")
    private String name;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
