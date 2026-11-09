package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.recruit.candidate.HrmRecruitCandidateStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - HRM 招聘候选人状态修改 Request VO")
@Data
public class HrmRecruitCandidateUpdateStatusReqVO {

    @Schema(description = "候选人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Candidate code is required.")
    private Long id;

    @Schema(description = "候选人状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Candidate status is required.")
    @InEnum(value = HrmRecruitCandidateStatusEnum.class, message = "Candidate status must be {value}.")
    private Integer status;

}
