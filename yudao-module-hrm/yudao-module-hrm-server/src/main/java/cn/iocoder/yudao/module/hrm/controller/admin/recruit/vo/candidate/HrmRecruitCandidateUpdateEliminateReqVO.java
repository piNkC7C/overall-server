package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM reject candidate request VO.")
@Data
public class HrmRecruitCandidateUpdateEliminateReqVO {

    @Schema(description = "Candidate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long id;

    @Schema(description = "Rejection Reason", requiredMode = Schema.RequiredMode.REQUIRED, example = "Skill mismatch")
    @NotBlank(message = "Rejection Reason is required.")
    @Size(max = 255, message = "Rejection Reason length cannot exceed 255 characters.")
    private String eliminate;

    @Schema(description = "Notes.", example = "Second interview failed")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

}
