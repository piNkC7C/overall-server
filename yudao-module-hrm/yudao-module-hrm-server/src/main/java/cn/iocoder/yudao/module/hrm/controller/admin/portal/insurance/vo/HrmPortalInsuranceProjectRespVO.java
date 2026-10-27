package cn.iocoder.yudao.module.hrm.controller.admin.portal.insurance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "HRM employee benefits item response VO.")
@Data
public class HrmPortalInsuranceProjectRespVO {

    @Schema(description = "Social security item code.")
    private Long schemeProjectId;

    @Schema(description = "Employee benefits item type.")
    private Integer type;

    @Schema(description = "Social security item name.")
    private String name;

    @Schema(description = "Default contribution amount.")
    private BigDecimal baseAmount;

    @Schema(description = "Company contribution rate.")
    private BigDecimal corporateRate;

    @Schema(description = "Employee contribution rate.")
    private BigDecimal personalRate;

    @Schema(description = "Company contribution amount.")
    private BigDecimal corporateAmount;

    @Schema(description = "Employee contribution amount.")
    private BigDecimal personalAmount;

}
