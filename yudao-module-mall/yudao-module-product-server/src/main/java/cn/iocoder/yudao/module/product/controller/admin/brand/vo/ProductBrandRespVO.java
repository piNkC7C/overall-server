package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - brand response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductBrandRespVO extends ProductBrandBaseVO {

    @Schema(description = "Brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
