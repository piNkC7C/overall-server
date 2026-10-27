package cn.iocoder.yudao.module.trade.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Trade 错误码枚举类
 * trade 系统，使用 1-011-000-000 段
 *
 * @author LeeYan9
 * @since 2022-08-26
 */
public interface ErrorCodeConstants {

    // ========== Order module 1-011-000-000 ==========
    ErrorCode ORDER_ITEM_NOT_FOUND = new ErrorCode(1_011_000_010, "Trade order item was not found.");
    ErrorCode ORDER_NOT_FOUND = new ErrorCode(1_011_000_011, "Trade order was not found.");
    ErrorCode ORDER_ITEM_UPDATE_AFTER_SALE_STATUS_FAIL = new ErrorCode(1_011_000_012, "Trade order item update after-sales status failed, please retry.");
    ErrorCode ORDER_UPDATE_PAID_STATUS_NOT_UNPAID = new ErrorCode(1_011_000_013, "Trade orderupdate payment status failed, order is not [ unpaid ] status.");
    ErrorCode ORDER_UPDATE_PAID_FAIL_PAY_ORDER_ID_ERROR = new ErrorCode(1_011_000_014, "Trade orderupdate payment status failed, payment order code does not match.");
    ErrorCode ORDER_UPDATE_PAID_FAIL_PAY_ORDER_STATUS_NOT_SUCCESS = new ErrorCode(1_011_000_015, "Trade orderupdate payment status failed, payment order status is not [ payment succeeded] status.");
    ErrorCode ORDER_UPDATE_PAID_FAIL_PAY_PRICE_NOT_MATCH = new ErrorCode(1_011_000_016, "Trade orderupdate payment status failed, payment order amount does not match.");
    ErrorCode ORDER_DELIVERY_FAIL_STATUS_NOT_UNDELIVERED = new ErrorCode(1_011_000_017, "Trade order shipping failed, order is not [ pending shipping ] status.");
    ErrorCode ORDER_RECEIVE_FAIL_STATUS_NOT_DELIVERED = new ErrorCode(1_011_000_018, "Trade order receiving failed, order is not [ pending receiving ] status.");
    ErrorCode ORDER_COMMENT_FAIL_STATUS_NOT_COMPLETED = new ErrorCode(1_011_000_019, "Create trade order item review failed, order is not [completed] status.");
    ErrorCode ORDER_COMMENT_STATUS_NOT_FALSE = new ErrorCode(1_011_000_020, "Create trade order item review failed, order already review.");
    ErrorCode ORDER_DELIVERY_FAIL_REFUND_STATUS_NOT_NONE = new ErrorCode(1_011_000_021, "Shipment failed because the order is refunded or partly refunded.");
    ErrorCode ORDER_DELIVERY_FAIL_COMBINATION_RECORD_STATUS_NOT_SUCCESS = new ErrorCode(1_011_000_022, "Trade order shipping failed, group buy not succeeded.");
    ErrorCode ORDER_DELIVERY_FAIL_BARGAIN_RECORD_STATUS_NOT_SUCCESS = new ErrorCode(1_011_000_023, "Trade order shipping failed, bargain not succeeded.");
    ErrorCode ORDER_DELIVERY_FAIL_DELIVERY_TYPE_NOT_EXPRESS = new ErrorCode(1_011_000_024, "Shipment failed because the shipping type is not courier.");
    ErrorCode ORDER_CANCEL_FAIL_STATUS_NOT_UNPAID = new ErrorCode(1_011_000_025, "Trade ordercancel failed, order is not [ pending payment ] status.");
    ErrorCode ORDER_UPDATE_PRICE_FAIL_PAID = new ErrorCode(1_011_000_026, "Price adjust failed because the payment is already paid.");
    ErrorCode ORDER_UPDATE_PRICE_FAIL_ALREADY = new ErrorCode(1_011_000_027, "Price adjust failed because the price was already changed.");
    ErrorCode ORDER_UPDATE_PRICE_FAIL_PRICE_ERROR = new ErrorCode(1_011_000_028, "Adjusted payment price cannot be less than $0.01.");
    ErrorCode ORDER_DELETE_FAIL_STATUS_NOT_CANCEL = new ErrorCode(1_011_000_029, "Trade orderCould not delete, order is not [canceled] status.");
    ErrorCode ORDER_RECEIVE_FAIL_DELIVERY_TYPE_NOT_PICK_UP = new ErrorCode(1_011_000_030, "Trade order pickup failed, receiving method is not [user pickup ].");
    ErrorCode ORDER_UPDATE_ADDRESS_FAIL_STATUS_NOT_DELIVERED = new ErrorCode(1_011_000_031, "Shipping address can be changed only when the order is awaiting shipment.");
    ErrorCode ORDER_CREATE_FAIL_EXIST_UNPAID = new ErrorCode(1_011_000_032, "Trade ordercreate failed, : exists not payment order.");
    ErrorCode ORDER_CANCEL_PAID_FAIL = new ErrorCode(1_011_000_033, "Trade ordercancel payment failed, : order is not [{}] status.");
    ErrorCode ORDER_UPDATE_PAID_ORDER_REFUNDED_FAIL_REFUND_NOT_FOUND = new ErrorCode(1_011_000_034, "Trade orderupdatepayment refund status failed, : refund was not found.");
    ErrorCode ORDER_UPDATE_PAID_ORDER_REFUNDED_FAIL_REFUND_STATUS_NOT_SUCCESS = new ErrorCode(1_011_000_035, "Trade orderupdatepayment refund status failed, : refund status is not [ refund succeeded].");
    ErrorCode ORDER_PICK_UP_FAIL_NOT_VERIFY_USER = new ErrorCode(1_011_000_036, "You do not have permission to check in this store pickup order.");
    ErrorCode ORDER_PICK_UP_FAIL_COMBINATION_NOT_SUCCESS = new ErrorCode(1_011_000_037, "Trade order pickup failed, : product group buy record is not [ succeeded] status.");
    ErrorCode ORDER_CREATE_FAIL_INSUFFICIENT_USER_POINTS = new ErrorCode(1_011_000_038, "Trade ordercreate failed, : user points is insufficient.");
    ErrorCode ORDER_PICK_UP_FAIL_STATUS_NOT_UNDELIVERED = new ErrorCode(1_011_000_039, "Pickup failed because the order is not awaiting check-in.");

    // ========== After Sale module 1-011-000-100 ==========
    ErrorCode AFTER_SALE_NOT_FOUND = new ErrorCode(1_011_000_100, "After-sales order was not found.");
    ErrorCode AFTER_SALE_CREATE_FAIL_REFUND_PRICE_ERROR = new ErrorCode(1_011_000_101, "Refund amount is invalid.");
    ErrorCode AFTER_SALE_CREATE_FAIL_ORDER_STATUS_CANCELED = new ErrorCode(1_011_000_102, "Order closed, cannot apply please after-sales.");
    ErrorCode AFTER_SALE_CREATE_FAIL_ORDER_STATUS_NO_PAID = new ErrorCode(1_011_000_103, "Order unpaid, cannot apply please after-sales.");
    ErrorCode AFTER_SALE_CREATE_FAIL_ORDER_STATUS_NO_DELIVERED = new ErrorCode(1_011_000_104, "Order not shipping, cannot apply please [ return refund ] after-sales.");
    ErrorCode AFTER_SALE_CREATE_FAIL_ORDER_ITEM_APPLIED = new ErrorCode(1_011_000_105, "Order item already apply please after-sales, cannot is duplicated apply please.");
    ErrorCode AFTER_SALE_AUDIT_FAIL_STATUS_NOT_APPLY = new ErrorCode(1_011_000_106, "Approval failed, after-sales status not at approval.");
    ErrorCode AFTER_SALE_UPDATE_STATUS_FAIL = new ErrorCode(1_011_000_107, "After-sales action failed. Refresh and try again.");
    ErrorCode AFTER_SALE_DELIVERY_FAIL_STATUS_NOT_SELLER_AGREE = new ErrorCode(1_011_000_108, "Return failed because the after-sales order is not awaiting buyer return.");
    ErrorCode AFTER_SALE_CONFIRM_FAIL_STATUS_NOT_BUYER_DELIVERY = new ErrorCode(1_011_000_109, "Confirm receiving failed, after-sales order status not at [ pending confirm receiving ].");
    ErrorCode AFTER_SALE_REFUND_FAIL_STATUS_NOT_WAIT_REFUND = new ErrorCode(1_011_000_110, "Refund failed, after-sales order status is not [ pending refund ].");
    ErrorCode AFTER_SALE_REFUND_FAIL_REFUND_NOT_FOUND = new ErrorCode(1_011_000_111, "Refund failed, refund was not found.");
    ErrorCode AFTER_SALE_REFUND_FAIL_REFUND_NOT_SUCCESS_OR_FAILURE = new ErrorCode(1_011_000_112, "Refund failed, refund not refund.");
    ErrorCode AFTER_SALE_REFUND_FAIL_REFUND_PRICE_NOT_MATCH = new ErrorCode(1_011_000_113, "Refund failed, refund amount does not match.");
    ErrorCode AFTER_SALE_REFUND_FAIL_REFUND_ORDER_ID_ERROR = new ErrorCode(1_011_000_114, "Refund failed, refund does not match.");
    ErrorCode AFTER_SALE_CANCEL_FAIL_STATUS_NOT_APPLY_OR_AGREE_OR_BUYER_DELIVERY =
            new ErrorCode(1_011_000_115, "Cancel failed because the after-sales status is not pending review, seller approved, or awaiting merchant receipt.");
    ErrorCode AFTER_SALE_CREATE_FAIL_ORDER_STATUS_COMBINATION_IN_PROGRESS = new ErrorCode(1_011_000_116, "Order group buy, cannot apply please after-sales.");

    // ========== Cart module 1-011-002-000 ==========
    ErrorCode CARD_ITEM_NOT_FOUND = new ErrorCode(1_011_002_000, "Cart item not found.");

    // ========== Price 相关 1-011-003-000 ============
    ErrorCode PRICE_CALCULATE_PAY_PRICE_ILLEGAL = new ErrorCode(1_011_003_000, "Payment price must be greater than 0.");
    ErrorCode PRICE_CALCULATE_DELIVERY_PRICE_TEMPLATE_NOT_FOUND = new ErrorCode(1_011_003_001, "Shipping-fee calculation failed: freight template not found.");
    ErrorCode PRICE_CALCULATE_COUPON_NOT_MATCH_NORMAL_ORDER = new ErrorCode(1_011_003_002, "Flash-sale, group-buy, and bargain products cannot use coupons.");
    ErrorCode PRICE_CALCULATE_SECKILL_TOTAL_LIMIT_COUNT = new ErrorCode(1_011_003_003, "This product exceeded the flash-sale purchase limit.");
    ErrorCode PRICE_CALCULATE_POINT_TOTAL_LIMIT_COUNT = new ErrorCode(1_011_003_004, "This product exceeded the points-activity purchase limit.");
    ErrorCode PRICE_CALCULATE_DELIVERY_PRICE_TYPE_ILLEGAL = new ErrorCode(1_011_003_005, "Shipping-fee calculation failed: delivery method does not match.");
    ErrorCode PRICE_CALCULATE_COUPON_CAN_NOT_USE = new ErrorCode(1_011_003_006, "This coupon cannot used, : {}」.");

    // ========== 物流 Express 模块 1-011-004-000 ==========
    ErrorCode EXPRESS_NOT_EXISTS = new ErrorCode(1_011_004_000, "Courier company not found.");
    ErrorCode EXPRESS_CODE_DUPLICATE = new ErrorCode(1_011_004_001, "A courier company with this code already exists.");
    ErrorCode EXPRESS_CLIENT_NOT_PROVIDE = new ErrorCode(1_011_004_002, "Connect a courier provider, such as Kuaidi100.");
    ErrorCode EXPRESS_STATUS_NOT_ENABLE = new ErrorCode(1_011_004_003, "The courier company is disabled.");

    ErrorCode EXPRESS_API_QUERY_ERROR = new ErrorCode(1_011_004_101, "Courier tracking API failed.");
    ErrorCode EXPRESS_API_QUERY_FAILED = new ErrorCode(1_011_004_102, "Courier tracking failed: {}.");

    // ========== 物流 Template 模块 1-011-005-000 ==========
    ErrorCode EXPRESS_TEMPLATE_NAME_DUPLICATE = new ErrorCode(1_011_005_000, "A freight template with this name already exists.");
    ErrorCode EXPRESS_TEMPLATE_NOT_EXISTS = new ErrorCode(1_011_005_001, "Freight template not found.");

    // ==========  物流 PICK_UP 模块 1-011-006-000 ==========
    ErrorCode PICK_UP_STORE_NOT_EXISTS = new ErrorCode(1_011_006_000, "Pickup store not found.");
    ErrorCode PICK_UP_STORE_STAFF_NOT_EXISTS = new ErrorCode(1_011_006_000, "Pickup store clerk not found.");

    // ========== 分销用户 模块 1-011-007-000 ==========
    ErrorCode BROKERAGE_USER_NOT_EXISTS = new ErrorCode(1_011_007_000, "Affiliate user not found.");
    ErrorCode BROKERAGE_USER_FROZEN_PRICE_NOT_ENOUGH = new ErrorCode(1_011_007_001, "Frozen commission ({}) is insufficient.");
    ErrorCode BROKERAGE_BIND_SELF = new ErrorCode(1_011_007_002, "Cannot bind your own.");
    ErrorCode BROKERAGE_BIND_USER_NOT_ENABLED = new ErrorCode(1_011_007_003, "The bound user is not eligible to promote.");
    ErrorCode BROKERAGE_BIND_CONDITION_ADMIN = new ErrorCode(1_011_007_004, "Promoters can be bound only in the admin console.");
    ErrorCode BROKERAGE_BIND_MODE_REGISTER = new ErrorCode(1_011_007_005, "Only in register time can bind.");
    ErrorCode BROKERAGE_BIND_OVERRIDE = new ErrorCode(1_011_007_006, "A promoter is already bound.");
    ErrorCode BROKERAGE_BIND_LOOP = new ErrorCode(1_011_007_007, "Level cannot bind its own level.");
    ErrorCode BROKERAGE_USER_LEVEL_NOT_SUPPORT = new ErrorCode(1_011_007_008, "Only levels less than or equal to 2 are supported.");
    ErrorCode BROKERAGE_CREATE_USER_EXISTS = new ErrorCode(1_011_007_009, "Affiliate user already exists.");

    // ========== 分销提现 模块 1-011-008-000 ==========
    ErrorCode BROKERAGE_WITHDRAW_NOT_EXISTS = new ErrorCode(1_011_008_000, "Commission withdrawal not found.");
    ErrorCode BROKERAGE_WITHDRAW_STATUS_NOT_AUDITING = new ErrorCode(1_011_008_001, "The commission withdrawal is not pending review.");
    ErrorCode BROKERAGE_WITHDRAW_MIN_PRICE = new ErrorCode(1_011_008_002, "Withdrawal amount cannot be less than ${}.");
    ErrorCode BROKERAGE_WITHDRAW_USER_BALANCE_NOT_ENOUGH = new ErrorCode(1_011_008_003, "You can withdraw up to ${}.");
    ErrorCode BROKERAGE_WITHDRAW_UPDATE_STATUS_FAIL_PAY_TRANSFER_ID_ERROR = new ErrorCode(1_011_008_005, "Withdrawal order update transfer status failed, transfer order does not match.");
    ErrorCode BROKERAGE_WITHDRAW_UPDATE_STATUS_FAIL_PAY_TRANSFER_STATUS_NOT_SUCCESS_OR_CLOSED = new ErrorCode(1_011_008_006, "Withdrawal order update transfer status failed, transfer order status is not succeeded or disable status.");
    ErrorCode BROKERAGE_WITHDRAW_UPDATE_STATUS_FAIL_PAY_PRICE_NOT_MATCH = new ErrorCode(1_011_008_007, "Withdrawal order update transfer status failed, transfer order amount does not match.");
    ErrorCode BROKERAGE_WITHDRAW_UPDATE_STATUS_FAIL_PAY_MERCHANT_EXISTS = new ErrorCode(1_011_008_008, "Failed to update withdrawal transfer status: merchant orders do not match.");
    ErrorCode BROKERAGE_WITHDRAW_UPDATE_STATUS_FAIL_PAY_CHANNEL_NOT_MATCH = new ErrorCode(1_011_008_009, "Withdrawal order update transfer status failed, transfer channel does not match.");

}
