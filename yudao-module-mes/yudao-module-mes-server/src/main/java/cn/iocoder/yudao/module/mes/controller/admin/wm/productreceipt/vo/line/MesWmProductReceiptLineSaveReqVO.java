package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES productinbound order line create / edit request.")
@Data
public class MesWmProductReceiptLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving order code is required.")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Inventory item record ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Receiving quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Receiving quantity is required.")
    @Positive(message = "Received quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260301001")
    private String batchCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
