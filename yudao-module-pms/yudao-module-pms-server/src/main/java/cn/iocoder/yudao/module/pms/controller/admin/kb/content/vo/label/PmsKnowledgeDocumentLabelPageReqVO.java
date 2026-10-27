package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.label;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "PMS by Tag search docs page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsKnowledgeDocumentLabelPageReqVO extends PageParam {

    @Schema(description = "Documenttag code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Documenttag code is required.")
    private Long labelId;

}
