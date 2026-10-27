package cn.iocoder.yudao.module.product.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Product 错误码枚举类
 *
 * product 系统，使用 1-008-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 商品分类相关 1-008-001-000 ============
    ErrorCode CATEGORY_NOT_EXISTS = new ErrorCode(1_008_001_000, "Product category was not found.");
    ErrorCode CATEGORY_PARENT_NOT_EXISTS = new ErrorCode(1_008_001_001, "Parent category was not found.");
    ErrorCode CATEGORY_PARENT_NOT_FIRST_LEVEL = new ErrorCode(1_008_001_002, "Parent category cannot be second-level category.");
    ErrorCode CATEGORY_EXISTS_CHILDREN = new ErrorCode(1_008_001_003, "Exists child category, cannot delete.");
    ErrorCode CATEGORY_DISABLED = new ErrorCode(1_008_001_004, "Product category({}) is disabled, cannot used.");
    ErrorCode CATEGORY_HAVE_BIND_SPU = new ErrorCode(1_008_001_005, "Class still has product, cannot delete.");
    ErrorCode CATEGORY_PARENT_IS_SELF = new ErrorCode(1_008_001_006, "Parent category cannot set is category itself.");

    // ========== 商品品牌相关编号 1-008-002-000 ==========
    ErrorCode BRAND_NOT_EXISTS = new ErrorCode(1_008_002_000, "Brand was not found.");
    ErrorCode BRAND_DISABLED = new ErrorCode(1_008_002_001, "Brand is disabled.");
    ErrorCode BRAND_NAME_EXISTS = new ErrorCode(1_008_002_002, "Brand name already exists.");

    // ========== product attribute item 1-008-003-000 ==========
    ErrorCode PROPERTY_NOT_EXISTS = new ErrorCode(1_008_003_000, "Property item was not found.");
    ErrorCode PROPERTY_EXISTS = new ErrorCode(1_008_003_001, "Property item name already exists.");
    ErrorCode PROPERTY_DELETE_FAIL_VALUE_EXISTS = new ErrorCode(1_008_003_002, "Attribute item still has attribute value, cannot delete.");

    // ========== 商品属性值 1-008-004-000 ==========
    ErrorCode PROPERTY_VALUE_NOT_EXISTS = new ErrorCode(1_008_004_000, "Attribute value was not found.");
    ErrorCode PROPERTY_VALUE_EXISTS = new ErrorCode(1_008_004_001, "Attribute value name already exists.");

    // ========== product SPU 1-008-005-000 ==========
    ErrorCode SPU_NOT_EXISTS = new ErrorCode(1_008_005_000, "Product SPU was not found.");
    ErrorCode SPU_SAVE_FAIL_CATEGORY_LEVEL_ERROR = new ErrorCode(1_008_005_001, "Use a second-level or lower product category.");
    ErrorCode SPU_SAVE_FAIL_COUPON_TEMPLATE_NOT_EXISTS = new ErrorCode(1_008_005_002, "Failed to save the SPU because the coupon was not found.");
    ErrorCode SPU_NOT_ENABLE = new ErrorCode(1_008_005_003, "Product SPU[{}] not at put away status.");
    ErrorCode SPU_NOT_RECYCLE = new ErrorCode(1_008_005_004, "Product SPU not at recycle bin status.");

    // ========== product SKU 1-008-006-000 ==========
    ErrorCode SKU_NOT_EXISTS = new ErrorCode(1_008_006_000, "Product SKU was not found.");
    ErrorCode SKU_PROPERTIES_DUPLICATED = new ErrorCode(1_008_006_001, "The SKU has a duplicate attribute combination.");
    ErrorCode SPU_ATTR_NUMBERS_MUST_BE_EQUALS = new ErrorCode(1_008_006_002, "Every SKU under an SPU must use the same attribute items.");
    ErrorCode SPU_SKU_NOT_DUPLICATE = new ErrorCode(1_008_006_003, "One SPU each SKU, must not is duplicated.");
    ErrorCode SKU_STOCK_NOT_ENOUGH = new ErrorCode(1_008_006_004, "Product SKU inventory is insufficient.");
    ErrorCode SKU_PROPERTIES_EMPTY = new ErrorCode(1_008_006_005, "Multi-spec products must choose an attribute combination from the spec list.");

    // ========== product review 1-008-007-000 ==========
    ErrorCode COMMENT_NOT_EXISTS = new ErrorCode(1_008_007_000, "Product review was not found.");
    ErrorCode COMMENT_ORDER_EXISTS = new ErrorCode(1_008_007_001, "Order product review already exists.");

    // ========== product Favorite 1-008-008-000 ==========
    ErrorCode FAVORITE_EXISTS = new ErrorCode(1_008_008_000, "This product is already in favorites.");
    ErrorCode FAVORITE_NOT_EXISTS = new ErrorCode(1_008_008_001, "Product favorite not found.");

}
