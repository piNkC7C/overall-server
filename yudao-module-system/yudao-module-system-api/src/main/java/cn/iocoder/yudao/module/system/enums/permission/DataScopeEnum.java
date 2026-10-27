package cn.iocoder.yudao.module.system.enums.permission;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 数据范围枚举类
 *
 * 用于实现数据级别的权限
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum DataScopeEnum implements ArrayValuable<Integer> {

    ALL(1), // All Data

    DEPT_CUSTOM(2), // Custom Departments
    DEPT_ONLY(3), // Department Only
    DEPT_AND_CHILD(4), // Department and Below

    SELF(5); // Self Only

    /**
     * 范围
     */
    private final Integer scope;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(DataScopeEnum::getScope).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
