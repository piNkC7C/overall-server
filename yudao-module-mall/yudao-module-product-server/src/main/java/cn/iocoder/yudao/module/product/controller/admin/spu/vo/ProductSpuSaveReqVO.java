package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - product SPU create /update request.")
@Data
public class ProductSpuSaveReqVO {

    @Schema(description = "Product code.", example = "1")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    @NotEmpty(message = "Product name is required.")
    private String name;

    @Schema(description = "Keyword.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool, smooth, and sweat-free")
    @NotEmpty(message = "Product keywords cannot be empty.")
    private String keyword;

    @Schema(description = "Product bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt intro")
    @NotEmpty(message = "Product bio is required.")
    private String introduction;

    @Schema(description = "Product details.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool tee details")
    @NotEmpty(message = "Product details is required.")
    private String description;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product category is required.")
    private Long categoryId;

    @Schema(description = "Product brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product brand is required.")
    private Long brandId;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotEmpty(message = "Product cover image is required.")
    private String picUrl;

    @Schema(description = "Product carousel images.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png]")
    private List<String> sliderPicUrls;

    @Schema(description = "Sort field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product sort field is required.")
    private Integer sort;

    // ========== SKU 相关字段 =========

    @Schema(description = "SKU type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "SKU type is required.")
    private Boolean specType;

    // ========== 物流相关字段 =========

    @Schema(description = "Delivery MethodArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Delivery Method is required.")
    private List<Integer> deliveryTypes;

    @Schema(description = "Shipping template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    private Long deliveryTemplateId;

    // ========== 营销相关字段 =========

    @Schema(description = "Bonus points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @NotNull(message = "Product bonus points cannot be empty.")
    private Integer giveIntegral;

    @Schema(description = "Distribution type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Product distribution type cannot be empty.")
    private Boolean subCommissionType;

    // ========== 统计相关字段 =========

    @Schema(description = "Virtual sales.", example = "66")
    private Integer virtualSalesCount;

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    private Integer salesCount;

    @Schema(description = "Views.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    private Integer browseCount;

    // ========== SKU 相关字段 =========

    @Schema(description = "SKU Array.")
    @Valid
    private List<ProductSkuSaveReqVO> skus;

}
