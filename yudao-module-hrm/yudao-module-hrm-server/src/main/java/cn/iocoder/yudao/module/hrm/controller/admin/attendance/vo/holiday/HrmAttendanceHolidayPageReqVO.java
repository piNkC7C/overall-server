package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceHolidayTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM attendance holiday page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmAttendanceHolidayPageReqVO extends PageParam {

    @Schema(description = "DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] date;

    @Schema(description = "Holiday type.", example = "1")
    @InEnum(value = HrmAttendanceHolidayTypeEnum.class, message = "Holiday type must be {value}.")
    private Integer type;

}
