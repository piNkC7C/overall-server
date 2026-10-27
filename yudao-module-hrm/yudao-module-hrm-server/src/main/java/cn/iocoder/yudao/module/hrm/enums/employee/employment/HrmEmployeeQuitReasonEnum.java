package cn.iocoder.yudao.module.hrm.enums.employee.employment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工离职原因枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeQuitReasonEnum implements ArrayValuable<Integer> {

    FAMILY(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 1, "Family reasons"),
    HEALTH(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 2, "Health reasons"),
    SALARY(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 3, "Payrollreason."),
    INCONVENIENT_TRAFFIC(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 4, "Commute issues"),
    WORK_PRESSURE(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 5, "Work pressure"),
    MANAGEMENT_ISSUE(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 6, "Management issues"),
    NO_PROMOTION_OPPORTUNITY(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 7, "No promotion path"),
    CAREER_PLANNING(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 8, "Career plan"),
    GIVE_UP_RENEWAL(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 9, "Declined renewal"),
    OTHER_PERSONAL_REASON(HrmEmployeeQuitTypeEnum.VOLUNTARY.getType(), 10, "Other personal reasons"),
    TRIAL_PERIOD_DISMISSAL(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 11, "Terminated during probation"),
    VIOLATION(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 12, "Policy violation"),
    LAYOFF(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 13, "Reorg / layoff"),
    UNDERPERFORMANCE(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 14, "Terminated for performance"),
    CONTRACT_NOT_RENEWED(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 15, "Contract not renewed"),
    OTHER_INVOLUNTARY_REASON(HrmEmployeeQuitTypeEnum.INVOLUNTARY.getType(), 16, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeQuitReasonEnum::getReason).toArray(Integer[]::new);

    /**
     * 离职类型
     *
     * 枚举 {@link HrmEmployeeQuitTypeEnum}
     */
    private final Integer quitType;
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

    public static HrmEmployeeQuitReasonEnum valueOf(Integer reason) {
        return ArrayUtil.firstMatch(item -> item.getReason().equals(reason), values());
    }

}
