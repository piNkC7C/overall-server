package cn.iocoder.yudao.module.crm.enums.receivable;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * CRM 回款方式枚举
 *
 * @author HUIHUI
 */
@Getter
@AllArgsConstructor
public enum CrmReceivableReturnTypeEnum implements ArrayValuable<Integer> {

    CHECK(1, "Check"),
    CASH(2, "Cash"),
    POSTAL_REMITTANCE(3, "Postal money order"),
    TELEGRAPHIC_TRANSFER(4, "Wire transfer"),
    ONLINE_TRANSFER(5, "Online transfer"),
    ALIPAY(6, "Alipay"),
    WECHAT_PAY(7, "WeChat payment"),
    OTHER(8, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(CrmReceivableReturnTypeEnum::getType).toArray(Integer[]::new);

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
