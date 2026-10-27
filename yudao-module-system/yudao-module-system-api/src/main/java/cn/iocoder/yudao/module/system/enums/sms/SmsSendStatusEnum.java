package cn.iocoder.yudao.module.system.enums.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信的发送状态枚举
 *
 * @author zzf
 * @date 2021/2/1 13:39
 */
@Getter
@AllArgsConstructor
public enum SmsSendStatusEnum {

    INIT(0), // 初始化
    SUCCESS(10), // Send succeeded
    FAILURE(20), // Send failed
    IGNORE(30), // 忽略，即不发送
    ;

    private final int status;

}
