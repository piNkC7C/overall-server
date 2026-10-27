package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Schema(description = "AI knowledge-base chunk update status request VO.")
@Data
public class AiKnowledgeSegmentUpdateStatusReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long id;

    @Schema(description = "Is not Enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Is not Enabled is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
