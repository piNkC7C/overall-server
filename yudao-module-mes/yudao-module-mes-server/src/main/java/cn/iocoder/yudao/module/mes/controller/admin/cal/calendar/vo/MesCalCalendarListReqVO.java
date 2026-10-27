package cn.iocoder.yudao.module.mes.controller.admin.cal.calendar.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "MES schedule calendar search request VO.")
@Data
public class MesCalCalendarListReqVO {

    public static final String QUERY_TYPE_TYPE = "TYPE";
    public static final String QUERY_TYPE_TEAM = "TEAM";
    public static final String QUERY_TYPE_USER = "USER";

    @Schema(description = "Start Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start Date is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startDay;

    @Schema(description = "End Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End Date is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endDay;

    @Schema(description = "Query type. TYPE=by category, TEAM=by team, USER=by person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "TYPE")
    @NotEmpty(message = "Search type is required.")
    private String queryType;

    @Schema(description = "Team type (queryType=TYPE time used).", example = "1")
    private Integer calendarType;

    @Schema(description = "Team code (queryType=TEAM time used).", example = "201")
    private Long teamId;

    @Schema(description = "User ID (queryType=USER time used).", example = "1")
    private Long userId;

}
