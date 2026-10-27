package cn.iocoder.yudao.module.hrm.enums.performance.assessment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 绩效申诉状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmPerformanceAppealStatusEnum implements ArrayValuable<Integer> {

    NONE(0, "No appeal"),
    PENDING(1, "Pending"),
    PASS(2, "Already via."),
    REJECT(3, "Rejected"),
    CANCEL(4, "Canceled.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmPerformanceAppealStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmPerformanceAppealStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
