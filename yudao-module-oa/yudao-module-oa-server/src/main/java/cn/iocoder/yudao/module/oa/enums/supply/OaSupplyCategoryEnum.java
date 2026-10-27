package cn.iocoder.yudao.module.oa.enums.supply;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 办公用品分类枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaSupplyCategoryEnum implements ArrayValuable<Integer> {

    STATIONERY(1, "Stationery"),
    PRINTING_CONSUMABLE(2, "Print supplies"),
    DAILY_NECESSITY(3, "Daily supplies"),
    COMPUTER_ACCESSORY(4, "Computer office"),
    OFFICE_EQUIPMENT(5, "Office equipment"),
    ELECTRICAL_APPLIANCE(7, "Appliances"),
    FINANCIAL_SUPPLY(6, "Finance supplies");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaSupplyCategoryEnum::getCategory).toArray(Integer[]::new);

    /**
     * 分类
     */
    private final Integer category;
    /**
     * 名称
     */
    private final String name;

    /**
     * 根据分类获得枚举
     *
     * @param category 分类
     * @return 对应枚举，不存在时返回 null
     */
    public static OaSupplyCategoryEnum valueOf(Integer category) {
        return ArrayUtil.firstMatch(item -> item.getCategory().equals(category), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
