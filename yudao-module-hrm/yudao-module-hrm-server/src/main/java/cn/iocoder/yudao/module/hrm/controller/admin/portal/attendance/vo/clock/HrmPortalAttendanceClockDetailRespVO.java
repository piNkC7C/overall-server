package cn.iocoder.yudao.module.hrm.controller.admin.portal.attendance.vo.clock;

import cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.TimeRange;
import cn.iocoder.yudao.module.hrm.dal.dataobject.attendance.config.HrmAttendanceGroupDO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM employee clock-in detail response VO.")
@Data
public class HrmPortalAttendanceClockDetailRespVO {

    @Schema(description = "Attendance group name.")
    private String groupName;

    @Schema(description = "Is not Enabled Location clock-in.")
    private Boolean openPointCard;

    @Schema(description = "Is not Enabled WiFi clock-in.")
    private Boolean openWifiCard;

    @Schema(description = "Shift attendanceDay.")
    private LocalDate attendanceDate;

    @Schema(description = "Shift title, for example 09:00-18:00.")
    private String shiftTitle;

    @Schema(description = "Is not rest Day.")
    private Boolean restDay;

    @Schema(description = "Required clock-in time.")
    private LocalDateTime onDutyAttendanceTime;

    @Schema(description = "Required clock-out time.")
    private LocalDateTime offDutyAttendanceTime;

    @Schema(description = "Clock-in Location list.")
    private List<Point> points;

    @Schema(description = "WiFi list.")
    private List<Wifi> wifis;

    @Schema(description = "Next allowed punch action.")
    private NextClock nextClock;

    @Schema(description = "Today punch timeline.")
    private List<TimelineItem> timeline;

    // ==================== 内部计算字段 ====================

    @JsonIgnore
    @Schema(hidden = true)
    private HrmAttendanceGroupDO group;

    @JsonIgnore
    @Schema(hidden = true)
    private HrmAttendanceGroupDO.Shift shift;

    @JsonIgnore
    @Schema(hidden = true)
    private TimeRange clockInRange;

    @JsonIgnore
    @Schema(hidden = true)
    private TimeRange clockOutRange;

    @Schema(description = "Clock-in Location.")
    @Data
    public static class Point {

        @Schema(description = "Location name.")
        private String name;

        @Schema(description = "LocationAddress.")
        private String address;

        @Schema(description = "Latitude")
        private BigDecimal latitude;

        @Schema(description = "Longitude")
        private BigDecimal longitude;

        @Schema(description = "Valid radius (meters).")
        private Integer radius;

    }

    @Schema(description = "WiFi setting.")
    @Data
    public static class Wifi {

        @Schema(description = "WiFi name.")
        private String ssid;

        @Schema(description = "MAC Address.")
        private String mac;

    }

    @Schema(description = "Next punch action.")
    @Data
    public static class NextClock {

        @Schema(description = "Clock-in type.")
        private Integer type;

        @Schema(description = "Clock-in Stage.")
        private Integer stage;

        @Schema(description = "Required clock-in time.")
        private LocalDateTime attendanceTime;

        @Schema(description = "Status：0 not to time 1 Normal 2 update 3 late 4 left early.")
        private Integer buttonStatus;

    }

    @Schema(description = "Today punch timeline item.")
    @Data
    public static class TimelineItem {

        @Schema(description = "Clock-in type.")
        private Integer type;

        @Schema(description = "Required clock-in time.")
        private LocalDateTime attendanceTime;

        @Schema(description = "Actual clock-in time; missed punch time is empty.")
        private LocalDateTime clockTime;

        @Schema(description = "Clock-in status.")
        private Integer status;

        @Schema(description = "Is not missed punch.")
        private Boolean missCard;

        @Schema(description = "Clock-in Address.")
        private String address;

    }

}
