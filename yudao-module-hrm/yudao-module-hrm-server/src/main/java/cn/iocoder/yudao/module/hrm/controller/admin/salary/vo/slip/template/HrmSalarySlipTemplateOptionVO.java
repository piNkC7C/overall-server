package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM payslip template item VO.")
@Data
public class HrmSalarySlipTemplateOptionVO {

    @Schema(description = "Payslip template option name.")
    @NotBlank(message = "Payslip template item name cannot be empty.")
    @Size(max = 64, message = "Payslip template item name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Payslip template option type.")
    private Integer type;

    @Schema(description = "Code.")
    private Integer code;

    @Schema(description = "Notes.")
    @Size(max = 255, message = "Notes cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "Parent code.")
    private Integer parentCode;

    @Schema(description = "Hidden.")
    private Boolean hidden;

    @Schema(description = "Sort.")
    private Integer sort;

}
