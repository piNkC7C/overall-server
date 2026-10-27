package cn.iocoder.yudao.module.fms.enums.voucher;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 凭证整理方式枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsVoucherTidyTypeEnum implements ArrayValuable<Integer> {

    FILL_GAPS(1, "Close number gaps in order"),
    REORDER_BY_TIME(2, "Renumber by journal date");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(FmsVoucherTidyTypeEnum::getType).toArray(Integer[]::new);

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

    public static FmsVoucherTidyTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
