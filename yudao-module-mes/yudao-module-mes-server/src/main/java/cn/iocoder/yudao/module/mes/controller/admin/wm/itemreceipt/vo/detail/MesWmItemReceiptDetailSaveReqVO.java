package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES purchase inbound detail create / edit request.")
@Data
public class MesWmItemReceiptDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order line code is required.")
    private Long lineId;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Put away quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Put away quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Put-away quantity must be greater than 0.")
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
