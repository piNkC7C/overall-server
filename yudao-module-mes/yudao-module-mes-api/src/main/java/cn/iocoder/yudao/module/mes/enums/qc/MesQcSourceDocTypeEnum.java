package cn.iocoder.yudao.module.mes.enums.qc;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.module.mes.enums.MesBizTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 质检来源单据类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesQcSourceDocTypeEnum implements ArrayValuable<Integer> {

    // === IQC source document ===
    ARRIVAL_NOTICE(MesBizTypeConstants.WM_ARRIVAL_NOTICE, "Receiving notification order"),
    OUTSOURCE_RECPT(MesBizTypeConstants.WM_OUTSOURCE_RECPT, "Subcontract inbound order"), // === IPQC source document === PRO_FEEDBACK(MesBizTypeConstants.PRO_FEEDBACK"Production work report."), // === OQC source document === PRODUCT_SALES(MesBizTypeConstants.WM_PRODUCT_SALES"Sales shipment."), // === RQC source document === RETURN_ISSUE(MesBizTypeConstants.WM_RETURN_ISSUE"Production material return order."),
    RETURN_SALES(MesBizTypeConstants.WM_RETURN_SALES, "Sales return"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesQcSourceDocTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型值
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
