package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return detail response.")
@Data
public class MesWmReturnSalesDetailRespVO {

    @Schema(description = "DetailID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Return orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long returnId;

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long lineId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Material A.")
    private String itemName;

    @Schema(description = "Material SKU.", example = "100*200")
    private String itemSpecification;

    @Schema(description = "Unit of measure.", example = "")
    private String itemUnit;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B001")
    private String batchCode;

    @Schema(description = "WarehouseID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse code.", example = "WH001")
    private String warehouseCode;

    @Schema(description = "Warehouse name.", example = "WarehouseA.")
    private String warehouseName;

    @Schema(description = "Zone ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long locationId;

    @Schema(description = "Zone code.", example = "LOC001")
    private String locationCode;

    @Schema(description = "Zone name.", example = "Zone A.")
    private String locationName;

    @Schema(description = "BinID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long areaId;

    @Schema(description = "Bin code.", example = "AREA001")
    private String areaCode;

    @Schema(description = "Bin name.", example = "BinA.")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
