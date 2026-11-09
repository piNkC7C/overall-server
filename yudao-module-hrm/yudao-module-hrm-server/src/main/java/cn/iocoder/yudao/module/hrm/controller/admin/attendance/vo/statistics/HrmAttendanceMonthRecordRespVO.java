package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - HRM 员工月度考勤汇总 Response VO")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceMonthRecordRespVO {

    @ExcelProperty(value = "Employee ID", index = 0)
    @Schema(description = "员工编号")
    private Long employeeId;

    @ExcelProperty(value = "Employee Name", index = 1)
    @Schema(description = "员工姓名")
    private String employeeName;

    @ExcelProperty(value = "Employee No", index = 2)
    @Schema(description = "工号")
    private String jobNumber;

    @Schema(description = "部门编号")
    private Long deptId;

    @ExcelProperty(value = "Department", index = 3)
    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "职位名称")
    @ExcelProperty(value = "Job Title", index = 4)
    private String postName;

    @Schema(description = "考勤组名称")
    private String attendanceGroupName;

    @Schema(description = "入职时间")
    private LocalDateTime entryTime;

    @Schema(description = "员工状态")
    private Integer employeeStatus;

    @Schema(description = "工作城市")
    private String workCity;

    @ExcelProperty(value = "Year", index = 5)
    @Schema(description = "年份")
    private Integer year;

    @ExcelProperty(value = "Month", index = 6)
    @Schema(description = "月份")
    private Integer month;

    @ExcelProperty(value = "Required Attendance Days", index = 7)
    @Schema(description = "应出勤天数")
    private Integer attendDays;

    @ExcelProperty(value = "Actual Attendance Days", index = 8)
    @Schema(description = "实际出勤天数")
    private BigDecimal actualDays;

    @ExcelProperty(value = "Late Minutes", index = 9)
    @Schema(description = "迟到时长（分钟）")
    private Integer lateMinute;

    @ExcelProperty(value = "Late Count", index = 10)
    @Schema(description = "迟到次数")
    private Integer lateCount;

    @ExcelProperty(value = "Early-leave Minutes", index = 11)
    @Schema(description = "早退时长（分钟）")
    private Integer earlyMinute;

    @ExcelProperty(value = "Early-leave Count", index = 12)
    @Schema(description = "早退次数")
    private Integer earlyCount;

    @ExcelProperty(value = "Missed Punch Count", index = 13)
    @Schema(description = "缺卡次数")
    private Integer misscardCount;

    @ExcelProperty(value = "Absence Days", index = 14)
    @Schema(description = "旷工天数")
    private BigDecimal absenteeismDays;

    @ExcelProperty(value = "Absence Minutes", index = 15)
    @Schema(description = "旷工时长（分钟）")
    private Integer absenteeismMinutes;

    @ExcelProperty(value = "Leave Days", index = 16)
    @Schema(description = "请假天数")
    private BigDecimal leaveDays;

    @ExcelProperty(value = "Leave Minutes", index = 17)
    @Schema(description = "请假时长（分钟）")
    private Integer leaveMinutes;

    @ExcelProperty(value = "Late Deduction", index = 18)
    @Schema(description = "迟到扣款")
    private BigDecimal lateDeductAmount;

    @ExcelProperty(value = "Early-leave Deduction", index = 19)
    @Schema(description = "早退扣款")
    private BigDecimal earlyDeductAmount;

    @ExcelProperty(value = "Missed-punch Deduction", index = 20)
    @Schema(description = "缺卡扣款")
    private BigDecimal misscardDeductAmount;

    @ExcelProperty(value = "Absence Deduction", index = 21)
    @Schema(description = "旷工扣款")
    private BigDecimal absenteeismDeductAmount;

    @ExcelProperty(value = "Attendance Deduction Total", index = 22)
    @Schema(description = "考勤扣款合计")
    private BigDecimal attendanceDeductAmount;

    @Schema(description = "是否全勤")
    private Boolean fullAttendance;

}
