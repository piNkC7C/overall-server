package cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "App - Discountcouponclaim request.")
@Data
public class AppCouponTakeReqVO {

    @Schema(description = "Coupontemplate code.", example = "1")
    @NotNull(message = "Coupontemplate code is required.")
    private Long templateId;

}
