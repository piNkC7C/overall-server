package cn.iocoder.yudao.module.mp.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "One-day API analytics response VO.")
@Data
public class MpStatisticsInterfaceSummaryRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime refDate;

    @Schema(description = "After receiving a message via the server URL, passive reply count to followers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer callbackCount;

    @Schema(description = "Failed action count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer failCount;

    @Schema(description = "Total time, divided by callback_count is the average time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Integer totalTimeCost;

    @Schema(description = "MaximumDuration.", requiredMode = Schema.RequiredMode.REQUIRED, example = "40")
    private Integer maxTimeCost;

}
