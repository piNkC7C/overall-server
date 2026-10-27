package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "OA work-plan comment request VO.")
@Data
public class OaPlanCommentReqVO {

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Plan code is required.")
    private Long id;

    @Schema(description = "Plan review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "The plan is on track. Continue follow-up.")
    @NotBlank(message = "Plan review cannot be empty.")
    @Size(max = 1000, message = "Review comment cannot exceed {max} characters.")
    private String comment;

}
