package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "AI chat message page request VO.")
@Data
public class AiChatMessagePageReqVO extends PageParam {

    @Schema(description = "Conversation ID.", example = "2048")
    private Long conversationId;

    @Schema(description = "User ID.", example = "1024")
    private Long userId;

    @Schema(description = "Message content.", example = "Hello")
    private String content;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
