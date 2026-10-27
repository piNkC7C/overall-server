package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM payroll setting response VO.")
@Data
public class HrmSalaryConfigRespVO {

    @Schema(description = "Setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Pay-cycle start day.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer cycleStartDay;

    @Schema(description = "Pay-cycle end day.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31")
    private Integer cycleEndDay;

    @Schema(description = "Social security matching Month type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer socialSecurityMonthType;

    @Schema(description = "Payroll start year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    private Integer startYear;

    @Schema(description = "Payroll start month.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    private Integer startMonth;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
