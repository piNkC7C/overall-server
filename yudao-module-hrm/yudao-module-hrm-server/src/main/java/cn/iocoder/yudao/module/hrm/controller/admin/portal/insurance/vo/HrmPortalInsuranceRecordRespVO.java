package cn.iocoder.yudao.module.hrm.controller.admin.portal.insurance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM employee benefits record response VO.")
@Data
public class HrmPortalInsuranceRecordRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Monthly benefits record ID.")
    private Long monthRecordId;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Social security plan code.")
    private Long schemeId;

    @Schema(description = "Social security plan name.")
    private String schemeName;

    @Schema(description = "Social security plan type.")
    private Integer schemeType;

    @Schema(description = "Insurance City")
    private String schemeCity;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Person social security amount.")
    private BigDecimal personalInsuranceAmount;

    @Schema(description = "Employee Housing Fund amount.")
    private BigDecimal personalProvidentFundAmount;

    @Schema(description = "Company social security amount.")
    private BigDecimal corporateInsuranceAmount;

    @Schema(description = "Company Housing Fund amount.")
    private BigDecimal corporateProvidentFundAmount;

    @Schema(description = "Employee benefits record status.")
    private Integer status;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Social security item list.")
    private List<HrmPortalInsuranceProjectRespVO> projects;

}
