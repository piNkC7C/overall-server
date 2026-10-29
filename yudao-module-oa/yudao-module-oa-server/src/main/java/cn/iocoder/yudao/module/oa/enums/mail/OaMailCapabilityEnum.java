package cn.iocoder.yudao.module.oa.enums.mail;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * IMAP 协议能力枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaMailCapabilityEnum implements ArrayValuable<String> {

    UID_PLUS("UIDPLUS", "By UID"),
    MOVE("MOVE", "Move email"),
    ID("ID", "Client identity");

    public static final String[] ARRAYS = Arrays.stream(values())
            .map(OaMailCapabilityEnum::getValue).toArray(String[]::new);

    /**
     * 值
     */
    private final String value;
    /**
     * 名称
     */
    private final String name;

    @Override
    public String[] array() {
        return ARRAYS;
    }

}
