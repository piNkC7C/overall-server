package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "HRM employee monthly attendance summary page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmAttendanceMonthRecordPageReqVO extends PageParam {

    @Schema(description = "Employee Name or Employee No., fuzzy match.", example = "John.")
    private String search;

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Department ID list.", example = "100,101")
    private List<Long> deptIds;

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Month is required.")
    @Min(value = 1, message = "Month must be between 1 and 12.")
    @Max(value = 12, message = "Month must be between 1 and 12.")
    private Integer month;

    @Schema(description = "Perfect attendance.", example = "true")
    private Boolean fullAttendance;

}
