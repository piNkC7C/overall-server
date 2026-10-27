package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS work item comment response.")
@Data
public class PmsWorkItemCommentRespVO {

    @Schema(description = "Comment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long workItemId;

    @Schema(description = "Comment person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Comment person Name.", example = "Overall.")
    private String userName;

    @Schema(description = "Root comment ID.", example = "1024")
    private Long mainId;

    @Schema(description = "Reply object user ID.", example = "2048")
    private Long replyUserId;

    @Schema(description = "Reply object Name.", example = "Source")
    private String replyUserName;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Reply list.")
    private List<PmsWorkItemCommentRespVO> children;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
