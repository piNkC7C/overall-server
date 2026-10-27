package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock.HrmAttendanceClockRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM employee each Dayattendancedetail response.")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceDailyDetailRespVO {

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

    @ExcelProperty(value = "Date", index = 0)
    @Schema(description = "Date")
    private LocalDateTime attendanceTime;

    @ExcelProperty(value = "Shift", index = 1)
    @Schema(description = "Shift.")
    private String shiftName;

    @Schema(description = "Is not schedule.")
    private Boolean scheduled;

    @Schema(description = "Required punch count.")
    private Integer requiredClockCount;

    @Schema(description = "Scheduled minutes.")
    private Integer scheduledMinutes;

    @ExcelProperty(value = "Missed Punch Count", index = 8)
    @Schema(description = "Missed punch count.")
    private Integer misscardCount;

    @Schema(description = "Is not Absence.")
    private Boolean absenteeism;

    @Schema(description = "Absence minutes.")
    private Integer absenteeismMinutes;

    @ExcelProperty(value = "Absence Days", index = 9)
    @Schema(description = "Absence days.")
    private BigDecimal absenteeismDays;

    @Schema(description = "On leave.")
    private Boolean leaveStatus;

    @Schema(description = "Leave minutes.")
    private Integer leaveMinutes;

    @ExcelProperty(value = "Leave Days", index = 10)
    @Schema(description = "Leave days.")
    private BigDecimal leaveDays;

    @ExcelProperty(value = "Attendance Result", index = 2)
    @Schema(description = "Attendance result.")
    private String attendanceResult;

    @ExcelProperty(value = "Punch Count", index = 3)
    @Schema(description = "Punch count.")
    private Integer clockCount;

    @ExcelProperty(value = "Late Count", index = 4)
    @Schema(description = "Late Count.")
    private Integer lateCount;

    @ExcelProperty(value = "Late Minutes", index = 5)
    @Schema(description = "Late Minutes.")
    private Integer lateMinutes;

    @ExcelProperty(value = "Early-leave Count", index = 6)
    @Schema(description = "Left-early Count.")
    private Integer earlyCount;

    @ExcelProperty(value = "Early-leave Minutes", index = 7)
    @Schema(description = "Left early Minutes.")
    private Integer earlyMinutes;

    @Schema(description = "Clock-in list.")
    private List<HrmAttendanceClockRespVO> clockList;

}
