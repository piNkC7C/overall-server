package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "AI chat conversation page request VO.")
@Data
public class AiChatConversationPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "1024")
    private Long userId;

    @Schema(description = "Conversation title.", example = "Hello")
    private String title;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
