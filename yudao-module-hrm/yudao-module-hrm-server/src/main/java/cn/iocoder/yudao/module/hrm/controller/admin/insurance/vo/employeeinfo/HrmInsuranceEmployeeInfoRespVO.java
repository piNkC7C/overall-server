package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee benefits info response VO.")
@Data
public class HrmInsuranceEmployeeInfoRespVO {

    @Schema(description = "Employee benefits ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long employeeId;

    @Schema(description = "First local social-security contribution.", example = "true")
    private Boolean firstSocialSecurity;

    @Schema(description = "First local housing-fund contribution.", example = "false")
    private Boolean firstAccumulationFund;

    @Schema(description = "Social security account.", example = "SB20260001")
    private String socialSecurityNumber;

    @Schema(description = "Housing-fund account.", example = "GJJ20260001")
    private String accumulationFundNumber;

    @Schema(description = "Insurance start month.")
    private LocalDateTime socialSecurityStartMonth;

    @Schema(description = "Social security plan code.", example = "1024")
    private Long schemeId;

    @Schema(description = "Social security plan name.", example = "Standard benefits plan")
    private String schemeName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
