package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 知识库文档评论保存 Request VO")
@Data
public class PmsKnowledgeDocumentCommentSaveReqVO {

    @Schema(description = "文档编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long documentId;

    @Schema(description = "主评论编号", example = "0")
    private Long mainId;

    @Schema(description = "回复对象用户编号", example = "1")
    private Long replyUserId;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "The document is clear")
    @NotBlank(message = "Comment content is required.")
    @Size(max = 2000, message = "Comment content cannot exceed 2000 characters.")
    private String content;

}
