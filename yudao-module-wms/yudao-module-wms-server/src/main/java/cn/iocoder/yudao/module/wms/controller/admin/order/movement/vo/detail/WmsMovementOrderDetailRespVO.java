package cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - WMS warehouse transfer order detail response.")
@Data
public class WmsMovementOrderDetailRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Warehouse transfer order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
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

    @Schema(description = "Source warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long sourceWarehouseId;

    @Schema(description = "Source warehouse name.", example = "Beijing warehouse")
    private String sourceWarehouseName;

    @Schema(description = "Target warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long targetWarehouseId;

    @Schema(description = "Target warehouse name.", example = "Shanghai warehouse")
    private String targetWarehouseName;

    @Schema(description = "Warehouse transfer quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Unit Price", example = "100.00")
    private BigDecimal price;

    @Schema(description = "Line amount.", example = "1000.00")
    private BigDecimal totalPrice;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
