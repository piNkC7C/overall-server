package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production task create / edit request.")
@Data
public class MesProTaskSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId; // 编辑时，可不传递

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId; // 编辑时，可不传递

    @Schema(description = "Routing path code.", example = "1")
    private Long routeId; // 编辑时，可不传递

    @Schema(description = "Operation code.", example = "1")
    private Long processId; // 编辑时，可不传递

    @Schema(description = "Product material code.", example = "100")
    private Long itemId; // 编辑时，可不传递

    @Schema(description = "Scheduled Qty", example = "100.00")
    @DecimalMin(value = "0", inclusive = false, message = "Scheduled quantity must be greater than 0.")
    private BigDecimal quantity; // 编辑时，可不传递

    @Schema(description = "Start production time.")
    private LocalDateTime startTime;

    @Schema(description = "Production Duration (Workday).", example = "3")
    @Min(value = 1, message = "Production duration must be greater than 0.")
    private Integer duration;

    @Schema(description = "End production time.")
    private LocalDateTime endTime;

    @Schema(description = "Gantt color.", example = "#00AEF3")
    private String colorCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
