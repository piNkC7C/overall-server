package cn.iocoder.yudao.module.mes.controller.admin.qc.pendinginspect.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "MES pending inspection task response VO.")
@Data
public class MesQcPendingInspectRespVO {

    @Schema(description = "Source document type (MesBizTypeConstants).", example = "100")
    private Integer sourceDocType;

    @Schema(description = "Source document ID.", example = "100")
    private Long sourceDocId;

    @Schema(description = "Source document line ID.", example = "200")
    private Long sourceLineId;
    @Schema(description = "Source document code.", example = "AN2025001")
    private String sourceDocCode;

    @Schema(description = "Inspection type (MesQcTypeEnum).", example = "1")
    private Integer qcType;

    // ========== material ==========

    @Schema(description = "Material ID.", example = "10")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Material A.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100mm*50mm")
    private String specification;

    @Schema(description = "Order characters name.", example = "")
    private String unitName;

    // ========== quantity ==========

    @Schema(description = "Pending inspection quantity.", example = "100.00")
    private BigDecimal quantity;

    // ========== 供应商（IQC 场景） ==========

    @Schema(description = "Supplier ID.", example = "5")
    private Long vendorId;

    @Schema(description = "Supplier name.", example = "SupplierA.")
    private String vendorName;

    // ========== 工单/工作站/任务（IPQC/RQC 场景） ==========

    @Schema(description = "Production work order ID.", example = "10")
    private Long workOrderId;

    @Schema(description = "Workstation ID.", example = "20")
    private Long workstationId;

    @Schema(description = "Workstation name.", example = "WorkstationA.")
    private String workstationName;

    @Schema(description = "Production task ID.", example = "30")
    private Long taskId;

    @Schema(description = "Production task code.", example = "TASK2025001")
    private String taskCode;

    // ========== 客户（OQC/RQC 场景） ==========

    @Schema(description = "Customer ID.", example = "40")
    private Long clientId;

    @Schema(description = "Customer name.", example = "CustomerA.")
    private String clientName;

    // ========== time ==========

    @Schema(description = "Record time.")
    private LocalDateTime recordTime;

}