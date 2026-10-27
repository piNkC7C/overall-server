package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeChangeReasonEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeChangeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee change record create request VO.")
@Data
public class HrmEmployeeChangeRecordCreateReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Change type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Change type cannot be empty.")
    @InEnum(value = HrmEmployeeChangeTypeEnum.class, message = "Change type must be {value}.")
    private Integer type;

    @Schema(description = "Change Reason", example = "1")
    @InEnum(value = HrmEmployeeChangeReasonEnum.class, message = "Change Reason must be {value}.")
    private Integer reason;

    @Schema(description = "Previous department ID.", example = "100")
    private Long oldDeptId;

    @Schema(description = "Original job title.", example = "Java engineer.")
    @Size(max = 255, message = "Original job title cannot exceed 255 characters.")
    private String oldPostName;

    @Schema(description = "Original job level.", example = "P5")
    @Size(max = 255, message = "Original job level cannot exceed 255 characters.")
    private String oldPostLevel;

    @Schema(description = "Original work location.", example = "Seattle")
    @Size(max = 255, message = "Original work location cannot exceed 255 characters.")
    private String oldWorkAddress;

    @Schema(description = "Previous manager employee ID.", example = "2")
    private Long oldLeaderEmployeeId;

    @Schema(description = "New department ID.", example = "200")
    private Long newDeptId;

    @Schema(description = "New job title.", example = "Senior Java engineer")
    @Size(max = 255, message = "New job title cannot exceed 255 characters.")
    private String newPostName;

    @Schema(description = "New job level.", example = "P6")
    @Size(max = 255, message = "New job level cannot exceed 255 characters.")
    private String newPostLevel;

    @Schema(description = "New work location.", example = "Shanghai")
    @Size(max = 255, message = "New work location cannot exceed 255 characters.")
    private String newWorkAddress;

    @Schema(description = "New manager employee ID.", example = "3")
    private Long newLeaderEmployeeId;

    @Schema(description = "Probation, in months.", example = "3")
    @Min(value = 0, message = "Probation period cannot be less than 0.")
    @Max(value = 6, message = "Probation period cannot exceed 6 months.")
    private Integer probation;

    @Schema(description = "Effective time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Effective time cannot be empty.")
    private LocalDateTime effectTime;

    @Schema(description = "Notes.", example = "Annual promotion")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
