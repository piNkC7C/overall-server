package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - AI 知识库新增/修改 Request VO")
@Data
public class AiKnowledgeSaveReqVO {

    @Schema(description = "对话编号", example = "1204")
    private Long id;

    @Schema(description = "知识库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Platform user guide")
    @NotBlank(message = "Knowledge base name is required.")
    private String name;

    @Schema(description = "知识库描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Storage ruoyi-vue-pro actiondocument.")
    private String description;

    @Schema(description = "向量模型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Embedding model cannot be empty.")
    private Long embeddingModelId;

    @Schema(description = "topK", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "TopK is required.")
    private Integer topK;

    @Schema(description = "相似性阈值", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.5")
    @NotNull(message = "Similarity threshold cannot be empty.")
    private Double similarityThreshold;

    @Schema(description = "是否启用",  requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Is not Enabled is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
