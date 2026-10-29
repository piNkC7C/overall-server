package cn.iocoder.yudao.module.im.enums.message;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * IM 消息状态枚举
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum ImMessageStatusEnum implements ArrayValuable<Integer> {

    SENDING(-1, "Send"), // 仅客户端使用
    NORMAL(0, "Normal"), // 私聊 / 群聊的正常（初始）状态
    RECALL(2, "Withdrawn");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ImMessageStatusEnum::getStatus).toArray(Integer[]::new);

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