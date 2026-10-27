package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES supplierreturn order response.")
@Data
public class MesWmReturnVendorRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RV20250226001")
    private String code;

    @Schema(description = "Return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Supplier return.")
    private String name;

    @Schema(description = "Purchase order code.", example = "PO20250226001")
    private String purchaseOrderCode;

    @Schema(description = "Supplier ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long vendorId;

    @Schema(description = "Supplier code.", example = "V001")
    private String vendorCode;

    @Schema(description = "Supplier name.", example = "XXsupplier.")
    private String vendorName;

    @Schema(description = "Supplier short name.", example = "XX")
    private String vendorNickname;

    @Schema(description = "Return Date.")
    private LocalDateTime returnDate;

    @Schema(description = "Return reason.", example = "Quality failed")
    private String returnReason;

    @Schema(description = "Tracking number.", example = "SF1234567890")
    private String transportCode;

    @Schema(description = "Carrier phone.", example = "13800138000")
    private String transportTelephone;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
