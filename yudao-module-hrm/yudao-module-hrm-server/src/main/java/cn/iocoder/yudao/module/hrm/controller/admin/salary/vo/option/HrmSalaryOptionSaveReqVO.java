package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM payroll sheet pay item save request VO.")
@Data
public class HrmSalaryOptionSaveReqVO {

    @Schema(description = "Parent payroll item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Payroll item category is required.")
    private Integer parentCode;

    @Schema(description = "Payroll item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Base salary")
    @NotBlank(message = "Payroll item name is required.")
    @Size(max = 64, message = "Payroll item name length cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Notes.", example = "Fixed pay item")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

}
