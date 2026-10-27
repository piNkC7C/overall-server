package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM Pay item value VO.")
@Data
public class HrmSalaryOptionValueVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10101")
    @NotNull(message = "Payroll item code is required.")
    private Integer code;

    @Schema(description = "Pay option value name.")
    private String name;

    @Schema(description = "Value.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
    @NotNull(message = "Pay item value cannot be empty.")
    @Digits(integer = 10, fraction = 2, message = "Pay item value can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal value;

}
