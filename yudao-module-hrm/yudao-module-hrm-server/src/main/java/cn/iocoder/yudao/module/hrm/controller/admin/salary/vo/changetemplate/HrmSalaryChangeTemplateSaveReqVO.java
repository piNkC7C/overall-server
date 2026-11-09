package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 调薪模板新增/修改 Request VO")
@Data
public class HrmSalaryChangeTemplateSaveReqVO {

    @Schema(description = "调薪模板编号", example = "1024")
    private Long id;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "R&D raise template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 64, message = "Template name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "是否默认模板", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not default template is required.")
    private Boolean defaultStatus;

    @Schema(description = "调薪项配置", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Salary Change item setting is required.")
    private List<HrmSalaryChangeOptionVO> options;

}
