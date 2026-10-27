package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.interview;

import cn.iocoder.yudao.module.hrm.enums.recruit.candidate.HrmRecruitInterviewResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.equalsAny;

@Schema(description = "Admin - HRM Recruiting interview result request.")
@Data
public class HrmRecruitInterviewResultReqVO {

    @Schema(description = "Interview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Interview code is required.")
    private Long id;

    @Schema(description = "Interview result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Interview result is required.")
    private Integer result;

    @Schema(description = "Review.", example = "Solid fundamentals")
    @Size(max = 255, message = "Review length cannot exceed 255 characters.")
    private String evaluate;

    @Schema(description = "Cancelreason.", example = "Candidate rescheduled")
    @Size(max = 255, message = "Cancelreason length cannot exceed 255 characters.")
    private String cancelReason;

    @AssertTrue(message = "Interview result must be via 、 not via or cancel.")
    @JsonIgnore
    public boolean isResultValid() {
        return equalsAny(result, null, HrmRecruitInterviewResultEnum.PASS.getResult(),
                HrmRecruitInterviewResultEnum.NOT_PASS.getResult(), HrmRecruitInterviewResultEnum.CANCEL.getResult());
    }

}
