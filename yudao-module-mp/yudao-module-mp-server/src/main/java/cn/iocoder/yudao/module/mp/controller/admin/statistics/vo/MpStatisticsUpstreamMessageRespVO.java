package cn.iocoder.yudao.module.mp.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - daily follower changedata response.")
@Data
public class MpStatisticsUpstreamMessageRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime refDate;

    @Schema(description = "Upstream sent (sent to the official account) follower count who sent messages.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer messageUser;

    @Schema(description = "Total upstream messages sent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer messageCount;

}
