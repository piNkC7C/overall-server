package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Flash-sale slot setting simple info response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeckillConfigSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Flash-sale slot name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Morning session")
    @NotNull(message = "Flash-sale slot name cannot be empty.")
    private String name;

    @Schema(description = "Start Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:00:00")
    private String startTime;

    @Schema(description = "End Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16:00:00")
    private String endTime;

}
