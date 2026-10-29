package cn.iocoder.yudao.module.promotion.enums.common;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 营销的商品范围枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PromotionProductScopeEnum implements ArrayValuable<Integer> {

    ALL(1, "Allproduct"),
    SPU(2, "Specified product"),
    CATEGORY(3, "Selected categories");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(PromotionProductScopeEnum::getScope).toArray(Integer[]::new);

    /**
     * 范围值
     */
    private final Integer scope;
    /**
     * 范围名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isAll(Integer scope) {
        return Objects.equals(scope, ALL.scope);
    }

    public static boolean isSpu(Integer scope) {
        return Objects.equals(scope, SPU.scope);
    }

    public static boolean isCategory(Integer scope) {
        return Objects.equals(scope, CATEGORY.scope);
    }

}
