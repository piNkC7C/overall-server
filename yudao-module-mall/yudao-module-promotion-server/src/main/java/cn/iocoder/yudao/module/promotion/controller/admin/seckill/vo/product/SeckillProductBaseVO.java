package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 秒杀参与商品 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class SeckillProductBaseVO {

    @Schema(description = "Productsku_id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30563")
    @NotNull(message = "Productsku_id is required.")
    private Long skuId;

    @Schema(description = "Flash sale amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6689")
    @NotNull(message = "Flash sale amount, order characters ：Min is required.")
    private Integer seckillPrice;

    @Schema(description = "Flash sale inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Flash sale inventory is required.")
    private Integer stock;

}
