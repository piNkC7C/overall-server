package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - points shop product create / edit request.")
@Data
public class PointProductSaveReqVO {

    @Schema(description = "Points shop product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31718")
    private Long id;

    @Schema(description = "Points shop campaign id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29388")
    @NotNull(message = "Points shop campaign id is required.")
    private Long activityId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8112")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2736")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Redeemable quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3926")
    @NotNull(message = "Redeemable quantity cannot be empty.")
    private Integer count;

    @Schema(description = "Redeem points.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Redeem points cannot be empty.")
    private Integer point;

    @Schema(description = "Redeem amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    @NotNull(message = "Redeem amount, in cents cannot be empty.")
    private Integer price;

    @Schema(description = "Points shop productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Points shop product is required.")
    private Integer stock;

    @Schema(description = "Points shop product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Points shop product status is required.")
    private Integer activityStatus;

}