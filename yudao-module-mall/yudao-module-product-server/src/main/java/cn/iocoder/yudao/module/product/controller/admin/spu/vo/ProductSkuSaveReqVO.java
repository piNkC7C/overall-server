package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Schema(description = "管理后台 - 商品 SKU 创建/更新 Request VO")
@Data
public class ProductSkuSaveReqVO {

    @Schema(description = "商品 SKU 名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    @NotEmpty(message = "Product SKU name is required.")
    private String name;

    @Schema(description = "销售价格，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    @NotNull(message = "Sales Price, order characters ：Min is required.")
    @Min(value = 0, message = "Selling price, in cents cannot be less than 0.")
    private Integer price;

    @Schema(description = "市场价", example = "2999")
    @Min(value = 0, message = "Market price cannot be less than 0.")
    private Integer marketPrice;

    @Schema(description = "成本价", example = "19")
    @Min(value = 0, message = "Cost price cannot be less than 0.")
    private Integer costPrice;

    @Schema(description = "条形码", example = "15156165456")
    private String barCode;

    @Schema(description = "图片地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotNull(message = "ImageAddress is required.")
    private String picUrl;

    @Schema(description = "库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Inventory is required.")
    private Integer stock;

    @Schema(description = "商品重量,单位：kg 千克", example = "1.2")
    private Double weight;

    @Schema(description = "商品体积,单位：m^3 平米", example = "2.5")
    private Double volume;

    @Schema(description = "一级分销的佣金，单位：分", example = "199")
    @Min(value = 0, message = "Level-1 commission, in cents cannot be less than 0.")
    private Integer firstBrokeragePrice;

    @Schema(description = "二级分销的佣金，单位：分", example = "19")
    @Min(value = 0, message = "Level-2 commission, in cents cannot be less than 0.")
    private Integer secondBrokeragePrice;

    @Schema(description = "属性数组")
    private List<Property> properties;

    @Schema(description = "商品属性")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Property {

        @Schema(description = "属性编号", example = "10")
        private Long propertyId;

        @Schema(description = "属性名字", example = "Color.")
        private String propertyName;

        @Schema(description = "属性值编号", example = "10")
        private Long valueId;

        @Schema(description = "属性值名字", example = "Red")
        private String valueName;

    }

}
