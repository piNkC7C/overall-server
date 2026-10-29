package cn.iocoder.yudao.module.mes.enums.qc;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.module.mes.enums.MesBizTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 检测种类枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesQcTypeEnum implements ArrayValuable<Integer> {

    IQC(MesBizTypeConstants.QC_IQC, "Incoming inspection"),
    IPQC(MesBizTypeConstants.QC_IPQC, "In-process inspection"),
    OQC(MesBizTypeConstants.QC_OQC, "Outgoing inspection"),
    RQC(MesBizTypeConstants.QC_RQC, "Return inspection");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesQcTypeEnum::getType).toArray(Integer[]::new);

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
