package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 排班计划 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesCalPlanRespVO {

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Plan ID")
    private Long id;

    @Schema(description = "计划编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "计划名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024Year schedule plan.")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "班组类型", example = "1")
    @ExcelProperty("Team Type")
    private Integer calendarType;

    @Schema(description = "开始日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Start Date")
    private LocalDateTime startDate;

    @Schema(description = "结束日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("End Date")
    private LocalDateTime endDate;

    @Schema(description = "轮班方式", example = "1")
    @ExcelProperty("Shift Method")
    private Integer shiftType;

    @Schema(description = "倒班方式", example = "1")
    @ExcelProperty("Rotation Method")
    private Integer shiftMethod;

    @Schema(description = "倒班天数", example = "7")
    @ExcelProperty("Rotation Days")
    private Integer shiftCount;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
