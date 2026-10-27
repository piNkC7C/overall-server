package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.taxrule;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.config.HrmSalaryTaxCycleTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.config.HrmSalaryTaxTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;


@Schema(description = "Admin - HRM Tax rulesave request.")
@Data
public class HrmSalaryTaxRuleSaveReqVO {

    @Schema(description = "Tax ruleID.", example = "1024")
    private Long id;

    @Schema(description = "Tax rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Wage income tax.")
    @NotBlank(message = "Tax rule name cannot be empty.")
    @Size(max = 64, message = "Tax rule name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Tax type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Tax type cannot be empty.")
    @InEnum(value = HrmSalaryTaxTypeEnum.class, message = "Tax type must be {value}.")
    private Integer type;

    @Schema(description = "Taxable.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Taxable cannot be empty.")
    private Boolean taxEnabled;

    @Schema(description = "Tax threshold.", example = "5000")
    @DecimalMin(value = "0.00", message = "Tax threshold cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Tax threshold can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal threshold;

    @Schema(description = "Decimal places.", example = "2")
    @Min(value = 0, message = "Decimal places cannot be less than 0.")
    @Max(value = 4, message = "Decimal places cannot be greater than 4.")
    private Integer decimalScale;

    @Schema(description = "Tax-cycle type.", example = "1")
    @InEnum(value = HrmSalaryTaxCycleTypeEnum.class, message = "Tax-cycle type must be {value}.")
    private Integer cycleType;

    @AssertTrue(message = "Tax-rule threshold and decimal places cannot be empty.")
    @JsonIgnore
    public boolean isTaxConfigValid() {
        return HrmSalaryTaxTypeEnum.NONE.getType().equals(type) || threshold != null && decimalScale != null;
    }

    @AssertTrue(message = "Wage-tax cycle cannot be empty.")
    @JsonIgnore
    public boolean isCycleTypeValid() {
        return ObjUtil.notEqual(HrmSalaryTaxTypeEnum.SALARY.getType(), type) || cycleType != null;
    }

}
