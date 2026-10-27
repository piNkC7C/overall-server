package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.share;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge base document share member list update request.")
@Data
public class PmsKnowledgeDocumentShareUpdateMemberListReqVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long documentId;

    @Schema(description = "Internal share member user IDs.")
    private List<@NotNull(message = "Share member user ID is required.") Long> shareUserIds;

}
