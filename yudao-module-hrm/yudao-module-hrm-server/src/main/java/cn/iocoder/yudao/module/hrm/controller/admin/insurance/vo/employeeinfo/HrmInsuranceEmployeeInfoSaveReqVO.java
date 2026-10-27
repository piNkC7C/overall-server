package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee benefits info save request VO.")
@Data
public class HrmInsuranceEmployeeInfoSaveReqVO {

    @Schema(description = "Employee benefits ID.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "First local social-security contribution.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "First local social-security contribution cannot be empty.")
    private Boolean firstSocialSecurity;

    @Schema(description = "First local housing-fund contribution.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "First local housing-fund contribution cannot be empty.")
    private Boolean firstAccumulationFund;

    @Schema(description = "Social security account.", example = "SB20260001")
    @Size(max = 64, message = "Social security account cannot exceed 64 characters.")
    private String socialSecurityNumber;

    @Schema(description = "Housing-fund account.", example = "GJJ20260001")
    @Size(max = 64, message = "Housing-fund account cannot exceed 64 characters.")
    private String accumulationFundNumber;

    @Schema(description = "Insurance start month.")
    private LocalDateTime socialSecurityStartMonth;

    @Schema(description = "Social security plan code.", example = "1024")
    private Long schemeId;

}
