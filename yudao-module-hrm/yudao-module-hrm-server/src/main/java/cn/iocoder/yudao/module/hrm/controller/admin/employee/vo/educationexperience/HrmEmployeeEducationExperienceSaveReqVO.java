package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.educationexperience;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isAfterOrEqual;

@Schema(description = "Admin - HRM employeeeducationsave request.")
@Data
public class HrmEmployeeEducationExperienceSaveReqVO {

    @Schema(description = "Education ID.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Education", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    @NotNull(message = "Education is required.")
    @DiffLogField(name = "Education")
    private Integer education;

    @Schema(description = "School", requiredMode = Schema.RequiredMode.REQUIRED, example = "Zhejiang University")
    @NotBlank(message = "School is required.")
    @Size(max = 255, message = "School length cannot exceed 255 characters.")
    @DiffLogField(name = "School")
    private String graduateSchool;

    @Schema(description = "Major", requiredMode = Schema.RequiredMode.REQUIRED, example = "Software engineering")
    @NotBlank(message = "Major is required.")
    @Size(max = 255, message = "Major length cannot exceed 255 characters.")
    @DiffLogField(name = "Major")
    private String major;

    @Schema(description = "Enrollment Date")
    @DiffLogField(name = "Enrollment Date")
    private LocalDateTime admissionTime;

    @Schema(description = "Graduation Date")
    @DiffLogField(name = "Graduation Date")
    private LocalDateTime graduationTime;

    @Schema(description = "Teaching method.", example = "1")
    @DiffLogField(name = "Teaching Method")
    private Integer teachingMethods;

    @Schema(description = "First degree.", example = "true")
    @DiffLogField(name = "First Degree")
    private Boolean firstDegree;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

    @AssertTrue(message = "Graduation Date cannot earlier than Enrollment Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return admissionTime == null || graduationTime == null
                || isAfterOrEqual(graduationTime, admissionTime);
    }

}
