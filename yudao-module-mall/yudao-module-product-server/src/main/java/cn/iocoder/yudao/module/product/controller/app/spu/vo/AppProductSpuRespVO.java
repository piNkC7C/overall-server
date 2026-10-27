package cn.iocoder.yudao.module.product.controller.app.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User App - product SPU response.")
@Data
public class AppProductSpuRespVO {

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Product bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt intro")
    private String introduction;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long categoryId;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED)
    private String picUrl;

    @Schema(description = "Product carousel images.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> sliderPicUrls;

    // ========== SKU 相关字段 =========

    @Schema(description = "SKU type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean specType;

    @Schema(description = "ProductPrice, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer price;

    @Schema(description = "Market Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer marketPrice;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Integer stock;

    // ========== 营销相关字段 =========

    // ========== 统计相关字段 =========

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer salesCount;

    // ========== 物流相关字段 =========

    @Schema(description = "Delivery MethodArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Integer> deliveryTypes;

}
