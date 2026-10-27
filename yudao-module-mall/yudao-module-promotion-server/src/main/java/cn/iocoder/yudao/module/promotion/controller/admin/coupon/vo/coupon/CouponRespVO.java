package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - coupon response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponRespVO extends CouponBaseVO {

    @Schema(description = "Coupon code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
