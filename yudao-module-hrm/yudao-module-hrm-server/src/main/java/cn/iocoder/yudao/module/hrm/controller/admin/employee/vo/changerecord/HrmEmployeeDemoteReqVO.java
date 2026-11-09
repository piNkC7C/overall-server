package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeChangeReasonEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - HRM 员工降级 Request VO")
@Data
public class HrmEmployeeDemoteReqVO {

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "异动原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Change Reason is required.")
    @InEnum(value = HrmEmployeeChangeReasonEnum.class, message = "Change Reason must be {value}.")
    private Integer reason;

    @Schema(description = "新部门编号", example = "200")
    private Long newDeptId;

    @Schema(description = "新岗位名称", example = "Java engineer.")
    @Size(max = 255, message = "New job title cannot exceed 255 characters.")
    private String newPostName;

    @Schema(description = "新职级", example = "P5")
    @Size(max = 255, message = "New job level cannot exceed 255 characters.")
    private String newPostLevel;

    @Schema(description = "新工作地点", example = "Seattle")
    @Size(max = 255, message = "New work location cannot exceed 255 characters.")
    private String newWorkAddress;

    @Schema(description = "新直属上级员工编号", example = "3")
    private Long newLeaderEmployeeId;

    @Schema(description = "生效日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Effective Date is required.")
    private LocalDateTime effectTime;

    @Schema(description = "备注", example = "Job Grade adjust.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @AssertTrue(message = "Demotionreason is invalid.")
    @JsonIgnore
    public boolean isReasonValid() {
        return reason == null || HrmEmployeeChangeReasonEnum.DEMOTION_REASONS.contains(reason);
    }

}
