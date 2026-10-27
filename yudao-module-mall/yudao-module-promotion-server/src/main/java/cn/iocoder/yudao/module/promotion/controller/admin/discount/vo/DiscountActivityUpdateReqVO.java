package cn.iocoder.yudao.module.promotion.controller.admin.discount.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Limited-time discount campaign update request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiscountActivityUpdateReqVO extends DiscountActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Campaign code is required.")
    private Long id;

    /**
     * 商品列表
     */
    @NotEmpty(message = "Product list is required.")
    @Valid
    private List<Product> products;

}
