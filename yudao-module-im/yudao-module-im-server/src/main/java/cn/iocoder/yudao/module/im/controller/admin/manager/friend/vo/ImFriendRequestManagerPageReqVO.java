package cn.iocoder.yudao.module.im.controller.admin.manager.friend.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM contact apply please page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImFriendRequestManagerPageReqVO extends PageParam {

    @Schema(description = "Initiatoruser ID.", example = "1024")
    private Long fromUserId;

    @Schema(description = "Recipient user ID.", example = "2048")
    private Long toUserId;

    @Schema(description = "Process result.", example = "0")
    private Integer handleResult; // See ImFriendRequestHandleResultEnum enum class

    @Schema(description = "Add source.", example = "1")
    private Integer addSource; // See ImFriendAddSourceEnum enum class

    @Schema(description = "Create time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
