package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.standard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "HRM Standard benefits item response VO.")
@Data
public class HrmInsuranceStandardProjectRespVO {

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pension")
    private String name;

    @Schema(description = "Contribution Base", example = "10000.00")
    private BigDecimal baseAmount;

    @Schema(description = "Company contribution rate.", example = "16.00")
    private BigDecimal corporateRate;

    @Schema(description = "Employee contribution rate.", example = "8.00")
    private BigDecimal personalRate;

    @Schema(description = "Company contribution amount.", example = "1600.00")
    private BigDecimal corporateAmount;

    @Schema(description = "Employee contribution amount.", example = "800.00")
    private BigDecimal personalAmount;

}
