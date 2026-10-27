package cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.coupon.CouponStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "User App - coupon page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCouponPageReqVO extends PageParam {

    @Schema(description = "Coupon status.", example = "1")
    @InEnum(value = CouponStatusEnum.class, message = "Coupon status, must be {value}.")
    private Integer status;

}
