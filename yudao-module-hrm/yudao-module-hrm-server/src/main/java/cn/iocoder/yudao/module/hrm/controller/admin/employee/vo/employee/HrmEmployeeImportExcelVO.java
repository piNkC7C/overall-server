package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.iocoder.yudao.framework.excel.core.annotations.ExcelColumnSelect;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.AreaConvert;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import cn.iocoder.yudao.module.hrm.framework.excel.core.HrmEmployeeProbationExcelColumnSelectFunction;
import cn.iocoder.yudao.module.hrm.framework.excel.core.HrmRecruitChannelExcelColumnSelectFunction;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee profile Excel import VO.")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class HrmEmployeeImportExcelVO {

    @ExcelProperty("Employee Name")
    @Schema(description = "Employee Name")
    private String name;

    @ExcelProperty("Employee No")
    @Schema(description = "Employee No.")
    private String jobNumber;

    @ExcelProperty("Phone Number")
    @Schema(description = "Phone number.")
    private String mobile;

    @ExcelProperty("Country Or Region")
    @Schema(description = "Country / Region")
    private String country;

    @ExcelProperty("Ethnicity")
    @Schema(description = "Ethnicity")
    private String nation;

    @ExcelProperty(value = "ID Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_ID_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_ID_TYPE)
    @Schema(description = "ID Type")
    private Integer idType;

    @ExcelProperty("ID Number")
    @Schema(description = "ID Number")
    private String idNumber;

    @ExcelProperty(value = "Gender", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    @ExcelColumnSelect(dictType = cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    @Schema(description = "Gender")
    private Integer sex;

    @ExcelProperty("Email")
    @Schema(description = "Email")
    private String email;

    @ExcelProperty("Hometown")
    @Schema(description = "Hometown")
    private String nativePlace;

    @ExcelProperty("Date Of Birth")
    @Schema(description = "Date of birth")
    private LocalDateTime birthday;

    @ExcelProperty("Household Address")
    @Schema(description = "Household Address")
    private String address;

    @ExcelProperty(value = "Highest Education", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_EDUCATION)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_EDUCATION)
    @Schema(description = "Highest Education")
    private Integer highestEducation;

    @ExcelProperty("Department ID")
    @Schema(description = "Department code.")
    private Long deptId;

    @ExcelProperty("Manager Employee No")
    @Schema(description = "Direct ManagerEmployee No.")
    private String leaderJobNumber;

    @ExcelProperty("Position Name")
    @Schema(description = "Job Title name.")
    private String postName;

    @ExcelProperty("Job Grade")
    @Schema(description = "Job Grade")
    private String postLevel;

    @ExcelProperty(value = "Hire Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_ENTRY_STATUS)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_ENTRY_STATUS)
    @Schema(description = "Onboarding status.")
    private Integer entryStatus;

    @ExcelProperty(value = "Employee Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_STATUS)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_STATUS)
    @Schema(description = "Employee status.")
    private Integer status;

    @ExcelProperty(value = "Employment Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_TYPE)
    @Schema(description = "Employment Type")
    private Integer type;

    @ExcelProperty("Hire Date")
    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @ExcelProperty("Probation (months)")
    @ExcelColumnSelect(functionName = HrmEmployeeProbationExcelColumnSelectFunction.NAME)
    @Schema(description = "Probation period (Month).")
    private Integer probation;

    @ExcelProperty("Confirmation Date")
    @Schema(description = "Confirmation Date")
    private LocalDateTime regularTime;

    @ExcelProperty("Termination Date")
    @Schema(description = "Offboarding time.")
    private LocalDateTime leaveTime;

    @ExcelProperty("Work City")
    @Schema(description = "Work City")
    private String workCity;

    @ExcelProperty("Work Location")
    @Schema(description = "Work Location")
    private String workAddress;

    @ExcelProperty("Work Address")
    @Schema(description = "Detailed work address.")
    private String workDetailAddress;

    @ExcelProperty("Recruiting Channel")
    @ExcelColumnSelect(functionName = HrmRecruitChannelExcelColumnSelectFunction.NAME)
    @Schema(description = "Recruiting channel option, formatted as name (ID).")
    private String channelName;

    @ExcelProperty("Company Seniority Start")
    @Schema(description = "Company seniority start.")
    private LocalDateTime companyAgeStartTime;

    @ExcelProperty("Bound User Phone")
    @Schema(description = "Bound admin-user phone.")
    private String userMobile;

    @ExcelProperty("Bank Card No")
    @Schema(description = "Bank Account")
    private String bankCardNumber;

    @ExcelProperty(value = "Bank Region", converter = AreaConvert.class)
    @Schema(description = "Bank Region")
    private Integer bankAreaId;

    @ExcelProperty("Bank Name")
    @Schema(description = "Bank name")
    private String bankName;

    @ExcelProperty("Bank Branch Name")
    @Schema(description = "Bank Branch name.")
    private String bankBranchName;

    @ExcelProperty(value = "First-time Benefits Enrollment", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    @ExcelColumnSelect(dictType = DictTypeConstants.BOOLEAN_STRING)
    @Schema(description = "First-time benefits enrollment.")
    private Boolean firstSocialSecurity;

    @ExcelProperty(value = "First-time Housing-fund Contribution", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    @ExcelColumnSelect(dictType = DictTypeConstants.BOOLEAN_STRING)
    @Schema(description = "First-time housing-fund contribution.")
    private Boolean firstAccumulationFund;

    @ExcelProperty("Personal Social-security Account")
    @Schema(description = "Person social security account.")
    private String socialSecurityNumber;

    @ExcelProperty("Personal Housing-fund Account")
    @Schema(description = "Employee Housing Fund account.")
    private String accumulationFundNumber;

    @ExcelProperty("Benefits Start Month")
    @Schema(description = "Insurance start month.")
    private LocalDateTime socialSecurityStartMonth;

    @ExcelProperty("Benefits Plan Name")
    @Schema(description = "Insurance plan name.")
    private String schemeName;

    @ExcelProperty("Notes")
    @Schema(description = "Notes.")
    private String remark;

}
