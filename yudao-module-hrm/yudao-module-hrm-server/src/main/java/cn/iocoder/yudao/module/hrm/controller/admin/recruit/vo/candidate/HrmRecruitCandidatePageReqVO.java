package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.recruit.candidate.HrmRecruitCandidateStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM Recruitingcandidate page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmRecruitCandidatePageReqVO extends PageParam {

    @Schema(description = "Name、Mobile Number or email, fuzzy match.", example = "John.")
    private String search;

    @Schema(description = "Job Title code.", example = "1024")
    private Long postId;

    @Schema(description = "Recruiteremployee code.", example = "1")
    private Long ownerEmployeeId;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "MinimumAge.", example = "20")
    private Integer minAge;

    @Schema(description = "MaximumAge.", example = "35")
    private Integer maxAge;

    @Schema(description = "MinimumYears of experience.", example = "1")
    private Integer minWorkTime;

    @Schema(description = "MaximumYears of experience.", example = "5")
    private Integer maxWorkTime;

    @Schema(description = "Education", example = "5")
    private Integer education;

    @Schema(description = "School, fuzzy match.", example = "Zhejiang University")
    private String graduateSchool;

    @Schema(description = "Last Employer, fuzzy match.", example = "Acme Corp")
    private String latestWorkPlace;

    @Schema(description = "Channel code.", example = "1")
    private Long channelId;

    @Schema(description = "Intervieweremployee code.", example = "1")
    private Long interviewEmployeeId;

    @Schema(description = "Interview time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] interviewTime;

    @Schema(description = "Creator user ID.", example = "1")
    private Long creator;

    @Schema(description = "Candidate status.", example = "1")
    @InEnum(value = HrmRecruitCandidateStatusEnum.class, message = "Candidate status must be {value}.")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
