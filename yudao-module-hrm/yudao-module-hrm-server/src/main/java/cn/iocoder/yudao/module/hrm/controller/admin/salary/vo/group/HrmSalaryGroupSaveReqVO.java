package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.group;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM payroll group save request.")
@Data
public class HrmSalaryGroupSaveReqVO {

    @Schema(description = "Payroll group code.", example = "1024")
    private Long id;

    @Schema(description = "Payroll group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HQ payroll group")
    @NotBlank(message = "Payroll group name is required.")
    @Size(max = 64, message = "Payroll group name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Tax ruleID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Tax rule cannot be empty.")
    private Long taxRuleId;

    @Schema(description = "Applicable department IDs.", example = "[100, 101]")
    private List<Long> deptIds;

    @Schema(description = "Applicable employee IDs.", example = "[1024, 1025]")
    private List<Long> employeeIds;

    @AssertTrue(message = "Applicable departments and employees cannot both be empty.")
    @JsonIgnore
    public boolean isScopeValid() {
        return CollUtil.isNotEmpty(deptIds) || CollUtil.isNotEmpty(employeeIds);
    }

}
