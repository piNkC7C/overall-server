package cn.iocoder.yudao.module.fms.enums.closing;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 结账模板分类枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsClosingTemplateCategoryEnum implements ArrayValuable<Integer> {

    DAILY_EXPENSE(1, "Daily expense"),
    PURCHASE_SALE(2, "Purchase sales."),
    CURRENT_ACCOUNT(3, "Current account"),
    TRANSFER_BUSINESS(4, "Transfer business.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(FmsClosingTemplateCategoryEnum::getCategory).toArray(Integer[]::new);

    /**
     * 分类
     */
    private final Integer category;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
