package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord;

import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionNodeRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM monthly payroll sheet response VO.")
@Data
public class HrmSalaryMonthRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    private Integer month;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "July 2026 payroll")
    private String title;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "Employee quantity.")
    private Integer employeeCount;

    @Schema(description = "Gross Pay")
    private BigDecimal expectedPaySalary;

    @Schema(description = "Person social security amount.")
    private BigDecimal personalInsuranceAmount;

    @Schema(description = "Employee Housing Fund amount.")
    private BigDecimal personalProvidentFundAmount;

    @Schema(description = "Income Tax")
    private BigDecimal personalTax;

    @Schema(description = "Net pay.")
    private BigDecimal realPaySalary;

    @Schema(description = "Company social security amount.")
    private BigDecimal corporateInsuranceAmount;

    @Schema(description = "Company Housing Fund amount.")
    private BigDecimal corporateProvidentFundAmount;

    @Schema(description = "Accounting status.")
    private Integer status;

    @Schema(description = "Pay-item header.")
    private List<HrmSalaryOptionNodeRespVO> optionHeaders;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
