package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM paysliptemplate response.")
@Data
public class HrmSalarySlipTemplateRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Template name.")
    private String name;

    @Schema(description = "Hide empty items.")
    private Boolean hideEmpty;

    @Schema(description = "Default option.")
    private Boolean defaultStatus;

    @Schema(description = "Options.")
    private List<HrmSalarySlipTemplateOptionVO> options;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
