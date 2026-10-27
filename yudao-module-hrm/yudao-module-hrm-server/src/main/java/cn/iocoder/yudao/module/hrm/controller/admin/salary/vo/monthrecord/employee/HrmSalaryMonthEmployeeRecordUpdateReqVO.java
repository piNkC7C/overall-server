package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord.employee;

import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM employeePay Item edit request.")
@Data
public class HrmSalaryMonthEmployeeRecordUpdateReqVO {

    @Schema(description = "Employee monthly payroll ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee payroll record ID cannot be empty.")
    private Long id;

    @Schema(description = "Pay item valuelist.")
    @Valid
    private List<HrmSalaryOptionValueVO> optionValues;

}
