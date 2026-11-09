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

@Schema(description = "管理后台 - HRM 招聘面试新增/修改 Request VO")
@Data
public class HrmRecruitInterviewSaveReqVO {

    @Schema(description = "面试编号", example = "1024")
    private Long id;

    @Schema(description = "候选人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long candidateId;

    @Schema(description = "面试方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Interview method is required.")
    @DiffLogField(name = "面试方式")
    private Integer type;

    @Schema(description = "面试轮次", example = "1")
    private Integer stageNumber;

    @Schema(description = "主面试官员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Lead Interviewer is required.")
    @DiffLogField(name = "主面试官")
    private Long interviewEmployeeId;

    @Schema(description = "其他面试官员工编号数组", example = "[2, 3]")
    @DiffLogField(name = "其他面试官")
    private List<Long> otherInterviewEmployeeIds;

    @Schema(description = "面试时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Interview time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @DiffLogField(name = "面试时间")
    private LocalDateTime interviewTime;

    @Schema(description = "面试地址", example = "Conference room A")
    @Size(max = 255, message = "Interview Address length cannot exceed 255 characters.")
    @DiffLogField(name = "面试地址")
    private String address;

    @Schema(description = "备注", example = "Please bring a portfolio")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    @DiffLogField(name = "备注")
    private String remark;

}
