package cn.iocoder.yudao.module.hrm.enums.employee.info;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工状态页签枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeStatusTabEnum implements ArrayValuable<Integer> {

    REGULAR(HrmEmployeeStatusEnum.REGULAR.getStatus(), "Regular"),
    PROBATION(HrmEmployeeStatusEnum.PROBATION.getStatus(), "Probation"),
    INTERN(HrmEmployeeStatusEnum.INTERN.getStatus(), "Intern"),
    PART_TIME(HrmEmployeeStatusEnum.PART_TIME.getStatus(), "Part-time"),
    LABOR(HrmEmployeeStatusEnum.LABOR.getStatus(), "Contractor"),
    CONSULTANT(HrmEmployeeStatusEnum.CONSULTANT.getStatus(), "Consultant"),
    REHIRE(HrmEmployeeStatusEnum.REHIRE.getStatus(), "Rehire"),
    OUTSOURCE(HrmEmployeeStatusEnum.OUTSOURCE.getStatus(), "Outsourced"),
    ACTIVE(11, "Active"),
    FULL_TIME(12, "Full-time"),
    PENDING_ENTRY(13, "Pending hire"),
    PENDING_LEAVE(14, "Pending offboard"),
    LEFT(15, "Already offboarding.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeStatusTabEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态页签
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

    public static HrmEmployeeStatusTabEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
