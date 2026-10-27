package cn.iocoder.yudao.module.oa.controller.admin.resign.vo;

import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - offboarding apply please create / edit request.")
@Data
public class OaResignApplySaveReqVO {

    @Schema(description = "Apply please code.", example = "1024")
    private Long id;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Offboarding apply please.")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "Handover personuser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Handover person cannot be empty.")
    private Long handoverUserId;

    @Schema(description = "Open items.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer files and project docs to hand over")
    @NotBlank(message = "Open items cannot be empty.")
    private String unfinishedWork;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Resigning for career development")
    @NotBlank(message = "Apply please reason is required.")
    @Size(max = 5000, message = "Apply please reason cannot exceed 5000 characters.")
    private String reason;

    @Schema(description = "Has unfinished expenses.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Has unfinished expenses cannot be empty.")
    private Boolean hasPendingReimbursement;


}
