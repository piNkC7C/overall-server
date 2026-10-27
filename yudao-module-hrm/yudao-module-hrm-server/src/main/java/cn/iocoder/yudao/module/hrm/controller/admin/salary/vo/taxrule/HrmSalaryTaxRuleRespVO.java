package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.taxrule;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM Tax rule response.")
@Data
public class HrmSalaryTaxRuleRespVO {

    @Schema(description = "Tax ruleID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Tax rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Wage income tax.")
    private String name;

    @Schema(description = "Tax type.", example = "1")
    private Integer type;

    @Schema(description = "Taxable.", example = "true")
    private Boolean taxEnabled;

    @Schema(description = "Tax threshold.", example = "5000")
    private BigDecimal threshold;

    @Schema(description = "Decimal places.", example = "2")
    private Integer decimalScale;

    @Schema(description = "Tax-cycle type.", example = "1")
    private Integer cycleType;

    @Schema(description = "Used this rule payroll group quantity.", example = "2")
    private Long usedGroupCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
