package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord.employee;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.monthrecord.HrmSalaryMonthRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM employee monthly pay page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalaryEmployeeMonthRecordPageReqVO extends PageParam {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Monthly payroll status.", example = "10")
    @InEnum(value = HrmSalaryMonthRecordStatusEnum.class, message = "Monthly payroll status must be {value}.")
    private Integer monthRecordStatus;

}
