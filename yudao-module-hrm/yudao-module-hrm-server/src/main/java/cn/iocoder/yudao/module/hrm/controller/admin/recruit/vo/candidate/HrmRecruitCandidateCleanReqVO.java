package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.recruit.candidate.HrmRecruitCandidateStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 招聘候选人清理 Request VO")
@Data
public class HrmRecruitCandidateCleanReqVO {

    @Schema(description = "候选人状态数组", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1, 2, 3, 4]")
    @NotEmpty(message = "Candidate status is required.")
    private List<@NotNull(message = "Candidate status is required.")
            @InEnum(value = HrmRecruitCandidateStatusEnum.class, message = "Candidate status must be {value}.") Integer> statuses;

    @Schema(description = "状态持续天数", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    @NotNull(message = "StatusDuration days is required.")
    @Positive(message = "Days in this status must be greater than 0.")
    private Integer days;

}
