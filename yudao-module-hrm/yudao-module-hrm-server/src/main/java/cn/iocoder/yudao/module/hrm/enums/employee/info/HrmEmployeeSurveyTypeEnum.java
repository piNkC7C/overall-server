package cn.iocoder.yudao.module.hrm.enums.employee.info;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 首页人事概况筛选类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeSurveyTypeEnum implements ArrayValuable<Integer> {

    ENTRY(1, "Onboarding"),
    LEAVE(2, "Offboarding"),
    REGULAR(3, "Confirmation"),
    TRANSFER(4, "Transfer"),
    PENDING_ENTRY(5, "Pending hire"),
    PENDING_LEAVE(6, "Pending offboard");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeSurveyTypeEnum::getType).toArray(Integer[]::new);

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

}
