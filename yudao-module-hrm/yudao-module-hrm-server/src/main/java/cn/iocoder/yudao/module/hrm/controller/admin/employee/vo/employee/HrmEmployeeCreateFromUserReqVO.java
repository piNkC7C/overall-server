package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM create employee from admin user request VO.")
@Data
public class HrmEmployeeCreateFromUserReqVO {

    @Schema(description = "Admin user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Admin user ID cannot be empty.")
    private Long userId;

    @Schema(description = "Employee No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HRM001")
    @NotBlank(message = "Employee No. is required.")
    @Size(max = 64, message = "Employee No. cannot exceed 64 characters.")
    private String jobNumber;

    @Schema(description = "Employeephone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotBlank(message = "Employeephone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Direct Manageremployee code.", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "Employment Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employment Type is required.")
    @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
    private Integer type;

    @Schema(description = "Employee status. Required for non-regular employees.", example = "3")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
    private Integer status;

    @Schema(description = "Hire Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Hire Date is required.")
    private LocalDateTime entryTime;

    @Schema(description = "Probation in months. Required for regular employees.", example = "3")
    @Min(value = 0, message = "Probation period cannot be less than 0.")
    @Max(value = 6, message = "Probation period cannot exceed 6 months.")
    private Integer probation;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    @Size(max = 255, message = "Job Title name cannot exceed 255 characters.")
    private String postName;

    @Schema(description = "Job Grade", example = "P6")
    @Size(max = 255, message = "Job Grade cannot exceed 255 characters.")
    private String postLevel;

    @Schema(description = "Work City", example = "Seattle")
    @Size(max = 64, message = "Work City cannot exceed 64 characters.")
    private String workCity;

    @Schema(description = "Work Location", example = "Downtown")
    @Size(max = 255, message = "Work Location cannot exceed 255 characters.")
    private String workAddress;

    @Schema(description = "Notes.", example = "Create profiles from admin users in bulk")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @AssertTrue(message = "Full-time probation period cannot be empty.")
    @JsonIgnore
    public boolean isProbationValid() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.FORMAL.getType(), type) || probation != null;
    }

    @AssertTrue(message = "Not regular employee status is required.")
    @JsonIgnore
    public boolean isStatusRequired() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.INFORMAL.getType(), type) || status != null;
    }

    @AssertTrue(message = "Employee status and Employment Type does not match.")
    @JsonIgnore
    public boolean isStatusValid() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.INFORMAL.getType(), type)
                || status == null || HrmEmployeeStatusEnum.INFORMAL_STATUSES.contains(status);
    }

}
