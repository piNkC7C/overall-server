package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES supplierreturn order create / edit request.")
@Data
public class MesWmReturnVendorSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RV20250226001")
    @NotBlank(message = "Return order code is required.")
    private String code;

    @Schema(description = "Return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Supplier return.")
    @NotBlank(message = "Return order name is required.")
    private String name;

    @Schema(description = "Purchase order code.", example = "PO20250226001")
    private String purchaseOrderCode;

    @Schema(description = "Supplier ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier ID is required.")
    private Long vendorId;

    @Schema(description = "Return Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Return Date is required.")
    private LocalDateTime returnDate;

    @Schema(description = "Return reason.", example = "Quality failed")
    private String returnReason;

    @Schema(description = "Tracking number.", example = "SF1234567890")
    private String transportCode;

    @Schema(description = "Carrier phone.", example = "13800138000")
    private String transportTelephone;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
