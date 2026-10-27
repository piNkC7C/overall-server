package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM Recruitingcandidate create / edit request.")
@Data
public class HrmRecruitCandidateSaveReqVO {

    @Schema(description = "Candidate code.", example = "1024")
    private Long id;

    @Schema(description = "CandidateName.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "CandidateName is required.")
    @Size(max = 255, message = "CandidateName length cannot exceed 255 characters.")
    @DiffLogField(name = "CandidateName.")
    private String name;

    @Schema(description = "Mobile Number", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691399")
    @NotBlank(message = "Mobile Number is required.")
    @Size(max = 18, message = "Mobile Number length cannot exceed 18 characters.")
    @Pattern(regexp = "^(\\+?0?\\d{2,4}-?)?\\d{6,11}$", message = "Mobile Number format is invalid.")
    @DiffLogField(name = "Mobile Number")
    private String mobile;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Gender is required.")
    @DiffLogField(name = "Gender")
    private Integer sex;

    @Schema(description = "Age", example = "28")
    @Min(value = 0, message = "Age cannot be less than 0.")
    @Max(value = 99, message = "Age cannot be greater than 99.")
    @DiffLogField(name = "Age")
    private Integer age;

    @Schema(description = "Email", example = "candidate@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email length cannot exceed 255 characters.")
    @DiffLogField(name = "Email")
    private String email;

    @Schema(description = "Applied job code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Applied job is required.")
    @DiffLogField(name = "Applied Job")
    private Long postId;

    @Schema(description = "Years of Experience", example = "5")
    @Min(value = 0, message = "Years of experience cannot be less than 0.")
    @Max(value = 60, message = "Years of experience cannot be greater than 60.")
    @DiffLogField(name = "Years of Experience")
    private Integer workTime;

    @Schema(description = "Education", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Education is required.")
    @DiffLogField(name = "Education")
    private Integer education;

    @Schema(description = "School", example = "Zhejiang University")
    @Size(max = 255, message = "School length cannot exceed 255 characters.")
    @DiffLogField(name = "School")
    private String graduateSchool;

    @Schema(description = "Last Employer", example = "Acme Corp")
    @Size(max = 255, message = "Last Employer length cannot exceed 255 characters.")
    @DiffLogField(name = "Last Employer")
    private String latestWorkPlace;

    @Schema(description = "Recruiting Channel code.", example = "1")
    @DiffLogField(name = "Recruiting Channel")
    private Long channelId;

    @Schema(description = "Notes.", example = "Strong communication intent")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Resume attachment URLArray.", example = "[\"https://example.com/resume.pdf\"]")
    @Size(max = 5, message = "Resume attachments cannot exceed 5.")
    @DiffLogField(name = "Resume Attachment")
    private List<@Size(max = 512, message = "Resume attachment URL cannot exceed 512 characters.") String> resumeUrls;

}
