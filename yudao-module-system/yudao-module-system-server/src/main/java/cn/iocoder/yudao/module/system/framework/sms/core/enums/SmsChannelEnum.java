package cn.iocoder.yudao.module.system.framework.sms.core.enums;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信渠道枚举
 *
 * @author zzf
 * @since 2021/1/25 10:56
 */
@Getter
@AllArgsConstructor
public enum SmsChannelEnum {

    DEBUG_DING_TALK("DEBUG_DING_TALK", "Debug (DingTalk)"),
    ALIYUN("ALIYUN", "Alibaba Cloud"),
    TENCENT("TENCENT", "Tencent Cloud"),
    HUAWEI("HUAWEI", "Huawei Cloud"),
    QINIU("QINIU", "Qiniu Cloud"),
    ;

    /**
     * 编码
     */
    private final String code;
    /**
     * 名字
     */
    private final String name;

    public static SmsChannelEnum getByCode(String code) {
        return ArrayUtil.firstMatch(o -> o.getCode().equals(code), values());
    }

}

