package cn.iocoder.yudao.module.im.controller.admin.manager.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "IM dashboard trend response VO.")
@Data
public class ImStatisticsManagerTrendRespVO {

    @Schema(description = "X-axis dates (00:00:00 each day). The client can take the date part.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<LocalDateTime> dates;

    @Schema(description = "Data series. Key is the series name (private/group or register/active). Value is a count array aligned with dates.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, List<Long>> series;

}
