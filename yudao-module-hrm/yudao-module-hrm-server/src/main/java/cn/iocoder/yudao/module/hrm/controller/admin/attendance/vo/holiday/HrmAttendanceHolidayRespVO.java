package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM attendance holiday response.")
@Data
public class HrmAttendanceHolidayRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Date")
    private LocalDateTime date;

    @Schema(description = "Attendance holiday type.")
    private Integer type;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
