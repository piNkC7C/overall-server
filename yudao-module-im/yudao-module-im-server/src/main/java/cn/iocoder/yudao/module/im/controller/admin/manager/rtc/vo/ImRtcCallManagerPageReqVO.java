package cn.iocoder.yudao.module.im.controller.admin.manager.rtc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - IM 通话记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImRtcCallManagerPageReqVO extends PageParam {

    @Schema(description = "发起人用户编号", example = "1024")
    private Long inviterUserId;

    @Schema(description = "会话类型", example = "1")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "媒体类型", example = "1")
    private Integer mediaType; // See ImRtcCallMediaTypeEnum enum class

    @Schema(description = "通话状态", example = "10")
    private Integer status; // See ImRtcCallStatusEnum enum class

    @Schema(description = "结束原因", example = "1")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "发起时间", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

}
