package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract issue order detail response.")
@Data
public class MesWmOutsourceIssueDetailRespVO {

    @Schema(description = "DetailID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long lineId;

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Quantity.", example = "300.00")
    private BigDecimal quantity;

    @Schema(description = "InventoryID.", example = "1")
    private Long materialStockId;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "WarehouseID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
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

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
