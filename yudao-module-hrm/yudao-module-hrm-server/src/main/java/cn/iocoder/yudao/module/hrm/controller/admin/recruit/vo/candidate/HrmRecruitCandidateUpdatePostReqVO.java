package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM RecruitingcandidateJob Title edit request.")
@Data
public class HrmRecruitCandidateUpdatePostReqVO {

    @Schema(description = "Candidate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long id;

    @Schema(description = "Job Title code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Job Title code is required.")
    private Long postId;

}
