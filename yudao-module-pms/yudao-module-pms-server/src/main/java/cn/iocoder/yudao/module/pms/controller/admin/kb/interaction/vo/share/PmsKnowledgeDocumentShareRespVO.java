package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.share;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS knowledge base document share response.")
@Data
public class PmsKnowledgeDocumentShareRespVO {

    @Schema(description = "Share code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long documentId;

    @Schema(description = "Internal share member user IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Long> shareUserIds;

    @Schema(description = "External view token.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;

    @Schema(description = "Share status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Disable person user ID.")
    private Long closeUserId;

    @Schema(description = "Disable time.")
    private LocalDateTime closeTime;

}
