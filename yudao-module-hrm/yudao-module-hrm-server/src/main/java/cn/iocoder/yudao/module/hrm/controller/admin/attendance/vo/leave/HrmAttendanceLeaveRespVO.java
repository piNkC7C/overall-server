package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM Leave record response.")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceLeaveRespVO {

    @Schema(description = "Leave record ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty(value = "Record ID", index = 0)
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @ExcelProperty(value = "Employee ID", index = 1)
    private Long employeeId;

    @Schema(description = "Employee Name", example = "John.")
    @ExcelProperty(value = "Employee Name", index = 2)
    private String employeeName;

    @Schema(description = "Employee No.", example = "HRM001")
    @ExcelProperty(value = "Employee No", index = 3)
    private String jobNumber;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    @ExcelProperty(value = "Department", index = 4)
    private String deptName;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    @ExcelProperty(value = "Job Title", index = 5)
    private String postName;

    @Schema(description = "Leave Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "Personal leave")
    @ExcelProperty(value = "Leave Type", index = 6, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_LEAVE_TYPE)
    private String type;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "Start Time", index = 7)
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "End Time", index = 8)
    private LocalDateTime endTime;

    @Schema(description = "Leave days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    @ExcelProperty(value = "Leave Days", index = 9)
    private BigDecimal day;

    @Schema(description = "Leave Reason", example = "Personal matter")
    @ExcelProperty(value = "Leave Reason", index = 10)
    private String reason;

    @Schema(description = "Notes.")
    @ExcelProperty(value = "Notes", index = 11)
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "Create Time", index = 12)
    private LocalDateTime createTime;

    @Schema(description = "Approval status.", example = "1")
    private Integer approvalStatus;

    @Schema(description = "Workflow instance code.")
    private String processInstanceId;

    @Schema(description = "Approval time.")
    private LocalDateTime approvalTime;

    @Schema(description = "Approval comment.")
    private String approvalReason;

}
