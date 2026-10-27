package cn.iocoder.yudao.module.pay.framework.pay.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付 UI 展示模式
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayOrderDisplayModeEnum {

    URL("url"), // Redirect Link method
    IFRAME("iframe"), // IFrame 内嵌链接的方式【目前暂时用不到】
    FORM("form"), // HTML form submit QR_CODE(."qr_code"), // QR Code Text content
    QR_CODE_URL("qr_code_url"), // QR Code ImageLink
    BAR_CODE("bar_code"), // 条形码
    APP("app"), // 应用：Android、iOS、微信小程序、微信公众号等，需要做自定义处理的
    ;

    /**
     * 展示模式
     */
    private final String mode;

}
