package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.material;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM Channelmedia page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImChannelMaterialPageReqVO extends PageParam {

    @Schema(description = "Channel ID", example = "1")
    private Long channelId;

    @Schema(description = "Content type.", example = "1")
    private Integer type; // See ImChannelMaterialTypeEnum enum class

    @Schema(description = "Title.", example = "Campaign.")
    private String title;

    @Schema(description = "Create time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
