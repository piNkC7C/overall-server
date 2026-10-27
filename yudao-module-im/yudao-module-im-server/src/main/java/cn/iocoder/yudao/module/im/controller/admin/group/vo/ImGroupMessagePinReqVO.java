package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 管理后台 - 群消息置顶 / 取消置顶 Request VO
 */
@Schema(description = "Pin group message / unpin request VO.")
@Data
public class ImGroupMessagePinReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13279")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Message code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9527")
    @NotNull(message = "Message code is required.")
    private Long messageId;

}
