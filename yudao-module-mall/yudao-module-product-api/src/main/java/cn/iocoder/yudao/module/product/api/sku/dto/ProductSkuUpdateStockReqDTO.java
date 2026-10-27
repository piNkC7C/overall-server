package cn.iocoder.yudao.module.product.api.sku.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "RPC service - product SKU updateinventory Request DTO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuUpdateStockReqDTO {

    @Schema(description = "Product SKU Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Product SKU is required.")
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Product SKU code is required.")
        private Long id;

        @Schema(description = "Stock change quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @NotNull(message = "Stock change quantity cannot be empty.")
        private Integer incrCount; // 正数：增加库存；负数：扣减库存

    }

}
