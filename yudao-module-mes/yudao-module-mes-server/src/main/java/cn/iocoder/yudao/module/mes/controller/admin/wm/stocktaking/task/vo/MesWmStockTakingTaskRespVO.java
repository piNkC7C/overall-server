package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES stocktake task response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmStockTakingTaskRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ST202603080001")
    @ExcelProperty("Task Code")
    private String code;

    @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @ExcelProperty("Task Name")
    private String name;

    @Schema(description = "Stocktake Date.")
    @ExcelProperty("Count Date")
    private LocalDateTime takingDate;

    @Schema(description = "Stocktake type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Count Type")
    private Integer type;

    @Schema(description = "Stocktake person ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Stocktake person Nickname.", example = "Admin.")
    @ExcelProperty("Counter")
    private String userNickname;

    @Schema(description = "Source plan ID.", example = "1")
    private Long planId;

    @Schema(description = "Source plan code.", example = "STP202603080001")
    @ExcelProperty("Plan Code")
    private String planCode;

    @Schema(description = "Source plan name.", example = "Raw-warehouse monthly count")
    @ExcelProperty("Plan Name")
    private String planName;

    @Schema(description = "Blind Count", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Blind Count")
    private Boolean blindFlag;

    @Schema(description = "Is not freeze inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Freeze Inventory")
    private Boolean frozen;

    @Schema(description = "Start time.")
    @ExcelProperty("Start Time")
    private LocalDateTime startTime;

    @Schema(description = "End time.")
    @ExcelProperty("End Time")
    private LocalDateTime endTime;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
