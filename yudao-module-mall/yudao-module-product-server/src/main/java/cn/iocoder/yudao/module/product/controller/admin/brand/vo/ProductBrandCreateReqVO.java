package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - product brandcreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductBrandCreateReqVO extends ProductBrandBaseVO {

}
