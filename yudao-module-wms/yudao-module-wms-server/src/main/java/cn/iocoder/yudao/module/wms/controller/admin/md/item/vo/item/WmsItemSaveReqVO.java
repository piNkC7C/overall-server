package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.item;

import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku.WmsItemSkuSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - WMS product create or update request.")
@Data
public class WmsItemSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM001")
    @NotBlank(message = "Product code is required.")
    @Size(max = 20, message = "Product code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei nova flip.")
    @NotBlank(message = "Product name is required.")
    @Size(max = 60, message = "Product name length cannot exceed 60 characters.")
    private String name;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product category is required.")
    private Long categoryId;

    @Schema(description = "Order characters.", example = "Unit")
    @Size(max = 20, message = "Order characters length cannot exceed 20 characters.")
    private String unit;

    @Schema(description = "Product brand code.", example = "1")
    private Long brandId;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "SKU list.")
    @Valid
    @NotEmpty(message = "Add at least one SKU.")
    private List<WmsItemSkuSaveReqVO> skus;

}
