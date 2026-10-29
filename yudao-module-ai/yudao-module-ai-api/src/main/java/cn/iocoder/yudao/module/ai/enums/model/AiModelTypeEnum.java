package cn.iocoder.yudao.module.ai.enums.model;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * AI 模型类型的枚举
 *
 * @author 芋道源码
 */
@Getter
@RequiredArgsConstructor
public enum AiModelTypeEnum implements ArrayValuable<Integer> {

    CHAT(1, "conversation"),
    IMAGE(2, "Picture"),
    VOICE(3, "Voice"),
    VIDEO(4, "Video"),
    EMBEDDING(5, "Embedding"),
    RERANK(6, "Rerank");

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(AiModelTypeEnum::getType).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
