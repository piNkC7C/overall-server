package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES product receiving order detail response.")
@Data
public class MesWmProductReceiptDetailRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Receiving order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long lineId;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "P001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Finished A")
    private String itemName;

    @Schema(description = "Spec / Model", example = "Standard")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Pcs.")
    private String unitMeasureName;

    @Schema(description = "Put away quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Finished-goods warehouse")
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
