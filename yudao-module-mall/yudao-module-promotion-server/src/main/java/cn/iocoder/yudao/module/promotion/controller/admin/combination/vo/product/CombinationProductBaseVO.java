package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 拼团商品 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class CombinationProductBaseVO {

    @Schema(description = "Product spuId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30563")
    @NotNull(message = "Product spuId is required.")
    private Long spuId;

    @Schema(description = "Product skuId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30563")
    @NotNull(message = "Product skuId is required.")
    private Long skuId;

    @Schema(description = "Group buy Price, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27682")
    @NotNull(message = "Group buy Price is required.")
    private Integer combinationPrice;

}
