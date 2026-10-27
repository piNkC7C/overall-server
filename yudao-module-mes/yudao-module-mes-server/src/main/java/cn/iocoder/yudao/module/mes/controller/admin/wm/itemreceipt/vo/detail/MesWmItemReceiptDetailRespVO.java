package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES purchase inbound detail response.")
@Data
public class MesWmItemReceiptDetailRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inbound order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long lineId;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long receiptId;

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

    @Schema(description = "Put away quantity.", example = "300.00")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String warehouseName;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A-01")
    private String areaName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
