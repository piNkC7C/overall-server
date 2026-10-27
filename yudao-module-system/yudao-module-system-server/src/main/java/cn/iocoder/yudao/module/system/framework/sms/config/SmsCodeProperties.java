package cn.iocoder.yudao.module.system.framework.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;

@ConfigurationProperties(prefix = "yudao.sms-code")
@Validated
@Data
public class SmsCodeProperties {

    /**
     * 过期时间
     */
    @NotNull(message = "Expires at is required.")
    private Duration expireTimes;
    /**
     * 短信发送频率
     */
    @NotNull(message = "SMS send frequency cannot be empty.")
    private Duration sendFrequency;
    /**
     * 每日发送最大数量
     */
    @NotNull(message = "Daily send limit cannot be empty.")
    private Integer sendMaximumQuantityPerDay;
    /**
     * 验证码最小值
     */
    @NotNull(message = "Verification codeMin is required.")
    private Integer beginCode;
    /**
     * 验证码最大值
     */
    @NotNull(message = "Verification codeMax is required.")
    private Integer endCode;

}
