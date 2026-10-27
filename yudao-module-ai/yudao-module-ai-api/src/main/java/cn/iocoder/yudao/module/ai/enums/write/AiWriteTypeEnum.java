package cn.iocoder.yudao.module.ai.enums.write;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * AI 写作类型的枚举
 *
 * @author xiaoxin
 */
@AllArgsConstructor
@Getter
public enum AiWriteTypeEnum implements ArrayValuable<Integer> {

    WRITING(1, "Write", "Write an article about [{}]. Format: {}, tone: {}, language: {}, length: {}. Cover the main points. Return only the article, with no title, extra explanation, or apology."),
    REPLY(2, "Reply", "Write a reply to [{}]. Use this reference: [{}]. Format: {}, tone: {}, language: {}, length: {}. Return only the reply, with no title, intro, extra explanation, or apology.");

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    /**
     * 模版
     */
    private final String prompt;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(AiWriteTypeEnum::getType).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
