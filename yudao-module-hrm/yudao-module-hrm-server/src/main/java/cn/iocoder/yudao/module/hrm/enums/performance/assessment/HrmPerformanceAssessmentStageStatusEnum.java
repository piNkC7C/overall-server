package cn.iocoder.yudao.module.hrm.enums.performance.assessment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工绩效考核阶段状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmPerformanceAssessmentStageStatusEnum implements ArrayValuable<Integer> {

    NOT_PROCESSED(0, "Unprocessed"),
    PROCESSED(1, "Processed"),
    PENDING(2, "Pending"),
    REJECTED(3, "Rejected"),
    PROCESSING(4, "Process"),
    APPEALED(5, "Appealed");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmPerformanceAssessmentStageStatusEnum::getStatus).toArray(Integer[]::new);

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

    public static HrmPerformanceAssessmentStageStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
