package cn.iocoder.yudao.module.system.enums.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 邮件的发送状态枚举
 *
 * @author wangjingyi
 * @since 2022/4/10 13:39
 */
@Getter
@AllArgsConstructor
public enum MailSendStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // Send succeeded
    FAILURE(20), // Send failed
    IGNORE(30), // 忽略，即不发送
    ;

    private final int status;

}
