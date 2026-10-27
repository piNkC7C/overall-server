package cn.iocoder.yudao.module.wms.controller.admin.inventory.vo.history;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "WMS inventory ledger response VO.")
@Data
public class WmsInventoryHistoryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long itemId;
    @Schema(description = "Product code.", example = "ITEM001")
    private String itemCode;
    @Schema(description = "Product name.", example = "Fuji apple")
    private String itemName;
    @Schema(description = "Product order characters.", example = "Box")
    private String unit;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private Long skuId;
    @Schema(description = "SKU code.", example = "SKU001")
    private String skuCode;
    @Schema(description = "SKU name.", example = "10kg case")
    private String skuName;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8192")
    private Long warehouseId;
    @Schema(description = "Warehouse name.", example = "Finished-goods warehouse")
    private String warehouseName;

    @Schema(description = "Stock change quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.00")
    private BigDecimal quantity;
    @Schema(description = "Stock before change.", example = "90.00")
    private BigDecimal beforeQuantity;
    @Schema(description = "Stock after change.", example = "100.00")
    private BigDecimal afterQuantity;
    @Schema(description = "Unit Price", example = "1000.00")
    private BigDecimal price;
    @Schema(description = "Stock change amount.", example = "10000.00")
    private BigDecimal totalPrice;
    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Document code.", example = "1024")
    private Long orderId;
    @Schema(description = "Document no.", example = "RK202605110001")
    private String orderNo;
    @Schema(description = "Document type.", example = "1")
    private Integer orderType;
    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
