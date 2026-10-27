package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM payroll group response.")
@Data
public class HrmSalaryGroupRespVO {

    @Schema(description = "Payroll group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Payroll group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HQ payroll group")
    private String name;

    @Schema(description = "Monthly pay standard.", example = "21.75")
    private BigDecimal salaryStandard;

    @Schema(description = "Confirmation 、Salary ChangeMonth rule.")
    private String changeRule;

    @Schema(description = "Tax ruleID.", example = "1024")
    private Long taxRuleId;

    @Schema(description = "Tax rule name.", example = "Wage income tax.")
    private String taxRuleName;

    @Schema(description = "Applicable department IDs.")
    private List<Long> deptIds;

    @Schema(description = "Applicable department names.")
    private List<String> deptNames;

    @Schema(description = "Applicable employee IDs.")
    private List<Long> employeeIds;

    @Schema(description = "Applicable employee names.")
    private List<String> employeeNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
