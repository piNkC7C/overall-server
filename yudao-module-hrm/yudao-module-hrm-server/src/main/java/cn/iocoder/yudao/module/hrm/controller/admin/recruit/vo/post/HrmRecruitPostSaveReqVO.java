package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.post;

import cn.iocoder.yudao.module.hrm.framework.operatelog.core.HrmAreaParseFunction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.module.hrm.dal.dataobject.recruit.post.HrmRecruitPostDO.AGE_UNLIMITED_VALUE;
import static cn.iocoder.yudao.module.hrm.dal.dataobject.recruit.post.HrmRecruitPostDO.SALARY_NEGOTIABLE_UNIT_VALUE;
import static cn.iocoder.yudao.module.hrm.dal.dataobject.recruit.post.HrmRecruitPostDO.SALARY_NEGOTIABLE_VALUE;

@Schema(description = "Admin - HRM RecruitingJob Title create / edit request.")
@Data
public class HrmRecruitPostSaveReqVO {

    @Schema(description = "RecruitingJob Title code.", example = "1024")
    private Long id;

    @Schema(description = "Job Title name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java engineer")
    @NotBlank(message = "Job Title name is required.")
    @Size(max = 255, message = "Job Title name cannot exceed 255 characters.")
    @DiffLogField(name = "Job Title name.")
    private String postName;

    @Schema(description = "Department code.", example = "100")
    @DiffLogField(name = "Department code.")
    private Long deptId;

    @Schema(description = "Work Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work Type is required.")
    @DiffLogField(name = "Work Type")
    private Integer jobNature;

    @Schema(description = "Work CityRegion ID.", example = "310115")
    @DiffLogField(name = "Work City", function = HrmAreaParseFunction.NAME)
    private Integer areaId;

    @Schema(description = "Headcount", example = "3")
    @Min(value = 0, message = "Headcount cannot be less than 0.")
    @DiffLogField(name = "Headcount")
    private Integer recruitNum;

    @Schema(description = "Recruitingreason.", example = "Team expansion")
    @Size(max = 255, message = "Recruitingreason cannot exceed 255 characters.")
    @DiffLogField(name = "Recruitingreason.")
    private String reason;

    @Schema(description = "Experience", example = "3")
    @DiffLogField(name = "Experience")
    private Integer workTime;

    @Schema(description = "Education require.", example = "4")
    @DiffLogField(name = "Education require.")
    private Integer educationRequire;

    @Schema(description = "Minimum salary.", example = "20000")
    @Digits(integer = 8, fraction = 2, message = "Minimum salary can have at most 8 integer digits and 2 decimal places.")
    @DiffLogField(name = "Minimum Salary")
    private BigDecimal minSalary;

    @Schema(description = "Maximum salary.", example = "30000")
    @Digits(integer = 8, fraction = 2, message = "Maximum salary can have at most 8 integer digits and 2 decimal places.")
    @DiffLogField(name = "Maximum Salary")
    private BigDecimal maxSalary;

    @Schema(description = "Payroll order characters.", example = "2")
    @DiffLogField(name = "Payroll order characters.")
    private Integer salaryUnit;

    @Schema(description = "MinimumAge.", example = "22")
    @DiffLogField(name = "Minimum Age")
    private Integer minAge;

    @Schema(description = "MaximumAge.", example = "35")
    @DiffLogField(name = "Maximum Age")
    private Integer maxAge;

    @Schema(description = "Latest Start Date")
    @DiffLogField(name = "Latest Start Date")
    private LocalDateTime latestEntryTime;

    @Schema(description = "Owner person employee code.", example = "1")
    @DiffLogField(name = "Owner person.")
    private Long ownerEmployeeId;

    @Schema(description = "Intervieweremployee ID list.", example = "[1, 2]")
    @DiffLogField(name = "Interviewer")
    private List<Long> interviewEmployeeIds;

    @Schema(description = "Job TitleDescription.", example = "Own core business system design and development")
    @Size(max = 4000, message = "Job TitleDescription cannot exceed 4000 characters.")
    @DiffLogField(name = "Job TitleDescription.")
    private String description;

    @Schema(description = "Urgency", example = "1")
    @DiffLogField(name = "Urgency")
    private Integer emergencyLevel;

    @Schema(description = "Job Title type code.", example = "100")
    @DiffLogField(name = "Job Title type code.")
    private Long postTypeId;

    @AssertTrue(message = "PayrollRange is invalid.")
    @JsonIgnore
    public boolean isSalaryRangeValid() {
        boolean hasNegotiableValue = SALARY_NEGOTIABLE_VALUE.equals(getMinSalary())
                || SALARY_NEGOTIABLE_VALUE.equals(getMaxSalary()) || SALARY_NEGOTIABLE_UNIT_VALUE.equals(getSalaryUnit());
        if (hasNegotiableValue) {
            return SALARY_NEGOTIABLE_VALUE.equals(getMinSalary())
                    && SALARY_NEGOTIABLE_VALUE.equals(getMaxSalary())
                    && SALARY_NEGOTIABLE_UNIT_VALUE.equals(getSalaryUnit());
        }
        if ((getMinSalary() != null && getMinSalary().signum() < 0)
                || (getMaxSalary() != null && getMaxSalary().signum() < 0)) {
            return false;
        }
        return getMinSalary() == null || getMaxSalary() == null || getMinSalary().compareTo(getMaxSalary()) <= 0;
    }

    @AssertTrue(message = "AgeRange is invalid.")
    @JsonIgnore
    public boolean isAgeRangeValid() {
        boolean hasUnlimitedValue = AGE_UNLIMITED_VALUE.equals(getMinAge()) || AGE_UNLIMITED_VALUE.equals(getMaxAge());
        if (hasUnlimitedValue) {
            return AGE_UNLIMITED_VALUE.equals(getMinAge()) && AGE_UNLIMITED_VALUE.equals(getMaxAge());
        }
        if ((getMinAge() != null && getMinAge() < 0) || (getMaxAge() != null && getMaxAge() < 0)) {
            return false;
        }
        return getMinAge() == null || getMaxAge() == null || getMinAge() <= getMaxAge();
    }

}
