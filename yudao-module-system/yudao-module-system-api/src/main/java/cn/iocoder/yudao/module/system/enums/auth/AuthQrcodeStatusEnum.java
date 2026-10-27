package cn.iocoder.yudao.module.system.enums.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 扫码登录状态
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum AuthQrcodeStatusEnum {

    WAITING(0), // Waiting for Mobile confirm
    CONFIRMED(1); // 手机已确认，等待电脑领取

    private final int status;

}
