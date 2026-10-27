package cn.iocoder.yudao.module.iot.controller.admin.statistics.vo;

import cn.iocoder.yudao.framework.common.enums.DateIntervalEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT devicemessage quantityStats response.")
@Data
public class IotStatisticsDeviceMessageReqVO {

    @Schema(description = "Time gap type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = DateIntervalEnum.class, message = "Time gap type, must be {value}.")
    private Integer interval;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2, message = "Select time range.")
    private LocalDateTime[] times;

}
