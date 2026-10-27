package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM employee monthly benefits response VO.")
@Data
public class HrmInsuranceMonthEmployeeRecordRespVO {

    @Schema(description = "Record code.")
    private Long id;

    @Schema(description = "Social security Table ID.")
    private Long monthRecordId;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Employee Name")
    private String employeeName;

    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Phone number.")
    private String mobile;

    @Schema(description = "National ID.")
    private String idNumber;

    @Schema(description = "Gender")
    private Integer sex;

    @Schema(description = "Age")
    private Integer age;

    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department.")
    private String deptName;

    @Schema(description = "Job Title name.")
    private String postName;

    @Schema(description = "Onboarding status.")
    private Integer entryStatus;

    @Schema(description = "Employee status.")
    private Integer employeeStatus;

    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Social security plan code.")
    private Long schemeId;

    @Schema(description = "Social security plan.")
    private String schemeName;

    @Schema(description = "Insurance region.")
    private String areaName;

    @Schema(description = "Insurance region ID.")
    private Integer areaId;

    @Schema(description = "Household type.")
    private String houseType;

    @Schema(description = "Social security plan type.")
    private Integer schemeType;

    @Schema(description = "Person social security no.")
    private String socialSecurityNumber;

    @Schema(description = "Employee Housing Fund no.")
    private String accumulationFundNumber;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Person social security.")
    private BigDecimal personalInsuranceAmount;

    @Schema(description = "Employee Housing Fund")
    private BigDecimal personalProvidentFundAmount;

    @Schema(description = "Company social security.")
    private BigDecimal corporateInsuranceAmount;

    @Schema(description = "Company Housing Fund")
    private BigDecimal corporateProvidentFundAmount;

    @Schema(description = "Insurance status.")
    private Integer status;

    @Schema(description = "Social security item list.")
    private List<HrmInsuranceMonthEmployeeProjectRespVO> socialSecurityProjectList;

    @Schema(description = "Housing-fund item list.")
    private List<HrmInsuranceMonthEmployeeProjectRespVO> providentFundProjectList;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
