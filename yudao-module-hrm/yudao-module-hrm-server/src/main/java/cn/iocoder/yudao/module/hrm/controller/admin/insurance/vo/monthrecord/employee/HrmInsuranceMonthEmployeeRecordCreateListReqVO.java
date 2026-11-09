package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 添加参保人员 Request VO")
@Data
public class HrmInsuranceMonthEmployeeRecordCreateListReqVO {

    @Schema(description = "月度社保表编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security Table ID is required.")
    private Long monthRecordId;

    @Schema(description = "员工编号列表", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1024, 1025]")
    @NotEmpty(message = "Employee is required.")
    private List<@NotNull(message = "Employee code is required.") Long> employeeIds;

}
