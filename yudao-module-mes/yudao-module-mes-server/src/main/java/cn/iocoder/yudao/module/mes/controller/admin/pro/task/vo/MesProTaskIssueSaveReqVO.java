package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES production task material input create / edit request.")
@Data
public class MesProTaskIssueSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Production task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production task code is required.")
    private Long taskId;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Source document type.", example = "MATERIAL_ISSUE")
    private String sourceDocType;

    @Schema(description = "Source document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source document code is required.")
    private Long sourceDocId;

    @Schema(description = "Source document line code.", example = "1")
    private Long sourceLineId;

    @Schema(description = "Source document code.", example = "DOC-001")
    private String sourceDocCode;

    @Schema(description = "Material input lot.", example = "BATCH-001")
    private String batchCode;

    @Schema(description = "Product material code.", example = "100")
    private Long itemId;

    @Schema(description = "Order characters code.", example = "1")
    private Long unitMeasureId;

    @Schema(description = "Total issued quantity.", example = "100.00")
    private BigDecimal issuedQuantity;

    @Schema(description = "Current can quantity.", example = "80.00")
    private BigDecimal availableQuantity;

    @Schema(description = "Current used quantity.", example = "20.00")
    private BigDecimal usedQuantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
