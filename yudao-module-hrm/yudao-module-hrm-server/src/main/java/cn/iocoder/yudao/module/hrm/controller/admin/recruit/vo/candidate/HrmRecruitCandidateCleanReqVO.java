package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.recruit.candidate.HrmRecruitCandidateStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM candidate cleanup request VO.")
@Data
public class HrmRecruitCandidateCleanReqVO {

    @Schema(description = "Candidate statusArray.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1, 2, 3, 4]")
    @NotEmpty(message = "Candidate status is required.")
    private List<@NotNull(message = "Candidate status is required.")
            @InEnum(value = HrmRecruitCandidateStatusEnum.class, message = "Candidate status must be {value}.") Integer> statuses;

    @Schema(description = "StatusDuration days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    @NotNull(message = "StatusDuration days is required.")
    @Positive(message = "Days in this status must be greater than 0.")
    private Integer days;

}
