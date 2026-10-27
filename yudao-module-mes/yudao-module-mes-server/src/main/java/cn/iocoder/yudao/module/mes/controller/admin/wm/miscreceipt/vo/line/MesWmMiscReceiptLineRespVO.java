package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous inbound order line response.")
@Data
public class MesWmMiscReceiptLineRespVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", example = "1")
    private Long receiptId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Inbound quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Lot no.", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String warehouseName;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "Bin name.", example = "Aisle 1 rack 1")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
