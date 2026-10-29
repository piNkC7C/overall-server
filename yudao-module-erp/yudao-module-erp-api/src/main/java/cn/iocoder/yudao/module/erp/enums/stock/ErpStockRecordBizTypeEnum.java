package cn.iocoder.yudao.module.erp.enums.stock;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * ERP 库存明细 - 业务类型枚举
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum ErpStockRecordBizTypeEnum implements ArrayValuable<Integer> {

    OTHER_IN(10, "Other inbound"),
    OTHER_IN_CANCEL(11, "Other inbound (voided)"),

    OTHER_OUT(20, "Other outbound"),
    OTHER_OUT_CANCEL(21, "Other outbound (voided)"),

    MOVE_IN(30, "Transfer inbound"),
    MOVE_IN_CANCEL(31, "Transfer inbound (voided)"),
    MOVE_OUT(32, "Transfer outbound"),
    MOVE_OUT_CANCEL(33, "Transfer outbound (voided)"),

    CHECK_MORE_IN(40, "Overage inbound"),
    CHECK_MORE_IN_CANCEL(41, "Overage inbound (voided)"),
    CHECK_LESS_OUT(42, "Shortage outbound"),
    CHECK_LESS_OUT_CANCEL(43, "Shortage outbound (voided)"),

    SALE_OUT(50, "Sales outbound"),
    SALE_OUT_CANCEL(51, "Sales outbound (voided)"),

    SALE_RETURN(60, "Sales return inbound"),
    SALE_RETURN_CANCEL(61, "Sales return inbound (voided)"),

    PURCHASE_IN(70, "Purchase inbound"),
    PURCHASE_IN_CANCEL(71, "Purchase inbound (voided)"),

    PURCHASE_RETURN(80, "Purchase return outbound"),
    PURCHASE_RETURN_CANCEL(81, "Purchase return outbound (voided)"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ErpStockRecordBizTypeEnum::getType).toArray(Integer[]::new);

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

}
