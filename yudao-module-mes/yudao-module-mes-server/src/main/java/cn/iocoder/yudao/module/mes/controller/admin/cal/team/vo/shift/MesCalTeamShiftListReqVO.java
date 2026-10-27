package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.shift;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES team schedule list request.")
@Data
public class MesCalTeamShiftListReqVO {

    @Schema(description = "Team code.", example = "201")
    private Long teamId;

    @Schema(description = "Team IDs.")
    private Collection<Long> teamIds;

    @Schema(description = "Schedule plan code.", example = "1")
    private Long planId;

    @Schema(description = "Start Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startDay;

    @Schema(description = "End Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endDay;

}
