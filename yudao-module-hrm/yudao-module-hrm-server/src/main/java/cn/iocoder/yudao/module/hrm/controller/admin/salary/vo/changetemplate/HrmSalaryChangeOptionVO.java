package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM Salary Change item VO.")
@Data
public class HrmSalaryChangeOptionVO {

    @Schema(description = "Payroll item name.", example = "Base salary")
    private String name;

    @Schema(description = "Payroll item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10101")
    @NotNull(message = "Payroll item code is required.")
    private Integer code;

}
