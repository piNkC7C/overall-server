package cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "App - Flash-sale slot response.")
@Data
public class AppSeckillConfigRespVO {

    @Schema(description = "Flash-sale slot ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Start Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:00")
    private String startTime;
    @Schema(description = "End Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:59")
    private String endTime;

    @Schema(description = "Carousel image.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> sliderPicUrls;

}
