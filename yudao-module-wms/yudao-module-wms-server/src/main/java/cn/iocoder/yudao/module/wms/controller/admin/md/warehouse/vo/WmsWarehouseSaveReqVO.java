package cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - WMS warehouse create / edit request.")
@Data
public class WmsWarehouseSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @NotEmpty(message = "Warehouse code is required.")
    @Size(max = 20, message = "Warehouse code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw Materials.")
    @NotEmpty(message = "Warehouse name is required.")
    private String name;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
