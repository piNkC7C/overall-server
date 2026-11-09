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

@Schema(description = "管理后台 - HRM 招聘候选人新增/修改 Request VO")
@Data
public class HrmRecruitCandidateSaveReqVO {

    @Schema(description = "候选人编号", example = "1024")
    private Long id;

    @Schema(description = "候选人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "CandidateName is required.")
    @Size(max = 255, message = "CandidateName length cannot exceed 255 characters.")
    @DiffLogField(name = "候选人姓名")
    private String name;

    @Schema(description = "手机号码", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691399")
    @NotBlank(message = "Mobile Number is required.")
    @Size(max = 18, message = "Mobile Number length cannot exceed 18 characters.")
    @Pattern(regexp = "^(\\+?0?\\d{2,4}-?)?\\d{6,11}$", message = "Mobile Number format is invalid.")
    @DiffLogField(name = "手机号码")
    private String mobile;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Gender is required.")
    @DiffLogField(name = "性别")
    private Integer sex;

    @Schema(description = "年龄", example = "28")
    @Min(value = 0, message = "Age cannot be less than 0.")
    @Max(value = 99, message = "Age cannot be greater than 99.")
    @DiffLogField(name = "年龄")
    private Integer age;

    @Schema(description = "邮箱", example = "candidate@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email length cannot exceed 255 characters.")
    @DiffLogField(name = "邮箱")
    private String email;

    @Schema(description = "应聘职位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Applied job is required.")
    @DiffLogField(name = "应聘职位")
    private Long postId;

    @Schema(description = "工作年限", example = "5")
    @Min(value = 0, message = "Years of experience cannot be less than 0.")
    @Max(value = 60, message = "Years of experience cannot be greater than 60.")
    @DiffLogField(name = "工作年限")
    private Integer workTime;

    @Schema(description = "学历", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Education is required.")
    @DiffLogField(name = "学历")
    private Integer education;

    @Schema(description = "毕业院校", example = "Zhejiang University")
    @Size(max = 255, message = "School length cannot exceed 255 characters.")
    @DiffLogField(name = "毕业院校")
    private String graduateSchool;

    @Schema(description = "最近工作单位", example = "Acme Corp")
    @Size(max = 255, message = "Last Employer length cannot exceed 255 characters.")
    @DiffLogField(name = "最近工作单位")
    private String latestWorkPlace;

    @Schema(description = "招聘渠道编号", example = "1")
    @DiffLogField(name = "招聘渠道")
    private Long channelId;

    @Schema(description = "备注", example = "Strong communication intent")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    @DiffLogField(name = "备注")
    private String remark;

    @Schema(description = "简历附件地址数组", example = "[\"https://example.com/resume.pdf\"]")
    @Size(max = 5, message = "Resume attachments cannot exceed 5.")
    @DiffLogField(name = "简历附件")
    private List<@Size(max = 512, message = "Resume attachment URL cannot exceed 512 characters.") String> resumeUrls;

}
