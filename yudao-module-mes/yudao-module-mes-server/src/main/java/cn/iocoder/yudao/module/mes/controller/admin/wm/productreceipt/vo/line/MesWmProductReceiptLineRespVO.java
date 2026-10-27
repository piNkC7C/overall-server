package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES product receiving order line response.")
@Data
public class MesWmProductReceiptLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Inventory item record ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", example = "P001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Finished A")
    private String itemName;

    @Schema(description = "Spec / Model", example = "Standard")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Pcs.")
    private String unitMeasureName;

    @Schema(description = "Receiving quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260301001")
    private String batchCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
