package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - Flash-sale slot response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillConfigRespVO extends SeckillConfigBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Flash sale campaign quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer seckillActivityCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
