package cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - WMS inventory count order detail response.")
@Data
public class WmsCheckOrderDetailRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inventory count order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderId;

    @Schema(description = "Product code.", example = "2048")
    private Long itemId;

    @Schema(description = "Product code.", example = "SPU-APPLE")
    private String itemCode;

    @Schema(description = "Product name.", example = "Fuji apple")
    private String itemName;

    @Schema(description = "Product order characters.", example = "Box")
    private String unit;

    @Schema(description = "SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long skuId;

    @Schema(description = "SKU code.", example = "SKU-APPLE-10KG")
    private String skuCode;

    @Schema(description = "SKU name.", example = "10kg case")
    private String skuName;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Beijing warehouse")
    private String warehouseName;

    @Schema(description = "Inventory code.", example = "1024")
    private Long inventoryId;

    @Schema(description = "Inbound time.")
    private LocalDateTime receiptTime;

    @Schema(description = "Book quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Counted quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "98.00")
    private BigDecimal checkQuantity;

    @Schema(description = "Unit Price", example = "1000.00")
    private BigDecimal price;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
