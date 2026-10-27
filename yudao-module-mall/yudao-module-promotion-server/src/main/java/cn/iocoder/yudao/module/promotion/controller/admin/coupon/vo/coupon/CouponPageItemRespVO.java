package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Coupon page item response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponPageItemRespVO extends CouponRespVO {

    @Schema(description = "Nickname", example = "John")
    private String nickname;

}
