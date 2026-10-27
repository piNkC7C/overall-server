package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES miscellaneous inbound order line create / edit request.")
@Data
public class MesWmMiscReceiptLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material is required.")
    private Long itemId;

    @Schema(description = "Inbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Inbound quantity is required.")
    @DecimalMin(value = "0.01", message = "Inbound quantity cannot be less than 0.01.")
    private BigDecimal quantity;

    @Schema(description = "Lot no.", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone is required.")
    private Long locationId;

    @Schema(description = "Bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin is required.")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
