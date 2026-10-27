package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM group chat page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImGroupManagerPageReqVO extends PageParam {

    @Schema(description = "Group name, fuzzy match.", example = "Tech group")
    private String name;

    @Schema(description = "Group Owner user ID.", example = "1024")
    private Long ownerUserId;

    @Schema(description = "Group status.", example = "0")
    private Integer status; // 参见 CommonStatusEnum 枚举类（0 正常 / 1 已解散）

    @Schema(description = "Banned.", example = "false")
    private Boolean banned;

    @Schema(description = "Create time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
