package cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmSchedulePriorityEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 我的日程分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class BpmSchedulePageReqVO extends PageParam {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "日程类型", example = "1")
    @InEnum(value = BpmScheduleTypeEnum.class, message = "Calendar type must be {value}.")
    private Integer type;

    @Schema(description = "优先级", example = "1")
    @InEnum(value = BpmSchedulePriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "开始时间范围")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "日历显示时间范围，查询与该范围相交的日程")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2)
    private LocalDateTime[] overlapTime;

}
