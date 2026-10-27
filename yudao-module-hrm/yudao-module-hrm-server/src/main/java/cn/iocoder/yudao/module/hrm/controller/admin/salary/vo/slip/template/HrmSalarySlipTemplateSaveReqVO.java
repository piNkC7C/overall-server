package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM paysliptemplatecreate/update request.")
@Data
public class HrmSalarySlipTemplateSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standardpaysliptemplate")
    @NotBlank(message = "Template name is required.")
    @Size(max = 64, message = "Template name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Hide empty items.", example = "true")
    private Boolean hideEmpty;

    @Schema(description = "Options.")
    @Valid
    private List<HrmSalarySlipTemplateOptionVO> options;

}
