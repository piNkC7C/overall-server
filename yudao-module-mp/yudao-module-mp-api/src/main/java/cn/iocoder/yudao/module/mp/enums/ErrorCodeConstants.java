package cn.iocoder.yudao.module.mp.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Mp 错误码枚举类
 *
 * mp 系统，使用 1-006-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== Official Account account 1-006-000-000 ============
    ErrorCode ACCOUNT_NOT_EXISTS = new ErrorCode(1_006_000_000, "Official account not found.");
    ErrorCode ACCOUNT_GENERATE_QR_CODE_FAIL = new ErrorCode(1_006_000_001, "Failed to create the official-account QR code: {}.");
    ErrorCode ACCOUNT_CLEAR_QUOTA_FAIL = new ErrorCode(1_006_000_002, "Failed to clear the official-account API quota: {}.");

    // ========== Official AccountStats 1-006-001-000 ============
    ErrorCode STATISTICS_GET_USER_SUMMARY_FAIL = new ErrorCode(1_006_001_000, "Failed to get follower change data: {}.");
    ErrorCode STATISTICS_GET_USER_CUMULATE_FAIL = new ErrorCode(1_006_001_001, "Failed to get cumulative follower data: {}.");
    ErrorCode STATISTICS_GET_UPSTREAM_MESSAGE_FAIL = new ErrorCode(1_006_001_002, "Failed to get message-send stats: {}.");
    ErrorCode STATISTICS_GET_INTERFACE_SUMMARY_FAIL = new ErrorCode(1_006_001_003, "Failed to get API analytics: {}.");

    // ========== Official Accounttag 1-006-002-000 ============
    ErrorCode TAG_NOT_EXISTS = new ErrorCode(1_006_002_000, "Tag was not found.");
    ErrorCode TAG_CREATE_FAIL = new ErrorCode(1_006_002_001, "Createtag failed, : {}.");
    ErrorCode TAG_UPDATE_FAIL = new ErrorCode(1_006_002_002, "Updatetag failed, : {}.");
    ErrorCode TAG_DELETE_FAIL = new ErrorCode(1_006_002_003, "Deletetag failed, : {}.");
    ErrorCode TAG_GET_FAIL = new ErrorCode(1_006_002_004, "Get tag failed, : {}.");

    // ========== Official Accountfollower 1-006-003-000 ============
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1_006_003_000, "Follower was not found.");
    ErrorCode USER_UPDATE_TAG_FAIL = new ErrorCode(1_006_003_001, "Updatefollowertag failed, : {}.");

    // ========== Official Accountmedia 1-006-004-000 ============
    ErrorCode MATERIAL_NOT_EXISTS = new ErrorCode(1_006_004_000, "Media was not found.");
    ErrorCode MATERIAL_UPLOAD_FAIL = new ErrorCode(1_006_004_001, "Failed to upload media: {}.");
    ErrorCode MATERIAL_IMAGE_UPLOAD_FAIL = new ErrorCode(1_006_004_002, "Failed to upload the image: {}.");
    ErrorCode MATERIAL_DELETE_FAIL = new ErrorCode(1_006_004_003, "Deletemedia failed, : {}.");

    // ========== Official Accountmessage 1-006-005-000 ============
    ErrorCode MESSAGE_SEND_FAIL = new ErrorCode(1_006_005_000, "Send message failed, : {}.");

    // ========== 公众号发布能力 1-006-006-000 ============
    ErrorCode FREE_PUBLISH_LIST_FAIL = new ErrorCode(1_006_006_000, "Failed to get published items: {}.");
    ErrorCode FREE_PUBLISH_SUBMIT_FAIL = new ErrorCode(1_006_006_001, "Failed to submit publish: {}.");
    ErrorCode FREE_PUBLISH_DELETE_FAIL = new ErrorCode(1_006_006_002, "Failed to delete publish: {}.");

    // ========== Official Account draft 1-006-007-000 ============
    ErrorCode DRAFT_LIST_FAIL = new ErrorCode(1_006_007_000, "Get draft list failed, : {}.");
    ErrorCode DRAFT_CREATE_FAIL = new ErrorCode(1_006_007_001, "Create draft failed, : {}.");
    ErrorCode DRAFT_UPDATE_FAIL = new ErrorCode(1_006_007_002, "Update draft failed, : {}.");
    ErrorCode DRAFT_DELETE_FAIL = new ErrorCode(1_006_007_003, "Delete draft failed, : {}.");

    // ========== Official Accountmenu 1-006-008-000 ============
    ErrorCode MENU_SAVE_FAIL = new ErrorCode(1_006_008_000, "Createmenu failed, : {}.");
    ErrorCode MENU_DELETE_FAIL = new ErrorCode(1_006_008_001, "Deletemenu failed, : {}.");

    // ========== Official AccountAuto reply 1-006-009-000 ============
    ErrorCode AUTO_REPLY_NOT_EXISTS = new ErrorCode(1_006_009_000, "Auto-reply not found.");
    ErrorCode AUTO_REPLY_ADD_SUBSCRIBE_FAIL_EXISTS = new ErrorCode(1_006_009_001, "The action failed, : already exists follow time reply.");
    ErrorCode AUTO_REPLY_ADD_MESSAGE_FAIL_EXISTS = new ErrorCode(1_006_009_002, "The action failed, : already exists this message type reply.");
    ErrorCode AUTO_REPLY_ADD_KEYWORD_FAIL_EXISTS = new ErrorCode(1_006_009_003, "A reply is already bound to this keyword.");

    // ========== Official Accounttemplatemessage 1-006-010-000 ============
    ErrorCode MESSAGE_TEMPLATE_NOT_EXISTS = new ErrorCode(1_006_010_000, "Templatemessage was not found.");
    ErrorCode MESSAGE_TEMPLATE_DELETE_FAIL = new ErrorCode(1_006_010_002, "Deletetemplatemessage failed, : {}.");
    ErrorCode MESSAGE_TEMPLATE_SYNC_FAIL = new ErrorCode(1_006_010_003, "Sync templatemessage failed, : {}.");
    ErrorCode MESSAGE_TEMPLATE_SEND_FAIL = new ErrorCode(1_006_010_004, "Send templatemessage failed, : {}.");

}
