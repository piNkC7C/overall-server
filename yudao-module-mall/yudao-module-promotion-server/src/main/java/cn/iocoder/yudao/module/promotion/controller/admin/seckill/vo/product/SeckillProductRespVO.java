package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Flash-sale product response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillProductRespVO extends SeckillProductBaseVO {

    @Schema(description = "Flash-sale product ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "256")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
