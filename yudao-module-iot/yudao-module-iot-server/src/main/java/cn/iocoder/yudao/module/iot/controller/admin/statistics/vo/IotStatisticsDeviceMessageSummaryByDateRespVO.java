package cn.iocoder.yudao.module.iot.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT devicemessage quantityStats response.")
@Data
public class IotStatisticsDeviceMessageSummaryByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Line message quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer upstreamCount;

    @Schema(description = "Line message quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer downstreamCount;

}
