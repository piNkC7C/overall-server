package cn.iocoder.yudao.module.promotion.enums.kefu;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 客服消息的类型枚举
 *
 * @author HUIHUI
 */
@AllArgsConstructor
@Getter
public enum KeFuMessageContentTypeEnum implements ArrayValuable<Integer> {

    TEXT(1, "Text message"),
    IMAGE(2, "Imagemessage"),
    VOICE(3, "Voice message"),
    VIDEO(4, "Video message"),
    SYSTEM(5, "Systemmessage"),

    // ========== 商城特殊消息 ==========
    PRODUCT(10, "Productmessage"),
    ORDER(11, "Ordermessage");

    private static final Integer[] ARRAYS = Arrays.stream(values()).map(KeFuMessageContentTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
