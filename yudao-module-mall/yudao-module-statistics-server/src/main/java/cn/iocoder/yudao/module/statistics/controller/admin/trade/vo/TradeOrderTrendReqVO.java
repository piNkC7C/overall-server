package cn.iocoder.yudao.module.statistics.controller.admin.trade.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.statistics.enums.TimeRangeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Trade order-volume trend request VO.")
@Data
public class TradeOrderTrendReqVO {

    @Schema(description = "DateRange type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "DateRange type is required.")
    @InEnum(value = TimeRangeTypeEnum.class, message = "DateRange type, must be {value}.")
    private Integer type;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Start time.")
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Due time.")
    private LocalDateTime endTime;

}
