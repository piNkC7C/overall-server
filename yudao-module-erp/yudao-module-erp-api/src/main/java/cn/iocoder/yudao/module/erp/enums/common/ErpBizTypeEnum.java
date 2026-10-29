package cn.iocoder.yudao.module.erp.enums.common;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * ERP 业务类型枚举
 *
 * @author HUIHUI
 */
@RequiredArgsConstructor
@Getter
public enum ErpBizTypeEnum implements ArrayValuable<Integer> {

    PURCHASE_ORDER(10, "Purchase order"),
    PURCHASE_IN(11, "Purchase inbound"),
    PURCHASE_RETURN(12, "Purchase return"),

    SALE_ORDER(20, "Sales order"),
    SALE_OUT(21, "Sales outbound"),
    SALE_RETURN(22, "Sales return"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ErpBizTypeEnum::getType).toArray(Integer[]::new);

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
