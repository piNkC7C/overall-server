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

@Schema(description = "管理后台 - HRM 从后台用户创建员工 Request VO")
@Data
public class HrmEmployeeCreateFromUserReqVO {

    @Schema(description = "后台用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Admin user ID cannot be empty.")
    private Long userId;

    @Schema(description = "工号", requiredMode = Schema.RequiredMode.REQUIRED, example = "HRM001")
    @NotBlank(message = "Employee No. is required.")
    @Size(max = 64, message = "Employee No. cannot exceed 64 characters.")
    private String jobNumber;

    @Schema(description = "员工手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotBlank(message = "Employeephone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "部门编号", example = "100")
    private Long deptId;

    @Schema(description = "直属上级员工编号", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "聘用形式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employment Type is required.")
    @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
    private Integer type;

    @Schema(description = "员工状态；非正式员工必填", example = "3")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
    private Integer status;

    @Schema(description = "入职时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Hire Date is required.")
    private LocalDateTime entryTime;

    @Schema(description = "试用期，单位：月；正式员工必填", example = "3")
    @Min(value = 0, message = "Probation period cannot be less than 0.")
    @Max(value = 6, message = "Probation period cannot exceed 6 months.")
    private Integer probation;

    @Schema(description = "职位名称", example = "Java engineer.")
    @Size(max = 255, message = "Job Title name cannot exceed 255 characters.")
    private String postName;

    @Schema(description = "岗位职级", example = "P6")
    @Size(max = 255, message = "Job Grade cannot exceed 255 characters.")
    private String postLevel;

    @Schema(description = "工作城市", example = "Seattle")
    @Size(max = 64, message = "Work City cannot exceed 64 characters.")
    private String workCity;

    @Schema(description = "工作地点", example = "Downtown")
    @Size(max = 255, message = "Work Location cannot exceed 255 characters.")
    private String workAddress;

    @Schema(description = "备注", example = "Create profiles from admin users in bulk")
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
