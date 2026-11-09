package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 盘点任务 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmStockTakingTaskRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "任务编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ST202603080001")
    @ExcelProperty("Task Code")
    private String code;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @ExcelProperty("Task Name")
    private String name;

    @Schema(description = "盘点日期")
    @ExcelProperty("Count Date")
    private LocalDateTime takingDate;

    @Schema(description = "盘点类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Count Type")
    private Integer type;

    @Schema(description = "盘点人 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "盘点人昵称", example = "Admin.")
    @ExcelProperty("Counter")
    private String userNickname;

    @Schema(description = "来源方案 ID", example = "1")
    private Long planId;

    @Schema(description = "来源方案编码", example = "STP202603080001")
    @ExcelProperty("Plan Code")
    private String planCode;

    @Schema(description = "来源方案名称", example = "Raw-warehouse monthly count")
    @ExcelProperty("Plan Name")
    private String planName;

    @Schema(description = "是否盲盘", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Blind Count")
    private Boolean blindFlag;

    @Schema(description = "是否冻结库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Freeze Inventory")
    private Boolean frozen;

    @Schema(description = "开始时间")
    @ExcelProperty("Start Time")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @ExcelProperty("End Time")
    private LocalDateTime endTime;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
