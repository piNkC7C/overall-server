package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.group;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM payroll group page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalaryGroupPageReqVO extends PageParam {

    @Schema(description = "Payroll group name.", example = "HQ payroll group")
    private String name;

    @Schema(description = "Tax ruleID.", example = "1024")
    private Long taxRuleId;

}
