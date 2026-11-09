package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 积分商城商品新增/修改 Request VO")
@Data
public class PointProductSaveReqVO {

    @Schema(description = "积分商城商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31718")
    private Long id;

    @Schema(description = "积分商城活动 id", requiredMode = Schema.RequiredMode.REQUIRED, example = "29388")
    @NotNull(message = "Points shop campaign id is required.")
    private Long activityId;

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8112")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2736")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "可兑换数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "3926")
    @NotNull(message = "Redeemable quantity cannot be empty.")
    private Integer count;

    @Schema(description = "兑换积分", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Redeem points cannot be empty.")
    private Integer point;

    @Schema(description = "兑换金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    @NotNull(message = "Redeem amount, in cents cannot be empty.")
    private Integer price;

    @Schema(description = "积分商城商品库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Points shop product is required.")
    private Integer stock;

    @Schema(description = "积分商城商品状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Points shop product status is required.")
    private Integer activityStatus;

}