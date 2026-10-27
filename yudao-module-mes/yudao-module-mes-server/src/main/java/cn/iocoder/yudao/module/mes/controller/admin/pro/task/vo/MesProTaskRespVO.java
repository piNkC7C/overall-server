package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production task response.")
@Data
public class MesProTaskRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Task code.", example = "PT202503150001")
    private String code;

    @Schema(description = "Task name.", example = "Injection-molding task")
    private String name;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Work order code.", example = "WO-001")
    private String workOrderCode;

    @Schema(description = "Work order name.", example = "Production work order-A.")
    private String workOrderName;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS-001")
    private String workstationCode;

    @Schema(description = "Workstation name.", example = "Injection workstation")
    private String workstationName;

    @Schema(description = "Routing path code.", example = "1")
    private Long routeId;

    @Schema(description = "Operation code.", example = "1")
    private Long processId;

    @Schema(description = "Operation name.", example = "Injection")
    private String processName;

    @Schema(description = "Product material code.", example = "100")
    private Long itemId;

    @Schema(description = "Product code.", example = "P-001")
    private String itemCode;

    @Schema(description = "Product name.", example = "PCB")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100x200mm")
    private String itemSpecification;

    @Schema(description = "Unit of measure name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Scheduled Qty", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Already production quantity.", example = "50.00")
    private BigDecimal producedQuantity;

    @Schema(description = "Passed quantity quantity.", example = "48.00")
    private BigDecimal qualifyQuantity;

    @Schema(description = "Defect quantity.", example = "2.00")
    private BigDecimal unqualifyQuantity;

    @Schema(description = "Adjust quantity.", example = "0")
    private BigDecimal changedQuantity;

    @Schema(description = "Customer code.", example = "300")
    private Long clientId;

    @Schema(description = "Customer name.", example = "CustomerA.")
    private String clientName;

    @Schema(description = "Start production time.")
    private LocalDateTime startTime;

    @Schema(description = "Production Duration (Workday).", example = "3")
    private Integer duration;

    @Schema(description = "End production time.")
    private LocalDateTime endTime;

    @Schema(description = "Gantt color.", example = "#00AEF3")
    private String colorCode;

    @Schema(description = "Need-by Date")
    private LocalDateTime requestDate;

    @Schema(description = "CompleteDate.")
    private LocalDateTime finishDate;

    @Schema(description = "CancelDate.")
    private LocalDateTime cancelDate;

    @Schema(description = "Task status.", example = "0")
    private Integer status;

    @Schema(description = "QC required. Derived from routing operation checkFlag.", example = "true")
    private Boolean checkFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
