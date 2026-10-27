package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM Recruitingcandidate response.")
@Data
@Accessors(chain = true)
public class HrmRecruitCandidateRespVO {

    @Schema(description = "Candidate code.", example = "1024")
    private Long id;

    @Schema(description = "CandidateName.", example = "John.")
    private String name;

    @Schema(description = "Mobile Number", example = "15601691399")
    private String mobile;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Age", example = "28")
    private Integer age;

    @Schema(description = "Email", example = "candidate@example.com")
    private String email;

    @Schema(description = "Applied job code.", example = "1024")
    private Long postId;

    @Schema(description = "Applied job name.", example = "Java engineer")
    private String postName;

    @Schema(description = "Applied job status.", example = "1")
    private Integer postStatus;

    @Schema(description = "Person department code.", example = "100")
    private Long deptId;

    @Schema(description = "Person department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Recruiteremployee code.", example = "1")
    private Long ownerEmployeeId;

    @Schema(description = "RecruiterName.", example = "Jane.")
    private String ownerEmployeeName;

    @Schema(description = "Interview Round", example = "1")
    private Integer stageNumber;

    @Schema(description = "Years of Experience", example = "5")
    private Integer workTime;

    @Schema(description = "Education", example = "5")
    private Integer education;

    @Schema(description = "School", example = "Zhejiang University")
    private String graduateSchool;

    @Schema(description = "Last Employer", example = "Acme Corp")
    private String latestWorkPlace;

    @Schema(description = "Recruiting Channel code.", example = "1")
    private Long channelId;

    @Schema(description = "Recruiting Channel name.", example = "LinkedIn")
    private String channelName;

    @Schema(description = "Notes.", example = "Strong communication intent")
    private String remark;

    @Schema(description = "Candidate status.", example = "1")
    private Integer status;

    @Schema(description = "Rejection Reason", example = "Skill mismatch")
    private String eliminate;

    @Schema(description = "Statusupdate time.")
    private LocalDateTime statusUpdateTime;

    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Resume attachment URLArray.", example = "[\"https://example.com/resume.pdf\"]")
    private List<String> resumeUrls;

    @Schema(description = "Current interview code.", example = "1024")
    private Long interviewId;

    @Schema(description = "Interview method.", example = "3")
    private Integer interviewType;

    @Schema(description = "Lead Intervieweremployee code.", example = "1")
    private Long interviewEmployeeId;

    @Schema(description = "Lead InterviewerName.", example = "Alex.")
    private String interviewEmployeeName;

    @Schema(description = "Other Interviewersemployee ID list.", example = "[2, 3]")
    private List<Long> otherInterviewEmployeeIds;

    @Schema(description = "Other InterviewersNameArray.", example = "[\"Alex\", \"Sam\"]")
    private List<String> otherInterviewEmployeeNames;

    @Schema(description = "Interview time.")
    private LocalDateTime interviewTime;

    @Schema(description = "Interview Address.", example = "Pudong, Shanghai")
    private String interviewAddress;

    @Schema(description = "Interview result.", example = "1")
    private Integer interviewResult;

    @Schema(description = "Transferred-in employee ID.", example = "100")
    private Long employeeId;

    @Schema(description = "Creator.", example = "1")
    private String creator;

    @Schema(description = "Creator name.", example = "Admin.")
    private String creatorName;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Update time.")
    private LocalDateTime updateTime;

}
