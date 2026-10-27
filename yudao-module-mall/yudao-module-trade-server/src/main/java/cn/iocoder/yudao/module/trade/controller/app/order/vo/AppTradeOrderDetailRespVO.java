package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import cn.iocoder.yudao.module.trade.controller.app.order.vo.item.AppTradeOrderItemRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - order trade detail response.")
@Data
public class AppTradeOrderDetailRespVO {

    // ========== orderBasic Info ==========

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "Order type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer type;

    @Schema(description = "Order time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "User notes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    private String userRemark;

    @Schema(description = "Order status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Purchased quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer productCount;

    @Schema(description = "Ordercomplete time.")
    private LocalDateTime finishTime;

    @Schema(description = "Ordercancel time.")
    private LocalDateTime cancelTime;

    @Schema(description = "Is not review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean commentStatus;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "Is not already payment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean payStatus;

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

    @Schema(description = "Payment time.")
    private LocalDateTime payTime;

    @Schema(description = "Pay timeout.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime payExpireTime;

    @Schema(description = "Payment channel.", example = "wx_lite_pay")
    private String payChannelCode;
    @Schema(description = "Payment channel name.", example = "WeChat Mini Program Pay")
    private String payChannelName;

    @Schema(description = "Original product total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer totalPrice;

    @Schema(description = "Order discount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer discountPrice;

    @Schema(description = "Shipping amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer deliveryPrice;

    @Schema(description = "Order price adjustment (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer adjustPrice;

    @Schema(description = "Amount due (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer payPrice;

    // ========== 收件 + 物流基本信息 ==========

    @Schema(description = "Delivery Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer deliveryType;

    @Schema(description = "Shipping carrierID.", example = "10")
    private Long logisticsId;

    @Schema(description = "Shipping carrier name.", example = "SF Express")
    private String logisticsName;

    @Schema(description = "Shipping tracking number.", example = "1024")
    private String logisticsNo;

    @Schema(description = "Shipping time.")
    private LocalDateTime deliveryTime;

    @Schema(description = "Receiving time.")
    private LocalDateTime receiveTime;

    @Schema(description = "Recipient name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String receiverName;

    @Schema(description = "Recipient mobile.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13800138000")
    private String receiverMobile;

    @Schema(description = "Recipient region ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "110000")
    private Integer receiverAreaId;

    @Schema(description = "Recipient region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Putuo, Shanghai")
    private String receiverAreaName;

    @Schema(description = "Recipient street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1 Market Street")
    private String receiverDetailAddress;

    @Schema(description = "Pickup Store code.", example = "1088")
    private Long pickUpStoreId;

    @Schema(description = "Pickup Check-in Code.", example = "40964096")
    private String pickUpVerifyCode;

    // ========== after-sales Basic Info ==========

    @Schema(description = "After-sales status.", example = "0")
    private Integer refundStatus;

    @Schema(description = "Refund amount, order characters ：Min.", example = "100")
    private Integer refundPrice;

    // ========== 营销基本信息 ==========

    @Schema(description = "Coupon code.", example = "1024")
    private Long couponId;

    @Schema(description = "Coupon discount amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer couponPrice;

    @Schema(description = "Points redemption amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer pointPrice;

    @Schema(description = "VIP discount amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    private Integer vipPrice;

    @Schema(description = "Group buy record code.", example = "100")
    private Long combinationRecordId;

    /**
     * 订单项数组
     */
    private List<AppTradeOrderItemRespVO> items;

}
