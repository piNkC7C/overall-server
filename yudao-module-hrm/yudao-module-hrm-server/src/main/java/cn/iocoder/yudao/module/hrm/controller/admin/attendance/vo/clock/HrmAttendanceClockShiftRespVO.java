package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeeActual shift response.")
@Data
public class HrmAttendanceClockShiftRespVO {

    @Schema(description = "Work time.")
    private LocalDateTime startTime;

    @Schema(description = "Clock-out time.")
    private LocalDateTime endTime;

    @Schema(description = "Work clock-in start time.")
    private LocalDateTime clockInStartTime;

    @Schema(description = "Work clock-in end time.")
    private LocalDateTime clockInEndTime;

    @Schema(description = "Clock-out window start.")
    private LocalDateTime clockOutStartTime;

    @Schema(description = "Clock-out window end.")
    private LocalDateTime clockOutEndTime;

}
