package cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production work report create / edit request.")
@Data
public class MesProFeedbackSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Work-report number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FB202503001")
    @NotNull(message = "Work-report number cannot be empty.")
    private String code;

    @Schema(description = "Work report type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work report type is required.")
    private Integer type;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path is required.")
    private Long routeId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation is required.")
    private Long processId;

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "Production task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production task is required.")
    private Long taskId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Production lot.", example = "LOT20260321")
    private String lotNumber;

    @Schema(description = "Scheduled Qty", example = "5000.00")
    private BigDecimal scheduledQuantity;

    @Schema(description = "This Times work report quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Work report quantity is required.")
    private BigDecimal feedbackQuantity;

    @Schema(description = "Passed quantity quantity.", example = "490.00")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Defect quantity.", example = "10.00")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "Pending inspection quantity.", example = "0")
    private BigDecimal uncheckQuantity;

    @Schema(description = "Process scrap quantity.", example = "6.00")
    private BigDecimal laborScrapQuantity;

    @Schema(description = "Material scrap quantity.", example = "4.00")
    private BigDecimal materialScrapQuantity;

    @Schema(description = "Other scrap quantity.", example = "0")
    private BigDecimal otherScrapQuantity;

    @Schema(description = "Work report person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work report person is required.")
    private Long feedbackUserId;

    @Schema(description = "Work report time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Work report time is required.")
    private LocalDateTime feedbackTime;

    @Schema(description = "Approval person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Approval person is required.")
    private Long approveUserId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
