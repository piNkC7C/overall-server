package cn.iocoder.yudao.module.oa.controller.admin.schedule.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaScheduleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA Calendar page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaSchedulePageReqVO extends PageParam {

    @Schema(description = "Is not include Me Calendar.", example = "true")
    private Boolean includeMine;

    @Schema(description = "Is not include Share WithMe Calendar.", example = "true")
    private Boolean includeReceived;

    @Schema(description = "Title.", example = "Week will.")
    private String title;

    @Schema(description = "Calendar type.", example = "1")
    @InEnum(value = OaScheduleTypeEnum.class, message = "Calendar type must be {value}.")
    private Integer type;

    @Schema(description = "Priority", example = "1")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "Start time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "Calendar range. Returns events that overlap it.", example = "[\"2026-09-01 00:00:00\", \"2026-09-30 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2)
    private LocalDateTime[] overlapTime;

}
