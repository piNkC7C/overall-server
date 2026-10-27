package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.interview;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM Recruiting interview response.")
@Data
public class HrmRecruitInterviewRespVO {

    @Schema(description = "Interview code.", example = "1024")
    private Long id;

    @Schema(description = "Candidate code.", example = "1024")
    private Long candidateId;

    @Schema(description = "Interview method.", example = "1")
    private Integer type;

    @Schema(description = "Interview Round", example = "1")
    private Integer stageNumber;

    @Schema(description = "Lead Intervieweremployee code.", example = "1")
    private Long interviewEmployeeId;

    @Schema(description = "Lead InterviewerName.", example = "John.")
    private String interviewEmployeeName;

    @Schema(description = "Other Interviewersemployee ID list.", example = "[2, 3]")
    private List<Long> otherInterviewEmployeeIds;

    @Schema(description = "Other InterviewersNameArray.", example = "[\"Jane\", \"John\"]")
    private List<String> otherInterviewEmployeeNames;

    @Schema(description = "Interview time.")
    private LocalDateTime interviewTime;

    @Schema(description = "Interview Address.", example = "Conference room A")
    private String address;

    @Schema(description = "Notes.", example = "Please bring a portfolio")
    private String remark;

    @Schema(description = "Interview result.", example = "1")
    private Integer result;

    @Schema(description = "Review.")
    private String evaluate;

    @Schema(description = "Cancelreason.")
    private String cancelReason;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
