package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM add enrolled employees request VO.")
@Data
public class HrmInsuranceMonthEmployeeRecordCreateListReqVO {

    @Schema(description = "Monthly insurance ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security Table ID is required.")
    private Long monthRecordId;

    @Schema(description = "Employee code list.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1024, 1025]")
    @NotEmpty(message = "Employee is required.")
    private List<@NotNull(message = "Employee code is required.") Long> employeeIds;

}
