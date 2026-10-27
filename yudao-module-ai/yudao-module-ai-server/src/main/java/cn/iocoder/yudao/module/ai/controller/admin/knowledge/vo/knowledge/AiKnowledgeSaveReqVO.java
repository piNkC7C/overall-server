package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - AI knowledge base create / edit request.")
@Data
public class AiKnowledgeSaveReqVO {

    @Schema(description = "Conversation ID.", example = "1204")
    private Long id;

    @Schema(description = "Knowledge base name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Platform user guide")
    @NotBlank(message = "Knowledge base name is required.")
    private String name;

    @Schema(description = "Knowledge base Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Storage ruoyi-vue-pro actiondocument.")
    private String description;

    @Schema(description = "Embedding modelID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Embedding model cannot be empty.")
    private Long embeddingModelId;

    @Schema(description = "topK", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "TopK is required.")
    private Integer topK;

    @Schema(description = "Similarity threshold.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.5")
    @NotNull(message = "Similarity threshold cannot be empty.")
    private Double similarityThreshold;

    @Schema(description = "Is not Enabled.",  requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Is not Enabled is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
