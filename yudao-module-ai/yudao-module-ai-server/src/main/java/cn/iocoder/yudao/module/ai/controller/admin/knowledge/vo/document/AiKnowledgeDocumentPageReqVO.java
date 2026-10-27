package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.document;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - AI knowledge base document page request.")
@Data
public class AiKnowledgeDocumentPageReqVO extends PageParam {

    @Schema(description = "Knowledge base code.", example = "1")
    private Long knowledgeId;

    @Schema(description = "Document name.", example = "Java handbook")
    private String name;

}
