package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.interview;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM Recruiting interview create / edit request.")
@Data
public class HrmRecruitInterviewSaveReqVO {

    @Schema(description = "Interview code.", example = "1024")
    private Long id;

    @Schema(description = "Candidate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long candidateId;

    @Schema(description = "Interview method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Interview method is required.")
    @DiffLogField(name = "Interview method.")
    private Integer type;

    @Schema(description = "Interview Round", example = "1")
    private Integer stageNumber;

    @Schema(description = "Lead Intervieweremployee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Lead Interviewer is required.")
    @DiffLogField(name = "Lead Interviewer")
    private Long interviewEmployeeId;

    @Schema(description = "Other Interviewersemployee ID list.", example = "[2, 3]")
    @DiffLogField(name = "Other Interviewers")
    private List<Long> otherInterviewEmployeeIds;

    @Schema(description = "Interview time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Interview time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @DiffLogField(name = "Interview time.")
    private LocalDateTime interviewTime;

    @Schema(description = "Interview Address.", example = "Conference room A")
    @Size(max = 255, message = "Interview Address length cannot exceed 255 characters.")
    @DiffLogField(name = "Interview Address.")
    private String address;

    @Schema(description = "Notes.", example = "Please bring a portfolio")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

}
