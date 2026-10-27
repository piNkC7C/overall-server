package cn.iocoder.yudao.module.system.api.social.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 小程序订单上传购物详情
 *
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/shopping-order/normal-shopping-detail/uploadShoppingInfo.html">上传购物详情</a>
 * @author 芋道源码
 */
@Data
public class SocialWxaOrderUploadShippingInfoReqDTO {

    /**
     * 物流模式 - 实体物流配送采用快递公司进行实体物流配送形式
     */
    public static final Integer LOGISTICS_TYPE_EXPRESS = 1;
    /**
     * 物流模式 - 虚拟商品，虚拟商品，例如话费充值，点卡等，无实体配送形式
     */
    public static final Integer LOGISTICS_TYPE_VIRTUAL = 3;
    /**
     * 物流模式 - 用户自提
     */
    public static final Integer LOGISTICS_TYPE_PICK_UP = 4;

    /**
     * 支付者，支付者信息(openid)
     */
    @NotEmpty(message = "Payer OpenID cannot be empty.")
    private String openid;

    /**
     * 原支付交易对应的微信订单号
     */
    @NotEmpty(message = "Original WeChat payment order number cannot be empty.")
    private String transactionId;

    /**
     * 物流模式
     */
    @NotNull(message = "Fulfillment mode cannot be empty.")
    private Integer logisticsType;
    /**
     * 物流发货单号
     */
    private String logisticsNo;
    /**
     * 物流公司编号
     *
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/express/business/express_search.html#%E8%8E%B7%E5%8F%96%E8%BF%90%E5%8A%9Bid%E5%88%97%E8%A1%A8get-delivery-list">物流查询插件简介</a>
     */
    private String expressCompany;
    /**
     * 商品信息
     */
    @NotEmpty(message = "Product info is required.")
    private String itemDesc;
    /**
     * 收件人手机号
     */
    @NotEmpty(message = "Tophone number.")
    private String receiverContact;

}
