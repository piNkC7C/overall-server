package cn.iocoder.yudao.module.bpm.enums.task;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.object.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 流程实例 ProcessInstance 的状态
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmProcessInstanceStatusEnum implements ArrayValuable<Integer> {

    NOT_START(-1, "Not start."),
    RUNNING(1, "Approval."),
    APPROVE(2, "Approved."),
    REJECT(3, "Approval not via."),
    CANCEL(4, "Canceled.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmProcessInstanceStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 描述
     */
    private final String desc;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isRejectStatus(Integer status) {
        return REJECT.getStatus().equals(status);
    }

    public static boolean isProcessEndStatus(Integer status) {
        return ObjectUtils.equalsAny(status,
                APPROVE.getStatus(), REJECT.getStatus(), CANCEL.getStatus());
    }

    public static BpmProcessInstanceStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
