package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Admin - HRM employeedepartmentStats response.")
@Data
@AllArgsConstructor
public class HrmEmployeeDeptStatisticsRespVO {

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long deptId;

    @Schema(description = "Active employee count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long activeCount;

    @Schema(description = "Full-time employee count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    private Long fullTimeCount;

    @Schema(description = "Non-full-time employee count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long nonFullTimeCount;

}
