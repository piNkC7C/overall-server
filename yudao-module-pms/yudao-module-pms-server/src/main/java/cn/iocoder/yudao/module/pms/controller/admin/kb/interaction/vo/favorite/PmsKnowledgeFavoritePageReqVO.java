package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.favorite;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.kb.PmsKnowledgeObjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - PMS knowledge Favorite ( follow ) page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsKnowledgeFavoritePageReqVO extends PageParam {

    @Schema(description = "Object type.", example = "3")
    @InEnum(value = PmsKnowledgeObjectTypeEnum.class, message = "Object type must be {value}.")
    private Integer type;

}
