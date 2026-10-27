package cn.iocoder.yudao.module.im.enums.message;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * IM 消息回执状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum ImMessageReceiptStatusEnum implements ArrayValuable<Integer> {

    NO_RECEIPT(0, "Not need to need Receipt"),
    PENDING(1, "To do"),
    DONE(2, "Completed.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ImMessageReceiptStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
