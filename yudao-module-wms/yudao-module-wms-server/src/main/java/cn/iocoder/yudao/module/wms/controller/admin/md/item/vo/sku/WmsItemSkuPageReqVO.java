package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - WMS product SKU page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsItemSkuPageReqVO extends PageParam {

    @Schema(description = "Product code.", example = "I00000001")
    private String itemCode;

    @Schema(description = "Product name.", example = "Huawei nova flip.")
    private String itemName;

    @Schema(description = "Product category code.", example = "1")
    private Long categoryId;

    @Schema(description = "Product brand code.", example = "1")
    private Long brandId;

    @Schema(description = "SKU code.", example = "S00000001")
    private String code;

    @Schema(description = "SKU name.", example = "Black")
    private String name;

    @Schema(description = "Barcode.", example = "12345678")
    private String barCode;

}
