package cn.iocoder.yudao.module.im.controller.admin.manager.rtc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM call record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImRtcCallManagerPageReqVO extends PageParam {

    @Schema(description = "Start person user ID.", example = "1024")
    private Long inviterUserId;

    @Schema(description = "Conversation type.", example = "1")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "Media Type", example = "1")
    private Integer mediaType; // See ImRtcCallMediaTypeEnum enum class

    @Schema(description = "Call status.", example = "10")
    private Integer status; // See ImRtcCallStatusEnum enum class

    @Schema(description = "End reason.", example = "1")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "Start time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

}
