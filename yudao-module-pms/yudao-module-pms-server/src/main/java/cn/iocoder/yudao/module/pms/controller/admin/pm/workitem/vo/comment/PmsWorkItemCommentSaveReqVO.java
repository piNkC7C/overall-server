package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS work item comment create / edit request.")
@Data
public class PmsWorkItemCommentSaveReqVO {

    @Schema(description = "Comment code.", example = "1024")
    private Long id;

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Work item code is required.")
    private Long workItemId;

    @Schema(description = "Parent comment ID. Pass when replying.", example = "1024")
    private Long mainId;

    @Schema(description = "Reply object user ID.", example = "2048")
    private Long replyUserId;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Already process.")
    @NotBlank(message = "Comment content is required.")
    @Size(max = 2000, message = "Comment content cannot exceed 2000 characters.")
    private String content;

}
