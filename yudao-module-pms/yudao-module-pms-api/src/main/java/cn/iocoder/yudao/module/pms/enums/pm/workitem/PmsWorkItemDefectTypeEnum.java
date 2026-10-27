package cn.iocoder.yudao.module.pms.enums.pm.workitem;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * PMS 缺陷类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PmsWorkItemDefectTypeEnum implements ArrayValuable<Integer> {

    FUNCTION(1, "Functional issue"),
    UI(2, "UI improvement"),
    USABILITY(3, "Usability issue"),
    SECURITY(4, "Security issue"),
    PERFORMANCE(5, "Performance issue"),
    CODE(6, "Code defect");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(PmsWorkItemDefectTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 缺陷类型
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

    public static PmsWorkItemDefectTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
