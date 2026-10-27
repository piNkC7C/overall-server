package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract inbound order create / edit request.")
@Data
public class MesWmOutsourceReceiptSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "OR2026030001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "Inbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Subcontract inbound")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "Subcontract work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Subcontract work order is required.")
    private Long workOrderId;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier is required.")
    private Long vendorId;

    @Schema(description = "Inbound date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
