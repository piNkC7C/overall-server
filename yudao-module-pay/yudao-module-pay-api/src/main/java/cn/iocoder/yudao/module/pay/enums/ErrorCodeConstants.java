package cn.iocoder.yudao.module.pay.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Pay 错误码 Core 枚举类
 *
 * pay 系统，使用 1-007-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== APP module 1-007-000-000 ==========
    ErrorCode APP_NOT_FOUND = new ErrorCode(1_007_000_000, "App was not found.");
    ErrorCode APP_IS_DISABLE = new ErrorCode(1_007_000_002, "App already by forbidden.");
    ErrorCode APP_EXIST_ORDER_CANT_DELETE =  new ErrorCode(1_007_000_003, "Payment app exists payment, cannot delete.");
    ErrorCode APP_EXIST_REFUND_CANT_DELETE =  new ErrorCode(1_007_000_004, "Payment app exists refund, cannot delete.");
    ErrorCode APP_KEY_EXISTS = new ErrorCode(1_007_000_005, "Payment app key already exists.");

    // ========== CHANNEL module 1-007-001-000 ==========
    ErrorCode CHANNEL_NOT_FOUND = new ErrorCode(1_007_001_000, "Payment channel setting was not found.");
    ErrorCode CHANNEL_IS_DISABLE = new ErrorCode(1_007_001_001, "Payment channel already forbidden.");
    ErrorCode CHANNEL_EXIST_SAME_CHANNEL_ERROR = new ErrorCode(1_007_001_004, "Already exists the same channel.");

    // ========== ORDER module 1-007-002-000 ==========
    ErrorCode PAY_ORDER_NOT_FOUND = new ErrorCode(1_007_002_000, "Payment was not found.");
    ErrorCode PAY_ORDER_STATUS_IS_NOT_WAITING = new ErrorCode(1_007_002_001, "Payment not at pending payment.");
    ErrorCode PAY_ORDER_STATUS_IS_SUCCESS = new ErrorCode(1_007_002_002, "The order is already paid. Refresh the page.");
    ErrorCode PAY_ORDER_IS_EXPIRED = new ErrorCode(1_007_002_003, "The payment has expired.");
    ErrorCode PAY_ORDER_SUBMIT_CHANNEL_ERROR = new ErrorCode(1_007_002_004, "Payment failed. Error code: {}. Message: {}.");
    ErrorCode PAY_ORDER_REFUND_FAIL_STATUS_ERROR = new ErrorCode(1_007_002_005, "Payment refund failed, : status is not already payment or already refund.");

    // ========== ORDER 模块(拓展单) 1-007-003-000 ==========
    ErrorCode PAY_ORDER_EXTENSION_NOT_FOUND = new ErrorCode(1_007_003_000, "Payment extension not found.");
    ErrorCode PAY_ORDER_EXTENSION_STATUS_IS_NOT_WAITING = new ErrorCode(1_007_003_001, "The payment extension is not waiting for payment.");
    ErrorCode PAY_ORDER_EXTENSION_IS_PAID = new ErrorCode(1_007_003_002, "Order already payment, please waiting for payment result.");

    // ========== payment module ( refund ) 1-007-006-000 ==========
    ErrorCode REFUND_PRICE_EXCEED = new ErrorCode(1_007_006_000, "Refund amount exceeds order can refund amount.");
    ErrorCode REFUND_HAS_REFUNDING = new ErrorCode(1_007_006_002, "Already has refund in process.");
    ErrorCode REFUND_EXISTS = new ErrorCode(1_007_006_003, "Already existsrefund.");
    ErrorCode REFUND_NOT_FOUND = new ErrorCode(1_007_006_004, "Payment refund was not found.");
    ErrorCode REFUND_STATUS_IS_NOT_WAITING = new ErrorCode(1_007_006_005, "Payment refund not at pending refund.");
    ErrorCode REFUND_SUBMIT_CHANNEL_ERROR = new ErrorCode(1_007_006_006, "Refund failed. Error code: {}. Message: {}.");
    ErrorCode REFUND_CREATE_FAIL_ORDER_NOT_MATCH = new ErrorCode(1_007_006_007, "Refund failed: the payment does not match the previous refund request.");
    ErrorCode REFUND_CREATE_FAIL_PRICE_NOT_MATCH = new ErrorCode(1_007_006_008, "Refund failed: the amount does not match the previous refund request.");

    // ========== wallet module 1-007-007-000 ==========
    ErrorCode WALLET_NOT_FOUND = new ErrorCode(1_007_007_000, "Userwallet was not found.");
    ErrorCode WALLET_BALANCE_NOT_ENOUGH = new ErrorCode(1_007_007_001, "Wallet balance is insufficient.");
    ErrorCode WALLET_TRANSACTION_NOT_FOUND = new ErrorCode(1_007_007_002, "Not find to a matching wallet trade.");
    ErrorCode WALLET_REFUND_EXIST = new ErrorCode(1_007_007_003, "Already existswallet refund.");
    ErrorCode WALLET_FREEZE_PRICE_NOT_ENOUGH = new ErrorCode(1_007_007_004, "Wallet freeze balance is insufficient.");

    // ========== wallet top-up module 1-007-008-000 ==========
    ErrorCode WALLET_RECHARGE_NOT_FOUND = new ErrorCode(1_007_008_000, "Wallet top-up record was not found.");
    ErrorCode WALLET_RECHARGE_UPDATE_PAID_STATUS_NOT_UNPAID = new ErrorCode(1_007_008_001, "Wallet top-up update payment status failed, wallet top-up record is not [ unpaid ] status.");
    ErrorCode WALLET_RECHARGE_UPDATE_PAID_PAY_ORDER_ID_ERROR = new ErrorCode(1_007_008_002, "Wallet top-up update payment status failed, payment order code does not match.");
    ErrorCode WALLET_RECHARGE_UPDATE_PAID_PAY_ORDER_STATUS_NOT_SUCCESS = new ErrorCode(1_007_008_003, "Wallet top-up update payment status failed, payment order status is not [ payment succeeded] status.");
    ErrorCode WALLET_RECHARGE_UPDATE_PAID_PAY_PRICE_NOT_MATCH = new ErrorCode(1_007_008_004, "Wallet top-up update payment status failed, payment order amount does not match.");
    ErrorCode WALLET_RECHARGE_REFUND_FAIL_NOT_PAID = new ErrorCode(1_007_008_005, "Walletstart refund failed, wallet top-up order unpaid.");
    ErrorCode WALLET_RECHARGE_REFUND_FAIL_REFUNDED = new ErrorCode(1_007_008_006, "Walletstart refund failed, wallet top-up order already refund.");
    ErrorCode WALLET_RECHARGE_REFUND_BALANCE_NOT_ENOUGH = new ErrorCode(1_007_008_007, "Walletstart refund failed, wallet balance is insufficient.");
    ErrorCode WALLET_RECHARGE_REFUND_FAIL_REFUND_ORDER_ID_ERROR = new ErrorCode(1_007_008_008, "Wallet refund update failed, walletrefund code does not match.");
    ErrorCode WALLET_RECHARGE_REFUND_FAIL_REFUND_NOT_FOUND = new ErrorCode(1_007_008_009, "Wallet refund update failed, refund was not found.");
    ErrorCode WALLET_RECHARGE_REFUND_FAIL_REFUND_PRICE_NOT_MATCH = new ErrorCode(1_007_008_010, "Wallet refund update failed, refund amount does not match.");
    ErrorCode WALLET_RECHARGE_PACKAGE_NOT_FOUND = new ErrorCode(1_007_008_011, "Wallet top-up package not found.");
    ErrorCode WALLET_RECHARGE_PACKAGE_IS_DISABLE = new ErrorCode(1_007_008_012, "Wallet top-up package is disabled.");
    ErrorCode WALLET_RECHARGE_PACKAGE_NAME_EXISTS = new ErrorCode(1_007_008_013, "Wallet top-up package name already exists.");

    // ========== transfer module 1-007-009-000 ==========
    ErrorCode PAY_TRANSFER_NOT_FOUND = new ErrorCode(1_007_009_001, "Transfer order was not found.");
    ErrorCode PAY_TRANSFER_CREATE_CHANNEL_NOT_MATCH = new ErrorCode(1_007_009_002, "Transfer failed: the type does not match the previous request.");
    ErrorCode PAY_TRANSFER_CREATE_PRICE_NOT_MATCH = new ErrorCode(1_007_009_003, "Transfer failed: the amount does not match the previous request.");
    ErrorCode PAY_TRANSFER_CREATE_FAIL_STATUS_NOT_CLOSED = new ErrorCode(1_007_009_004, "Transfer start failed, : already exists the same transfer order, and status is not closed.");
    ErrorCode PAY_TRANSFER_NOTIFY_FAIL_STATUS_IS_NOT_WAITING = new ErrorCode(1_007_009_006, "Notification transfer result failed, : transfer order not at pending transfer.");
    ErrorCode PAY_TRANSFER_NOTIFY_FAIL_STATUS_NOT_WAITING_OR_PROCESSING = new ErrorCode(1_007_009_007, "Notification transfer result failed, : transfer order not at pending transfer or transfer.");
    ErrorCode PAY_TRANSFER_SUBMIT_CHANNEL_ERROR = new ErrorCode(1_007_009_008, "Transfer failed. Error code: {}. Message: {}.");

    // ========== sample order 1-007-900-000 ==========
    ErrorCode DEMO_ORDER_NOT_FOUND = new ErrorCode(1_007_900_000, "Sample order was not found.");
    ErrorCode DEMO_ORDER_UPDATE_PAID_STATUS_NOT_UNPAID = new ErrorCode(1_007_900_001, "Sample orderupdate payment status failed, order is not [ unpaid ] status.");
    ErrorCode DEMO_ORDER_UPDATE_PAID_FAIL_PAY_ORDER_ID_ERROR = new ErrorCode(1_007_900_002, "Sample orderupdate payment status failed, payment order code does not match.");
    ErrorCode DEMO_ORDER_UPDATE_PAID_FAIL_PAY_ORDER_STATUS_NOT_SUCCESS = new ErrorCode(1_007_900_003, "Sample orderupdate payment status failed, payment order status is not [ payment succeeded] status.");
    ErrorCode DEMO_ORDER_UPDATE_PAID_FAIL_PAY_PRICE_NOT_MATCH = new ErrorCode(1_007_900_004, "Sample orderupdate payment status failed, payment order amount does not match.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_NOT_PAID = new ErrorCode(1_007_900_005, "Start refund failed, sample order unpaid.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_REFUNDED = new ErrorCode(1_007_900_006, "Start refund failed, sample order already refund.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_REFUND_NOT_FOUND = new ErrorCode(1_007_900_007, "Start refund failed, refund was not found.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_REFUND_NOT_SUCCESS = new ErrorCode(1_007_900_008, "Start refund failed, refund not refund succeeded.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_REFUND_ORDER_ID_ERROR = new ErrorCode(1_007_900_009, "Start refund failed, refund code does not match.");
    ErrorCode DEMO_ORDER_REFUND_FAIL_REFUND_PRICE_NOT_MATCH = new ErrorCode(1_007_900_010, "Start refund failed, refund amount does not match.");

    // ========== sample withdrawal order 1-007-901-000 ==========
    ErrorCode DEMO_WITHDRAW_NOT_FOUND = new ErrorCode(1_007_901_000, "Sample withdrawal order was not found.");
    ErrorCode DEMO_WITHDRAW_UPDATE_STATUS_FAIL_PAY_TRANSFER_ID_ERROR = new ErrorCode(1_007_901_001, "Update sample withdrawal order status failed, payment transfer order code does not match.");
    ErrorCode DEMO_WITHDRAW_UPDATE_STATUS_FAIL_PAY_TRANSFER_STATUS_NOT_SUCCESS_OR_CLOSED = new ErrorCode(1_007_901_002, "Update sample withdrawal order status failed, payment transfer order status is not [ transfer succeeded] or [ transfer failed] status.");
    ErrorCode DEMO_WITHDRAW_UPDATE_STATUS_FAIL_PAY_PRICE_NOT_MATCH = new ErrorCode(1_007_901_003, "Update sample withdrawal order status failed, payment transfer order amount does not match.");
    ErrorCode DEMO_WITHDRAW_UPDATE_STATUS_FAIL_PAY_MERCHANT_EXISTS = new ErrorCode(1_007_901_004, "Failed to update the sample withdrawal: merchant order numbers do not match.");
    ErrorCode DEMO_WITHDRAW_UPDATE_STATUS_FAIL_PAY_CHANNEL_NOT_MATCH = new ErrorCode(1_007_901_005, "Update sample withdrawal order status failed, payment transfer order channel does not match.");
    ErrorCode DEMO_WITHDRAW_TRANSFER_FAIL_STATUS_NOT_WAITING_OR_CLOSED = new ErrorCode(1_007_901_008, "Start transfer failed, : sample withdrawal order status is not [ waiting for withdrawal ] or [ withdrawal disable ].");

}
