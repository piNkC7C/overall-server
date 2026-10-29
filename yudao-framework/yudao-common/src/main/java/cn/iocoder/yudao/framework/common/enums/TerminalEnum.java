package cn.iocoder.yudao.framework.common.enums;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 终端的枚举
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum TerminalEnum implements ArrayValuable<Integer> {

    UNKNOWN(0, "Unknown"), // 目的：在无法解析到 terminal 时，使用它
    WECHAT_MINI_PROGRAM(10, "WeChat mini program"),
    WECHAT_WAP(11, "WeChat Official Account"),
    H5(20, "H5 page"),
    APP(31, "Mobile App"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(TerminalEnum::getTerminal).toArray(Integer[]::new);

    /**
     * 终端
     */
    private final Integer terminal;
    /**
     * 终端名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }
}
