package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Schema(description = "HRM employee monthly clock-in overview response VO.")
@Data
public class HrmAttendanceMonthDailyOverviewRespVO {

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Employee Name")
    private String employeeName;

    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department name.")
    private String deptName;

    @Schema(description = "Job Title name.")
    private String postName;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Daily punch overview. Key is the date.")
    private Map<LocalDate, HrmAttendanceDailyOverviewRespVO> dailyClockMap;

}
