package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.scheme;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.insurance.config.HrmInsuranceProjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM social security plan item save request.")
@Data
public class HrmInsuranceSchemeProjectSaveReqVO {

    @Schema(description = "Social security plan item code.", example = "1024")
    private Long id;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Item type is required.")
    @InEnum(value = HrmInsuranceProjectTypeEnum.class, message = "Item type must be {value}.")
    private Integer type;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pension")
    @NotBlank(message = "Item name is required.")
    @Size(max = 64, message = "Item name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Contribution Base", example = "10000.00")
    @DecimalMin(value = "0.00", message = "Contribution base cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Contribution base can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal baseAmount;

    @Schema(description = "Company contribution rate.", example = "16.00")
    @DecimalMin(value = "0.00", message = "Company contribution rate cannot be less than 0.")
    @DecimalMax(value = "100.00", message = "Company contribution rate cannot be greater than 100.")
    @Digits(integer = 3, fraction = 2, message = "Company contribution rate can have at most 2 decimal places.")
    private BigDecimal corporateRate;

    @Schema(description = "Employee contribution rate.", example = "8.00")
    @DecimalMin(value = "0.00", message = "Employee contribution rate cannot be less than 0.")
    @DecimalMax(value = "100.00", message = "Employee contribution rate cannot be greater than 100.")
    @Digits(integer = 3, fraction = 2, message = "Employee contribution rate can have at most 2 decimal places.")
    private BigDecimal personalRate;

    @Schema(description = "Company contribution amount.", example = "1600.00")
    @DecimalMin(value = "0.00", message = "Company contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Company contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal corporateAmount;

    @Schema(description = "Employee contribution amount.", example = "800.00")
    @DecimalMin(value = "0.00", message = "Employee contribution amount cannot be less than 0.")
    @Digits(integer = 10, fraction = 2, message = "Employee contribution amount can have at most 10 integer digits and 2 decimal places.")
    private BigDecimal personalAmount;

}
