package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES purchase receipt line response.")
@Data
public class MesWmItemReceiptLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long receiptId;

    @Schema(description = "Inbound order code.", example = "IR2026020001")
    private String receiptCode;

    @Schema(description = "Purchase order no.", example = "PO20260201")
    private String purchaseOrderCode;

    @Schema(description = "Receiving notification order line code.", example = "1")
    private Long arrivalNoticeLineId;

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

    @Schema(description = "Inbound quantity.", example = "500.00")
    private BigDecimal receivedQuantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "BATCH20260110")
    private String batchCode;

    @Schema(description = "Production date.")
    private LocalDateTime productionDate;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Production lot.", example = "PB20260110")
    private String lotNumber;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
