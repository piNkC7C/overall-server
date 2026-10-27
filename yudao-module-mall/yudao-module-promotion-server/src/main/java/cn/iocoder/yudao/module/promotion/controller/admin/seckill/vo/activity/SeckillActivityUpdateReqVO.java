package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.product.SeckillProductBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - flash sale campaignupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillActivityUpdateReqVO extends SeckillActivityBaseVO {

    @Schema(description = "Flash sale campaignid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Flash sale product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<SeckillProductBaseVO> products;

}
