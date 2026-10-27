package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM Performance Factorsearch request.")
@Data
public class HrmSalaryPerformanceCoefficientReqVO {

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Month is required.")
    private Integer month;

    @Schema(description = "Employee code list.", example = "[1024, 1025]")
    private List<Long> employeeIds;

}
