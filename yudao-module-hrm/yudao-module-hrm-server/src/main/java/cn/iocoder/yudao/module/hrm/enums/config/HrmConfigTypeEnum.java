package cn.iocoder.yudao.module.hrm.enums.config;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 业务配置类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmConfigTypeEnum implements ArrayValuable<Integer> {

    RECRUIT_ELIMINATE(1, "Rejection reason"),
    EMPLOYEE_CREATE_ACTIVE_FIELD(2, "New active-employee field"),
    EMPLOYEE_CREATE_PENDING_FIELD(3, "New pre-hire field"),
    EMPLOYEE_ARCHIVE_FIELD(4, "Employee profile field");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmConfigTypeEnum::getType).toArray(Integer[]::new);

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

    public static HrmConfigTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
