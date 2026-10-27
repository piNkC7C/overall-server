package cn.iocoder.yudao.module.mes.enums;

/**
 * MES 业务类型常量
 *
 * 集中管理业务类型枚举的编号，按业务域分段。
 * 各枚举类引用此处常量，避免硬编码数字。（也避免冲突！！！）
 *
 * @author 芋道源码
 */
public final class MesBizTypeConstants {

    private MesBizTypeConstants() {}

    // ========== QC quality inspection module [1, 100) ==========

    public static final int QC_IQC = 1; // 来料检验：MesQcIqcDO
    public static final int QC_IPQC = 2; // 过程检验：MesQcIpqcDO
    public static final int QC_OQC = 3; // 出货检验：MesQcOqcDO
    public static final int QC_RQC = 4; // Return inspection ：MesQcRqcDO

    // ========== WM warehouse module [100, 200) ==========

    public static final int WM_ARRIVAL_NOTICE = 100; // Receiving notification order ：MesWmArrivalNoticeDO
    public static final int WM_WAREHOUSE = 102; // Warehouse：MesWmWarehouseDO
    public static final int WM_LOCATION = 103; // Bin：MesWmLocationDO
    public static final int WM_AREA = 104; // Bin：MesWmStorageAreaDO
    public static final int WM_PACKAGE = 105; // Packing order ：MesWmPackageDO
    public static final int WM_STOCK = 106; // Inventory：MesWmMaterialStockDO
    public static final int WM_BATCH = 107; // Lot：MesWmBatchDO
    public static final int WM_TRANSACTION = 108; // 库存事务流水：MesWmTransactionDO
    public static final int WM_SN = 109; // SN 码：MesWmSnDO
    public static final int WM_ITEM_RECEIPT_IN = 110; // Purchase inbound ：MesWmItemReceiptDO
    public static final int WM_TRANSFER_OUT = 111; // Transfer outbound ：MesWmTransferDO
    public static final int WM_TRANSFER_IN = 112; // Transfer inbound ：MesWmTransferDO
    public static final int WM_MISC_ISSUE = 113; // 其他出库：MesWmMiscIssueDO
    public static final int WM_MISC_RECPT = 114; // 其他入库：MesWmMiscReceiptDO
    public static final int WM_ISSUE = 115; // Production material issue ：MesWmProductIssueDO
    public static final int WM_RETURN_ISSUE = 116; // Production material return ：MesWmReturnIssueDO
    public static final int WM_PRODUCT_RECPT = 117; // Production inbound ：MesWmProductReceiptDO
    public static final int WM_PRODUCT_SALES = 118; // Sales outbound ：MesWmProductSalesDO
    public static final int WM_RETURN_SALES = 119; // Sales return inbound ：MesWmReturnSalesDO
    public static final int WM_OUTSOURCE_ISSUE = 120; // Subcontract issue ：MesWmOutsourceIssueDO
    public static final int WM_OUTSOURCE_RECPT = 121; // Subcontract inbound ：MesWmOutsourceReceiptDO
    public static final int WM_ITEM_CONSUME = 122; // 生产消耗：MesWmItemConsumeDO
    public static final int WM_PRODUCT_PRODUCE = 123; // 产品产出：MesWmProductProduceDO
    public static final int WM_RETURN_VENDOR = 124; // Supplier return outbound ：MesWmReturnVendorDO

    // ========== CAL schedule module [200, 300) ==========

    // TODO @芋艿【暂时忽略】：MesProWorkOrderTypeEnum
    // TODO @芋艿【暂时忽略】：MesProWorkOrderSourceTypeEnum

    // ========== PRO production module [300, 400) ==========

    public static final int PRO_CARD = 300; // Routing card ：MesProCardDO
    public static final int PRO_WORKORDER = 301; // Work order：MesProWorkOrderDO
    public static final int PRO_TRANS_ORDER = 302; // 流转单：MesProTransOrderDO
    public static final int PRO_TASK = 303; // Production task ：MesProTaskDO
    public static final int PRO_FEEDBACK = 304; // Production work report ：MesProFeedbackDO

    // ========== DV device module [400, 500) ==========

    public static final int DV_MACHINERY = 400; // Device：MesDvMachineryDO

    // ========== TM fixture module [500, 600) ==========

    public static final int TM_TOOL = 500; // 工装：MesToolDO

    // ========== MD 主数据模块 [600, 700) ==========

    public static final int MD_ITEM = 600; // Material ：MesMdItemDO
    public static final int MD_VENDOR = 601; // Supplier：MesMdVendorDO
    public static final int MD_WORKSTATION = 602; // Workstation：MesMdWorkstationDO
    public static final int MD_WORKSHOP = 603; // Workshop ：MesMdWorkshopDO
    public static final int MD_USER = 604; // 人员：系统用户
    public static final int MD_CLIENT = 605; // Customer：MesMdClientDO

    // ========== 特殊类型（非业务实体） [900, 1000) ==========

    public static final int QUALITY_STATUS = 900; // 质量状态：非实体，用于盘点等场景的状态筛选

}
