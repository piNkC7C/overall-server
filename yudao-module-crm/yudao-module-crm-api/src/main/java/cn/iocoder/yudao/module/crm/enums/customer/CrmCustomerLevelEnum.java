package cn.iocoder.yudao.module.crm.enums.customer;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * CRM 客户等级
 *
 * @author Wanwan
 */
@Getter
@AllArgsConstructor
public enum CrmCustomerLevelEnum implements ArrayValuable<Integer> {

    IMPORTANT(1, "A (key account)"),
    GENERAL(2, "B (standard account)"),
    LOW_PRIORITY(3, "C ( not Prioritycustomer)");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(CrmCustomerLevelEnum::getLevel).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer level;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
