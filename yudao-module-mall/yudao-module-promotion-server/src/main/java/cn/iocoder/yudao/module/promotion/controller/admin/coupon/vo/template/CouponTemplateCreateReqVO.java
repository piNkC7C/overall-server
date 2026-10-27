package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - coupontemplatecreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponTemplateCreateReqVO extends CouponTemplateBaseVO {

}
