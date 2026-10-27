package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production task material input response.")
@Data
public class MesProTaskIssueRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Production task code.", example = "1")
    private Long taskId;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Source document type.", example = "MATERIAL_ISSUE")
    private String sourceDocType;

    @Schema(description = "Source document code.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document line code.", example = "1")
    private Long sourceLineId;

    @Schema(description = "Source document code.", example = "DOC-001")
    private String sourceDocCode;

    @Schema(description = "Material input lot.", example = "BATCH-001")
    private String batchCode;

    @Schema(description = "Product material code.", example = "100")
    private Long itemId;

    @Schema(description = "Product code.", example = "P-001")
    private String itemCode;

    @Schema(description = "Product name.", example = "PCB")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100x200mm")
    private String itemSpecification;

    @Schema(description = "Order characters code.", example = "1")
    private Long unitMeasureId;

    @Schema(description = "Order characters name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Total issued quantity.", example = "100.00")
    private BigDecimal issuedQuantity;

    @Schema(description = "Current can quantity.", example = "80.00")
    private BigDecimal availableQuantity;

    @Schema(description = "Current used quantity.", example = "20.00")
    private BigDecimal usedQuantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
