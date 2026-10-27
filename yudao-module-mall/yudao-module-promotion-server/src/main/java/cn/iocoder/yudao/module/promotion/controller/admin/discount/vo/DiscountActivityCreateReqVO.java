package cn.iocoder.yudao.module.promotion.controller.admin.discount.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Limited-time discount campaign create request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiscountActivityCreateReqVO extends DiscountActivityBaseVO {

    /**
     * 商品列表
     */
    @NotEmpty(message = "Product list is required.")
    @Valid
    private List<Product> products;

}
