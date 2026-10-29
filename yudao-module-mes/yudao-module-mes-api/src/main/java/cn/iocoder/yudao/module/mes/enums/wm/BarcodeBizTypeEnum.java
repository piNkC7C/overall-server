package cn.iocoder.yudao.module.mes.enums.wm;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.module.mes.enums.MesBizTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 条码业务类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BarcodeBizTypeEnum implements ArrayValuable<Integer> {

    WAREHOUSE(MesBizTypeConstants.WM_WAREHOUSE, "Warehouse"),
    LOCATION(MesBizTypeConstants.WM_LOCATION, "Zone"),
    AREA(MesBizTypeConstants.WM_AREA, "Bin"),
    PACKAGE(MesBizTypeConstants.WM_PACKAGE, "Packing order"),
    STOCK(MesBizTypeConstants.WM_STOCK, "Inventory"),
    BATCH(MesBizTypeConstants.WM_BATCH, "Lot"),
    SN(MesBizTypeConstants.WM_SN, "SN"),
    PROCARD(MesBizTypeConstants.PRO_CARD, "Routing card"),
    WORKORDER(MesBizTypeConstants.PRO_WORKORDER, "Work order"),
    TRANSORDER(MesBizTypeConstants.PRO_TRANS_ORDER, "Flow document"),
    MACHINERY(MesBizTypeConstants.DV_MACHINERY, "Device"),
    TOOL(MesBizTypeConstants.TM_TOOL, "Tool"),
    ITEM(MesBizTypeConstants.MD_ITEM, "Material"),
    VENDOR(MesBizTypeConstants.MD_VENDOR, "Supplier"),
    CLIENT(MesBizTypeConstants.MD_CLIENT, "Customer"),
    WORKSTATION(MesBizTypeConstants.MD_WORKSTATION, "Workstation"),
    WORKSHOP(MesBizTypeConstants.MD_WORKSHOP, "Workshop"),
    USER(MesBizTypeConstants.MD_USER, "Personnel");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BarcodeBizTypeEnum::getValue).toArray(Integer[]::new);

    /**
     * 业务类型值
     */
    private final Integer value;
    /**
     * 业务类型名称
     */
    private final String label;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
