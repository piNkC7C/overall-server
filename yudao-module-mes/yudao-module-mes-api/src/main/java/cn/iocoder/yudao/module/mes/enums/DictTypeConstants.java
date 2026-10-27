package cn.iocoder.yudao.module.mes.enums;

/**
 * MES 字典类型的枚举类
 *
 * @author 芋道源码
 */
public interface DictTypeConstants {

    // ========== 基础数据 (MD) ==========
    String MES_MD_ITEM_OR_PRODUCT = "mes_md_item_or_product"; // MES material product key
    String MES_MD_AUTO_CODE_PART_TYPE = "mes_md_auto_code_part_type"; // MES segment type
    String MES_MD_AUTO_CODE_CYCLE_METHOD = "mes_md_auto_code_cycle_method"; // MES 循环方式
    String MES_MD_AUTO_CODE_PADDED_METHOD = "mes_md_auto_code_padded_method"; // MES 补齐方式
    String MES_CLIENT_TYPE = "mes_client_type"; // MES customer type
    String MES_VENDOR_LEVEL = "mes_vendor_level"; // MES supplier level

    // ========== production plan and execute (PRO) ==========
    String MES_PRO_WORK_ORDER_STATUS = "mes_pro_work_order_status"; // MES production work order status
    String MES_PRO_WORK_ORDER_SOURCE_TYPE = "mes_pro_work_order_source_type"; // MES work order source type
    String MES_PRO_WORK_ORDER_TYPE = "mes_pro_work_order_type"; // MES work order type
    String MES_PRO_LINK_TYPE = "mes_pro_link_type"; // MES operationRelationship type
    String MES_TIME_UNIT_TYPE = "mes_time_unit_type"; // MES time order characters
    String MES_PRO_ANDON_STATUS = "mes_pro_andon_status"; // MES 安灯处置状态
    String MES_PRO_ANDON_LEVEL = "mes_pro_andon_level"; // MES 安灯级别
    String MES_PRO_WORK_RECORD_TYPE = "mes_pro_work_record_type"; // MES 上下工状态类型
    String MES_PRO_FEEDBACK_STATUS = "mes_pro_feedback_status"; // MES production work report status
    String MES_PRO_FEEDBACK_TYPE = "mes_pro_feedback_type"; // MES production work report type
    String MES_PRO_FEEDBACK_CHANNEL = "mes_pro_feedback_channel"; // MES 生产报工途径
    String MES_PRO_TASK_STATUS = "mes_pro_task_status"; // MES task status

    // ========== 仓储条码与管理 (WM) ==========
    String MES_BARCODE_FORMAT = "mes_barcode_format"; // MES barcode format
    String MES_BARCODE_BIZ_TYPE = "mes_barcode_biz_type"; // MES barcode business type
    String MES_WM_TRANSACTION_TYPE = "mes_wm_transaction_type"; // MES 库存事务类型
    String MES_WM_QUALITY_STATUS = "mes_wm_quality_status"; // MES 质量状态（待检/合格/不合格）

    // ========== 仓储入库 (WM Receipt) ==========
    String MES_WM_ARRIVAL_NOTICE_STATUS = "mes_wm_arrival_notice_status"; // MES receiving notification order status
    String MES_WM_ITEM_RECEIPT_STATUS = "mes_wm_item_receipt_status"; // MES purchase receipt status
    String MES_WM_PRODUCT_PRODUCE_STATUS = "mes_wm_product_produce_status"; // MES production inbound order status
    String MES_WM_MISC_RECEIPT_TYPE = "mes_wm_misc_receipt_type"; // MES miscellaneous inbound type
    String MES_WM_MISC_RECEIPT_STATUS = "mes_wm_misc_receipt_status"; // MES miscellaneous inbound status
    String MES_WM_OUTSOURCE_RECEIPT_STATUS = "mes_wm_outsource_receipt_status"; // MES 委外入库状态
    String MES_WM_PRODUCT_RECEIPT_STATUS = "mes_wm_product_receipt_status"; // MES product inbound status
    String MES_WM_RETURN_ISSUE_TYPE = "mes_wm_return_issue_type"; // MES production material return type
    String MES_WM_RETURN_ISSUE_STATUS = "mes_wm_return_issue_status"; // MES production material return order status
    String MES_WM_RETURN_SALES_STATUS = "mes_wm_return_sales_status"; // MES sales return status

    // ========== 仓储出库 (WM Issue) ==========
    String MES_WM_MISC_ISSUE_TYPE = "mes_wm_misc_issue_type"; // MES miscellaneous outbound type
    String MES_WM_MISC_ISSUE_STATUS = "mes_wm_misc_issue_status"; // MES miscellaneous outbound order status
    String MES_WM_SALES_NOTICE_STATUS = "mes_wm_sales_notice_status"; // MES shipping notification order status
    String MES_WM_PRODUCT_SALES_STATUS = "mes_wm_product_sales_status"; // MES sales shipment status
    String MES_WM_OUTSOURCE_ISSUE_STATUS = "mes_wm_outsource_issue_status"; // MES 委外出库状态
    String MES_WM_PRODUCT_ISSUE_STATUS = "mes_wm_product_issue_status"; // MES production material issue status
    String MES_WM_RETURN_VENDOR_STATUS = "mes_wm_return_vendor_status"; // MES supplierreturn order status

    // ========== 仓储移库与盘点 (WM Transfer) ==========
    String MES_WM_TRANSFER_STATUS = "mes_wm_transfer_status"; // MES transfer order status
    String MES_WM_TRANSFER_TYPE = "mes_wm_transfer_type"; // MES transfer order type
    String MES_WM_STOCK_TAKING_PLAN_PARAM_TYPE = "mes_wm_stock_taking_plan_param_type"; // MES 盘点参数值类型
    String MES_WM_STOCK_TAKING_TYPE = "mes_wm_stock_taking_type"; // MES stocktake type
    String MES_WM_STOCK_TAKING_TASK_STATUS = "mes_wm_stock_taking_task_status"; // MES stocktake task status
    String MES_WM_STOCK_TAKING_TASK_LINE_STATUS = "mes_wm_stock_taking_task_line_status"; // MES stocktake taskdetail status
    
    // ========== 其它仓储 (WM Misc) ==========
    String MES_WM_PACKAGE_STATUS = "mes_wm_package_status"; // MES 打包状态
    String MES_WM_ITEM_CONSUME_STATUS = "mes_wm_item_consume_status"; // MES 物料消耗状态

    // ========== quality admin (QC) ==========
    String MES_INDICATOR_TYPE = "mes_indicator_type"; // MES inspect item type
    String MES_QC_RESULT_TYPE = "mes_qc_result_type"; // MES 质检结果值类型
    String MES_DEFECT_LEVEL = "mes_defect_level"; // MES defect level
    String MES_QC_TYPE = "mes_qc_type"; // MES Inspection Type (IQC/IPQC/OQC/RQC)
    String MES_IPQC_TYPE = "mes_ipqc_type"; // MES IPQC inspection type
    String MES_ORDER_STATUS = "mes_order_status"; // MES 单据状态（IQC/IPQC/OQC/RQC 通用）
    String MES_QC_CHECK_RESULT = "mes_qc_check_result"; // MES inspection result
    String MES_QC_SOURCE_DOC_TYPE = "mes_qc_source_doc_type"; // MES source document type

    // ========== device admin (DV) ==========
    String MES_DV_MACHINERY_STATUS = "mes_dv_machinery_status"; // MES device status
    String MES_DV_SUBJECT_TYPE = "mes_dv_subject_type"; // MES inspection and maintenance item type
    String MES_DV_CYCLE_TYPE = "mes_dv_cycle_type"; // MES inspection and maintenance Cycle Type
    String MES_DV_CHECK_PLAN_STATUS = "mes_dv_check_plan_status"; // MES inspection and maintenance plan status
    String MES_MAINTEN_RECORD_STATUS = "mes_mainten_record_status"; // MES maintenance record status
    String MES_MAINTEN_STATUS = "mes_mainten_status"; // MES maintenance result
    String MES_DV_CHECK_RECORD_STATUS = "mes_dv_check_record_status"; // MES inspection record status
    String MES_DV_CHECK_RESULT = "mes_dv_check_result"; // MES inspection result
    String MES_DV_REPAIR_STATUS = "mes_dv_repair_status"; // MES repair work order status
    String MES_DV_REPAIR_RESULT = "mes_dv_repair_result"; // MES maintenance result

    // ========== 排班日历 (CAL) ==========
    String MES_CAL_HOLIDAY_TYPE = "mes_cal_holiday_type"; // MES holiday type
    String MES_CAL_SHIFT_TYPE = "mes_cal_shift_type"; // MES rotation method
    String MES_CAL_SHIFT_METHOD = "mes_cal_shift_method"; // MES shift rotation method
    String MES_CAL_CALENDAR_TYPE = "mes_cal_calendar_type"; // MES team type
    String MES_CAL_PLAN_STATUS = "mes_cal_plan_status"; // MES schedule plan status

    // ========== tool admin (TM) ==========
    String MES_TM_TOOL_STATUS = "mes_tm_tool_status"; // MES tool status
    String MES_TM_MAINTEN_TYPE = "mes_tm_mainten_type"; // MES Maintenance Type
}
