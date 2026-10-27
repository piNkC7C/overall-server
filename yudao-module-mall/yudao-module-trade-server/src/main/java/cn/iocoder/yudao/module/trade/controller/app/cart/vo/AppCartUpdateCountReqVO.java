package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Update cart quantity request VO.")
@Data
public class AppCartUpdateCountReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    @Min(message = "Quantity must be greater than 0.", value = 1L)
    private Integer count;

}
