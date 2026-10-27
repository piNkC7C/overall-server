package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


@Schema(description = "Admin - AI knowledge base document create request.")
@Data
public class AiKnowledgeDocumentCreateReqVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1204")
    @NotNull(message = "Knowledge base code is required.")
    private Long knowledgeId;

    @Schema(description = "Document name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Third-party sign-in")
    @NotBlank(message = "Document name is required.")
    private String name;

    @Schema(description = "Document URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://doc.iocoder.cn")
    @URL(message = "Document URL format is invalid.")
    private String url;

    @Schema(description = "Maximum tokens per chunk.", requiredMode = Schema.RequiredMode.REQUIRED, example = "800")
    @NotNull(message = "Maximum tokens per chunk cannot be empty.")
    private Integer segmentMaxTokens;

}
