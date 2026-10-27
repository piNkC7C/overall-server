package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import cn.iocoder.yudao.module.hrm.enums.salary.employee.HrmSalaryBatchAdjustTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.employee.HrmSalaryChangeReasonEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM batch Salary Change request.")
@Data
public class HrmSalaryEmployeeInfoUpdateListReqVO {

    @Schema(description = "Employee code list.", example = "[1024, 1025]")
    private List<@NotNull(message = "Employee is required.") Long> employeeIds;

    @Schema(description = "Department code list.", example = "[100, 101]")
    private List<@NotNull(message = "Department is required.") Long> deptIds;

    @Schema(description = "Salary Change method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Salary Change method is required.")
    @InEnum(value = HrmSalaryBatchAdjustTypeEnum.class, message = "Salary Change method must be {value}.")
    private Integer type;

    @Schema(description = "Adjust reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Salary Changereason is required.")
    @InEnum(value = HrmSalaryChangeReasonEnum.class, message = "Salary Changereason must be {value}.")
    private Integer changeReason;

    @Schema(description = "Effective Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Salary ChangeEffective Date is required.")
    private LocalDateTime effectTime;

    @Schema(description = "Notes.", example = "Annual company-wide raise")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "Payroll item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Salary Change item is required.")
    @Valid
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @AssertTrue(message = "At least need to need select one department or employee.")
    @JsonIgnore
    public boolean isScopeValid() {
        return CollUtil.isNotEmpty(deptIds) || CollUtil.isNotEmpty(employeeIds);
    }

}
