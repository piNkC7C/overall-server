package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 交易订单 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class TradeOrderBaseVO {

    // ========== orderBasic Info ==========

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "Order time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Order type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Order source.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer terminal;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long userId;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

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

    @Schema(description = "Cancel type.", example = "10")
    private Integer cancelType;

    @Schema(description = "Merchant notes.", example = "Take a guess")
    private String remark;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

    @Schema(description = "Is not already payment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean payStatus;

    @Schema(description = "Payment time.")
    private LocalDateTime payTime;

    @Schema(description = "Payment channel.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx_lite")
    private String payChannelCode;

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

    @Schema(description = "Delivery Method", example = "10")
    private Integer deliveryType;

    @Schema(description = "Pickup Store", example = "10")
    private Long pickUpStoreId;

    @Schema(description = "Pickup Check-in Code.", example = "10")
    private Long pickUpVerifyCode;

    @Schema(description = "Delivery template ID.", example = "1024")
    private Long deliveryTemplateId;

    @Schema(description = "Shipping carrierID.", example = "1024")
    private Long logisticsId;

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

    @Schema(description = "Recipient street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1 Market Street")
    private String receiverDetailAddress;

    // ========== after-sales Basic Info ==========

    @Schema(description = "After-sales status.", example = "1")
    private Integer afterSaleStatus;

    @Schema(description = "Refund amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
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

    @Schema(description = "Referrer ID.", example = "1")
    private Long brokerageUserId;

}
