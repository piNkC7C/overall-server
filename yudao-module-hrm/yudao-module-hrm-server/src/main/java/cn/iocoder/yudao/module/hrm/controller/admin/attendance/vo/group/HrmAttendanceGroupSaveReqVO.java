package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.group;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils;
import cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.TimeRange;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceAbsenteeismDeductMethodEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceHolidayTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceLateEarlyDeductMethodEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceMisscardDeductMethodEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Schema(description = "Admin - HRM attendance group save request.")
@Data
public class HrmAttendanceGroupSaveReqVO {

    private static final Set<Integer> POINT_RADIUS_VALUES = new HashSet<>(
            Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000));

    @Schema(description = "Attendance group code.", example = "1024")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HQ attendance group")
    @NotBlank(message = "Attendance group name is required.")
    @Size(max = 50, message = "Attendance group name cannot exceed 50 characters.")
    @DiffLogField(name = "Attendance group name.")
    private String name;

    @Schema(description = "Is not Enabled WiFi clock-in.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not Enabled WiFi clock-in is required.")
    @DiffLogField(name = "Is not Enabled WiFi clock-in.")
    private Boolean openWifiCard;

    @Schema(description = "Is not Enabled Location clock-in.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not Enabled Location clock-in is required.")
    @DiffLogField(name = "Is not Enabled Location clock-in.")
    private Boolean openPointCard;

    @Schema(description = "Rest on statutory holidays.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Rest on statutory holidays cannot be empty.")
    @DiffLogField(name = "Rest on Statutory Holidays")
    private Boolean rest;

    @Schema(description = "Special-date settingArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Special-date setting cannot be empty.")
    @DiffLogField(name = "Special Date Settings")
    private List<SpecialDate> specialDates;

    @Schema(description = "DepartmentRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1024, 2048]")
    @NotNull(message = "DepartmentRange is required.")
    @DiffLogField(name = "Applies to Departments")
    private List<@NotNull(message = "Department code is required.") Long> deptIds;

    @Schema(description = "EmployeeRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1024, 2048]")
    @NotNull(message = "EmployeeRange is required.")
    @DiffLogField(name = "Applies to Employees")
    private List<@NotNull(message = "Employee code is required.") Long> employeeIds;

    @Schema(description = "Shift setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Shift setting is required.")
    @DiffLogField(name = "Shift setting.")
    private List<Shift> shifts;

    @Schema(description = "Clock-in Location.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Clock-in Location is required.")
    @DiffLogField(name = "Clock-in Location.")
    private List<Point> points;

    @Schema(description = "Clock-in WiFi.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Clock-in WiFi is required.")
    @DiffLogField(name = "Clock-in WiFi.")
    private List<Wifi> wifis;

    @Schema(description = "Deduction rule.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Deduction rule cannot be empty.")
    @DiffLogField(name = "Deduction Rule")
    private DeductRule deductRule;

    @Schema(description = "Admin - HRM attendance groupSpecial date.")
    @Data
    public static class SpecialDate {

        @Schema(description = "Date type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Special date type cannot be empty.")
        @InEnum(value = HrmAttendanceHolidayTypeEnum.class, message = "Special date type must be {value}.")
        private Integer type;

        @Schema(description = "Special date.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Special date cannot be empty.")
        private LocalDateTime date;
    }

    @Schema(description = "Admin - HRM attendance group shift setting.")
    @Data
    public static class Shift {

        @Schema(description = "WorkdayArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2, 3, 4, 5]")
        @NotEmpty(message = "Shift Workday is required.")
        private List<@NotNull(message = "Shift Workday is required.")
                @Min(value = 1, message = "Shift weekday must be between 1 and 7.")
                @Max(value = 7, message = "Shift weekday must be between 1 and 7.") Integer> weeks;

        @Schema(description = "Work time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Work time is required.")
        private LocalTime startTime;

        @Schema(description = "Clock-out time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Clock-out time cannot be empty.")
        private LocalTime endTime;

        @Schema(description = "Work clock-in start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "08:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Work clock-in start time is required.")
        private LocalTime clockInStartTime;

        @Schema(description = "Work clock-in end time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Work clock-in end time is required.")
        private LocalTime clockInEndTime;

        @Schema(description = "Clock-out window start.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Clock-out window start cannot be empty.")
        private LocalTime clockOutStartTime;

        @Schema(description = "Clock-out window end.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Clock-out window end cannot be empty.")
        private LocalTime clockOutEndTime;

        @Schema(description = "Rest start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Rest start time is required.")
        private LocalTime restStartTime;

        @Schema(description = "Rest end time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13:00")
        @JsonFormat(pattern = "HH:mm")
        @NotNull(message = "Rest end time is required.")
        private LocalTime restEndTime;

        @Schema(description = "Exclude breaks from work hours.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Break-time calculation cannot be empty.")
        private Boolean excludeRestTime;
    }

    @Schema(description = "Admin - HRM attendance group clock-in Location.")
    @Data
    public static class Point {

        @Schema(description = "Location name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HQ office")
        @NotBlank(message = "Location name is required.")
        @Size(max = 50, message = "Location name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "LocationAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Market Street, Seattle")
        @NotBlank(message = "LocationAddress is required.")
        @Size(max = 255, message = "LocationAddress cannot exceed 255 characters.")
        private String address;

        @Schema(description = "Latitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "39.983424")
        @NotNull(message = "Latitude is required.")
        @DecimalMin(value = "-90", message = "Latitude must be between -90 and 90.")
        @DecimalMax(value = "90", message = "Latitude must be between -90 and 90.")
        private BigDecimal latitude;

        @Schema(description = "Longitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "116.322987")
        @NotNull(message = "Longitude is required.")
        @DecimalMin(value = "-180", message = "Longitude must be between -180 and 180.")
        @DecimalMax(value = "180", message = "Longitude must be between -180 and 180.")
        private BigDecimal longitude;

        @Schema(description = "Valid punch radius, in meters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300")
        @NotNull(message = "Valid clock-in radius cannot be empty.")
        @Positive(message = "Valid clock-in radius must be greater than 0.")
        private Integer radius;
    }

    @Schema(description = "Admin - HRM attendance group WiFi setting.")
    @Data
    public static class Wifi {

        @Schema(description = "WiFi name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office-WiFi")
        @NotBlank(message = "WiFi name is required.")
        @Size(max = 50, message = "WiFi name cannot exceed 50 characters.")
        private String ssid;

        @Schema(description = "MAC Address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "00:11:22:33:44:55")
        @NotBlank(message = "MAC Address is required.")
        @Pattern(regexp = "^((([0-9a-fA-F]{2}:){5})|(([0-9a-fA-F]{2}-){5}))[0-9a-fA-F]{2}$",
                message = "MAC Address format is invalid.")
        private String mac;
    }

    @Schema(description = "Admin - HRM attendance groupDeduction rule.")
    @Data
    public static class DeductRule {

        @Schema(description = "Late deduction method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Late deduction method cannot be empty.")
        @InEnum(value = HrmAttendanceLateEarlyDeductMethodEnum.class, message = "Late deduction method must be {value}.")
        private Integer lateMethod;

        @Schema(description = "Late deduction amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.00")
        @NotNull(message = "Late deduction amount cannot be empty.")
        @DecimalMin(value = "0", message = "Late deduction amount cannot be less than 0.")
        @Digits(integer = 8, fraction = 2, message = "Late deduction amount can have at most 8 integer digits and 2 decimal places.")
        private BigDecimal lateDeductMoney;

        @Schema(description = "Early-leave deduction method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Early-leave deduction method cannot be empty.")
        @InEnum(value = HrmAttendanceLateEarlyDeductMethodEnum.class, message = "Early-leave deduction method must be {value}.")
        private Integer earlyMethod;

        @Schema(description = "Early-leave deduction amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.00")
        @NotNull(message = "Early-leave deduction amount cannot be empty.")
        @DecimalMin(value = "0", message = "Early-leave deduction amount cannot be less than 0.")
        @Digits(integer = 8, fraction = 2, message = "Early-leave deduction amount can have at most 8 integer digits and 2 decimal places.")
        private BigDecimal earlyDeductMoney;

        @Schema(description = "Absenteeism deduction method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Absenteeism deduction method cannot be empty.")
        @InEnum(value = HrmAttendanceAbsenteeismDeductMethodEnum.class, message = "Absenteeism deduction method must be {value}.")
        private Integer absenteeismMethod;

        @Schema(description = "Absenteeism deduction amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Absenteeism deduction amount cannot be empty.")
        @DecimalMin(value = "0", message = "Absenteeism deduction amount cannot be less than 0.")
        @Digits(integer = 8, fraction = 2, message = "Absenteeism deduction amount can have at most 8 integer digits and 2 decimal places.")
        private BigDecimal absenteeismDeductMoney;

        @Schema(description = "Missed-punch deduction method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Missed-punch deduction method cannot be empty.")
        @InEnum(value = HrmAttendanceMisscardDeductMethodEnum.class, message = "Missed-punch deduction method must be {value}.")
        private Integer misscardMethod;

        @Schema(description = "Missed-punch deduction amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20.00")
        @NotNull(message = "Missed-punch deduction amount cannot be empty.")
        @DecimalMin(value = "0", message = "Missed-punch deduction amount cannot be less than 0.")
        @Digits(integer = 8, fraction = 2, message = "Missed-punch deduction amount can have at most 8 integer digits and 2 decimal places.")
        private BigDecimal misscardDeductMoney;
    }

    @AssertTrue(message = "Shifts cannot share the same weekday.")
    @JsonIgnore
    public boolean isShiftWeeksUnique() {
        if (CollUtil.isEmpty(shifts)) {
            return true;
        }
        Set<Integer> weeks = new HashSet<>();
        return shifts.stream().allMatch(shift -> shift != null && CollUtil.isNotEmpty(shift.getWeeks())
                && shift.getWeeks().stream().allMatch(weeks::add));
    }

    @AssertTrue(message = "Shift work, clock-in window, or break times are invalid.")
    @JsonIgnore
    public boolean isShiftTimeValid() {
        if (CollUtil.isEmpty(shifts)) {
            return true;
        }
        return shifts.stream().allMatch(this::isShiftTimeValid);
    }

    private boolean isShiftTimeValid(Shift shift) {
        if (shift == null || shift.getStartTime() == null || shift.getEndTime() == null
                || shift.getClockInStartTime() == null || shift.getClockInEndTime() == null
                || shift.getClockOutStartTime() == null || shift.getClockOutEndTime() == null
                || shift.getRestStartTime() == null || shift.getRestEndTime() == null
                || shift.getExcludeRestTime() == null) {
            // 交由内嵌字段的 @NotNull 输出具体校验错误
            return true;
        }
        if (shift.getStartTime().equals(shift.getEndTime())
                || shift.getClockInStartTime().equals(shift.getClockInEndTime())
                || shift.getClockOutStartTime().equals(shift.getClockOutEndTime())) {
            return false;
        }
        LocalDate attendanceDate = LocalDate.of(2000, 1, 3);
        TimeRange shiftTimeRange = CollUtil.getFirst(LocalDateTimeUtils.buildDailyTimeRanges(
                attendanceDate, attendanceDate, shift.getStartTime(), shift.getEndTime()));
        return LocalDateTimeUtils.findDailyTimeRange(
                attendanceDate, shift.getClockInStartTime(), shift.getClockInEndTime(),
                shiftTimeRange.getStartTime()) != null
                && LocalDateTimeUtils.findDailyTimeRange(
                        attendanceDate, shift.getClockOutStartTime(), shift.getClockOutEndTime(),
                        shiftTimeRange.getEndTime()) != null
                && isRestTimeValid(attendanceDate, shift, shiftTimeRange);
    }

    private boolean isRestTimeValid(LocalDate attendanceDate, Shift shift,
                                    TimeRange shiftTimeRange) {
        if (Boolean.FALSE.equals(shift.getExcludeRestTime())) {
            return true;
        }
        if (shift.getRestStartTime().equals(shift.getRestEndTime())) {
            return false;
        }
        List<TimeRange> restTimeRanges = LocalDateTimeUtils.buildDailyTimeRanges(
                attendanceDate.minusDays(1), attendanceDate.plusDays(1),
                shift.getRestStartTime(), shift.getRestEndTime());
        return CollUtil.findOne(restTimeRanges, restTimeRange ->
                LocalDateTimeUtils.isAfterOrEqual(restTimeRange.getStartTime(), shiftTimeRange.getStartTime())
                        && LocalDateTimeUtils.isBeforeOrEqual(
                        restTimeRange.getEndTime(), shiftTimeRange.getEndTime())) != null;
    }

    @AssertTrue(message = "Special dates cannot be duplicated.")
    @JsonIgnore
    public boolean isSpecialDatesUnique() {
        if (CollUtil.isEmpty(specialDates)) {
            return true;
        }
        Set<LocalDate> dates = new HashSet<>();
        return specialDates.stream().allMatch(specialDate -> specialDate != null && specialDate.getDate() != null
                && dates.add(specialDate.getDate().toLocalDate()));
    }

    @AssertTrue(message = "Select at least one department or employee for the attendance group.")
    @JsonIgnore
    public boolean isScopeValid() {
        if (deptIds == null || employeeIds == null) {
            return true;
        }
        return CollUtil.isNotEmpty(deptIds) || CollUtil.isNotEmpty(employeeIds);
    }

    @AssertTrue(message = "Attendance group at least need to need Enabled Location clock-in or WiFi clock-in.")
    @JsonIgnore
    public boolean isClockMethodValid() {
        if (openPointCard == null || openWifiCard == null) {
            return true;
        }
        return openPointCard || openWifiCard;
    }

    @AssertTrue(message = "Enabled Location clock-in time, clock-in Location is required.")
    @JsonIgnore
    public boolean isPointSettingValid() {
        if (Boolean.TRUE.equals(openPointCard)) {
            return CollUtil.isNotEmpty(points);
        }
        return true;
    }

    @AssertTrue(message = "Enabled WiFi clock-in time, clock-in WiFi is required.")
    @JsonIgnore
    public boolean isWifiSettingValid() {
        if (Boolean.TRUE.equals(openWifiCard)) {
            return CollUtil.isNotEmpty(wifis);
        }
        return true;
    }

    @AssertTrue(message = "Valid clock-in radius must be 100-1000 meters in 100-meter steps, or 2000 or 3000 meters.")
    @JsonIgnore
    public boolean isPointRadiusValid() {
        if (CollUtil.isEmpty(points)) {
            return true;
        }
        return points.stream().allMatch(point -> point != null
                && point.getRadius() != null && POINT_RADIUS_VALUES.contains(point.getRadius()));
    }

}
