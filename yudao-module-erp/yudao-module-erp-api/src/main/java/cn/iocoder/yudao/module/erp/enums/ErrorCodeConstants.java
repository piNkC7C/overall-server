package cn.iocoder.yudao.module.erp.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * ERP 错误码枚举类
 * <p>
 * erp 系统，使用 1-030-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== ERP supplier (1-030-100-000) ==========
    ErrorCode SUPPLIER_NOT_EXISTS = new ErrorCode(1_030_100_000, "Supplier was not found.");
    ErrorCode SUPPLIER_NOT_ENABLE = new ErrorCode(1_030_100_000, "Supplier({}) is not enabled.");

    // ========== ERP purchase order (1-030-101-000) ==========
    ErrorCode PURCHASE_ORDER_NOT_EXISTS = new ErrorCode(1_030_101_000, "Purchase order was not found.");
    ErrorCode PURCHASE_ORDER_DELETE_FAIL_APPROVE = new ErrorCode(1_030_101_001, "Purchase order({}) approved, cannot delete.");
    ErrorCode PURCHASE_ORDER_PROCESS_FAIL = new ErrorCode(1_030_101_002, "Could not reverse approval, Only approved purchase order can reverse approval.");
    ErrorCode PURCHASE_ORDER_APPROVE_FAIL = new ErrorCode(1_030_101_003, "Could not approve, Only unapproved purchase order can approval.");
    ErrorCode PURCHASE_ORDER_NO_EXISTS = new ErrorCode(1_030_101_004, "Create purchase order no. failed, submit again.");
    ErrorCode PURCHASE_ORDER_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_101_005, "Purchase order({}) approved, cannot be edited.");
    ErrorCode PURCHASE_ORDER_NOT_APPROVE = new ErrorCode(1_030_101_006, "Purchase order unapproved, cannot action.");
    ErrorCode PURCHASE_ORDER_ITEM_IN_FAIL_PRODUCT_EXCEED = new ErrorCode(1_030_101_007, "Purchase order line ({}) exceeds the max inbound quantity ({}).");
    ErrorCode PURCHASE_ORDER_PROCESS_FAIL_EXISTS_IN = new ErrorCode(1_030_101_008, "Could not reverse approval, already exists a matching purchase receipt.");
ErrorCode PURCHASE_ORDER_ITEM_RETURN_FAIL_IN_EXCEED = new ErrorCode(1_030_101_009, "Purchase order line ({}) exceeds the max return quantity ({}).");
    ErrorCode PURCHASE_ORDER_PROCESS_FAIL_EXISTS_RETURN = new ErrorCode(1_030_101_010, "Could not reverse approval, already exists a matching purchase return order.");

    // ========== ERP purchase inbound (1-030-102-000) ==========
    ErrorCode PURCHASE_IN_NOT_EXISTS = new ErrorCode(1_030_102_000, "Purchase receipt was not found.");
    ErrorCode PURCHASE_IN_DELETE_FAIL_APPROVE = new ErrorCode(1_030_102_001, "Purchase receipt({}) approved, cannot delete.");
    ErrorCode PURCHASE_IN_PROCESS_FAIL = new ErrorCode(1_030_102_002, "Could not reverse approval, Only approved inbound order can reverse approval.");
    ErrorCode PURCHASE_IN_APPROVE_FAIL = new ErrorCode(1_030_102_003, "Could not approve, Only unapproved inbound order can approval.");
    ErrorCode PURCHASE_IN_NO_EXISTS = new ErrorCode(1_030_102_004, "Could not create the inbound order, submit again.");
    ErrorCode PURCHASE_IN_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_102_005, "Purchase receipt({}) approved, cannot be edited.");
    ErrorCode PURCHASE_IN_NOT_APPROVE = new ErrorCode(1_030_102_006, "Purchase receipt unapproved, cannot action.");
    ErrorCode PURCHASE_IN_FAIL_PAYMENT_PRICE_EXCEED = new ErrorCode(1_030_102_007, "Payment amount ({}) exceeds purchase receipt total amount ({}).");
    ErrorCode PURCHASE_IN_PROCESS_FAIL_EXISTS_PAYMENT = new ErrorCode(1_030_102_008, "Could not reverse approval, already exists a matching payment order.");

    // ========== ERP purchase return (1-030-103-000) ==========
    ErrorCode PURCHASE_RETURN_NOT_EXISTS = new ErrorCode(1_030_103_000, "Purchase return order was not found.");
    ErrorCode PURCHASE_RETURN_DELETE_FAIL_APPROVE = new ErrorCode(1_030_103_001, "Purchase return order({}) approved, cannot delete.");
    ErrorCode PURCHASE_RETURN_PROCESS_FAIL = new ErrorCode(1_030_103_002, "Could not reverse approval, Only approved return order can reverse approval.");
    ErrorCode PURCHASE_RETURN_APPROVE_FAIL = new ErrorCode(1_030_103_003, "Could not approve, Only unapproved return order can approval.");
    ErrorCode PURCHASE_RETURN_NO_EXISTS = new ErrorCode(1_030_103_004, "Could not create the return order, submit again.");
    ErrorCode PURCHASE_RETURN_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_103_005, "Purchase return order({}) approved, cannot be edited.");
    ErrorCode PURCHASE_RETURN_NOT_APPROVE = new ErrorCode(1_030_103_006, "Purchase return order unapproved, cannot action.");
    ErrorCode PURCHASE_RETURN_FAIL_REFUND_PRICE_EXCEED = new ErrorCode(1_030_103_007, "Refund amount ({}) exceeds purchase return order total amount ({}).");
    ErrorCode PURCHASE_RETURN_PROCESS_FAIL_EXISTS_REFUND = new ErrorCode(1_030_103_008, "Could not reverse approval, already exists a matching refund.");

    // ========== ERP customer (1-030-200-000)==========
    ErrorCode CUSTOMER_NOT_EXISTS = new ErrorCode(1_020_200_000, "Customer was not found.");
    ErrorCode CUSTOMER_NOT_ENABLE = new ErrorCode(1_020_200_001, "Customer({}) is not enabled.");

    // ========== ERP sales order (1-030-201-000) ==========
    ErrorCode SALE_ORDER_NOT_EXISTS = new ErrorCode(1_020_201_000, "Sales order was not found.");
    ErrorCode SALE_ORDER_DELETE_FAIL_APPROVE = new ErrorCode(1_020_201_001, "Sales order({}) approved, cannot delete.");
    ErrorCode SALE_ORDER_PROCESS_FAIL = new ErrorCode(1_020_201_002, "Could not reverse approval, Only approved sales order can reverse approval.");
    ErrorCode SALE_ORDER_APPROVE_FAIL = new ErrorCode(1_020_201_003, "Could not approve, Only unapproved sales order can approval.");
    ErrorCode SALE_ORDER_NO_EXISTS = new ErrorCode(1_020_201_004, "Create sales order no. failed, submit again.");
    ErrorCode SALE_ORDER_UPDATE_FAIL_APPROVE = new ErrorCode(1_020_201_005, "Sales order({}) approved, cannot be edited.");
    ErrorCode SALE_ORDER_NOT_APPROVE = new ErrorCode(1_020_201_006, "Sales order unapproved, cannot action.");
    ErrorCode SALE_ORDER_ITEM_OUT_FAIL_PRODUCT_EXCEED = new ErrorCode(1_020_201_007, "Sales order line ({}) exceeds the max outbound quantity ({}).");
    ErrorCode SALE_ORDER_PROCESS_FAIL_EXISTS_OUT = new ErrorCode(1_020_201_008, "Could not reverse approval, already exists a matching sales shipment.");
    ErrorCode SALE_ORDER_ITEM_RETURN_FAIL_OUT_EXCEED = new ErrorCode(1_020_201_009, "Sales order line ({}) exceeds the max return quantity ({}).");
    ErrorCode SALE_ORDER_PROCESS_FAIL_EXISTS_RETURN = new ErrorCode(1_020_201_010, "Could not reverse approval, already exists a matching sales return.");

    // ========== ERP sales outbound (1-030-202-000) ==========
    ErrorCode SALE_OUT_NOT_EXISTS = new ErrorCode(1_020_202_000, "Sales shipment was not found.");
    ErrorCode SALE_OUT_DELETE_FAIL_APPROVE = new ErrorCode(1_020_202_001, "Sales shipment({}) approved, cannot delete.");
    ErrorCode SALE_OUT_PROCESS_FAIL = new ErrorCode(1_020_202_002, "Could not reverse approval, Only approved outbound order can reverse approval.");
    ErrorCode SALE_OUT_APPROVE_FAIL = new ErrorCode(1_020_202_003, "Could not approve, Only unapproved outbound order can approval.");
    ErrorCode SALE_OUT_NO_EXISTS = new ErrorCode(1_020_202_004, "Createoutbound order failed, submit again.");
    ErrorCode SALE_OUT_UPDATE_FAIL_APPROVE = new ErrorCode(1_020_202_005, "Sales shipment({}) approved, cannot be edited.");
    ErrorCode SALE_OUT_NOT_APPROVE = new ErrorCode(1_020_202_006, "Sales shipment unapproved, cannot action.");
    ErrorCode SALE_OUT_FAIL_RECEIPT_PRICE_EXCEED = new ErrorCode(1_020_202_007, "Receipt amount ({}) exceeds sales shipment total amount ({}).");
    ErrorCode SALE_OUT_PROCESS_FAIL_EXISTS_RECEIPT = new ErrorCode(1_020_202_008, "Could not reverse approval, already exists a matching receipt order.");

    // ========== ERP sales return (1-030-203-000) ==========
    ErrorCode SALE_RETURN_NOT_EXISTS = new ErrorCode(1_020_203_000, "Sales return was not found.");
    ErrorCode SALE_RETURN_DELETE_FAIL_APPROVE = new ErrorCode(1_020_203_001, "Sales return({}) approved, cannot delete.");
    ErrorCode SALE_RETURN_PROCESS_FAIL = new ErrorCode(1_020_203_002, "Could not reverse approval, Only approved return order can reverse approval.");
    ErrorCode SALE_RETURN_APPROVE_FAIL = new ErrorCode(1_020_203_003, "Could not approve, Only unapproved return order can approval.");
    ErrorCode SALE_RETURN_NO_EXISTS = new ErrorCode(1_020_203_004, "Could not create the return order, submit again.");
    ErrorCode SALE_RETURN_UPDATE_FAIL_APPROVE = new ErrorCode(1_020_203_005, "Sales return({}) approved, cannot be edited.");
    ErrorCode SALE_RETURN_NOT_APPROVE = new ErrorCode(1_020_203_006, "Sales return unapproved, cannot action.");
    ErrorCode SALE_RETURN_FAIL_REFUND_PRICE_EXCEED = new ErrorCode(1_020_203_007, "Refund amount ({}) exceeds sales return total amount ({}).");
    ErrorCode SALE_RETURN_PROCESS_FAIL_EXISTS_REFUND = new ErrorCode(1_020_203_008, "Could not reverse approval, already exists a matching refund.");

    // ========== ERP warehouse 1-030-400-000 ==========
    ErrorCode WAREHOUSE_NOT_EXISTS = new ErrorCode(1_030_400_000, "Warehouse was not found.");
    ErrorCode WAREHOUSE_NOT_ENABLE = new ErrorCode(1_030_400_001, "Warehouse({}) is not enabled.");

    // ========== ERP other inbound order 1-030-401-000 ==========
    ErrorCode STOCK_IN_NOT_EXISTS = new ErrorCode(1_030_401_000, "Other inbound order was not found.");
    ErrorCode STOCK_IN_DELETE_FAIL_APPROVE = new ErrorCode(1_030_401_001, "Other inbound order({}) approved, cannot delete.");
    ErrorCode STOCK_IN_PROCESS_FAIL = new ErrorCode(1_030_401_002, "Could not reverse approval, Only approved inbound order can reverse approval.");
    ErrorCode STOCK_IN_APPROVE_FAIL = new ErrorCode(1_030_401_003, "Could not approve, Only unapproved inbound order can approval.");
    ErrorCode STOCK_IN_NO_EXISTS = new ErrorCode(1_030_401_004, "Could not create the inbound order, submit again.");
    ErrorCode STOCK_IN_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_401_005, "Other inbound order({}) approved, cannot be edited.");

    // ========== ERP other outbound order 1-030-402-000 ==========
    ErrorCode STOCK_OUT_NOT_EXISTS = new ErrorCode(1_030_402_000, "Other outbound order was not found.");
    ErrorCode STOCK_OUT_DELETE_FAIL_APPROVE = new ErrorCode(1_030_402_001, "Other outbound order({}) approved, cannot delete.");
    ErrorCode STOCK_OUT_PROCESS_FAIL = new ErrorCode(1_030_402_002, "Could not reverse approval, Only approved outbound order can reverse approval.");
    ErrorCode STOCK_OUT_APPROVE_FAIL = new ErrorCode(1_030_402_003, "Could not approve, Only unapproved outbound order can approval.");
    ErrorCode STOCK_OUT_NO_EXISTS = new ErrorCode(1_030_402_004, "Createoutbound order failed, submit again.");
    ErrorCode STOCK_OUT_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_402_005, "Other outbound order({}) approved, cannot be edited.");

    // ========== ERP inventory transfer order 1-030-403-000 ==========
    ErrorCode STOCK_MOVE_NOT_EXISTS = new ErrorCode(1_030_402_000, "Inventory transfer order was not found.");
    ErrorCode STOCK_MOVE_DELETE_FAIL_APPROVE = new ErrorCode(1_030_402_001, "Inventory transfer order ({}) approved, cannot delete.");
    ErrorCode STOCK_MOVE_PROCESS_FAIL = new ErrorCode(1_030_402_002, "Could not reverse approval, Only approved transfer order can reverse approval.");
    ErrorCode STOCK_MOVE_APPROVE_FAIL = new ErrorCode(1_030_402_003, "Could not approve, Only unapproved transfer order can approval.");
    ErrorCode STOCK_MOVE_NO_EXISTS = new ErrorCode(1_030_402_004, "Create transfer no. failed, submit again.");
    ErrorCode STOCK_MOVE_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_402_005, "Inventory transfer order ({}) approved, cannot be edited.");

    // ========== ERP inventory stocktake order 1-030-403-000 ==========
    ErrorCode STOCK_CHECK_NOT_EXISTS = new ErrorCode(1_030_403_000, "Inventory stocktake order was not found.");
    ErrorCode STOCK_CHECK_DELETE_FAIL_APPROVE = new ErrorCode(1_030_403_001, "Inventory stocktake order ({}) approved, cannot delete.");
    ErrorCode STOCK_CHECK_PROCESS_FAIL = new ErrorCode(1_030_403_002, "Could not reverse approval, Only approved stocktake order can reverse approval.");
    ErrorCode STOCK_CHECK_APPROVE_FAIL = new ErrorCode(1_030_403_003, "Could not approve, Only unapproved stocktake order can approval.");
    ErrorCode STOCK_CHECK_NO_EXISTS = new ErrorCode(1_030_403_004, "Create stocktake no. failed, submit again.");
    ErrorCode STOCK_CHECK_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_403_005, "Inventory stocktake order ({}) approved, cannot be edited.");

    // ========== ERP productinventory 1-030-404-000 ==========
    ErrorCode STOCK_COUNT_NEGATIVE = new ErrorCode(1_030_404_000, "Inventory for product ({}) in warehouse ({}) is {}, which is less than the change {}.");
    ErrorCode STOCK_COUNT_NEGATIVE2 = new ErrorCode(1_030_404_001, "The action failed, product({}) in warehouse({}) inventory is insufficient.");

    // ========== ERP product 1-030-500-000 ==========
    ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(1_030_500_000, "Product was not found.");
    ErrorCode PRODUCT_NOT_ENABLE = new ErrorCode(1_030_500_001, "Product({}) is not enabled.");
    ErrorCode PRODUCT_DELETE_FAIL_PURCHASE_ORDER_EXISTS = new ErrorCode(1_030_500_002, "Product is already used by purchase order referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_PURCHASE_IN_EXISTS = new ErrorCode(1_030_500_003, "Product is already used by purchase receipt referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_PURCHASE_RETURN_EXISTS = new ErrorCode(1_030_500_004, "Product is already used by purchase return order referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_SALE_ORDER_EXISTS = new ErrorCode(1_030_500_005, "Product is already used by sales order referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_SALE_OUT_EXISTS = new ErrorCode(1_030_500_006, "Product is already used by sales shipment referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_SALE_RETURN_EXISTS = new ErrorCode(1_030_500_007, "Product is already used by sales return referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_STOCK_IN_EXISTS = new ErrorCode(1_030_500_008, "Product is already used by other inbound order referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_STOCK_OUT_EXISTS = new ErrorCode(1_030_500_009, "Product is already used by other outbound order referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_STOCK_CHECK_EXISTS = new ErrorCode(1_030_500_010, "Product is already used by stocktake order referenced, cannot delete.");

    // ========== ERP product category 1-030-501-000 ==========
    ErrorCode PRODUCT_CATEGORY_NOT_EXISTS = new ErrorCode(1_030_501_000, "Product category was not found.");
    ErrorCode PRODUCT_CATEGORY_EXITS_CHILDREN = new ErrorCode(1_030_501_001, "Exists exists child product category, cannot delete.");
    ErrorCode PRODUCT_CATEGORY_PARENT_NOT_EXITS = new ErrorCode(1_030_501_002,"Parent product category was not found.");
    ErrorCode PRODUCT_CATEGORY_PARENT_ERROR = new ErrorCode(1_030_501_003, "Cannot set itself as parent product category.");
    ErrorCode PRODUCT_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_030_501_004, "Already exists this category name product category.");
    ErrorCode PRODUCT_CATEGORY_PARENT_IS_CHILD = new ErrorCode(1_030_501_005, "Cannot set its own child category is parent category.");
    ErrorCode PRODUCT_CATEGORY_EXITS_PRODUCT = new ErrorCode(1_030_502_002, "Exists product used this category, cannot delete.");

    // ========== ERP product order characters 1-030-502-000 ==========
    ErrorCode PRODUCT_UNIT_NOT_EXISTS = new ErrorCode(1_030_502_000, "Product order was not found.");
    ErrorCode PRODUCT_UNIT_NAME_DUPLICATE = new ErrorCode(1_030_502_001, "Already exists this name product order.");
    ErrorCode PRODUCT_UNIT_EXITS_PRODUCT = new ErrorCode(1_030_502_002, "Exists product used this order, cannot delete.");

    // ========== ERP Settlement Account 1-030-600-000 ==========
    ErrorCode ACCOUNT_NOT_EXISTS = new ErrorCode(1_030_600_000, "Settlement account not found.");
    ErrorCode ACCOUNT_NOT_ENABLE = new ErrorCode(1_030_600_001, "Settlement account ({}) is disabled.");

    // ========== ERP payment order 1-030-601-000 ==========
    ErrorCode FINANCE_PAYMENT_NOT_EXISTS = new ErrorCode(1_030_601_000, "Payment order was not found.");
    ErrorCode FINANCE_PAYMENT_DELETE_FAIL_APPROVE = new ErrorCode(1_030_601_001, "Payment order ({}) approved, cannot delete.");
    ErrorCode FINANCE_PAYMENT_PROCESS_FAIL = new ErrorCode(1_030_601_002, "Could not reverse approval, Only approved payment order can reverse approval.");
    ErrorCode FINANCE_PAYMENT_APPROVE_FAIL = new ErrorCode(1_030_601_003, "Could not approve, Only unapproved payment order can approval.");
    ErrorCode FINANCE_PAYMENT_NO_EXISTS = new ErrorCode(1_030_601_004, "Create payment order no. failed, submit again.");
    ErrorCode FINANCE_PAYMENT_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_601_005, "Payment order ({}) approved, cannot be edited.");

    // ========== ERP receipt order 1-030-602-000 ==========
    ErrorCode FINANCE_RECEIPT_NOT_EXISTS = new ErrorCode(1_030_602_000, "Receipt order was not found.");
    ErrorCode FINANCE_RECEIPT_DELETE_FAIL_APPROVE = new ErrorCode(1_030_602_001, "Receipt order ({}) approved, cannot delete.");
    ErrorCode FINANCE_RECEIPT_PROCESS_FAIL = new ErrorCode(1_030_602_002, "Could not reverse approval, Only approved receipt order can reverse approval.");
    ErrorCode FINANCE_RECEIPT_APPROVE_FAIL = new ErrorCode(1_030_602_003, "Could not approve, Only unapproved receipt order can approval.");
    ErrorCode FINANCE_RECEIPT_NO_EXISTS = new ErrorCode(1_030_602_004, "Create receipt order no. failed, submit again.");
    ErrorCode FINANCE_RECEIPT_UPDATE_FAIL_APPROVE = new ErrorCode(1_030_602_005, "Receipt order ({}) approved, cannot be edited.");

}
