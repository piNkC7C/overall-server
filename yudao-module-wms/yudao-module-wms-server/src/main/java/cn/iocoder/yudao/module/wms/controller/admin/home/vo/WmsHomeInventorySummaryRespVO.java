package cn.iocoder.yudao.module.wms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "WMS home Inventory summary stats response VO.")
@Data
public class WmsHomeInventorySummaryRespVO {

    @Schema(description = "Total stock quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000.00")
    private BigDecimal totalQuantity;

    @Schema(description = "Product stock share list.")
    private List<ItemRank> goodsShareList;

    @Schema(description = "Warehouse stock distribution.")
    private List<WarehouseRank> warehouseDistributionList;

    @Schema(description = "WMS home product Inventory ranking response VO.")
    @Data
    public static class ItemRank {

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A4 copy paper")
        private String name;

        @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal quantity;

    }

    @Schema(description = "WMS home WarehouseInventory ranking response VO.")
    @Data
    public static class WarehouseRank {

        @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Shanghai warehouse")
        private String name;

        @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal quantity;

    }

}
