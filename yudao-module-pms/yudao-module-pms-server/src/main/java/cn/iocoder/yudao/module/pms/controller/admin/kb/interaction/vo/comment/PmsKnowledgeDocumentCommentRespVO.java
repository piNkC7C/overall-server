package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS knowledge base document comment response.")
@Data
public class PmsKnowledgeDocumentCommentRespVO {

    @Schema(description = "Comment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long documentId;

    @Schema(description = "Comment person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Comment person Nickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Root comment ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Long mainId;

    @Schema(description = "Reply object user ID.", example = "2")
    private Long replyUserId;

    @Schema(description = "Reply object Nickname.", example = "Source")
    private String replyUserName;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Reply list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsKnowledgeDocumentCommentRespVO> children;

}
