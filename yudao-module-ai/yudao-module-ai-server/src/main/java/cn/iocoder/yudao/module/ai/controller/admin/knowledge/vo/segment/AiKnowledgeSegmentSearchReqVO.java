package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - AI 知识库段落搜索 Request VO")
@Data
public class AiKnowledgeSegmentSearchReqVO {

    @Schema(description = "知识库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long knowledgeId;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "How to use this product")
    @NotEmpty(message = "Content is required.")
    private String content;

    @Schema(description = "最大返回数量", example = "5")
    private Integer topK;

    @Schema(description = "相似度阈值", example = "0.7")
    private Double similarityThreshold;

}
