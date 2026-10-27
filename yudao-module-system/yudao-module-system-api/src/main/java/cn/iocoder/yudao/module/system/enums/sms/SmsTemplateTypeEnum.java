package cn.iocoder.yudao.module.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信的模板类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum SmsTemplateTypeEnum {

    VERIFICATION_CODE(1), // Verification code
    NOTICE(2), // Notification
    PROMOTION(3), // 营销
    ;

    /**
     * 类型
     */
    private final int type;

}
