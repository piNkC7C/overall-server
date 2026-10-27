package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES supplier return detail response.")
@Data
public class MesWmReturnVendorDetailRespVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Return order code.", example = "1")
    private Long returnId;

    @Schema(description = "Line code.", example = "1")
    private Long lineId;

    @Schema(description = "Inventoryrecord code.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Screw")
    private String itemName;

    @Schema(description = "Spec / Model", example = "M8*20")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Return quantity.", example = "300.00")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw-material warehouse")
    private String warehouseName;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A01")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
