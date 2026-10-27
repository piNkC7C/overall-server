package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.scheme;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM social security plan response.")
@Data
public class HrmInsuranceSchemeRespVO {

    @Schema(description = "Social security plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standard benefits plan")
    private String name;

    @Schema(description = "Insurance region ID.", example = "440300")
    private Integer areaId;

    @Schema(description = "Insurance region.", example = "CA San Jose")
    private String areaName;

    @Schema(description = "Household type.", example = "Local resident")
    private String householdType;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "All social security item.")
    private List<HrmInsuranceSchemeProjectRespVO> projectList;

    @Schema(description = "Social security item.")
    private List<HrmInsuranceSchemeProjectRespVO> socialSecurityProjectList;

    @Schema(description = "Housing-fund item.")
    private List<HrmInsuranceSchemeProjectRespVO> providentFundProjectList;

    @Schema(description = "Person social security amount.", example = "800.00")
    private BigDecimal personalInsuranceAmount;

    @Schema(description = "Company social security amount.", example = "1600.00")
    private BigDecimal corporateInsuranceAmount;

    @Schema(description = "Employee Housing Fund amount.", example = "700.00")
    private BigDecimal personalProvidentFundAmount;

    @Schema(description = "Company Housing Fund amount.", example = "700.00")
    private BigDecimal corporateProvidentFundAmount;

    @Schema(description = "User count.", example = "10")
    private Long useCount;

    @Schema(description = "Historical month-record count.", example = "120")
    private Long monthRecordCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
