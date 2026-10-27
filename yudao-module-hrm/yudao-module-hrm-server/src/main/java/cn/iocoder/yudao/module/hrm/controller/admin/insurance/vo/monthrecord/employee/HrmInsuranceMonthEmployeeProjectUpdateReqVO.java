package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "HRM employee monthly benefits item adjust request VO.")
@Data
public class HrmInsuranceMonthEmployeeProjectUpdateReqVO {

    @Schema(description = "Social security plan item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security plan item code is required.")
    private Long schemeProjectId;

    @Schema(description = "Contribution Base", example = "10000.00")
    @DecimalMin(value = "0", message = "Contribution base cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Contribution base can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal baseAmount;

    @Schema(description = "Company contribution amount.", example = "1600.00")
    @DecimalMin(value = "0", message = "Company contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Company contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal corporateAmount;

    @Schema(description = "Employee contribution amount.", example = "800.00")
    @DecimalMin(value = "0", message = "Employee contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Employee contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal personalAmount;

}
