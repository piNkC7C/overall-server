package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM monthly insurance response.")
@Data
public class HrmInsuranceMonthRecordRespVO {

    @Schema(description = "Monthly insurance ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    private Integer month;

    @Schema(description = "Title.", example = "July 2026 benefits sheet")
    private String title;

    @Schema(description = "Enrolled count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer insuredEmployeeCount;

    @Schema(description = "Stopped-benefits count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer stoppedEmployeeCount;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Person social security amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "800.00")
    private BigDecimal personalInsuranceAmount;

    @Schema(description = "Employee Housing Fund amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "700.00")
    private BigDecimal personalProvidentFundAmount;

    @Schema(description = "Company social-security amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1600.00")
    private BigDecimal corporateInsuranceAmount;

    @Schema(description = "Company housing-fund amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "700.00")
    private BigDecimal corporateProvidentFundAmount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
