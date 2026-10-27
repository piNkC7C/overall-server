package cn.iocoder.yudao.module.promotion.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Promotion 错误码枚举类
 * <p>
 * promotion 系统，使用 1-013-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 促销活动相关 1-013-001-000 ============
    ErrorCode DISCOUNT_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_001_000, "Limit time discount campaign was not found.");
    ErrorCode DISCOUNT_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_001_001, "A product is already in another flash-sale [{}].");
    ErrorCode DISCOUNT_ACTIVITY_UPDATE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_001_002, "Limit time discount campaign closed, cannot edit.");
    ErrorCode DISCOUNT_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED = new ErrorCode(1_013_001_003, "Limit time discount campaign not disable, cannot be deleted.");
    ErrorCode DISCOUNT_ACTIVITY_CLOSE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_001_004, "Limit time discount campaign closed, cannot is duplicated disable.");

    // ========== Banner 相关 1-013-002-000 ============
    ErrorCode BANNER_NOT_EXISTS = new ErrorCode(1_013_002_000, "Banner was not found.");

    // ========== Coupon 相关 1-013-003-000 ============

    // ========== coupontemplate 1-013-004-000 ==========
    ErrorCode COUPON_TEMPLATE_NOT_EXISTS = new ErrorCode(1_013_004_000, "Coupontemplate was not found.");
    ErrorCode COUPON_TEMPLATE_TOTAL_COUNT_TOO_SMALL = new ErrorCode(1_013_004_001, "Issued quantity cannot be less than claimed quantity ({}).");
    ErrorCode COUPON_TEMPLATE_NOT_ENOUGH = new ErrorCode(1_013_004_002, "Remaining quantity is not enough to claim.");
    ErrorCode COUPON_TEMPLATE_USER_ALREADY_TAKE = new ErrorCode(1_013_004_003, "The user already claimed this coupon.");
    ErrorCode COUPON_TEMPLATE_EXPIRED = new ErrorCode(1_013_004_004, "The coupon has expired.");
    ErrorCode COUPON_TEMPLATE_CANNOT_TAKE = new ErrorCode(1_013_004_005, "Invalid claim method.");

    // ========== coupon 1-013-005-000 ==========
    ErrorCode COUPON_NOT_EXISTS = new ErrorCode(1_013_005_000, "Coupon was not found.");
    ErrorCode COUPON_DELETE_FAIL_USED = new ErrorCode(1_013_005_001, "Cannot recycle the coupon because it was already used.");
    ErrorCode COUPON_STATUS_NOT_UNUSED = new ErrorCode(1_013_005_002, "Coupon not at pending used status.");
    ErrorCode COUPON_VALID_TIME_NOT_NOW = new ErrorCode(1_013_005_003, "The coupon is outside its valid time range.");
    ErrorCode COUPON_STATUS_NOT_USED = new ErrorCode(1_013_005_004, "Coupon is not already used status.");

    // ========== spend-and-save campaign 1-013-006-000 ==========
    ErrorCode REWARD_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_006_000, "Spend-and-save campaign was not found.");
    ErrorCode REWARD_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_006_001, "A product is already in another spend-and-save activity in this time range.");
    ErrorCode REWARD_ACTIVITY_UPDATE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_006_002, "Spend-and-save campaign closed, cannot edit.");
    ErrorCode REWARD_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED = new ErrorCode(1_013_006_003, "Spend-and-save campaign not disable, cannot be deleted.");
    ErrorCode REWARD_ACTIVITY_CLOSE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_006_004, "Spend-and-save campaign closed, cannot is duplicated disable.");
    ErrorCode REWARD_ACTIVITY_SCOPE_EXISTS = new ErrorCode(1_013_006_005, "Conflicts with spend-and-save [{}] product scope: {}.");

    // ========== points shop campaign 1-013-007-000 ==========
    ErrorCode POINT_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_007_000, "Points shop campaign was not found.");
    ErrorCode POINT_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_007_001, "A product is already in another points-mall activity.");
    ErrorCode POINT_ACTIVITY_UPDATE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_007_002, "Points shop campaign closed, cannot edit.");
    ErrorCode POINT_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED_OR_END = new ErrorCode(1_013_007_003, "Points shop campaign not disable or not end, cannot be deleted.");
    ErrorCode POINT_ACTIVITY_CLOSE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_007_004, "Points shop campaign closed, cannot is duplicated disable.");
    ErrorCode POINT_ACTIVITY_JOIN_ACTIVITY_STATUS_CLOSED = new ErrorCode(1_013_007_005, "Points redemption failed because the activity is closed.");
    ErrorCode POINT_ACTIVITY_JOIN_ACTIVITY_SINGLE_LIMIT_COUNT_EXCEED = new ErrorCode(1_013_007_006, "Points redemption failed because the per-order limit was exceeded.");
    ErrorCode POINT_ACTIVITY_JOIN_ACTIVITY_PRODUCT_NOT_EXISTS = new ErrorCode(1_013_007_007, "Points redemption failed because the product was not found.");
    ErrorCode POINT_ACTIVITY_UPDATE_STOCK_FAIL = new ErrorCode(1_013_007_008, "Points redemption failed because inventory is insufficient.");

    // ========== flash sale campaign 1-013-008-000 ==========
    ErrorCode SECKILL_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_008_000, "Flash sale campaign was not found.");
    ErrorCode SECKILL_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_008_002, "A product is already in another flash sale in this time slot.");
    ErrorCode SECKILL_ACTIVITY_UPDATE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_008_003, "Flash sale campaign closed, cannot edit.");
    ErrorCode SECKILL_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED_OR_END = new ErrorCode(1_013_008_004, "Flash sale campaign not disable or not end, cannot be deleted.");
    ErrorCode SECKILL_ACTIVITY_CLOSE_FAIL_STATUS_CLOSED = new ErrorCode(1_013_008_005, "Flash sale campaign closed, cannot is duplicated disable.");
    ErrorCode SECKILL_ACTIVITY_UPDATE_STOCK_FAIL = new ErrorCode(1_013_008_006, "Flash sale failed, : flash sale inventory is insufficient.");
    ErrorCode SECKILL_JOIN_ACTIVITY_TIME_ERROR = new ErrorCode(1_013_008_007, "Flash sale failed because it is outside the activity window.");
    ErrorCode SECKILL_JOIN_ACTIVITY_STATUS_CLOSED = new ErrorCode(1_013_008_008, "Flash sale failed, : flash sale campaign closed.");
    ErrorCode SECKILL_JOIN_ACTIVITY_SINGLE_LIMIT_COUNT_EXCEED = new ErrorCode(1_013_008_009, "Flash sale failed because the per-order limit was exceeded.");
    ErrorCode SECKILL_JOIN_ACTIVITY_PRODUCT_NOT_EXISTS = new ErrorCode(1_013_008_010, "Flash sale failed, : product was not found.");

    // ========== 秒杀时段 1-013-009-000 ==========
    ErrorCode SECKILL_CONFIG_NOT_EXISTS = new ErrorCode(1_013_009_000, "Flash sale time segment was not found.");
    ErrorCode SECKILL_CONFIG_TIME_CONFLICTS = new ErrorCode(1_013_009_001, "Flash sale time segment conflict.");
    ErrorCode SECKILL_CONFIG_DISABLE = new ErrorCode(1_013_009_004, "Flash sale time segment closed.");

    // ========== group buy campaign 1-013-010-000 ==========
    ErrorCode COMBINATION_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_010_000, "Group buy campaign was not found.");
    ErrorCode COMBINATION_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_010_001, "A product is already in another group-buy activity.");
    ErrorCode COMBINATION_ACTIVITY_STATUS_DISABLE_NOT_UPDATE = new ErrorCode(1_013_010_002, "Group buy campaign closed cannot edit.");
    ErrorCode COMBINATION_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED_OR_END = new ErrorCode(1_013_010_003, "Group buy campaign not disable or not end, cannot be deleted.");
    ErrorCode COMBINATION_ACTIVITY_STATUS_DISABLE = new ErrorCode(1_013_010_004, "Group buy failed, : group buy campaign closed.");
    ErrorCode COMBINATION_JOIN_ACTIVITY_PRODUCT_NOT_EXISTS = new ErrorCode(1_013_010_005, "Group buy failed, : group buy campaignproduct was not found.");
    ErrorCode COMBINATION_ACTIVITY_UPDATE_STOCK_FAIL = new ErrorCode(1_013_010_006, "Group buy failed, : group buy campaignproductinventory is insufficient.");

    // ========== group buy record 1-013-011-000 ==========
    ErrorCode COMBINATION_RECORD_NOT_EXISTS = new ErrorCode(1_013_011_000, "Group buy was not found.");
    ErrorCode COMBINATION_RECORD_EXISTS = new ErrorCode(1_013_011_001, "Group buy failed because you already joined.");
    ErrorCode COMBINATION_RECORD_HEAD_NOT_EXISTS = new ErrorCode(1_013_011_002, "Group buy failed, parent group buy was not found.");
    ErrorCode COMBINATION_RECORD_USER_FULL = new ErrorCode(1_013_011_003, "Group buy failed because it is full.");
    ErrorCode COMBINATION_RECORD_FAILED_HAVE_JOINED = new ErrorCode(1_013_011_004, "Group buy failed, : exists this campaign is currently group buy record.");
    ErrorCode COMBINATION_RECORD_FAILED_TIME_NOT_START = new ErrorCode(1_013_011_005, "Group buy failed, campaign not start.");
    ErrorCode COMBINATION_RECORD_FAILED_TIME_END = new ErrorCode(1_013_011_006, "Group buy failed, campaign already end.");
    ErrorCode COMBINATION_RECORD_FAILED_SINGLE_LIMIT_COUNT_EXCEED = new ErrorCode(1_013_011_007, "Group buy failed because the per-order limit was exceeded.");
    ErrorCode COMBINATION_RECORD_FAILED_TOTAL_LIMIT_COUNT_EXCEED = new ErrorCode(1_013_011_008, "Group buy failed because the total purchase limit was exceeded.");
    ErrorCode COMBINATION_RECORD_FAILED_ORDER_STATUS_UNPAID = new ErrorCode(1_013_011_009, "Group buy failed, : exists not payment, first payment.");

    // ========== bargain campaign 1-013-012-000 ==========
    ErrorCode BARGAIN_ACTIVITY_NOT_EXISTS = new ErrorCode(1_013_012_000, "Bargain campaign was not found.");
    ErrorCode BARGAIN_ACTIVITY_SPU_CONFLICTS = new ErrorCode(1_013_012_001, "A product is already in another bargain activity.");
    ErrorCode BARGAIN_ACTIVITY_STATUS_DISABLE = new ErrorCode(1_013_012_002, "Bargain campaign closed, cannot edit.");
    ErrorCode BARGAIN_ACTIVITY_DELETE_FAIL_STATUS_NOT_CLOSED_OR_END = new ErrorCode(1_013_012_003, "Bargain campaign not disable or not end, cannot be deleted.");
    ErrorCode BARGAIN_ACTIVITY_STOCK_NOT_ENOUGH = new ErrorCode(1_013_012_004, "Bargain campaigninventory is insufficient.");
    ErrorCode BARGAIN_ACTIVITY_STATUS_CLOSED = new ErrorCode(1_013_012_005, "Bargain campaign closed.");
    ErrorCode BARGAIN_ACTIVITY_TIME_END = new ErrorCode(1_013_012_006, "Bargain campaign already end.");

    // ========== bargain record 1-013-013-000 ==========
    ErrorCode BARGAIN_RECORD_NOT_EXISTS = new ErrorCode(1_013_013_000, "Bargain record was not found.");
    ErrorCode BARGAIN_RECORD_CREATE_FAIL_EXISTS = new ErrorCode(1_013_013_001, "And failed, you already and current bargain campaign.");
    ErrorCode BARGAIN_RECORD_CREATE_FAIL_LIMIT = new ErrorCode(1_013_013_002, "And failed, you already reached current bargain campaign and limit.");
    ErrorCode BARGAIN_JOIN_RECORD_NOT_SUCCESS = new ErrorCode(1_013_013_004, "Order failed, bargain not succeeded.");
    ErrorCode BARGAIN_JOIN_RECORD_ALREADY_ORDER = new ErrorCode(1_013_013_005, "Order failed, this bargain already order.");

    // ========== bargain assist 1-013-014-000 ==========
    ErrorCode BARGAIN_HELP_CREATE_FAIL_RECORD_NOT_IN_PROCESS = new ErrorCode(1_013_014_000, "Assist failed, bargain record not at in progress.");
    ErrorCode BARGAIN_HELP_CREATE_FAIL_RECORD_SELF = new ErrorCode(1_013_014_001, "Assist failed, cannot assist your own.");
    ErrorCode BARGAIN_HELP_CREATE_FAIL_LIMIT = new ErrorCode(1_013_014_002, "Assist failed, you already reached current bargain campaign assist limit.");
    ErrorCode BARGAIN_HELP_CREATE_FAIL_CONFLICT = new ErrorCode(1_013_014_003, "Assist failed, please retry.");
    ErrorCode BARGAIN_HELP_CREATE_FAIL_HELP_EXISTS = new ErrorCode(1_013_014_004, "You already helped this bargain.");

    // ========== articlecategory 1-013-015-000 ==========
    ErrorCode ARTICLE_CATEGORY_NOT_EXISTS = new ErrorCode(1_013_015_000, "Articlecategory was not found.");
    ErrorCode ARTICLE_CATEGORY_DELETE_FAIL_HAVE_ARTICLES = new ErrorCode(1_013_015_001, "ArticlecategoryCould not delete, exists related article.");

    // ========== article admin 1-013-016-000 ==========
    ErrorCode ARTICLE_NOT_EXISTS = new ErrorCode(1_013_016_000, "Article was not found.");

    // ========== 装修模板 1-013-017-000 ==========
    ErrorCode DIY_TEMPLATE_NOT_EXISTS = new ErrorCode(1_013_017_000, "Decor template not found.");
    ErrorCode DIY_TEMPLATE_NAME_USED = new ErrorCode(1_013_017_001, "Decor template name ({}) is already used.");
    ErrorCode DIY_TEMPLATE_USED_CANNOT_DELETE = new ErrorCode(1_013_017_002, "A decor template in use cannot be deleted.");

    // ========== 装修页面 1-013-018-000 ==========
    ErrorCode DIY_PAGE_NOT_EXISTS = new ErrorCode(1_013_018_000, "Decor page not found.");
    ErrorCode DIY_PAGE_NAME_USED = new ErrorCode(1_013_018_001, "Decor page name ({}) is already used.");

    // ========== 客服会话 1-013-019-000 ==========
    ErrorCode KEFU_CONVERSATION_NOT_EXISTS = new ErrorCode(1_013_019_000, "Support conversation not found.");

    // ========== 客服消息 1-013-020-000 ==========
    ErrorCode KEFU_MESSAGE_NOT_EXISTS = new ErrorCode(1_013_020_000, "Support message not found.");

}
