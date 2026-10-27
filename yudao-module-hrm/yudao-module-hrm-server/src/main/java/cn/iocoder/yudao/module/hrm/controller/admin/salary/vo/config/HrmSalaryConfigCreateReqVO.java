package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.config;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.config.HrmSalarySocialSecurityMonthTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "HRM payroll setting create request VO.")
@Data
public class HrmSalaryConfigCreateReqVO {

    @Schema(description = "Pay-cycle start day.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Pay-cycle start day cannot be empty.")
    @Min(value = 1, message = "Pay-cycle start day must be between 1 and 31.")
    @Max(value = 31, message = "Pay-cycle start day must be between 1 and 31.")
    private Integer cycleStartDay;

    @Schema(description = "Social security matching Month type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Social security matching Month type is required.")
    @InEnum(value = HrmSalarySocialSecurityMonthTypeEnum.class, message = "Social security matching Month type must be {value}.")
    private Integer socialSecurityMonthType;

    @Schema(description = "Payroll start year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Payroll start year cannot be empty.")
    @Min(value = 2000, message = "Payroll start year cannot be less than 2000.")
    @Max(value = 2100, message = "Payroll start year cannot be greater than 2100.")
    private Integer startYear;

    @Schema(description = "Payroll start month.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Payroll start month cannot be empty.")
    @Min(value = 1, message = "Payroll start month must be between 1 and 12.")
    @Max(value = 12, message = "Payroll start month must be between 1 and 12.")
    private Integer startMonth;

}
