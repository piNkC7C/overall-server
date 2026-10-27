package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.product.enums.spu.ProductSpuStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - product SPU Status update request.")
@Data
public class ProductSpuUpdateStatusReqVO{

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product code is required.")
    private Long id;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product status is required.")
    @InEnum(ProductSpuStatusEnum.class)
    private Integer status;

}
