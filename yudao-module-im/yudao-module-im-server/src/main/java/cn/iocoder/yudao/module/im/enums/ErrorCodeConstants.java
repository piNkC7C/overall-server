package cn.iocoder.yudao.module.im.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * IM 错误码枚举类
 * <p>
 * im 系统，使用 1-040-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== message (1-040-300-000) ==========
    ErrorCode MESSAGE_NOT_EXISTS = new ErrorCode(1_040_300_000, "Message was not found.");
    ErrorCode MESSAGE_RECALL_DENIED = new ErrorCode(1_040_300_002, "Can only withdraw your own send message.");
    ErrorCode MESSAGE_ALREADY_RECALLED = new ErrorCode(1_040_300_003, "Message already withdraw.");
    ErrorCode MESSAGE_SENSITIVE_WORD_BLOCKED = new ErrorCode(1_040_300_004, "The message contains a blocked word and cannot be sent.");
    ErrorCode MESSAGE_PULL_SIZE_EXCEEDED = new ErrorCode(1_040_300_005, "You cannot fetch more than {} messages at a time.");
    ErrorCode MESSAGE_RECALL_TIMEOUT = new ErrorCode(1_040_300_007, "Messages older than {} minutes cannot be recalled.");
    ErrorCode MESSAGE_QUOTE_INVALID = new ErrorCode(1_040_300_008, "Referenced message not can.");
    ErrorCode MESSAGE_NOT_IN_GROUP = new ErrorCode(1_040_300_009, "Message does not belong to this group.");
    ErrorCode MESSAGE_PRIVATE_READ_DISABLED = new ErrorCode(1_040_300_010, "Private-chat read receipts are disabled.");
    ErrorCode MESSAGE_GROUP_READ_DISABLED = new ErrorCode(1_040_300_011, "Group-chat read receipts are disabled.");
    ErrorCode MESSAGE_CONTENT_INVALID = new ErrorCode(1_040_300_013, "Message content format is invalid.");

    // ========== 群 (1-040-400-000) ==========
    ErrorCode GROUP_NOT_EXISTS = new ErrorCode(1_040_400_000, "Group was not found.");
    ErrorCode GROUP_BANNED = new ErrorCode(1_040_400_001, "The group is banned.");
    ErrorCode GROUP_DISSOLVED = new ErrorCode(1_040_400_002, "The group is dissolved.");
    ErrorCode GROUP_NOT_OWNER = new ErrorCode(1_040_400_003, "Only the group owner can do this.");
    ErrorCode GROUP_NOT_OWNER_OR_ADMIN = new ErrorCode(1_040_400_004, "Only the group owner or an admin can do this.");
    ErrorCode GROUP_TRANSFER_OWNER_TO_SELF = new ErrorCode(1_040_400_005, "You cannot transfer group ownership to yourself.");
    ErrorCode GROUP_MESSAGE_PIN_MAX_LIMIT = new ErrorCode(1_040_400_006, "A group cannot pin more than {} messages.");
    ErrorCode GROUP_MESSAGE_ALREADY_PINNED = new ErrorCode(1_040_400_007, "This message is already pinned.");
    ErrorCode GROUP_MESSAGE_NOT_PINNED = new ErrorCode(1_040_400_008, "This message is not pinned.");
    ErrorCode GROUP_MESSAGE_PIN_DIRECTED_DENIED = new ErrorCode(1_040_400_009, "Directed messages cannot be pinned.");

    // ========== 群成员 (1-040-500-000) ==========
    ErrorCode GROUP_MEMBER_NOT_IN_GROUP = new ErrorCode(1_040_500_001, "You already is not in this group.");
    ErrorCode GROUP_OWNER_CANNOT_QUIT = new ErrorCode(1_040_500_003, "The group owner cannot leave. Transfer ownership or dissolve the group first.");
    ErrorCode GROUP_CANNOT_REMOVE_SELF = new ErrorCode(1_040_500_004, "Cannot your own remove group chat.");
    ErrorCode GROUP_MEMBER_EXCEED = new ErrorCode(1_040_500_005, "A group cannot have more than {} members.");
    ErrorCode GROUP_INVITE_NOT_FRIEND = new ErrorCode(1_040_500_006, "'{}' is not your friend, so the invite failed.");
    ErrorCode GROUP_ADMIN_TARGET_NOT_IN_GROUP = new ErrorCode(1_040_500_007, "Target user already is not in this group.");
    ErrorCode GROUP_ADMIN_TARGET_IS_OWNER = new ErrorCode(1_040_500_008, "The group owner cannot be set or unset as admin.");
    ErrorCode GROUP_ADMIN_MAX_LIMIT = new ErrorCode(1_040_500_009, "Group admin quantity cannot exceeds {} person.");
    ErrorCode GROUP_REMOVE_OWNER_DENIED = new ErrorCode(1_040_500_010, "The group owner cannot be removed from the group.");
    ErrorCode GROUP_REMOVE_ADMIN_DENIED = new ErrorCode(1_040_500_011, "Admins cannot remove other admins. Ask the owner to revoke admin first.");
    ErrorCode GROUP_MUTED_CANNOT_SEND = new ErrorCode(1_040_500_012, "The group is muted. Only the owner and admins can send messages.");
    ErrorCode GROUP_MEMBER_MUTED_CANNOT_SEND = new ErrorCode(1_040_500_013, "You are muted until {}.");
    ErrorCode GROUP_MUTE_MEMBER_SELF = new ErrorCode(1_040_500_014, "You cannot mute yourself.");
    ErrorCode GROUP_MUTE_OWNER_DENIED = new ErrorCode(1_040_500_015, "The group owner cannot be muted.");
    ErrorCode GROUP_MUTE_ADMIN_DENIED = new ErrorCode(1_040_500_016, "Admins cannot mute other admins.");

    // ========== contact (1-040-600-000) ==========
    ErrorCode FRIEND_NOT_FRIEND = new ErrorCode(1_040_600_001, "This user is not your friend.");
    ErrorCode FRIEND_ADD_SELF = new ErrorCode(1_040_600_002, "Is not allowed add itself as contact.");
    ErrorCode FRIEND_NOT_BLOCKED = new ErrorCode(1_040_600_003, "This user is not on your block list.");
    ErrorCode FRIEND_BLOCKED_BY_PEER = new ErrorCode(1_040_600_004, "You are blocked and cannot send messages.");

    // ========== 加群申请 (1-040-510-000) ==========
    ErrorCode GROUP_REQUEST_NOT_EXISTS = new ErrorCode(1_040_510_001, "Join-group request not found.");
    ErrorCode GROUP_REQUEST_HANDLED = new ErrorCode(1_040_510_002, "The join-group request was already handled.");
    ErrorCode GROUP_REQUEST_NOT_TO_ME = new ErrorCode(1_040_510_003, "Only the group owner or an admin can handle join requests.");
    ErrorCode GROUP_REQUEST_ALREADY_MEMBER = new ErrorCode(1_040_510_004, "You already in this group, no need to is duplicated apply please.");

    // ========== contact apply please (1-040-610-000) ==========
    ErrorCode FRIEND_REQUEST_NOT_EXISTS = new ErrorCode(1_040_610_001, "Contact apply please was not found.");
    ErrorCode FRIEND_REQUEST_HANDLED = new ErrorCode(1_040_610_002, "Contact apply please already process.");
    ErrorCode FRIEND_REQUEST_NOT_TO_ME = new ErrorCode(1_040_610_003, "Cannot process person contact apply please.");
    ErrorCode FRIEND_REQUEST_ALREADY_FRIEND = new ErrorCode(1_040_610_005, "You already is TA contact, no need to is duplicated add.");
    ErrorCode FRIEND_REQUEST_BLOCKED_BY_PEER = new ErrorCode(1_040_610_006, "You are blocked and cannot add this user as a friend.");

    // ========== Blocked Word (1-040-700-000) ==========
    ErrorCode SENSITIVE_WORD_NOT_EXISTS = new ErrorCode(1_040_700_000, "Blocked word not found.");
    ErrorCode SENSITIVE_WORD_DUPLICATED = new ErrorCode(1_040_700_001, "Blocked word '{}' already exists.");

    // ========== 表情包 (1-040-800-000) ==========
    ErrorCode FACE_PACK_NOT_EXISTS = new ErrorCode(1_040_800_000, "Sticker pack not found.");
    ErrorCode FACE_PACK_HAS_ITEMS = new ErrorCode(1_040_800_001, "The sticker pack still has stickers and cannot be deleted.");
    ErrorCode FACE_PACK_ITEM_NOT_EXISTS = new ErrorCode(1_040_800_002, "Emoji was not found.");
    ErrorCode FACE_USER_ITEM_NOT_EXISTS = new ErrorCode(1_040_800_010, "Person emoji was not found.");
    ErrorCode FACE_USER_ITEM_NOT_OWN = new ErrorCode(1_040_800_011, "Cannot be changed other person emoji.");
    ErrorCode FACE_USER_ITEM_DUPLICATED = new ErrorCode(1_040_800_013, "This emoji already add to person emoji.");
    ErrorCode FACE_USER_ITEM_MAX_LIMIT = new ErrorCode(1_040_800_014, "Person emoji quantity cannot exceeds {}.");

    // ========== Channel (1-040-810-000) ==========
    ErrorCode IM_CHANNEL_NOT_EXISTS = new ErrorCode(1_040_810_000, "Channel not found.");
    ErrorCode IM_CHANNEL_CODE_DUPLICATED = new ErrorCode(1_040_810_001, "Channel code '{}' already exists.");
    ErrorCode IM_CHANNEL_HAS_MATERIAL = new ErrorCode(1_040_810_002, "The channel still has media and cannot be deleted.");
    ErrorCode IM_CHANNEL_MATERIAL_NOT_EXISTS = new ErrorCode(1_040_810_010, "Media was not found.");
    ErrorCode IM_CHANNEL_MATERIAL_USED = new ErrorCode(1_040_810_011, "This media was already published and cannot be deleted.");
    ErrorCode IM_CHANNEL_MESSAGE_NOT_EXISTS = new ErrorCode(1_040_810_020, "Channel message not found.");

    // ========== 实时通话 (1-040-900-000) ==========
    ErrorCode RTC_NOT_ENABLED = new ErrorCode(1_040_900_000, "Call feature not enable.");
    ErrorCode RTC_SESSION_NOT_EXISTS = new ErrorCode(1_040_900_001, "Call already end.");
    ErrorCode RTC_PEER_BUSY = new ErrorCode(1_040_900_002, "The other user is already on a call.");
    ErrorCode RTC_SELF_BUSY = new ErrorCode(1_040_900_003, "You is currently call.");
    ErrorCode RTC_NOT_PARTICIPANT = new ErrorCode(1_040_900_004, "You is not in this call.");
    ErrorCode RTC_INVITE_SELF = new ErrorCode(1_040_900_005, "You cannot call yourself.");
    ErrorCode RTC_PRIVATE_INVITEE_REQUIRED = new ErrorCode(1_040_900_006, "A private call must specify the other user.");
    ErrorCode RTC_GROUP_REQUIRED = new ErrorCode(1_040_900_007, "Group chat call must specified group code.");
    ErrorCode RTC_INVITE_BUSY = new ErrorCode(1_040_900_008, "Call setup is busy. Try again later.");
    ErrorCode RTC_GROUP_CALL_ACTIVE = new ErrorCode(1_040_900_009, "This group already has an active call. Join from the call bar.");
    ErrorCode RTC_GROUP_INVITEE_OVER_LIMIT = new ErrorCode(1_040_900_010, "Group-call invite count exceeds the maximum.");
    ErrorCode RTC_GROUP_INVITEE_REQUIRED = new ErrorCode(1_040_900_011, "A group call must include invitees.");

}
