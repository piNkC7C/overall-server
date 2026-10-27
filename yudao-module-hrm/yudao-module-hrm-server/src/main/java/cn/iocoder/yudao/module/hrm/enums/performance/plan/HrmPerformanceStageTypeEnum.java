package cn.iocoder.yudao.module.hrm.enums.performance.plan;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * HRM 绩效阶段类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmPerformanceStageTypeEnum implements ArrayValuable<Integer> {

    NOT_STARTED(0, "Not start."),
    FILL_QUOTA(1, "Employee enter."),
    TARGET_CONFIRM(2, "Target confirm."),
    SELF_SCORE(3, "Self review"),
    OTHER_SCORE(4, "Peer score"),
    RESULT_AUDIT(5, "Result approval."),
    RESULT_CONFIRM(6, "Result confirm."),
    APPEAL_CONFIRM(7, "Appeal confirm"),
    ARCHIVED(8, "Archive"),
    EXECUTING(9, "Execute."),
    END(10, "End.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmPerformanceStageTypeEnum::getType).toArray(Integer[]::new);

    public static final List<Integer> REVIEW_TYPES = Collections.unmodifiableList(Arrays.asList(
            SELF_SCORE.getType(), OTHER_SCORE.getType()));

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

    public static HrmPerformanceStageTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
