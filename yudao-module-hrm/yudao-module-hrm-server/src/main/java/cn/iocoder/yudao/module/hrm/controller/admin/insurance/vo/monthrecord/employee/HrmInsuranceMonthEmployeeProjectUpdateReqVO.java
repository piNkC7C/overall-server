package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - HRM 员工月度社保项目调整 Request VO")
@Data
public class HrmInsuranceMonthEmployeeProjectUpdateReqVO {

    @Schema(description = "社保方案项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security plan item code is required.")
    private Long schemeProjectId;

    @Schema(description = "缴纳基数", example = "10000.00")
    @DecimalMin(value = "0", message = "Contribution base cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Contribution base can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal baseAmount;

    @Schema(description = "公司缴纳金额", example = "1600.00")
    @DecimalMin(value = "0", message = "Company contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Company contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal corporateAmount;

    @Schema(description = "个人缴纳金额", example = "800.00")
    @DecimalMin(value = "0", message = "Employee contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Employee contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal personalAmount;

}
