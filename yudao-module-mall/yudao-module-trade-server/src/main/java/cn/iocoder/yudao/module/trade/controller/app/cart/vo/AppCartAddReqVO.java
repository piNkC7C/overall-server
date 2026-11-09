package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "用户 App - 购物车添加购物项 Request VO")
@Data
public class AppCartAddReqVO {

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "新增商品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Product quantity must be at least 1.")
    private Integer count;

}
