package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES purchase receipt create / edit request.")
@Data
public class MesWmItemReceiptSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IR2026020001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "Inbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Steel plateinbound order.")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "Incoming inspection number.", example = "1")
    private Long iqcId;

    @Schema(description = "Receiving notification order code.", example = "1")
    private Long noticeId;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier is required.")
    private Long vendorId;

    @Schema(description = "Inbound date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "Purchase order no.", example = "PO20260201")
    private String purchaseOrderCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
