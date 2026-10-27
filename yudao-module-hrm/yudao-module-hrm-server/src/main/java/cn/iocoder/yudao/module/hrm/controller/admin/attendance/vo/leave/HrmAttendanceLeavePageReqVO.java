package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave;

import cn.iocoder.yudao.framework.common.pojo.SortablePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "HRM Leave record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmAttendanceLeavePageReqVO extends SortablePageParam {

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Department ID list.", example = "[100, 101]")
    private List<Long> deptIds;

    @Schema(description = "Employee Name or Employee No.", example = "John.")
    private String employeeKeyword;

    @Schema(description = "Leave TypeArray.", example = "[Personal leave, Sick leave]")
    private List<String> types;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Start time.")
    private LocalDateTime[] startTime;

    @Schema(description = "Approval status.", example = "2")
    private Integer approvalStatus;

    @Schema(hidden = true)
    private Collection<Long> employeeIds;

}
