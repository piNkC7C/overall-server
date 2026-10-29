package cn.iocoder.yudao.module.hrm.enums.employee.employment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

/**
 * HRM 员工异动原因枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeChangeReasonEnum implements ArrayValuable<Integer> {

    ORGANIZATION_ADJUSTMENT(1, "Org change"),
    PERSONAL_APPLICATION(2, "Person apply please"),
    WORK_ARRANGEMENT(3, "Work arrangement"),
    VIOLATION(4, "Policy violation"),
    UNDERPERFORMANCE(5, "Performance below target"),
    HEALTH_REASON(6, "Health reasons"),
    UNSUITABLE_POSITION(7, "Not a fit for the role");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeChangeReasonEnum::getReason).toArray(Integer[]::new);

    /**
     * 调岗、晋升原因
     */
    public static final Set<Integer> TRANSFER_AND_PROMOTION_REASONS = SetUtils.asSet(
            ORGANIZATION_ADJUSTMENT.getReason(), PERSONAL_APPLICATION.getReason(), WORK_ARRANGEMENT.getReason());

    /**
     * 降级原因
     */
    public static final Set<Integer> DEMOTION_REASONS = SetUtils.asSet(
            VIOLATION.getReason(), UNDERPERFORMANCE.getReason(), HEALTH_REASON.getReason(),
            UNSUITABLE_POSITION.getReason());

    /**
     * 原因
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

    public static HrmEmployeeChangeReasonEnum valueOf(Integer reason) {
        return ArrayUtil.firstMatch(item -> item.getReason().equals(reason), values());
    }

}
