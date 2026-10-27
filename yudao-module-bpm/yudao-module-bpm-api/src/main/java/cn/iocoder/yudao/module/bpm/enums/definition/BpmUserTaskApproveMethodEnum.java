package cn.iocoder.yudao.module.bpm.enums.definition;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 多人审批方式的枚举
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
public enum BpmUserTaskApproveMethodEnum implements ArrayValuable<Integer> {

    RANDOM(1, "Assign one random approver", null),
    RATIO(2, "Countersign by pass ratio", "${ nrOfCompletedInstances/nrOfInstances >= %s}"), // 会签（按通过比例）
    ANY(3, "Or-sign (one approve or reject)", "${ nrOfCompletedInstances > 0 }"), // 或签（通过只需一人，拒绝只需一人）
    SEQUENTIAL(4, "Sequential approval", "${ nrOfCompletedInstances >= nrOfInstances }"); // 依次审批

    /**
     * 审批方式
     */
    private final Integer method;
    /**
     * 名字
     */
    private final String name;
    /**
     * 完成表达式
     */
    private final String completionCondition;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmUserTaskApproveMethodEnum::getMethod).toArray(Integer[]::new);

    public static BpmUserTaskApproveMethodEnum valueOf(Integer method) {
        return ArrayUtil.firstMatch(item -> item.getMethod().equals(method), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }
}
