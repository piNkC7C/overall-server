package cn.iocoder.yudao.module.oa.controller.admin.announcement.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.announcement.OaAnnouncementTypeEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA announcement page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaAnnouncementPageReqVO extends PageParam {

    @Schema(description = "Announcement title, fuzzy match.", example = "National Day holiday notice")
    private String title;

    @Schema(description = "Announcement type.", example = "1")
    @InEnum(value = OaAnnouncementTypeEnum.class, message = "Announcement type must be {value}.")
    private Integer type;

    @Schema(description = "Priority", example = "1")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "Is not Read.", example = "false")
    private Boolean readStatus;

    @Schema(description = "PublishedRange.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
