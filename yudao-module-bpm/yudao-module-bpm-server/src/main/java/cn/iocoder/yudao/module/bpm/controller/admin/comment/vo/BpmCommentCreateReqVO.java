package cn.iocoder.yudao.module.bpm.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - workflow comment create request.")
@Data
public class BpmCommentCreateReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotEmpty(message = "Task code is required.")
    private String taskId;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Please review the expense invoice attachment")
    @NotBlank(message = "Comment content is required.")
    @Size(max = 500, message = "Comment content cannot exceed 500 characters.")
    private String message;

}
