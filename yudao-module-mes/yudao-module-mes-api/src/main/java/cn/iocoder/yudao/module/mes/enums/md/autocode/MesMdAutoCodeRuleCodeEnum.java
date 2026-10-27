package cn.iocoder.yudao.module.mes.enums.md.autocode;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * MES 编码规则代码枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesMdAutoCodeRuleCodeEnum {

    MD_ITEM_TYPE_CODE("MD_ITEM_TYPE_CODE", "Material category code."),
    MD_ITEM_CODE("MD_ITEM_CODE", "Material code."),
    MD_VENDOR_CODE("MD_VENDOR_CODE", "Supplier code."),
    MD_CLIENT_CODE("MD_CLIENT_CODE", "Customer code."),
    MD_WORKSTATION_CODE("MD_WORKSTATION_CODE", "Workstation code."),
    MD_WORKSHOP_CODE("MD_WORKSHOP_CODE", "Workshop code."),
    TM_TOOL_TYPE_CODE("TM_TOOL_TYPE_CODE", "Tool type code."),
    WM_ARRIVAL_NOTICE_CODE("WM_ARRIVAL_NOTICE_CODE", "Receiving notification order code."),
    WM_ITEM_RECEIPT_CODE("WM_ITEM_RECEIPT_CODE", "Purchase receipt code."),
    WM_RETURN_VENDOR_CODE("WM_RETURN_VENDOR_CODE", "Purchase return order code."),
    WM_RETURN_ISSUE_CODE("WM_RETURN_ISSUE_CODE", "Production material return order code."),
    WM_SN_CODE("WM_SN_CODE", "SN"),
    WM_PACKAGE_CODE("WM_PACKAGE_CODE", "Packing order code."),
    WM_BATCH_CODE("WM_BATCH_CODE", "Lot code."),
    PRO_TASK_CODE("PRO_TASK_CODE", "Production task code."),
    QC_IQC_CODE("QC_IQC_CODE", "Incoming inspection number"),
    QC_IPQC_CODE("QC_IPQC_CODE", "In-process inspection number"),
    QC_OQC_CODE("QC_OQC_CODE", "Outgoing inspection number"),
    QC_RQC_CODE("QC_RQC_CODE", "Return inspection code."),
    WM_WAREHOUSE_CODE("WM_WAREHOUSE_CODE", "Warehouse code."),
    WM_LOCATION_CODE("WM_LOCATION_CODE", "Zone code."),
    WM_AREA_CODE("WM_AREA_CODE", "Bin code."),
    WM_PRODUCT_SALES_CODE("WM_PRODUCT_SALES_CODE", "Sales shipment code."),
    WM_MISC_RECEIPT_CODE("WM_MISC_RECEIPT_CODE", "Miscellaneous inbound order code."),
    WM_STOCK_TAKING_PLAN_CODE("WM_STOCK_TAKING_PLAN_CODE", "Stocktake plan code."),
    WM_STOCK_TAKING_CODE("WM_STOCK_TAKING_CODE", "Stocktake task code."),
    TRANSFER_CODE("TRANSFER_CODE", "Transfer transfer order code."),
    WM_OUTSOURCE_ISSUE_CODE("WM_OUTSOURCE_ISSUE_CODE", "Subcontract issue order code."),
    DV_MACHINERY_CODE("DV_MACHINERY_CODE", "Device code."),
    DV_MACHINERY_TYPE_CODE("DV_MACHINERY_TYPE_CODE", "Device type code."),
    DV_SUBJECT_CODE("DV_SUBJECT_CODE", "Inspection and maintenance item code."),
    DV_CHECK_PLAN_CODE("DV_CHECK_PLAN_CODE", "Inspection and maintenance plan code."),
    DV_REPAIR_CODE("DV_REPAIR_CODE", "Maintenance order code."),
    WM_SALES_NOTICE_CODE("WM_SALES_NOTICE_CODE", "Shipping notification order code."),
    WM_RETURN_SALES_CODE("WM_RETURN_SALES_CODE", "Sales return code."),
    WM_MISC_ISSUE_CODE("WM_MISC_ISSUE_CODE", "Miscellaneous outbound order code."),
    PRO_ROUTE_CODE("PRO_ROUTE_CODE", "Routing path code."),
    PRO_FEEDBACK_CODE("PRO_FEEDBACK_CODE", "Work-report number"),
    PRO_WORK_ORDER_CODE("PRO_WORK_ORDER_CODE", "Production work order code."),
    QC_DEFECT_CODE("QC_DEFECT_CODE", "Defect type code."),
    QC_INDICATOR_RESULT_CODE("QC_INDICATOR_RESULT_CODE", "Sample result number"),
    WM_OUTSOURCE_RECEIPT_CODE("WM_OUTSOURCE_RECEIPT_CODE", "Subcontract inbound order code.");

    /**
     * 规则代码
     */
    private final String code;
    /**
     * 规则名称
     */
    private final String name;

}
