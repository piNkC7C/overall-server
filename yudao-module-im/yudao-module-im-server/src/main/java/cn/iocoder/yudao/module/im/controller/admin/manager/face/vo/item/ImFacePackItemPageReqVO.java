package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.item;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "IM sticker item page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImFacePackItemPageReqVO extends PageParam {

    @Schema(description = "Sticker pack ID.", example = "1024")
    private Long packId;

    @Schema(description = "Emoji Name, fuzzy match.", example = "Dog")
    private String name;

    @Schema(description = "Status.", example = "0")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class

}
