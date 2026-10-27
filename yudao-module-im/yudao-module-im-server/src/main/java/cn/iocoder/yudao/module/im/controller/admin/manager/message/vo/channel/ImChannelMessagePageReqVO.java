package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.channel;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM Channelmessage page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImChannelMessagePageReqVO extends PageParam {

    @Schema(description = "Channel ID", example = "1")
    private Long channelId;

    @Schema(description = "Media code.", example = "1024")
    private Long materialId;

    @Schema(description = "Send time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

}
