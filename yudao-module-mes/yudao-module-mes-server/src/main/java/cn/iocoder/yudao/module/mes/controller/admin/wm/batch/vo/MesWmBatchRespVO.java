package cn.iocoder.yudao.module.mes.controller.admin.wm.batch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES lot control response.")
@Data
public class MesWmBatchRespVO {

    @Schema(description = "Lot ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Lot code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "BATCH20250314001")
    private String code;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Material name.", example = "ProductA.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100*200")
    private String itemSpecification;

    @Schema(description = "Order characters name.", example = "")
    private String unitName;

    @Schema(description = "Production date.")
    private LocalDateTime produceDate;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Inbound date.")
    private LocalDateTime receiptDate;

    @Schema(description = "Supplier ID.", example = "1")
    private Long vendorId;

    @Schema(description = "Supplier code.", example = "V001")
    private String vendorCode;

    @Schema(description = "Supplier name.", example = "SupplierA.")
    private String vendorName;

    @Schema(description = "Customer ID.", example = "1")
    private Long clientId;

    @Schema(description = "Customer code.", example = "C001")
    private String clientCode;

    @Schema(description = "Customer name.", example = "CustomerA.")
    private String clientName;

    @Schema(description = "Purchase order code.", example = "PO20250314001")
    private String purchaseOrderCode;

    @Schema(description = "Sales order code.", example = "SO20250314001")
    private String salesOrderCode;

    @Schema(description = "Production work order ID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", example = "WO20250314001")
    private String workOrderCode;

    @Schema(description = "Production task ID.", example = "1")
    private Long taskId;

    @Schema(description = "Production task code.", example = "TASK20250314001")
    private String taskCode;

    @Schema(description = "Workstation ID.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS001")
    private String workstationCode;

    @Schema(description = "Tool ID.", example = "1")
    private Long toolId;

    @Schema(description = "Tool code.", example = "TOOL001")
    private String toolCode;

    @Schema(description = "Mold ID.", example = "1")
    private Long moldId;

    @Schema(description = "Production lot.", example = "LOT20250314001")
    private String lotNumber;

    @Schema(description = "Quality status.", example = "1")
    private Integer qualityStatus;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
