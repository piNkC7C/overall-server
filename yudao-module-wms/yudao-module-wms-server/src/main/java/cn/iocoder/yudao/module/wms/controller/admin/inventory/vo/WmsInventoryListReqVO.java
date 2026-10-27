package cn.iocoder.yudao.module.wms.controller.admin.inventory.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - WMS inventoryStats list request.")
@Data
public class WmsInventoryListReqVO {

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Warehouse code is required.")
    private Long warehouseId;

}
