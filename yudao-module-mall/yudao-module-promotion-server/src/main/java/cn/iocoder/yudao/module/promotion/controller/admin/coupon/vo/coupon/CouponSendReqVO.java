package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Schema(description = "Coupon grant request VO.")
@Data
@ToString(callSuper = true)
public class CouponSendReqVO {

    @Schema(description = "Coupontemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Coupontemplate code is required.")
    private Long templateId;

    @Schema(description = "User ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "User ID list is required.")
    private Set<Long> userIds;

}
