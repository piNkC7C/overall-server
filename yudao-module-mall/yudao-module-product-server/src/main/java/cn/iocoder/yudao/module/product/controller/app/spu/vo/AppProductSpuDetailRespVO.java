package cn.iocoder.yudao.module.product.controller.app.spu.vo;

import cn.iocoder.yudao.module.product.controller.app.property.vo.value.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User App - product SPU detail response.")
@Data
public class AppProductSpuDetailRespVO {

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    // ========== Basic Info =========

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Product bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I am a cheerful summary")
    private String introduction;

    @Schema(description = "Product details.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is productDescription.")
    private String description;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long categoryId;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED)
    private String picUrl;

    @Schema(description = "Product carousel images.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> sliderPicUrls;

    // ========== 营销相关字段 =========

    // ========== SKU 相关字段 =========

    @Schema(description = "SKU type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean specType;

    @Schema(description = "ProductPrice, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer price;

    @Schema(description = "Market Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer marketPrice;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Integer stock;

    /**
     * SKU 数组
     */
    private List<Sku> skus;

    // ========== 统计相关字段 =========

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer salesCount;

    @Schema(description = "User App - product SPU detail SKU info.")
    @Data
    public static class Sku {

        @Schema(description = "Product SKU code.", example = "1")
        private Long id;

        /**
         * 商品属性数组
         */
        private List<AppProductPropertyValueDetailRespVO> properties;

        @Schema(description = "Sales Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Integer price;

        @Schema(description = "Market Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Integer marketPrice;

        @Schema(description = "VIP Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "968") // 通过会员等级，计算出折扣后价格
        private Integer vipPrice;

        @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
        private String picUrl;

        @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer stock;

        @Schema(description = "Product weight.", example = "1") // Order characters ：kg kg
        private Double weight;

        @Schema(description = "Product volume.", example = "1024") // 单位：m^3 平米
        private Double volume;

    }

}
