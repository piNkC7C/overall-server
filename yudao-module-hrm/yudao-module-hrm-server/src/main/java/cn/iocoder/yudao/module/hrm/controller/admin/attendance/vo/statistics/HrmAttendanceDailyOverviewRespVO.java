package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock.HrmAttendanceClockRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee daily clock-in overview response VO.")
@Data
public class HrmAttendanceDailyOverviewRespVO {

    @Schema(description = "Clock-in record.")
    private List<HrmAttendanceClockRespVO> clocks;

    @Schema(description = "Attendance result.")
    private String attendanceResult;

    @Schema(description = "Punch overview item.")
    private List<OverviewItem> overviews;

    @Schema(description = "Daily clock-in overview display item response VO.")
    @Data
    public static class OverviewItem {

        @Schema(description = "Clock-in type.")
        private String type;

        @Schema(description = "Clock-in time.")
        private String time;

        @Schema(description = "Clock-in status.")
        private String status;

        @Schema(description = "Attendance result.")
        private String text;

    }

}
