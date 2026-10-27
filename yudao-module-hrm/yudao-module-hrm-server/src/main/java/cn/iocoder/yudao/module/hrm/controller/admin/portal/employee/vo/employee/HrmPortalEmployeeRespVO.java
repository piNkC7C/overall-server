package cn.iocoder.yudao.module.hrm.controller.admin.portal.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee employee profile response VO.")
@Data
public class HrmPortalEmployeeRespVO {

    @Schema(description = "Employee profile code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee Name", example = "John.")
    private String name;

    @Schema(description = "EmployeeAvatar.")
    private String avatar;

    @Schema(description = "Employee No.", example = "HRM001")
    private String jobNumber;

    @Schema(description = "Phone number.", example = "15601691300")
    private String mobile;

    @Schema(description = "Country / Region", example = "China")
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

    @Schema(description = "Date of birth")
    private LocalDateTime birthday;

    @Schema(description = "Age", example = "28")
    private Integer age;

    @Schema(description = "Household Address", example = "Xihu District, Hangzhou")
    private String address;

    @Schema(description = "Highest Education", example = "8")
    private Integer highestEducation;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Direct Manageremployee code.", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "Direct ManagerEmployee Name.", example = "Jane.")
    private String leaderEmployeeName;

    @Schema(description = "Onboarding status.", example = "1")
    private Integer entryStatus;

    @Schema(description = "Employee status.", example = "1")
    private Integer status;

    @Schema(description = "Employment Type", example = "1")
    private Integer type;

    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Onboarding days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long entryDay;

    @Schema(description = "Probation months. 0 means none.", example = "3")
    private Integer probation;

    @Schema(description = "Confirmation Date")
    private LocalDateTime regularTime;

    @Schema(description = "Offboarding time.")
    private LocalDateTime leaveTime;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    private String postName;

    @Schema(description = "Job Grade", example = "P6")
    private String postLevel;

    @Schema(description = "Work City", example = "Shanghai")
    private String workCity;

    @Schema(description = "Work Location", example = "Downtown")
    private String workAddress;

    @Schema(description = "Detailed work address.", example = "Building 1, Innovation Park")
    private String workDetailAddress;

    @Schema(description = "Tenure start date.")
    private LocalDateTime companyAgeStartTime;

    @Schema(description = "Tenure in years.", example = "2")
    private Integer companyAge;

}
