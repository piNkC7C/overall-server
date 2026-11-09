package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "用户 App - 购物车重置 Request VO")
@Data
public class AppCartResetReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "商品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    @Min(message = "Quantity must be greater than 0.", value = 1L)
    private Integer count;

}
