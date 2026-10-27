package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES sales outbound detail create / edit request.")
@Data
public class MesWmProductSalesDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound order line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound order line ID is required.")
    private Long lineId;

    @Schema(description = "Outbound orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound orderID is required.")
    private Long salesId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material is required.")
    private Long itemId;

    @Schema(description = "Picking quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    @NotNull(message = "Picking quantity is required.")
    private BigDecimal quantity;

    @Schema(description = "InventoryrecordID.", example = "1")
    private Long materialStockId;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "WarehouseID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Zone ID.", example = "1")
    private Long locationId;

    @Schema(description = "BinID.", example = "1")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
