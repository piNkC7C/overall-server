package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - product brandupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductBrandUpdateReqVO extends ProductBrandBaseVO {

    @Schema(description = "Brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Brand code is required.")
    private Long id;

}
