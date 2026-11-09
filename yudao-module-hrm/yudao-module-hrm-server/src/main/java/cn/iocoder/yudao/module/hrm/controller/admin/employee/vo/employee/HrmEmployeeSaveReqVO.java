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

@Schema(description = "管理后台 - HRM 员工档案新增/修改 Request VO")
@Data
public class HrmEmployeeSaveReqVO {

    @Schema(description = "员工档案编号", example = "1024")
    private Long id;

    @Schema(description = "员工姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "Employee Name is required.")
    @Size(max = 255, message = "Employee Name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "工号", example = "HRM001")
    @Size(max = 64, message = "Employee No. cannot exceed 64 characters.")
    private String jobNumber;

    @Schema(description = "系统用户编号", example = "1024")
    private Long userId;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotBlank(message = "Phone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "国家地区", example = "China")
    @Size(max = 64, message = "Country / region cannot exceed 64 characters.")
    private String country;

    @Schema(description = "民族", example = "Han")
    @Size(max = 64, message = "Ethnicity cannot exceed 64 characters.")
    private String nation;

    @Schema(description = "证件类型", example = "1")
    @InEnum(value = HrmEmployeeIdTypeEnum.class, message = "ID Type must be {value}.")
    private Integer idType;

    @Schema(description = "证件号码", example = "310101199001011234")
    @Size(max = 255, message = "ID Number cannot exceed 255 characters.")
    private String idNumber;

    @Schema(description = "性别", example = "1")
    private Integer sex;

    @Schema(description = "邮箱", example = "hrm@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
    private String email;

    @Schema(description = "籍贯", example = "Hangzhou, Zhejiang")
    @Size(max = 128, message = "Hometown cannot exceed 128 characters.")
    private String nativePlace;

    @Schema(description = "出生时间")
    @PastOrPresent(message = "Date of birth cannot be later than today.")
    private LocalDateTime birthday;

    @Schema(description = "年龄", example = "28")
    private Integer age;

    @Schema(description = "户籍地址", example = "Xihu District, Hangzhou")
    @Size(max = 255, message = "Household Address cannot exceed 255 characters.")
    private String address;

    @Schema(description = "最高学历", example = "8")
    @InEnum(value = HrmEmployeeEducationEnum.class, message = "Highest Education must be {value}.")
    private Integer highestEducation;

    @Schema(description = "部门编号", example = "100")
    private Long deptId;

    @Schema(description = "直属上级员工编号", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "入职状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Onboarding status is required.")
    @InEnum(value = HrmEmployeeEntryStatusEnum.class, message = "Onboarding status must be {value}.")
    private Integer entryStatus;

    @Schema(description = "员工状态", example = "1")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
    private Integer status;

    @Schema(description = "聘用形式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employment Type is required.")
    @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
    private Integer type;

    @Schema(description = "入职时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Hire Date is required.")
    private LocalDateTime entryTime;

    @Schema(description = "试用期，单位月；0 表示无试用期", example = "3")
    @Min(value = 0, message = "Probation period cannot be less than 0 months.")
    @Max(value = 6, message = "Probation period cannot exceed 6 months.")
    private Integer probation;

    @Schema(description = "转正时间")
    private LocalDateTime regularTime;

    @Schema(description = "离职时间")
    private LocalDateTime leaveTime;

    @Schema(description = "职位名称", example = "Java engineer.")
    @Size(max = 255, message = "Job Title name cannot exceed 255 characters.")
    private String postName;

    @Schema(description = "岗位职级", example = "P6")
    @Size(max = 255, message = "Job Grade cannot exceed 255 characters.")
    private String postLevel;

    @Schema(description = "工作城市", example = "Shanghai")
    @Size(max = 64, message = "Work City cannot exceed 64 characters.")
    private String workCity;

    @Schema(description = "工作地址", example = "Downtown")
    @Size(max = 255, message = "Work address cannot exceed 255 characters.")
    private String workAddress;

    @Schema(description = "工作详细地址", example = "Building 1, Innovation Park")
    @Size(max = 255, message = "Detailed work address cannot exceed 255 characters.")
    private String workDetailAddress;

    @Schema(description = "招聘渠道编号", example = "10")
    private Long channelId;

    @Schema(description = "司龄开始时间")
    private LocalDateTime companyAgeStartTime;

    @Schema(description = "司龄，单位年", example = "2")
    private Integer companyAge;

    @Schema(description = "关联招聘候选人编号", example = "200")
    private Long candidateId;

    @Schema(description = "备注", example = "First-wave migrated employees")
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
