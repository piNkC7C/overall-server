package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous outbound order line response.")
@Data
public class MesWmMiscIssueLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Outbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long issueId;

    @Schema(description = "Source document line ID.", example = "1")
    private Long sourceDocLineId;

    @Schema(description = "InventoryrecordID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Outbound quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String warehouseName;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "Bin name.", example = "Aisle 1 rack 1")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
