package cn.iocoder.yudao.module.wms.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * WMS 错误码枚举类
 * <p>
 * wms 系统，使用 1-060-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== WMS 基础数据-仓库 1-060-100-000 ==========
    ErrorCode WAREHOUSE_NOT_EXISTS = new ErrorCode(1_060_100_000, "Warehouse was not found.");
    ErrorCode WAREHOUSE_NAME_DUPLICATE = new ErrorCode(1_060_100_001, "Warehouse name is duplicated.");
    ErrorCode WAREHOUSE_CODE_DUPLICATE = new ErrorCode(1_060_100_002, "Warehouse code is duplicated.");
    ErrorCode WAREHOUSE_HAS_ORDER = new ErrorCode(1_060_100_004, "Could not delete! warehouse is already used by {} used!");
    ErrorCode WAREHOUSE_HAS_INVENTORY = new ErrorCode(1_060_100_005, "Could not delete! warehouse already existson-hand inventory!");

    // ========== WMS 基础数据-商品分类 1-060-102-000 ==========
    ErrorCode ITEM_CATEGORY_NOT_EXISTS = new ErrorCode(1_060_102_000, "Product category was not found.");
    ErrorCode ITEM_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_060_102_001, "Product category name is already used.");
    ErrorCode ITEM_CATEGORY_PARENT_NOT_EXISTS = new ErrorCode(1_060_102_002, "Parent product category was not found.");
    ErrorCode ITEM_CATEGORY_PARENT_ERROR = new ErrorCode(1_060_102_003, "Cannot set itself as parent product category.");
    ErrorCode ITEM_CATEGORY_PARENT_IS_CHILD = new ErrorCode(1_060_102_004, "Cannot set its own child product category is parent product category.");
    ErrorCode ITEM_CATEGORY_HAS_CHILDREN = new ErrorCode(1_060_102_005, "Could not delete! delete its child category!");
    ErrorCode ITEM_CATEGORY_HAS_ITEM = new ErrorCode(1_060_102_006, "Could not delete! category is already used by product used!");
    ErrorCode ITEM_CATEGORY_CODE_DUPLICATE = new ErrorCode(1_060_102_007, "Product category code is already used.");

    // ========== WMS 基础数据-商品品牌 1-060-103-000 ==========
    ErrorCode ITEM_BRAND_NOT_EXISTS = new ErrorCode(1_060_103_000, "Product brand was not found.");
    ErrorCode ITEM_BRAND_HAS_ITEM = new ErrorCode(1_060_103_001, "Could not delete! brand is already used by product used!");
    ErrorCode ITEM_BRAND_CODE_DUPLICATE = new ErrorCode(1_060_103_002, "Product brand code is already used.");
    ErrorCode ITEM_BRAND_NAME_DUPLICATE = new ErrorCode(1_060_103_003, "Product brand name is already used.");

    // ========== WMS 基础数据-商品 1-060-104-000 ==========
    ErrorCode ITEM_NOT_EXISTS = new ErrorCode(1_060_104_000, "Product was not found.");
    ErrorCode ITEM_NAME_DUPLICATE = new ErrorCode(1_060_104_001, "Product name is already used.");
    ErrorCode ITEM_CODE_DUPLICATE = new ErrorCode(1_060_104_007, "Product code is already used.");
    ErrorCode ITEM_SKU_REQUIRED = new ErrorCode(1_060_104_002, "Add at least one SKU.");
    ErrorCode ITEM_SKU_NAME_DUPLICATE = new ErrorCode(1_060_104_003, "SKU name[{}] is duplicated.");
    ErrorCode ITEM_SKU_NOT_EXISTS = new ErrorCode(1_060_104_004, "SKU was not found.");
    ErrorCode ITEM_SKU_HAS_INVENTORY = new ErrorCode(1_060_104_005, "Could not delete! SKU[{}] is already used by inventory business used!");
    ErrorCode ITEM_SKU_HAS_ORDER = new ErrorCode(1_060_104_006, "Could not delete! SKU[{}] is already used by {} used!");

    // ========== WMS 基础数据-往来企业 1-060-105-000 ==========
    ErrorCode MERCHANT_NOT_EXISTS = new ErrorCode(1_060_105_000, "Business partner was not found.");
    ErrorCode MERCHANT_NOT_SUPPLIER = new ErrorCode(1_060_105_001, "Business partner must be supplier or customer/supplier type.");
    ErrorCode MERCHANT_NOT_CUSTOMER = new ErrorCode(1_060_105_002, "Business partner must be customer or customer/supplier type.");
    ErrorCode MERCHANT_HAS_ORDER = new ErrorCode(1_060_105_003, "Could not delete! business partner is already used by {} used!");
    ErrorCode MERCHANT_CODE_DUPLICATE = new ErrorCode(1_060_105_004, "Business partner code is already used.");
    ErrorCode MERCHANT_NAME_DUPLICATE = new ErrorCode(1_060_105_005, "Business partner name is already used.");

    // ========== WMS inbound order 1-060-200-000 ==========
    ErrorCode RECEIPT_ORDER_NOT_EXISTS = new ErrorCode(1_060_200_000, "Inbound order was not found.");
    ErrorCode RECEIPT_ORDER_NO_DUPLICATE = new ErrorCode(1_060_200_001, "Inbound order no. is duplicated.");
    ErrorCode RECEIPT_ORDER_STATUS_NOT_PREPARE = new ErrorCode(1_060_200_002, "Inbound order status is not draft, cannot be changed.");
    ErrorCode RECEIPT_ORDER_DETAIL_REQUIRED = new ErrorCode(1_060_200_003, "Inbound order at least include one item detail.");
    ErrorCode RECEIPT_ORDER_STATUS_NOT_DELETABLE = new ErrorCode(1_060_200_005, "Only draft or voided inbound orders can be deleted.");
    ErrorCode RECEIPT_ORDER_DETAIL_NOT_EXISTS = new ErrorCode(1_060_200_007, "Inbound orderdetail was not found.");

    // ========== WMS outbound order 1-060-201-000 ==========
    ErrorCode SHIPMENT_ORDER_NOT_EXISTS = new ErrorCode(1_060_201_000, "Outbound order was not found.");
    ErrorCode SHIPMENT_ORDER_NO_DUPLICATE = new ErrorCode(1_060_201_001, "Outbound order no. is duplicated.");
    ErrorCode SHIPMENT_ORDER_STATUS_NOT_PREPARE = new ErrorCode(1_060_201_002, "Outbound order status is not draft, cannot be changed.");
    ErrorCode SHIPMENT_ORDER_DETAIL_REQUIRED = new ErrorCode(1_060_201_003, "Outbound order at least include one item detail.");
    ErrorCode SHIPMENT_ORDER_STATUS_NOT_DELETABLE = new ErrorCode(1_060_201_005, "Only draft or voided outbound orders can be deleted.");
    ErrorCode SHIPMENT_ORDER_DETAIL_NOT_EXISTS = new ErrorCode(1_060_201_007, "Outbound orderdetail was not found.");

    // ========== WMS warehouse transfer order 1-060-202-000 ==========
    ErrorCode MOVEMENT_ORDER_NOT_EXISTS = new ErrorCode(1_060_202_000, "Warehouse transfer order was not found.");
    ErrorCode MOVEMENT_ORDER_NO_DUPLICATE = new ErrorCode(1_060_202_001, "Warehouse transfer order no. is duplicated.");
    ErrorCode MOVEMENT_ORDER_STATUS_NOT_PREPARE = new ErrorCode(1_060_202_002, "Warehouse transfer order status is not draft, cannot be changed.");
    ErrorCode MOVEMENT_ORDER_DETAIL_REQUIRED = new ErrorCode(1_060_202_003, "Warehouse transfer order at least include one item detail.");
    ErrorCode MOVEMENT_ORDER_STATUS_NOT_DELETABLE = new ErrorCode(1_060_202_005, "Only draft or voided warehouse transfers can be deleted.");
    ErrorCode MOVEMENT_ORDER_DETAIL_NOT_EXISTS = new ErrorCode(1_060_202_006, "Warehouse transfer order detail was not found.");
    ErrorCode MOVEMENT_ORDER_WAREHOUSE_SAME = new ErrorCode(1_060_202_007, "Source warehouse and target warehouse cannot the same.");

    // ========== WMS inventory count order 1-060-203-000 ==========
    ErrorCode CHECK_ORDER_NOT_EXISTS = new ErrorCode(1_060_203_000, "Inventory count order was not found.");
    ErrorCode CHECK_ORDER_NO_DUPLICATE = new ErrorCode(1_060_203_001, "Inventory count order no. is duplicated.");
    ErrorCode CHECK_ORDER_STATUS_NOT_PREPARE = new ErrorCode(1_060_203_002, "Inventory count order status is not draft, cannot be changed.");
    ErrorCode CHECK_ORDER_DETAIL_REQUIRED = new ErrorCode(1_060_203_003, "Inventory count order at least include one item detail.");
    ErrorCode CHECK_ORDER_STATUS_NOT_DELETABLE = new ErrorCode(1_060_203_005, "Only draft or voided inventory counts can be deleted.");
    ErrorCode CHECK_ORDER_DETAIL_NOT_EXISTS = new ErrorCode(1_060_203_006, "Inventory count order detail was not found.");
    ErrorCode CHECK_ORDER_INVENTORY_CHANGED = new ErrorCode(1_060_203_007, "Inventory changed. Reload stock before completing the count.");

    // ========== WMS inventory 1-060-300-000 ==========
    ErrorCode INVENTORY_QUANTITY_NOT_ENOUGH = new ErrorCode(1_060_300_000,
            "Insufficient inventory. Product: {}, SKU: {}, warehouse: {}, on hand: {}, change: {}.");

}
