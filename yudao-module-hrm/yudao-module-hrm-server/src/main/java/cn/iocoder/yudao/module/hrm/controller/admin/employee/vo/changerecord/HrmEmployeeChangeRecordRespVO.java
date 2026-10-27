package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee change record response VO.")
@Data
public class HrmEmployeeChangeRecordRespVO {

    @Schema(description = "Change ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Change type.", example = "5")
    private Integer type;

    @Schema(description = "Change Reason", example = "1")
    private Integer reason;

    @Schema(description = "Previous department ID.", example = "100")
    private Long oldDeptId;

    @Schema(description = "Previous department name.", example = "Engineering.")
    private String oldDeptName;

    @Schema(description = "New department ID.", example = "200")
    private Long newDeptId;

    @Schema(description = "New department name.", example = "Product")
    private String newDeptName;

    @Schema(description = "Original job title.")
    private String oldPostName;

    @Schema(description = "New job title.")
    private String newPostName;

    @Schema(description = "Original job level.")
    private String oldPostLevel;

    @Schema(description = "New job level.")
    private String newPostLevel;

    @Schema(description = "Original work location.")
    private String oldWorkAddress;

    @Schema(description = "New work location.")
    private String newWorkAddress;

    @Schema(description = "Previous manager employee ID.")
    private Long oldLeaderEmployeeId;

    @Schema(description = "Previous manager name.")
    private String oldLeaderEmployeeName;

    @Schema(description = "New manager employee ID.")
    private Long newLeaderEmployeeId;

    @Schema(description = "New manager name.")
    private String newLeaderEmployeeName;

    @Schema(description = "Probation, in months.")
    private Integer probation;

    @Schema(description = "Effective Date")
    private LocalDateTime effectTime;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
