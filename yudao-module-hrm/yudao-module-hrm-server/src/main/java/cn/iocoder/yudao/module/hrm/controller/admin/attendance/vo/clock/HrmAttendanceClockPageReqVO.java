package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.record.HrmAttendanceClockSourceEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.record.HrmAttendanceClockStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.record.HrmAttendanceClockTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM clock-in record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmAttendanceClockPageReqVO extends PageParam {

    @Schema(description = "Employee Name or Employee No., fuzzy match.", example = "John.")
    private String search;

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Department ID list.", example = "100,101")
    private List<Long> deptIds;

    @Schema(hidden = true)
    private Collection<Long> employeeIds;

    @Schema(description = "Attendance clock-in type.", example = "1")
    @InEnum(value = HrmAttendanceClockTypeEnum.class, message = "Clock-in type must be {value}.")
    private Integer type;

    @Schema(description = "Attendance clock-in status.", example = "1")
    @InEnum(value = HrmAttendanceClockStatusEnum.class, message = "Clock-in status must be {value}.")
    private Integer status;

    @Schema(description = "Source typeArray.", example = "[1, 2]")
    @InEnum(value = HrmAttendanceClockSourceEnum.class, message = "Clock-in source must be {value}.")
    private List<Integer> sourceTypes;

    @Schema(description = "Clock-in Location, fuzzy match.", example = "Wensan Road")
    private String address;

    @Schema(description = "Work DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] attendanceTime;

    @Schema(description = "Actual clock-in time range.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] clockTime;

}
