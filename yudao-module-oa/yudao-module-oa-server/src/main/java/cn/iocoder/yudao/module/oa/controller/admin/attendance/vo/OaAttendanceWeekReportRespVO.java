package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA attendanceWeekly Report response.")
@Data
@Accessors(chain = true)
public class OaAttendanceWeekReportRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String userName;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Each Dayattendance list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DailyAttendance> dailyAttendances;

    @Schema(description = "Admin - OA each Dayattendance response.")
    @Data
    @Accessors(chain = true)
    public static class DailyAttendance {

        @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-07")
        private LocalDate date;

        @Schema(description = "Work attendancerecord code.", example = "1024")
        private Long clockInId;

        @Schema(description = "Work clock-in time.", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime clockInTime;

        @Schema(description = "Work clock-in status.", example = "1")
        private Integer clockInStatus;

        @Schema(description = "Clock-out attendance record ID.", example = "1025")
        private Long clockOutId;

        @Schema(description = "Clock Outtime.", type = "integer", format = "int64", example = "1789380000000")
        private LocalDateTime clockOutTime;

        @Schema(description = "Clock Outstatus.", example = "1")
        private Integer clockOutStatus;

    }

}
