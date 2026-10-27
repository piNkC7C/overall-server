package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.hrm.enums.employee.experience.HrmEmployeeEducationEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeEntryStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeIdTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isBeforeOrEqual;

@Schema(description = "Admin - HRM employee profile create / edit request.")
@Data
public class HrmEmployeeSaveReqVO {

    @Schema(description = "Employee profile code.", example = "1024")
    private Long id;

    @Schema(description = "Employee Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "Employee Name is required.")
    @Size(max = 255, message = "Employee Name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Employee No.", example = "HRM001")
    @Size(max = 64, message = "Employee No. cannot exceed 64 characters.")
    private String jobNumber;

    @Schema(description = "System user ID.", example = "1024")
    private Long userId;

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotBlank(message = "Phone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "Country / region.", example = "China")
    @Size(max = 64, message = "Country / region cannot exceed 64 characters.")
    private String country;

    @Schema(description = "Ethnicity", example = "Han")
    @Size(max = 64, message = "Ethnicity cannot exceed 64 characters.")
    private String nation;

    @Schema(description = "ID Type", example = "1")
    @InEnum(value = HrmEmployeeIdTypeEnum.class, message = "ID Type must be {value}.")
    private Integer idType;

    @Schema(description = "ID Number", example = "310101199001011234")
    @Size(max = 255, message = "ID Number cannot exceed 255 characters.")
    private String idNumber;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Email", example = "hrm@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
    private String email;

    @Schema(description = "Hometown", example = "Hangzhou, Zhejiang")
    @Size(max = 128, message = "Hometown cannot exceed 128 characters.")
    private String nativePlace;

    @Schema(description = "Date of Birth")
    @PastOrPresent(message = "Date of birth cannot be later than today.")
    private LocalDateTime birthday;

    @Schema(description = "Age", example = "28")
    private Integer age;

    @Schema(description = "Household Address", example = "Xihu District, Hangzhou")
    @Size(max = 255, message = "Household Address cannot exceed 255 characters.")
    private String address;

    @Schema(description = "Highest Education", example = "8")
    @InEnum(value = HrmEmployeeEducationEnum.class, message = "Highest Education must be {value}.")
    private Integer highestEducation;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Direct Manageremployee code.", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "Onboarding status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Onboarding status is required.")
    @InEnum(value = HrmEmployeeEntryStatusEnum.class, message = "Onboarding status must be {value}.")
    private Integer entryStatus;

    @Schema(description = "Employee status.", example = "1")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
    private Integer status;

    @Schema(description = "Employment Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employment Type is required.")
    @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
    private Integer type;

    @Schema(description = "Hire Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Hire Date is required.")
    private LocalDateTime entryTime;

    @Schema(description = "Probation months. 0 means none.", example = "3")
    @Min(value = 0, message = "Probation period cannot be less than 0 months.")
    @Max(value = 6, message = "Probation period cannot exceed 6 months.")
    private Integer probation;

    @Schema(description = "Confirmation Date")
    private LocalDateTime regularTime;

    @Schema(description = "Offboarding time.")
    private LocalDateTime leaveTime;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    @Size(max = 255, message = "Job Title name cannot exceed 255 characters.")
    private String postName;

    @Schema(description = "Job Grade", example = "P6")
    @Size(max = 255, message = "Job Grade cannot exceed 255 characters.")
    private String postLevel;

    @Schema(description = "Work City", example = "Shanghai")
    @Size(max = 64, message = "Work City cannot exceed 64 characters.")
    private String workCity;

    @Schema(description = "Work address.", example = "Downtown")
    @Size(max = 255, message = "Work address cannot exceed 255 characters.")
    private String workAddress;

    @Schema(description = "Detailed work address.", example = "Building 1, Innovation Park")
    @Size(max = 255, message = "Detailed work address cannot exceed 255 characters.")
    private String workDetailAddress;

    @Schema(description = "Recruiting Channel code.", example = "10")
    private Long channelId;

    @Schema(description = "Tenure start date.")
    private LocalDateTime companyAgeStartTime;

    @Schema(description = "Tenure in years.", example = "2")
    private Integer companyAge;

    @Schema(description = "Relation Recruitingcandidate code.", example = "200")
    private Long candidateId;

    @Schema(description = "Notes.", example = "First-wave migrated employees")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @AssertTrue(message = "ID number format is invalid.")
    @JsonIgnore
    public boolean isIdNumberValid() {
        return ObjUtil.notEqual(HrmEmployeeIdTypeEnum.ID_CARD.getType(), idType)
                || StrUtil.isBlank(idNumber) || IdcardUtil.isValidCard(idNumber);
    }

    @AssertTrue(message = "Employee status and Employment Type does not match.")
    @JsonIgnore
    public boolean isStatusValid() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.INFORMAL.getType(), type)
                || status == null || HrmEmployeeStatusEnum.INFORMAL_STATUSES.contains(status);
    }

    @AssertTrue(message = "Not regular employee status is required.")
    @JsonIgnore
    public boolean isStatusRequired() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.INFORMAL.getType(), type) || status != null;
    }

    @AssertTrue(message = "Active employeeEmployee No. is required.")
    @JsonIgnore
    public boolean isJobNumberValid() {
        return ObjUtil.notEqual(HrmEmployeeEntryStatusEnum.ACTIVE.getStatus(), entryStatus)
                || StrUtil.isNotBlank(jobNumber);
    }

    @AssertTrue(message = "Full-time probation period cannot be empty.")
    @JsonIgnore
    public boolean isProbationValid() {
        return ObjUtil.notEqual(HrmEmployeeTypeEnum.FORMAL.getType(), type) || probation != null;
    }

    @AssertTrue(message = "Tenure start date cannot be later than the hire date.")
    @JsonIgnore
    public boolean isCompanyAgeStartTimeValid() {
        return entryTime == null || companyAgeStartTime == null
                || isBeforeOrEqual(companyAgeStartTime, entryTime);
    }

}
