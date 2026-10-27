package cn.iocoder.yudao.module.hrm.enums.employee.employment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工合同类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeContractTypeEnum implements ArrayValuable<Integer> {

    FIXED_TERM_LABOR_CONTRACT(1, "Fixed-term labor contract"),
    NON_FIXED_TERM_LABOR_CONTRACT(2, "Open-ended labor contract"),
    WORK_TASK_LABOR_CONTRACT(3, "Project-based labor contract"),
    INTERNSHIP_AGREEMENT(4, "Internship agreement"),
    LABOR_SERVICE_CONTRACT(5, "Contractor contract"),
    REEMPLOYMENT_AGREEMENT(6, "Rehire agreement"),
    LABOR_DISPATCH_CONTRACT(7, "Staffing contract"),
    SECONDMENT_CONTRACT(8, "Secondment contract"),
    OTHER(9, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeContractTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmEmployeeContractTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
