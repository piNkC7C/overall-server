package cn.iocoder.yudao.module.wms.enums.order;

/**
 * WMS 单据业务类型常量
 *
 * 集中管理业务类型枚举的编号，按业务域分段。
 * 各枚举类引用此处常量，避免硬编码数字。（也避免冲突！！！）
 *
 * @author 芋道源码
 */
public final class WmsOrderTypeConstants {

    private WmsOrderTypeConstants() {}

    // ========== inbound order type [100, 200) ==========

    public static final int RECEIPT_PRODUCTION = 100; // Production inbound ：WmsReceiptOrderDO
    public static final int RECEIPT_PURCHASE = 101; // Purchase inbound ：WmsReceiptOrderDO
    public static final int RECEIPT_RETURN = 102; // Return inbound ：WmsReceiptOrderDO
    public static final int RECEIPT_GIVE_BACK = 103; // 归还入库：WmsReceiptOrderDO

    // ========== outbound order type [200, 300) ==========

    public static final int SHIPMENT_RETURN = 200; // Return outbound ：WmsShipmentOrderDO
    public static final int SHIPMENT_SALE = 201; // Sales outbound ：WmsShipmentOrderDO
    public static final int SHIPMENT_PRODUCTION = 202; // Production outbound ：WmsShipmentOrderDO

}
