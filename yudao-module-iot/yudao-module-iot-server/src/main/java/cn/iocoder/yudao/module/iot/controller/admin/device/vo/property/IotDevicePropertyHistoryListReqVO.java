package cn.iocoder.yudao.module.iot.controller.admin.device.vo.property;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT device attribute history list request.")
@Data
public class IotDevicePropertyHistoryListReqVO {

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "177")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

    @Schema(description = "Attribute identifier.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Attribute identifier is required.")
    private String identifier;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2, message = "Select time range.")
    private LocalDateTime[] times;

}