package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - AI knowledge base segment page request.")
@Data
public class AiKnowledgeSegmentPageReqVO extends PageParam {

    @Schema(description = "Document code.", example = "1")
    private Long documentId;

    @Schema(description = "Segment content keyword.", example = "Java development")
    private String content;

    @Schema(description = "Segment status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
