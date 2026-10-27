package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES product receiving order detail create / edit request.")
@Data
public class MesWmProductReceiptDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Receiving order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving order line code is required.")
    private Long lineId;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving order code is required.")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Put away quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Put away quantity is required.")
    @Positive(message = "Put-away quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
