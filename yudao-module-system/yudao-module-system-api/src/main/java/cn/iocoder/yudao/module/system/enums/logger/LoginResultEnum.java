package cn.iocoder.yudao.module.system.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录结果的枚举类
 */
@Getter
@AllArgsConstructor
public enum LoginResultEnum {

    SUCCESS(0), // Succeeded
    BAD_CREDENTIALS(10), // Account or password is invalid
    USER_DISABLED(20), // User by Disabled
    CAPTCHA_NOT_FOUND(30), // ImageVerification code was not found
    CAPTCHA_CODE_ERROR(31), // ImageVerification code is invalid

    ;

    /**
     * 结果
     */
    private final Integer result;

}
