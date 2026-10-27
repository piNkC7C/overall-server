package cn.iocoder.yudao.module.mp.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "One-day message send overview response VO.")
@Data
public class MpStatisticsUserCumulateRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime refDate;

    @Schema(description = "Total followers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer cumulateUser;

}
