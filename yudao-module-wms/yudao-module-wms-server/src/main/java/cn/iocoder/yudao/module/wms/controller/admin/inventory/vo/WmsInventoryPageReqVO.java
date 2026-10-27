package cn.iocoder.yudao.module.wms.controller.admin.inventory.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Schema(description = "Admin - WMS inventoryStats page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsInventoryPageReqVO extends PageParam {

    /**
     * 按仓库维度统计
     */
    public static final String TYPE_WAREHOUSE = "warehouse";

    /**
     * 按商品维度统计
     */
    public static final String TYPE_ITEM = "item";

    @Schema(description = "StatsDimension.", requiredMode = Schema.RequiredMode.REQUIRED, example = "warehouse")
    @NotBlank(message = "StatsDimension is required.")
    private String type;

    @Schema(description = "Product code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Product name.", example = "Fuji apple")
    private String itemName;

    @Schema(description = "Product SKU code.", example = "1024")
    private Long skuId;

    @Schema(description = "SKU code.", example = "SKU001")
    private String skuCode;

    @Schema(description = "SKU name.", example = "10kg case")
    private String skuName;

    @Schema(description = "Warehouse code.", example = "2048")
    private Long warehouseId;

    @Schema(description = "MinimumStock quantity.", example = "0.01")
    private BigDecimal minQuantity;

    @Schema(description = "Positive stock only.", example = "true")
    private Boolean onlyPositiveQuantity;

}
