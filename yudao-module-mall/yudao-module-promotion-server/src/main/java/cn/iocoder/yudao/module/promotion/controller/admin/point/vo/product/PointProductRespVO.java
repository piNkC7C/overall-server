package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;

@Schema(description = "Admin - points shop product response.")
@Data
@ExcelIgnoreUnannotated
public class PointProductRespVO {

    @Schema(description = "Points shop product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31718")
    private Long id;

    @Schema(description = "Points shop campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29388")
    private Long activityId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8112")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2736")
    private Long skuId;

    @Schema(description = "Redeemable quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3926")
    private Integer count;

    @Schema(description = "Redeem points.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer point;

    @Schema(description = "Redeem amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    private Integer price;

    @Schema(description = "Points shop productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer stock;

    @Schema(description = "Points shop product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer activityStatus;

}