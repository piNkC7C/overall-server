package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "管理后台 - 秒杀时段配置精简信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeckillConfigSimpleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "秒杀时段名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Morning session")
    @NotNull(message = "Flash-sale slot name cannot be empty.")
    private String name;

    @Schema(description = "开始时间点", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:00:00")
    private String startTime;

    @Schema(description = "结束时间点", requiredMode = Schema.RequiredMode.REQUIRED, example = "16:00:00")
    private String endTime;

}
