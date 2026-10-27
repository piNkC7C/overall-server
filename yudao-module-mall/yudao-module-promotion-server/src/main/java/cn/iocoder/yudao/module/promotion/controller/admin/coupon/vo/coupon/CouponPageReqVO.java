package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.coupon.CouponStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - coupon page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponPageReqVO extends PageParam {

    @Schema(description = "Coupontemplate code.", example = "2048")
    private Long templateId;

    @Schema(description = "Promo code status.", example = "1")
    @InEnum(value = CouponStatusEnum.class, message = "Coupon status, must be {value}.")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Nickname", example = "Overall.")
    private String nickname;

    @Schema(description = "User ID.", example = "1")
    private Collection<Long> userIds;

}
