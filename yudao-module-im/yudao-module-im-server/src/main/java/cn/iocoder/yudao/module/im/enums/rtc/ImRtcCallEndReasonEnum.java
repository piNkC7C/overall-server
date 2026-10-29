package cn.iocoder.yudao.module.im.enums.rtc;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * IM 通话结束原因枚举；落历史消息时计算 content 文案
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum ImRtcCallEndReasonEnum implements ArrayValuable<Integer> {

    HANGUP(1, "Call end"), // 接通后任一方主动挂断
    REJECT(2, "Rejected"), // 被叫接通前点拒接
    CANCEL(3, "Canceled"), // 主叫接通前主动取消
    NO_ANSWER(4, "No answer"), // 振铃超时未接通；由参与者超时 Job 触发
    BUSY(5, "Busy"), // 私聊呼叫时对方在另一通话
    ERROR(9, "Call error"); // 网络中断、设备失败等

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ImRtcCallEndReasonEnum::getReason).toArray(Integer[]::new);

    /**
     * 原因值
     */
    private final Integer reason;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
