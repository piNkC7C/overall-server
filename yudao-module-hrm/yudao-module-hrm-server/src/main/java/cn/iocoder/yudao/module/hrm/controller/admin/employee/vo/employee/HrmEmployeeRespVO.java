package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee profile response.")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class HrmEmployeeRespVO {

    @ExcelProperty(value = "Employee ID", index = 0)
    @Schema(description = "Employee profile code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @ExcelProperty(value = "Employee Name", index = 1)
    @Schema(description = "Employee Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String name;

    @ExcelProperty(value = "Employee No", index = 2)
    @Schema(description = "Employee No.", example = "HRM001")
    private String jobNumber;

    @Schema(description = "System user ID.", example = "1024")
    private Long userId;

    @ExcelProperty(value = "Bound User", index = 17)
    @Schema(description = "Admin user nickname.", example = "Overall.")
    private String userNickname;

    @ExcelProperty(value = "Phone Number", index = 3)
    @Schema(description = "Phone number.", example = "15601691300")
    private String mobile;

    @Schema(description = "Country / region.", example = "China")
    private String country;

    @Schema(description = "Ethnicity", example = "Han")
    private String nation;

    @Schema(description = "ID Type", example = "1")
    private Integer idType;

    @Schema(description = "ID Number", example = "310101199001011234")
    private String idNumber;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Email", example = "hrm@example.com")
    private String email;

    @Schema(description = "Hometown", example = "Hangzhou, Zhejiang")
    private String nativePlace;

    @Schema(description = "Date of Birth")
    private LocalDateTime birthday;

    @Schema(description = "Age", example = "28")
    private Integer age;

    @Schema(description = "Household Address", example = "Xihu District, Hangzhou")
    private String address;

    @Schema(description = "Highest Education", example = "8")
    private Integer highestEducation;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @ExcelProperty(value = "Department", index = 4)
    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Direct Manageremployee code.", example = "1")
    private Long leaderEmployeeId;

    @ExcelProperty(value = "Direct Manager", index = 7)
    @Schema(description = "Direct ManagerEmployee Name.", example = "Jane.")
    private String leaderEmployeeName;

    @ExcelProperty(value = "Hire Status", index = 8, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_ENTRY_STATUS)
    @Schema(description = "Onboarding status.", example = "1")
    private Integer entryStatus;

    @ExcelProperty(value = "Employee Status", index = 9, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_STATUS)
    @Schema(description = "Employee status.", example = "1")
    private Integer status;

    @ExcelProperty(value = "Employment Type", index = 10, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_TYPE)
    @Schema(description = "Employment Type", example = "1")
    private Integer type;

    @ExcelProperty(value = "Hire Date", index = 11)
    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Probation months. 0 means none.", example = "3")
    private Integer probation;

    @ExcelProperty(value = "Confirmation Date", index = 12)
    @Schema(description = "Confirmation Date")
    private LocalDateTime regularTime;

    @ExcelProperty(value = "Termination Date", index = 13)
    @Schema(description = "Offboarding time.")
    private LocalDateTime leaveTime;

    @ExcelProperty(value = "Job Title", index = 5)
    @Schema(description = "Job Title name.", example = "Java engineer.")
    private String postName;

    @ExcelProperty(value = "Job Grade", index = 6)
    @Schema(description = "Job Grade", example = "P6")
    private String postLevel;

    @ExcelProperty(value = "Work City", index = 14)
    @Schema(description = "Work City", example = "Shanghai")
    private String workCity;

    @ExcelProperty(value = "Work Location", index = 15)
    @Schema(description = "Work address.", example = "Downtown")
    private String workAddress;

    @Schema(description = "Detailed work address.", example = "Building 1, Innovation Park")
    private String workDetailAddress;

    @Schema(description = "Recruiting Channel code.", example = "10")
    private Long channelId;

    @ExcelProperty(value = "Recruiting Channel", index = 16)
    @Schema(description = "Recruiting Channel name.", example = "LinkedIn")
    private String channelName;

    @Schema(description = "Tenure start date.")
    private LocalDateTime companyAgeStartTime;

    @Schema(description = "Tenure in years.", example = "2")
    private Integer companyAge;

    @Schema(description = "Relation Recruitingcandidate code.", example = "200")
    private Long candidateId;

    // ==================== 工资卡信息 ====================

    @Schema(description = "Bank Account", example = "622202600001")
    private String salaryCardNumber;

    @Schema(description = "Bank Region code.", example = "440300")
    private Integer salaryCardAreaId;

    @Schema(description = "Bank Region name.", example = "CA San Jose")
    private String salaryCardAreaName;

    @Schema(description = "Bank name", example = "China Merchants Bank")
    private String salaryCardBankName;

    @Schema(description = "Bank Branch name.", example = "Tech Park branch")
    private String salaryCardBankBranchName;

    // ==================== social security info ====================

    @Schema(description = "Person social security account.", example = "SB20260001")
    private String socialSecurityNumber;

    @Schema(description = "Employee Housing Fund account.", example = "GJJ20260001")
    private String accumulationFundNumber;

    @Schema(description = "Notes.", example = "First-wave migrated employees")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
