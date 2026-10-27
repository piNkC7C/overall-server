package cn.iocoder.yudao.module.im.enums.group;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * IM 加群申请处理结果枚举
 * <p>
 * 取值与 {@link cn.iocoder.yudao.module.im.enums.friend.ImFriendRequestHandleResultEnum} 平行，便于复用心智模型
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum ImGroupRequestHandleResultEnum implements ArrayValuable<Integer> {

    UNHANDLED(0, "Not process."),
    AGREED(1, "Approve"),
    REFUSED(2, "Reject");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ImGroupRequestHandleResultEnum::getResult).toArray(Integer[]::new);

    /**
     * 结果
     */
    private final Integer result;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    /**
     * 判断申请是否还未处理
     */
    public static boolean isUnhandled(Integer result) {
        return Objects.equals(UNHANDLED.result, result);
    }

}
