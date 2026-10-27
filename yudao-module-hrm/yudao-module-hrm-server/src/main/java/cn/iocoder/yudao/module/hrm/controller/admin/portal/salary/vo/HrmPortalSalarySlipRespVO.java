package cn.iocoder.yudao.module.hrm.controller.admin.portal.salary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM employee payslip response VO.")
@Data
public class HrmPortalSalarySlipRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "PaysliprecordID.")
    private Long sendRecordId;

    @Schema(description = "Employee payroll record ID.")
    private Long monthEmployeeRecordId;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Read status.")
    private Integer readStatus;

    @Schema(description = "Actualpayroll.")
    private BigDecimal realPaySalary;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Options.")
    private List<HrmPortalSalarySlipOptionRespVO> options;

}
