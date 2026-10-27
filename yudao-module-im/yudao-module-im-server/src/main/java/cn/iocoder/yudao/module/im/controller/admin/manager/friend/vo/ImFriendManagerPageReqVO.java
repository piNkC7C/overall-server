package cn.iocoder.yudao.module.im.controller.admin.manager.friend.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM contactRelationship page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImFriendManagerPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "1024")
    private Long userId;

    @Schema(description = "Contact user ID.", example = "2048")
    private Long friendUserId;

    @Schema(description = "Contact status.", example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Is not Do Not Disturb.", example = "false")
    private Boolean silent;

    @Schema(description = "Add contact time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] addTime;

}
