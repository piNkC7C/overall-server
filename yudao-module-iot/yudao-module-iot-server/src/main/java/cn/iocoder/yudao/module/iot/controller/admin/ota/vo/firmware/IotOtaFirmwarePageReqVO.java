package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT OTA firmware page request.")
@Data
public class IotOtaFirmwarePageReqVO extends PageParam {

    @Schema(description = "Firmware name.", example = "Smart-switch firmware")
    private String name;

    @Schema(description = "Product key.", example = "1024")
    private String productId;

    @Schema(description = "Create time.", example = "[2022-07-01 00:00:00, 2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
