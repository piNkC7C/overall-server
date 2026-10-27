package cn.iocoder.yudao.module.system.framework.sms.core.property;

import cn.iocoder.yudao.module.system.framework.sms.core.enums.SmsChannelEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 短信渠道配置类
 *
 * @author zzf
 * @since 2021/1/25 17:01
 */
@Data
@Validated
public class SmsChannelProperties {

    /**
     * 渠道编号
     */
    @NotNull(message = "SMS channel ID is required.")
    private Long id;
    /**
     * 短信签名
     */
    @NotEmpty(message = "SMS signature is required.")
    private String signature;
    /**
     * 渠道编码
     *
     * 枚举 {@link SmsChannelEnum}
     */
    @NotEmpty(message = "Channel code is required.")
    private String code;
    /**
     * 短信 API 的账号
     */
    @NotEmpty(message = "SMS API account is required.")
    private String apiKey;
    /**
     * 短信 API 的密钥
     */
    @NotEmpty(message = "SMS API secret is required.")
    private String apiSecret;
    /**
     * 短信发送回调 URL
     */
    private String callbackUrl;

}
