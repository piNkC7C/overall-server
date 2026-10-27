package cn.iocoder.yudao.module.pay.framework.pay.core.client.dto.order;

import cn.iocoder.yudao.module.pay.framework.pay.core.enums.PayOrderDisplayModeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 统一下单 Request DTO
 *
 * @author 芋道源码
 */
@Data
public class PayOrderUnifiedReqDTO {

    /**
     * 用户 IP
     */
    @NotEmpty(message = "User IP is required.")
    private String userIp;

    // ========== 商户相关字段 ==========

    /**
     * 外部订单号
     *
     * 对应 PayOrderExtensionDO 的 no 字段
     */
    @NotEmpty(message = "External order number cannot be empty.")
    private String outTradeNo;
    /**
     * 商品标题
     */
    @NotEmpty(message = "Product title is required.")
    @Length(max = 32, message = "Product title cannot exceed 32.")
    private String subject;
    /**
     * 商品描述信息
     */
    @Length(max = 128, message = "ProductDescription info length cannot exceed 128.")
    private String body;
    /**
     * 支付结果的 notify 回调地址
     */
    @NotEmpty(message = "Payment callback URL cannot be empty.")
    @URL(message = "Payment notify URL must be a valid URL.")
    private String notifyUrl;
    /**
     * 支付结果的 return 回调地址
     */
    @URL(message = "Payment return URL must be a valid URL.")
    private String returnUrl;

    // ========== 订单相关字段 ==========

    /**
     * 支付金额，单位：分
     */
    @NotNull(message = "Payment amount is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Payment amount must be greater than 0.")
    private Integer price;

    /**
     * 支付过期时间
     */
    @NotNull(message = "Payment Expires at is required.")
    private LocalDateTime expireTime;

    // ========== 拓展参数 ==========
    /**
     * 支付渠道的额外参数
     *
     * 例如说，微信公众号需要传递 openid 参数
     */
    private Map<String, String> channelExtras;

    /**
     * 展示模式
     *
     * 如果不传递，则每个支付渠道使用默认的方式
     *
     * 枚举 {@link PayOrderDisplayModeEnum}
     */
    private String displayMode;

}
