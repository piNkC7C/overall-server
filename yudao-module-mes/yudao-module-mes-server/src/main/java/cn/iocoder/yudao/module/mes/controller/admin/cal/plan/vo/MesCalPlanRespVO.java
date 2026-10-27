package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES schedule plan response.")
@Data
@ExcelIgnoreUnannotated
public class MesCalPlanRespVO {

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Plan ID")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024Year schedule plan.")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "Team type.", example = "1")
    @ExcelProperty("Team Type")
    private Integer calendarType;

    @Schema(description = "Start Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Start Date")
    private LocalDateTime startDate;

    @Schema(description = "End Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("End Date")
    private LocalDateTime endDate;

    @Schema(description = "Rotation method.", example = "1")
    @ExcelProperty("Shift Method")
    private Integer shiftType;

    @Schema(description = "Shift rotation method.", example = "1")
    @ExcelProperty("Rotation Method")
    private Integer shiftMethod;

    @Schema(description = "Shift rotation days.", example = "7")
    @ExcelProperty("Rotation Days")
    private Integer shiftCount;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
