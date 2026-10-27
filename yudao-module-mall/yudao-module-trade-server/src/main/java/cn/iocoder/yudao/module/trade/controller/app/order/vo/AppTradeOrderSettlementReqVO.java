package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.trade.enums.delivery.DeliveryTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Trade order settlement request VO.")
@Data
@Valid
public class AppTradeOrderSettlementReqVO {

    @Schema(description = "Product item Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Product is required.")
    private List<Item> items;

    @Schema(description = "Coupon code.", example = "1024")
    private Long couponId;

    @Schema(description = "Is not used points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not used points is required.")
    private Boolean pointStatus;

    // ========== 配送相关相关字段 ==========
    @Schema(description = "Delivery Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = DeliveryTypeEnum.class, message = "Delivery Method is invalid.")
    private Integer deliveryType;

    @Schema(description = "Shipping-address ID.", example = "1")
    private Long addressId;

    @Schema(description = "Pickup Store code.", example = "1088")
    private Long pickUpStoreId;
    @Schema(description = "Recipient name", example = "Overall.") // 选择门店自提时，该字段为联系人名
    private String receiverName;
    @Schema(description = "Recipient mobile.", example = "15601691300") // 选择门店自提时，该字段为联系人手机
    @Mobile(message = "Recipient mobile format is invalid.")
    private String receiverMobile;

    // ========== 秒杀活动相关字段 ==========
    @Schema(description = "Flash sale campaign code.", example = "1024")
    private Long seckillActivityId;

    // ========== 拼团活动相关字段 ==========
    @Schema(description = "Group buy campaign code.", example = "1024")
    private Long combinationActivityId;

    @Schema(description = "Group-buy leader ID.", example = "2048")
    private Long combinationHeadId;

    // ========== 砍价活动相关字段 ==========
    @Schema(description = "Bargain record code.", example = "123")
    private Long bargainRecordId;

    // ========== 积分商城活动相关字段 ==========
    @Schema(description = "Points shop campaign code.", example = "123")
    private Long pointActivityId;

    @AssertTrue(message = "You can buy only one SKU of this campaign product at a time.")
    @JsonIgnore
    public boolean isValidActivityItems() {
        // 校验是否是活动订单
        if (ObjUtil.isAllEmpty(seckillActivityId, combinationActivityId, combinationHeadId, bargainRecordId)) {
            return true;
        }
        // 校验订单项是否超出
        return items.size() == 1;
    }

    @Data
    @Schema(description = "User App - product item.")
    @Valid
    public static class Item {

        @Schema(description = "Product SKU code.", example = "2048")
        @NotNull(message = "Product SKU code is required.")
        private Long skuId;

        @Schema(description = "Purchase quantity.", example = "1")
        @Min(value = 1, message = "Purchase quantity minimum is {value}.")
        private Integer count;

        @Schema(description = "Cart line ID.", example = "1024")
        private Long cartId;

        @AssertTrue(message = "Product is invalid.")
        @JsonIgnore
        public boolean isValid() {
            // 组合一：skuId + count 使用商品 SKU
            if (skuId != null && count != null) {
                return true;
            }
            // 组合二：cartId 使用购物车项
            return cartId != null;
        }

    }

}
