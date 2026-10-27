package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Schema(description = "Admin - product SKU create or update request.")
@Data
public class ProductSkuSaveReqVO {

    @Schema(description = "Product SKU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    @NotEmpty(message = "Product SKU name is required.")
    private String name;

    @Schema(description = "Sales Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    @NotNull(message = "Sales Price, order characters ：Min is required.")
    @Min(value = 0, message = "Selling price, in cents cannot be less than 0.")
    private Integer price;

    @Schema(description = "Market Price", example = "2999")
    @Min(value = 0, message = "Market price cannot be less than 0.")
    private Integer marketPrice;

    @Schema(description = "Cost price.", example = "19")
    @Min(value = 0, message = "Cost price cannot be less than 0.")
    private Integer costPrice;

    @Schema(description = "Barcode.", example = "15156165456")
    private String barCode;

    @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotNull(message = "ImageAddress is required.")
    private String picUrl;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Inventory is required.")
    private Integer stock;

    @Schema(description = "Product weight, in kg.", example = "1.2")
    private Double weight;

    @Schema(description = "Product volume, in m³.", example = "2.5")
    private Double volume;

    @Schema(description = "Level-1 commission, in cents.", example = "199")
    @Min(value = 0, message = "Level-1 commission, in cents cannot be less than 0.")
    private Integer firstBrokeragePrice;

    @Schema(description = "Level-2 commission, in cents.", example = "19")
    @Min(value = 0, message = "Level-2 commission, in cents cannot be less than 0.")
    private Integer secondBrokeragePrice;

    @Schema(description = "Attribute Array.")
    private List<Property> properties;

    @Schema(description = "Product attribute.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Property {

        @Schema(description = "Attribute code.", example = "10")
        private Long propertyId;

        @Schema(description = "Attribute name.", example = "Color.")
        private String propertyName;

        @Schema(description = "PropertyValueID.", example = "10")
        private Long valueId;

        @Schema(description = "Attribute value name.", example = "Red")
        private String valueName;

    }

}
