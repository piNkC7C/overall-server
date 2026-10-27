package cn.iocoder.yudao.module.im.controller.admin.conversation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * IM 会话读位置 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "IM conversation read position response VO.")
@Data
public class ImConversationReadRespVO {

    @Schema(description = "Read-position ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Conversation type.", example = "1")
    private Integer conversationType; // See ImConversationTypeEnum enum

    @Schema(description = "Target code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long targetId;

    @Schema(description = "MaximumReadmessageID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private Long messageId;

    @Schema(description = "Last update time (incremental cursor).")
    private LocalDateTime updateTime;

}
