package cn.iocoder.yudao.module.hrm.enums.attendance.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HRM 考勤结果枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmAttendanceResultEnum {

    NOT_SCHEDULED("Not schedule."),
    REST("Rest."),
    FUTURE("Not to Date."),
    LEAVE("Leave"),
    LEAVE_DAYS("Leave %s days"),
    ABSENTEEISM("Absence"),
    ABSENTEEISM_DAYS("Absence %s Days"),
    MISS_CARD("Missed punch %s Times"),
    LATE("Late %s Minutes"),
    EARLY("Left early %s Minutes"),
    PENDING_CLOCK("Pending punch"),
    NORMAL("Normal");

    /**
     * 结果格式
     */
    private final String format;

    public String format(Object... args) {
        return String.format(format, args);
    }

}
