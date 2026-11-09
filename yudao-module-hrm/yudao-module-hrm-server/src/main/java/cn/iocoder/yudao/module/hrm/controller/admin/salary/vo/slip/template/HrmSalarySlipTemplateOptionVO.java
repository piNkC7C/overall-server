package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 工资条模板项 VO")
@Data
public class HrmSalarySlipTemplateOptionVO {

    @Schema(description = "薪资工资条模板选项名称")
    @NotBlank(message = "Payslip template item name cannot be empty.")
    @Size(max = 64, message = "Payslip template item name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "薪资工资条模板选项类型")
    private Integer type;

    @Schema(description = "编码")
    private Integer code;

    @Schema(description = "备注")
    @Size(max = 255, message = "Notes cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "父级编码")
    private Integer parentCode;

    @Schema(description = "是否隐藏")
    private Boolean hidden;

    @Schema(description = "排序")
    private Integer sort;

}
