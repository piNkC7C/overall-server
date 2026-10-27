package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM Salary Changetemplate response.")
@Data
public class HrmSalaryChangeTemplateRespVO {

    @Schema(description = "Salary Changetemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "R&D raise template")
    private String name;

    @Schema(description = "Is not default template.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean defaultStatus;

    @Schema(description = "Salary Change item setting.")
    private List<HrmSalaryChangeOptionVO> options;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
