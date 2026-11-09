package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - HRM 薪资项值 VO")
@Data
public class HrmSalaryOptionValueVO {

    @Schema(description = "编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "10101")
    @NotNull(message = "Payroll item code is required.")
    private Integer code;

    @Schema(description = "薪资选项值名称")
    private String name;

    @Schema(description = "值", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
    @NotNull(message = "Pay item value cannot be empty.")
    @Digits(integer = 10, fraction = 2, message = "Pay item value can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal value;

}
