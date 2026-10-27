package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Add cart item request VO.")
@Data
public class AppCartAddReqVO {

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Create product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Product quantity must be at least 1.")
    private Integer count;

}
