package cn.iocoder.yudao.module.mp.enums.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公众号消息自动回复的类型
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MpAutoReplyTypeEnum {

    SUBSCRIBE(1, "Follow time reply."),
    MESSAGE(2, "Reply on message"),
    KEYWORD(3, "Keyword reply"),
    ;

    /**
     * 来源
     */
    private final Integer type;
    /**
     * 类型的名字
     */
    private final String name;

}
