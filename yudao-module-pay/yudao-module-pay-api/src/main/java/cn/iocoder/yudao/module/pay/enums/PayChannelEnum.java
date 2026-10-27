package cn.iocoder.yudao.module.pay.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 支付渠道的编码的枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayChannelEnum implements ArrayValuable<String> {

    WX_PUB("wx_pub", "WeChat JSAPI payment."), // 公众号网页
    WX_LITE("wx_lite", "WeChat mini-program pay"),
    WX_APP("wx_app", "WeChat App payment."),
    WX_NATIVE("wx_native", "WeChat Native payment."),
    WX_WAP("wx_wap", "WeChat WAP pay"), // H5 网页
    WX_BAR("wx_bar", "WeChat payment-code pay"),

    ALIPAY_PC("alipay_pc", "Alipay PC pay"),
    ALIPAY_WAP("alipay_wap", "Alipay WAP pay"),
    ALIPAY_APP("alipay_app", "Alipay app pay"),
    ALIPAY_QR("alipay_qr", "Alipay QR pay"),
    ALIPAY_BAR("alipay_bar", "Alipay barcode pay"),
    ALIPAY_LITE("alipay_lite", "Alipay mini-program pay"),

    MOCK("mock", "Mock pay"),

    WALLET("wallet", "Wallet payment.");

    public static final String[] ARRAYS = Arrays.stream(values()).map(PayChannelEnum::getCode).toArray(String[]::new);

    /**
     * 编码
     *
     * 参考 <a href="https://www.pingxx.com/api/支付渠道属性值.html">支付渠道属性值</a>
     */
    private final String code;
    /**
     * 名字
     */
    private final String name;

    @Override
    public String[] array() {
        return ARRAYS;
    }

    public static PayChannelEnum getByCode(String code) {
        return ArrayUtil.firstMatch(o -> o.getCode().equals(code), values());
    }

    public static boolean isAlipay(String channelCode) {
        return StrUtil.startWith(channelCode, "alipay_");
    }

    public static boolean isWeixin(String channelCode) {
        return StrUtil.startWith(channelCode, "wx_");
    }

}
