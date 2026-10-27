package cn.iocoder.yudao.module.bpm.controller.admin.comment.vo;

import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - workflow comment response.")
@Data
public class BpmCommentRespVO {

    @Schema(description = "Comment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Task code.", example = "2048")
    private String taskId;

    @Schema(description = "Task.")
    private Task task;

    @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private String processInstanceId;

    @Schema(description = "Comment type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private String type;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Please review the expense invoice attachment")
    private String message;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Creator.")
    private UserSimpleBaseVO user;

    @Schema(description = "Task.")
    @Data
    public static class Task {

        @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private String id;

        @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Manager approval")
        private String name;

        @Schema(description = "Task definition key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Activity_one")
        private String taskDefinitionKey;

    }

}
