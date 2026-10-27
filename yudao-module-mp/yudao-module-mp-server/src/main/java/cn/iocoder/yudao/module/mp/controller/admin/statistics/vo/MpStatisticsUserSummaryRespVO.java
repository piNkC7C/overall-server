package cn.iocoder.yudao.module.mp.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Schema(description = "Admin - daily follower changedata response.")
@Data
public class MpStatisticsUserSummaryRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime refDate;

    @Schema(description = "Follower source.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer userSource;

    @Schema(description = "New followers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer newUser;

    @Schema(description = "Cancel follow follower quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer cancelUser;

}
