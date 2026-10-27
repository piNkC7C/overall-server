package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "HRM employee monthly attendance summary response VO.")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceMonthRecordRespVO {

    @ExcelProperty(value = "Employee ID", index = 0)
    @Schema(description = "Employee code.")
    private Long employeeId;

    @ExcelProperty(value = "Employee Name", index = 1)
    @Schema(description = "Employee Name")
    private String employeeName;

    @ExcelProperty(value = "Employee No", index = 2)
    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Department code.")
    private Long deptId;

    @ExcelProperty(value = "Department", index = 3)
    @Schema(description = "Department name.")
    private String deptName;

    @Schema(description = "Job Title name.")
    @ExcelProperty(value = "Job Title", index = 4)
    private String postName;

    @Schema(description = "Attendance group name.")
    private String attendanceGroupName;

    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Employee status.")
    private Integer employeeStatus;

    @Schema(description = "Work City")
    private String workCity;

    @ExcelProperty(value = "Year", index = 5)
    @Schema(description = "Year.")
    private Integer year;

    @ExcelProperty(value = "Month", index = 6)
    @Schema(description = "Month")
    private Integer month;

    @ExcelProperty(value = "Required Attendance Days", index = 7)
    @Schema(description = "Required attendance days.")
    private Integer attendDays;

    @ExcelProperty(value = "Actual Attendance Days", index = 8)
    @Schema(description = "Actual attendance days.")
    private BigDecimal actualDays;

    @ExcelProperty(value = "Late Minutes", index = 9)
    @Schema(description = "Late minutes.")
    private Integer lateMinute;

    @ExcelProperty(value = "Late Count", index = 10)
    @Schema(description = "Late Count.")
    private Integer lateCount;

    @ExcelProperty(value = "Early-leave Minutes", index = 11)
    @Schema(description = "Early-leave minutes.")
    private Integer earlyMinute;

    @ExcelProperty(value = "Early-leave Count", index = 12)
    @Schema(description = "Left-early Count.")
    private Integer earlyCount;

    @ExcelProperty(value = "Missed Punch Count", index = 13)
    @Schema(description = "Missed punch count.")
    private Integer misscardCount;

    @ExcelProperty(value = "Absence Days", index = 14)
    @Schema(description = "Absence days.")
    private BigDecimal absenteeismDays;

    @ExcelProperty(value = "Absence Minutes", index = 15)
    @Schema(description = "Absence minutes.")
    private Integer absenteeismMinutes;

    @ExcelProperty(value = "Leave Days", index = 16)
    @Schema(description = "Leave days.")
    private BigDecimal leaveDays;

    @ExcelProperty(value = "Leave Minutes", index = 17)
    @Schema(description = "Leave minutes.")
    private Integer leaveMinutes;

    @ExcelProperty(value = "Late Deduction", index = 18)
    @Schema(description = "Latededuction.")
    private BigDecimal lateDeductAmount;

    @ExcelProperty(value = "Early-leave Deduction", index = 19)
    @Schema(description = "Left Earlydeduction.")
    private BigDecimal earlyDeductAmount;

    @ExcelProperty(value = "Missed-punch Deduction", index = 20)
    @Schema(description = "Missed Punchdeduction.")
    private BigDecimal misscardDeductAmount;

    @ExcelProperty(value = "Absence Deduction", index = 21)
    @Schema(description = "Absencededuction.")
    private BigDecimal absenteeismDeductAmount;

    @ExcelProperty(value = "Attendance Deduction Total", index = 22)
    @Schema(description = "AttendancedeductionTotal.")
    private BigDecimal attendanceDeductAmount;

    @Schema(description = "Perfect attendance.")
    private Boolean fullAttendance;

}
