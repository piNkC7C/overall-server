package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES sales outbound detail response.")
@Data
public class MesWmProductSalesDetailRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Outbound order line ID.", example = "1")
    private Long lineId;

    @Schema(description = "Outbound orderID.", example = "1")
    private Long salesId;

    @Schema(description = "Material ID.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "ProductA.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100g")
    private String specification;

    @Schema(description = "Order characters name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Picking quantity.", example = "50")
    private BigDecimal quantity;

    @Schema(description = "InventoryrecordID.", example = "1")
    private Long materialStockId;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "WarehouseID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Finished-goods warehouse")
    private String warehouseName;

    @Schema(description = "Zone ID.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "BinID.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A-01")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
