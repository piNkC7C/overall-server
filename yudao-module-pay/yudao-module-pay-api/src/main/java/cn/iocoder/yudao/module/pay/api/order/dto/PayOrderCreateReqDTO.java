package cn.iocoder.yudao.module.pay.api.order.dto;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 支付单创建 Request DTO
 */
@Data
public class PayOrderCreateReqDTO implements Serializable {

    public static final int SUBJECT_MAX_LENGTH = 32;

    /**
     * 应用标识
     */
    @NotNull(message = "App key is required.")
    private String appKey;

    /**
     * 用户 IP
     */
    @NotEmpty(message = "User IP is required.")
    private String userIp;

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    @InEnum(UserTypeEnum.class)
    private Integer userType;

    // ========== 商户相关字段 ==========

    /**
     * 商户订单编号
     */
    @NotEmpty(message = "Merchant order number cannot be empty.")
    private String merchantOrderId;
    /**
     * 商品标题
     */
    @NotEmpty(message = "Product title is required.")
    @Length(max = SUBJECT_MAX_LENGTH, message = "Product title cannot exceed 32.")
    private String subject;
    /**
     * 商品描述
     */
    @Length(max = 128, message = "ProductDescription info length cannot exceed 128.")
    private String body;

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

}
