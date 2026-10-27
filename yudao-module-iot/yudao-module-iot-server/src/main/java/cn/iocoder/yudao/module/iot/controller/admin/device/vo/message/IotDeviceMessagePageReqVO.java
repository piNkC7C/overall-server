package cn.iocoder.yudao.module.iot.controller.admin.device.vo.message;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.core.enums.IotDeviceMessageMethodEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT devicemessage page search request.")
@Data
public class IotDeviceMessagePageReqVO extends PageParam {

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

    @Schema(description = "Message type.", example = "property")
    @InEnum(IotDeviceMessageMethodEnum.class)
    private String method;

    @Schema(description = "Is not line.", example = "true")
    private Boolean upstream;

    @Schema(description = "Is not reply.", example = "true")
    private Boolean reply;

    @Schema(description = "Identifier.", example = "temperature")
    private String identifier;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2, message = "Select time range.")
    private LocalDateTime[] times;

}