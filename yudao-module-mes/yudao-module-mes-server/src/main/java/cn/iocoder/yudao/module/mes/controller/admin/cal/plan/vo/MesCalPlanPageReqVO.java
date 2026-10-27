package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES schedule plan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesCalPlanPageReqVO extends PageParam {

    @Schema(description = "Plan code.", example = "PLAN001")
    private String code;

    @Schema(description = "Plan name.", example = "2024Year schedule.")
    private String name;

    @Schema(description = "Rotation method.", example = "1")
    private Integer shiftType;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Team type.", example = "1")
    private Integer calendarType;

    @Schema(description = "Start Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startDate;

    @Schema(description = "End Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endDate;

}
