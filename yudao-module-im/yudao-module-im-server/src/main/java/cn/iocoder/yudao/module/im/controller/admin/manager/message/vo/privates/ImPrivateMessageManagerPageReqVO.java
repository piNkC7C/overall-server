package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.privates;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM direct messagepage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImPrivateMessageManagerPageReqVO extends PageParam {

    @Schema(description = "Send person code.", example = "1024")
    private Long senderId;

    @Schema(description = "Recipient code.", example = "2048")
    private Long receiverId;

    @Schema(description = "Message type.", example = "1")
    private Integer type; // See ImContentTypeEnum enum class

    @Schema(description = "Message content.", example = "Hello")
    private String content;

    @Schema(description = "Message status.", example = "0")
    private Integer status; // See ImMessageStatusEnum enum class

    @Schema(description = "Send time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

}
