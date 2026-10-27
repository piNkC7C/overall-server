package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM Recruitingcandidatechannel edit request.")
@Data
public class HrmRecruitCandidateUpdateChannelReqVO {

    @Schema(description = "Candidate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long id;

    @Schema(description = "Recruiting Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Recruiting Channel code is required.")
    private Long channelId;

}
