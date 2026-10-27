package cn.iocoder.yudao.module.promotion.controller.app.activity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "App - Campaign response.")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppActivityRespVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Campaign type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // Matching PromotionTypeEnum enum

    @Schema(description = "Campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer sale")
    private String name;

    @Schema(description = "Spu code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "618")
    private Long spuId;

    @Schema(description = "Campaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

}
