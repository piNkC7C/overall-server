package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "IM channel message push request VO.")
@Data
public class ImChannelMessageSendReqVO {

    @Schema(description = "Media code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Media code is required.")
    private Long materialId;

    @Schema(description = "Recipient IDs. Empty means everyone.", example = "[1024, 2048]")
    private List<Long> receiverUserIds;

}
