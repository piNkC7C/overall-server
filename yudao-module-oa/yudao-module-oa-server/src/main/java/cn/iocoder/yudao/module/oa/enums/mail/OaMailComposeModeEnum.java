package cn.iocoder.yudao.module.oa.enums.mail;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 邮件写信方式枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaMailComposeModeEnum implements ArrayValuable<String> {

    NEW("new", "New mail"),
    DRAFT("draft", "Edit draft"),
    REPLY("reply", "Reply"),
    REPLY_ALL("replyAll", "Reply All"),
    FORWARD("forward", "Forward");

    public static final String[] ARRAYS = Arrays.stream(values())
            .map(OaMailComposeModeEnum::getValue).toArray(String[]::new);

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
