package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Schema(description = "Admin - HRM attendance group response.")
@Data
public class HrmAttendanceGroupRespVO {

    @Schema(description = "Attendance group code.", example = "1024")
    private Long id;

    @Schema(description = "Name.", example = "HQ attendance group")
    private String name;

    @Schema(description = "Is not Enabled WiFi clock-in.")
    private Boolean openWifiCard;

    @Schema(description = "Is not Enabled Location clock-in.")
    private Boolean openPointCard;

    @Schema(description = "Rest on statutory holidays.")
    private Boolean rest;

    @Schema(description = "Is not default setting.")
    private Boolean defaultStatus;

    @Schema(description = "Special-date settingArray.")
    private List<SpecialDate> specialDates;

    @Schema(description = "DepartmentRange.")
    private List<Long> deptIds;

    @Schema(description = "Applicable department name.")
    private List<String> deptNames;

    @Schema(description = "EmployeeRange.")
    private List<Long> employeeIds;

    @Schema(description = "Applicable employee name.")
    private List<String> employeeNames;

    @Schema(description = "Shift setting.")
    private List<Shift> shifts;

    @Schema(description = "Clock-in Location.")
    private List<Point> points;

    @Schema(description = "Clock-in WiFi.")
    private List<Wifi> wifis;

    @Schema(description = "Deduction rule.")
    private DeductRule deductRule;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Admin - HRM attendance groupSpecial date response.")
    @Data
    public static class SpecialDate {

        @Schema(description = "Date type.", example = "1")
        private Integer type;

        @Schema(description = "Special date.")
        private LocalDateTime date;
    }

    @Schema(description = "Admin - HRM attendance group shift setting response.")
    @Data
    public static class Shift {

        @Schema(description = "WorkdayArray.", example = "[1, 2, 3, 4, 5]")
        private List<Integer> weeks;

        @Schema(description = "Work time.", example = "09:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime startTime;

        @Schema(description = "Clock-out time.", example = "18:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime endTime;

        @Schema(description = "Work clock-in start time.", example = "08:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime clockInStartTime;

        @Schema(description = "Work clock-in end time.", example = "10:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime clockInEndTime;

        @Schema(description = "Clock-out window start.", example = "17:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime clockOutStartTime;

        @Schema(description = "Clock-out window end.", example = "20:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime clockOutEndTime;

        @Schema(description = "Rest start time.", example = "12:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime restStartTime;

        @Schema(description = "Rest end time.", example = "13:00")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime restEndTime;

        @Schema(description = "Exclude breaks from work hours.")
        private Boolean excludeRestTime;
    }

    @Schema(description = "Admin - HRM attendance group clock-in Location response.")
    @Data
    public static class Point {

        @Schema(description = "Location name.", example = "HQ office")
        private String name;

        @Schema(description = "LocationAddress.", example = "Market Street, Seattle")
        private String address;

        @Schema(description = "Latitude", example = "39.983424")
        private BigDecimal latitude;

        @Schema(description = "Longitude", example = "116.322987")
        private BigDecimal longitude;

        @Schema(description = "Valid punch radius, in meters.", example = "300")
        private Integer radius;
    }

    @Schema(description = "Admin - HRM attendance group WiFi setting response.")
    @Data
    public static class Wifi {

        @Schema(description = "WiFi name.", example = "Office-WiFi")
        private String ssid;

        @Schema(description = "MAC Address.", example = "00:11:22:33:44:55")
        private String mac;
    }

    @Schema(description = "Admin - HRM attendance groupDeduction rule response.")
    @Data
    public static class DeductRule {

        @Schema(description = "Late deduction method.", example = "1")
        private Integer lateMethod;

        @Schema(description = "Late deduction amount.", example = "10.00")
        private BigDecimal lateDeductMoney;

        @Schema(description = "Early-leave deduction method.", example = "1")
        private Integer earlyMethod;

        @Schema(description = "Early-leave deduction amount.", example = "10.00")
        private BigDecimal earlyDeductMoney;

        @Schema(description = "Absenteeism deduction method.", example = "1")
        private Integer absenteeismMethod;

        @Schema(description = "Absenteeism deduction amount.", example = "100.00")
        private BigDecimal absenteeismDeductMoney;

        @Schema(description = "Missed-punch deduction method.", example = "1")
        private Integer misscardMethod;

        @Schema(description = "Missed-punch deduction amount.", example = "20.00")
        private BigDecimal misscardDeductMoney;
    }

}
