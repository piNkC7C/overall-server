package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.favorite;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.kb.PmsKnowledgeObjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge Favorite ( follow ) save request.")
@Data
public class PmsKnowledgeFavoriteSaveReqVO {

    @Schema(description = "Object type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Object type is required.")
    @InEnum(value = PmsKnowledgeObjectTypeEnum.class, message = "Object type must be {value}.")
    private Integer type;

    @Schema(description = "Object code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Object code is required.")
    private Long entityId;

}
