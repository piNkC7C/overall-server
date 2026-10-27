package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.product.SeckillProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Schema(description = "Flash-sale campaign detail response VO.")
@Data
@ToString(callSuper = true)
public class SeckillActivityDetailRespVO extends SeckillActivityBaseVO{

    @Schema(description = "Flash sale campaignid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Flash sale product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<SeckillProductRespVO> products;

}
