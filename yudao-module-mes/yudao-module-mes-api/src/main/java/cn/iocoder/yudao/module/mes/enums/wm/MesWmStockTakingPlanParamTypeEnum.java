package cn.iocoder.yudao.module.mes.enums.wm;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.module.mes.enums.MesBizTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 盘点方案参数类型枚举
 */
@Getter
@AllArgsConstructor
public enum MesWmStockTakingPlanParamTypeEnum implements ArrayValuable<Integer> {

    WAREHOUSE(MesBizTypeConstants.WM_WAREHOUSE, "Warehouse"),
    LOCATION(MesBizTypeConstants.WM_LOCATION, "Zone"),
    AREA(MesBizTypeConstants.WM_AREA, "Bin"),
    ITEM(MesBizTypeConstants.MD_ITEM, "Material"),
    BATCH(MesBizTypeConstants.WM_BATCH, "Lot"),
    QUALITY_STATUS(MesBizTypeConstants.QUALITY_STATUS, "Quality status");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(MesWmStockTakingPlanParamTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 参数类型
     */
    private final Integer type;
    /**
     * 类型名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
