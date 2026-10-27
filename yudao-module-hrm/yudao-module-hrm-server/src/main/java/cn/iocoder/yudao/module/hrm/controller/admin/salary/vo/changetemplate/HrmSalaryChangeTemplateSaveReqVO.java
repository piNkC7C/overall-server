package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM Salary Changetemplate create / edit request.")
@Data
public class HrmSalaryChangeTemplateSaveReqVO {

    @Schema(description = "Salary Changetemplate code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "R&D raise template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 64, message = "Template name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Is not default template.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not default template is required.")
    private Boolean defaultStatus;

    @Schema(description = "Salary Change item setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Salary Change item setting is required.")
    private List<HrmSalaryChangeOptionVO> options;

}
