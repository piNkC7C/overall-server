package cn.iocoder.yudao.module.mes.controller.admin.wm.materialstock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - material inventorysearch request.")
@Data
public class MesWmMaterialStockListReqVO {

    @Schema(description = "Warehouse code.")
    private Long warehouseId;

    @Schema(description = "Zone code.")
    private Long locationId;

    @Schema(description = "Bin code.")
    private Long areaId;

    @Schema(description = "Material code.")
    private Long itemId;

    @Schema(description = "Lot code.")
    private Long batchId;

    @Schema(description = "Lot no.")
    private String batchCode;

    @Schema(description = "Start time (for dynamic counting).")
    private LocalDateTime startTime;

    @Schema(description = "End time (for dynamic counting).")
    private LocalDateTime endTime;

}
