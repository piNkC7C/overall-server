package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Flash-sale slotupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillConfigUpdateReqVO extends SeckillConfigBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Code is required.")
    private Long id;

}
