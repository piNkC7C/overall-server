package cn.iocoder.yudao.module.oa.controller.admin.schedule.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaScheduleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - OA 日程列表（按时间窗，不分页）Request VO")
@Data
public class OaScheduleListReqVO {

    @Schema(description = "兼容旧参数，已忽略（日程仅本人）", example = "true", deprecated = true)
    private Boolean includeMine;

    @Schema(description = "兼容旧参数，已忽略（日程无共享）", example = "true", deprecated = true)
    private Boolean includeReceived;

    @Schema(description = "标题", example = "Week will.")
    private String title;

    @Schema(description = "日程类型", example = "1")
    @InEnum(value = OaScheduleTypeEnum.class, message = "Calendar type must be {value}.")
    private Integer type;

    @Schema(description = "优先级", example = "1")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "日历显示时间范围，查询与该范围相交的日程", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[\"2026-11-19 00:00:00\", \"2026-11-19 23:59:59\"]")
    @NotNull(message = "Calendar time range is required.")
    @Size(min = 2, max = 2, message = "Calendar time range must contain begin and end.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] overlapTime;

}
