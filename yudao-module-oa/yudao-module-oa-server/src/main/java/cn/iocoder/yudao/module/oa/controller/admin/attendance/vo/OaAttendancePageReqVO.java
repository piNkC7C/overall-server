package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.attendance.OaAttendanceStatusEnum;
import cn.iocoder.yudao.module.oa.enums.attendance.OaAttendanceTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA attendance page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaAttendancePageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Attendance type.", example = "1")
    @InEnum(value = OaAttendanceTypeEnum.class, message = "Attendance type must be {value}.")
    private Integer type;

    @Schema(description = "Attendance status.", example = "1")
    @InEnum(value = OaAttendanceStatusEnum.class, message = "Attendance status must be {value}.")
    private Integer status;

    @Schema(description = "Attendance time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] attendanceTime;

}
