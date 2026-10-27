package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM employeeActual shift request.")
@Data
public class HrmAttendanceClockShiftReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "Attendance time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Attendance time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime attendanceTime;

}
