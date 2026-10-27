package cn.iocoder.yudao.module.oa.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * OA 错误码常量
 *
 * OA 系统，使用 1-054-000-000 段
 *
 * @author 芋道源码
 */
public interface ErrorCodeConstants {

    // ========== workflow apply please 1-054-280-000 ==========
    ErrorCode APPLY_NOT_EXISTS = new ErrorCode(1_054_280_000, "Apply please was not found.");
    ErrorCode APPLY_ACCESS_DENIED = new ErrorCode(1_054_280_001, "You do not have permission to view this request.");
    ErrorCode APPLY_STATUS_INVALID = new ErrorCode(1_054_280_004, "Apply please status is not allowed this action.");
    ErrorCode LEAVE_APPLY_DAYS_EXCEEDED = new ErrorCode(1_054_280_005, "A single {} cannot exceed {} days.");

    // ========== 出差管理 1-054-270-000 ==========
    ErrorCode TRAVEL_NOT_EXISTS = new ErrorCode(1_054_270_000, "Travel request not found.");
    ErrorCode TRAVEL_ACCESS_DENIED = new ErrorCode(1_054_270_001, "You do not have permission to change this travel request.");
    ErrorCode TRAVEL_STATUS_INVALID = new ErrorCode(1_054_270_002, "Current document status is not allowed this action.");
    ErrorCode TRAVEL_APPLY_ALREADY_REIMBURSED = new ErrorCode(1_054_270_010, "The selected travel request is already reimbursed.");
    ErrorCode TRAVEL_APPLY_NOT_APPROVED = new ErrorCode(1_054_270_009, "The selected travel request is not approved yet.");
    ErrorCode TRAVEL_NO_DUPLICATE = new ErrorCode(1_054_270_011, "Travel request number already exists.");

    // ========== Calendar admin 1-054-100-000 ==========
    ErrorCode SCHEDULE_NOT_EXISTS = new ErrorCode(1_054_100_000, "Calendar event not found.");
    ErrorCode SCHEDULE_ACCESS_DENIED = new ErrorCode(1_054_100_001, "You do not have permission to view this calendar event.");

    // ========== 工作计划 1-054-110-000 ==========
    ErrorCode PLAN_NOT_EXISTS = new ErrorCode(1_054_110_000, "Work plan not found.");
    ErrorCode PLAN_ACCESS_DENIED = new ErrorCode(1_054_110_001, "You do not have permission to change this work plan.");

    // ========== Note admin 1-054-120-000 ==========
    ErrorCode NOTE_NOT_EXISTS = new ErrorCode(1_054_120_000, "Note not found.");
    ErrorCode NOTE_ACCESS_DENIED = new ErrorCode(1_054_120_001, "You do not have permission to view this note.");
    ErrorCode NOTE_CATEGORY_NOT_EXISTS = new ErrorCode(1_054_120_002, "Note folder not found.");
    ErrorCode NOTE_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_054_120_003, "Note folder name already exists.");

    // ========== 通讯录 1-054-130-000 ==========
    ErrorCode CONTACT_NOT_EXISTS = new ErrorCode(1_054_130_000, "Contact was not found.");
    ErrorCode CONTACT_ACCESS_DENIED = new ErrorCode(1_054_130_001, "Do not have permission access this contact.");
    ErrorCode CONTACT_CATEGORY_NOT_EXISTS = new ErrorCode(1_054_130_002, "Contactcategory was not found.");
    ErrorCode CONTACT_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_054_130_003, "Contactcategory name already exists.");

    // ========== 讨论区 1-054-150-000 ==========
    ErrorCode DISCUSSION_NOT_EXISTS = new ErrorCode(1_054_150_000, "Discussion not found.");
    ErrorCode DISCUSSION_ACCESS_DENIED = new ErrorCode(1_054_150_001, "You can edit or delete only your own discussions.");
    ErrorCode DISCUSSION_REPLY_NOT_EXISTS = new ErrorCode(1_054_150_002, "Discussion reply not found.");
    ErrorCode DISCUSSION_REPLY_ACCESS_DENIED = new ErrorCode(1_054_150_003, "Only the author or a super admin can delete a reply.");
    ErrorCode DISCUSSION_VOTE_INVALID = new ErrorCode(1_054_150_004, "Vote settings are invalid.");
    ErrorCode DISCUSSION_VOTE_EXPIRED = new ErrorCode(1_054_150_005, "The vote has not started or has already ended.");
    ErrorCode DISCUSSION_VOTE_DUPLICATE = new ErrorCode(1_054_150_006, "You already voted.");
    ErrorCode DISCUSSION_VOTE_OPTION_NOT_EXISTS = new ErrorCode(1_054_150_007, "Vote option not found.");
    ErrorCode DISCUSSION_LIKE_TARGET_INVALID = new ErrorCode(1_054_150_009, "You can like only a discussion or a top-level reply.");

    // ========== attendance admin 1-054-160-000 ==========
    ErrorCode ATTENDANCE_NOT_EXISTS = new ErrorCode(1_054_160_000, "Attendancerecord was not found.");
    ErrorCode ATTENDANCE_CLOCK_TIME_INVALID = new ErrorCode(1_054_160_001, "Clock-in is allowed only after {} and before {} each day.");
    ErrorCode ATTENDANCE_STATUS_INVALID = new ErrorCode(1_054_160_002, "Attendance type and status does not match.");

    // ========== task admin 1-054-170-000 ==========
    ErrorCode TASK_NOT_EXISTS = new ErrorCode(1_054_170_000, "Task was not found.");
    ErrorCode TASK_ACCESS_DENIED = new ErrorCode(1_054_170_001, "Do not have permission access this task.");
    ErrorCode TASK_RECEIVER_NOT_EXISTS = new ErrorCode(1_054_170_003, "You are not the recipient of this task.");
    ErrorCode TASK_STATUS_TRANSITION_INVALID = new ErrorCode(1_054_170_004, "Invalid task status change.");
    ErrorCode TASK_RECEIVED_DELETE_DENIED = new ErrorCode(1_054_170_006, "Only canceled received tasks can be deleted.");

    // ========== announcement admin 1-054-180-000 ==========
    ErrorCode ANNOUNCEMENT_NOT_EXISTS = new ErrorCode(1_054_180_000, "Announcement was not found.");
    ErrorCode ANNOUNCEMENT_ACCESS_DENIED = new ErrorCode(1_054_180_001, "Do not have permission action this announcement.");
    ErrorCode ANNOUNCEMENT_RECEIVER_NOT_EXISTS = new ErrorCode(1_054_180_002, "You are not the recipient of this announcement.");
    ErrorCode ANNOUNCEMENT_ALREADY_FORWARDED = new ErrorCode(1_054_180_003, "This announcement was already forwarded.");
    ErrorCode ANNOUNCEMENT_UNREAD_DELETE_DENIED = new ErrorCode(1_054_180_004, "Read the announcement before removing it.");

    // ========== 企业邮箱 1-054-190-000 ==========
    ErrorCode MAIL_PROVIDER_NOT_EXISTS = new ErrorCode(1_054_190_000, "Email service setting was not found.");
    ErrorCode MAIL_PROVIDER_DISABLED = new ErrorCode(1_054_190_001, "Email service setting is not enabled.");
    ErrorCode MAIL_PROVIDER_IN_USE = new ErrorCode(1_054_190_002, "Email service setting is already used by account referenced.");
    ErrorCode MAIL_ACCOUNT_NOT_EXISTS = new ErrorCode(1_054_190_003, "Email account was not found or do not have permission access.");
    ErrorCode MAIL_ACCOUNT_DISABLED = new ErrorCode(1_054_190_004, "Emailaccount is not enabled.");
    ErrorCode MAIL_ACCOUNT_IDENTITY_IMMUTABLE = new ErrorCode(1_054_190_033, "After binding, email address, sign-in name, and service cannot change. Add a new binding.");
    ErrorCode MAIL_ACCOUNT_PASSWORD_REQUIRED = new ErrorCode(1_054_190_005, "Enter the email password or app password.");
    ErrorCode MAIL_MESSAGE_NOT_EXISTS = new ErrorCode(1_054_190_006, "Email was not found or already move, first sync.");
    ErrorCode MAIL_FOLDER_NOT_AVAILABLE = new ErrorCode(1_054_190_007, "Folder unavailable, first sync.");
    ErrorCode MAIL_SYNC_COUNT_EXCEEDED = new ErrorCode(1_054_190_008, "This folder has more than {} messages. Narrow the mailbox range, then sync.");
    ErrorCode MAIL_SYNC_CHANGED = new ErrorCode(1_054_190_009, "The mailbox changed during sync. Sync again.");
    ErrorCode MAIL_UID_EXPIRED = new ErrorCode(1_054_190_010, "The message ID changed. Sync first.");
    ErrorCode MAIL_PERMANENT_DELETE_UNSUPPORTED = new ErrorCode(1_054_190_011, "The provider does not support safe permanent delete. Use the original mail client.");
    ErrorCode MAIL_TRASH_NOT_EXISTS = new ErrorCode(1_054_190_012, "Deleted folder was not found. Use the original mail client.");
    ErrorCode MAIL_MOVE_UNSUPPORTED = new ErrorCode(1_054_190_013, "The provider does not support safe move. Use the original mail client.");
    ErrorCode MAIL_RECIPIENT_REQUIRED = new ErrorCode(1_054_190_014, "Enter a recipient.");
    ErrorCode MAIL_SUBJECT_INVALID = new ErrorCode(1_054_190_015, "The subject cannot contain line breaks.");
    ErrorCode MAIL_ADDRESS_INVALID = new ErrorCode(1_054_190_016, "Invalid email address. Check To and Cc.");
    ErrorCode MAIL_NOT_DRAFT = new ErrorCode(1_054_190_017, "Email is not draft.");
    ErrorCode MAIL_SYNC_FAILED = new ErrorCode(1_054_190_018, "Mailbox sync failed and the local snapshot was not updated. Check the connection and retry.");
    ErrorCode MAIL_DETAIL_READ_FAILED = new ErrorCode(1_054_190_019, "Failed to read the message. Sync first or use the original mail client.");
    ErrorCode MAIL_READ_STATUS_FAILED = new ErrorCode(1_054_190_020, "Failed to update read status. Sync and confirm the remote state.");
    ErrorCode MAIL_DELETE_UNCONFIRMED = new ErrorCode(1_054_190_021, "Delete result is unconfirmed. Sync to verify and do not retry yet.");
    ErrorCode MAIL_DRAFT_FOLDER_NOT_EXISTS = new ErrorCode(1_054_190_022, "Drafts folder was not found. Configure it in the original mailbox first.");
    ErrorCode MAIL_DRAFT_REPLACE_UNSUPPORTED = new ErrorCode(1_054_190_023, "The provider does not support safe draft replace. Use the original mail client.");
    ErrorCode MAIL_DRAFT_SAVE_UNCONFIRMED = new ErrorCode(1_054_190_024, "Draft save is unconfirmed. Sync Drafts to verify and do not save again yet.");
    ErrorCode MAIL_DRAFT_INDEX_NOT_FOUND = new ErrorCode(1_054_190_025, "The draft was saved. Sync to view it.");
    ErrorCode MAIL_SOURCE_NOT_OWNED = new ErrorCode(1_054_190_026, "Original email does not belong to current email.");
    ErrorCode MAIL_SEND_UNCONFIRMED = new ErrorCode(1_054_190_027, "Send failed or the result is unknown. Confirm in the original mailbox before resending.");
    ErrorCode MAIL_DRAFT_NOT_OWNED = new ErrorCode(1_054_190_028, "Can only edit current account draft.");
    ErrorCode MAIL_SOURCE_READ_FAILED = new ErrorCode(1_054_190_029, "Failed to read the original message or attachment. Send was not executed.");
    ErrorCode MAIL_ATTACHMENT_NOT_EXISTS = new ErrorCode(1_054_190_031, "Email attachment not found.");
    ErrorCode MAIL_ATTACHMENT_READ_FAILED = new ErrorCode(1_054_190_032, "Failed to read the attachment. Sync the message and retry.");
    ErrorCode MAIL_RESTORE_UNCONFIRMED = new ErrorCode(1_054_190_034, "Restore result is unconfirmed. Sync to verify.");
    ErrorCode MAIL_NOT_TRASH = new ErrorCode(1_054_190_035, "Only messages in the deleted folder can be restored.");
    ErrorCode MAIL_INBOX_READ_FAILED = new ErrorCode(1_054_190_030, "Failed to read the inbox. Check the mailbox connection or try again later.");

    // ========== 办公用品 1-054-200-000 ==========
    ErrorCode SUPPLY_ITEM_PENDING_ISSUE = new ErrorCode(1_054_200_004, "This item still has pending issue lines and cannot be deleted.");
    ErrorCode SUPPLY_ITEM_NOT_RETURNED = new ErrorCode(1_054_200_002, "This item still has unreturned quantity and cannot be deleted.");
    ErrorCode SUPPLY_ITEM_NOT_EXISTS = new ErrorCode(1_054_200_000, "Office supply not found.");
    ErrorCode SUPPLY_ITEM_NO_DUPLICATE = new ErrorCode(1_054_200_001, "Item code already exists.");
    ErrorCode SUPPLY_STOCK_INSUFFICIENT = new ErrorCode(1_054_200_003, "Item inventory is insufficient.");
    ErrorCode SUPPLY_APPLY_NOT_EXISTS = new ErrorCode(1_054_200_005, "Item apply please was not found.");
    ErrorCode SUPPLY_APPLY_ACCESS_DENIED = new ErrorCode(1_054_200_006, "Do not have permission action this item apply please.");
    ErrorCode SUPPLY_APPLY_STATUS_INVALID = new ErrorCode(1_054_200_007, "Current apply please status is not allowed this action.");
    ErrorCode SUPPLY_APPLY_ITEM_INVALID = new ErrorCode(1_054_200_008, "Item is disabled or is duplicated.");
    ErrorCode SUPPLY_APPLY_NO_DUPLICATE = new ErrorCode(1_054_200_009, "Item apply please order no. already exists.");
    ErrorCode SUPPLY_APPLY_QTY_INVALID = new ErrorCode(1_054_200_010, "Quantity exceeds the requested or unreturned quantity.");
    ErrorCode SUPPLY_ISSUE_NOT_EXISTS = new ErrorCode(1_054_200_011, "Supply issue or return record not found.");

    // ========== Seal admin 1-054-210-000 ==========
    ErrorCode SEAL_IN_USE = new ErrorCode(1_054_210_002, "The seal is used by business documents and cannot be deleted.");
    ErrorCode SEAL_NOT_EXISTS = new ErrorCode(1_054_210_000, "Seal not found.");
    ErrorCode SEAL_APPLY_NOT_EXISTS = new ErrorCode(1_054_210_013, "Seal apply please was not found.");
    ErrorCode SEAL_APPLY_NOT_OWNER = new ErrorCode(1_054_210_014, "Can only action this person seal apply please.");
    ErrorCode SEAL_APPLY_STATUS_INVALID = new ErrorCode(1_054_210_015, "Seal apply please status is not allowed this action.");
    ErrorCode SEAL_APPLY_TIME_INVALID = new ErrorCode(1_054_210_016, "Seal use or return time is invalid.");
    ErrorCode SEAL_APPLY_TIME_CONFLICT = new ErrorCode(1_054_210_017, "This seal has a conflicting reservation or has not been returned.");
    ErrorCode SEAL_APPLY_NO_DUPLICATE = new ErrorCode(1_054_210_021, "Seal apply please order no. already exists.");
    ErrorCode SEAL_NO_DUPLICATE = new ErrorCode(1_054_210_001, "Seal number already exists.");

    // ========== Vehicle admin 1-054-220-000 ==========
    ErrorCode VEHICLE_IN_USE = new ErrorCode(1_054_220_019, "The vehicle is used by business documents and cannot be deleted.");
    ErrorCode VEHICLE_NOT_EXISTS = new ErrorCode(1_054_220_000, "Vehicle not found.");
    ErrorCode VEHICLE_NO_DUPLICATE = new ErrorCode(1_054_220_001, "License plate already exists.");
    ErrorCode VEHICLE_NOT_ENABLED = new ErrorCode(1_054_220_002, "The vehicle is not idle and cannot be requested.");
    ErrorCode VEHICLE_APPLY_NOT_EXISTS = new ErrorCode(1_054_220_003, "Vehicle apply please was not found.");
    ErrorCode VEHICLE_APPLY_NOT_OWNER = new ErrorCode(1_054_220_004, "Can only action this person vehicle apply please.");
    ErrorCode VEHICLE_APPLY_STATUS_INVALID = new ErrorCode(1_054_220_005, "Vehicle apply please status is not allowed this action.");
    ErrorCode VEHICLE_APPLY_TIME_INVALID = new ErrorCode(1_054_220_006, "Departure time must be earlier than return time.");
    ErrorCode VEHICLE_APPLY_TIME_CONFLICT = new ErrorCode(1_054_220_007, "The vehicle is already reserved in this time range.");
    ErrorCode VEHICLE_RETURN_NOT_EXISTS = new ErrorCode(1_054_220_009, "Still vehicle apply please was not found.");
    ErrorCode VEHICLE_RETURN_NOT_OWNER = new ErrorCode(1_054_220_010, "Can only action this person still vehicle apply please.");
    ErrorCode VEHICLE_RETURN_STATUS_INVALID = new ErrorCode(1_054_220_011, "Current apply please status is not allowed still vehicle action.");
    ErrorCode VEHICLE_RETURN_TIME_INVALID = new ErrorCode(1_054_220_014, "Enter the actual departure time. Return time cannot be earlier than departure or later than now.");

    ErrorCode VEHICLE_APPLY_NO_DUPLICATE = new ErrorCode(1_054_220_017, "Vehicle apply please order no. already exists.");

    ErrorCode VEHICLE_RETURN_NO_DUPLICATE = new ErrorCode(1_054_220_018, "Still vehicle apply please order no. already exists.");

    // ========== 云盘文件 1-054-230-000 ==========
    ErrorCode FILE_NODE_NOT_EXISTS = new ErrorCode(1_054_230_000, "File or directory was not found.");
    ErrorCode FILE_NODE_NOT_AVAILABLE = new ErrorCode(1_054_230_001, "File or belonging directory already in recycle bin.");
    ErrorCode FILE_NODE_PATH_INVALID = new ErrorCode(1_054_230_002, "Folder structure is invalid, or the parent folder was deleted.");
    ErrorCode FILE_NODE_ACCESS_DENIED = new ErrorCode(1_054_230_003, "Do not have permission action this file or directory.");
    ErrorCode FILE_NODE_NAME_DUPLICATE = new ErrorCode(1_054_230_004, "A file or folder with this name already exists here.");
    ErrorCode FILE_NODE_MOVE_INVALID = new ErrorCode(1_054_230_005, "Cannot move to itself or child directory.");
    ErrorCode FILE_NODE_NOT_RECYCLED = new ErrorCode(1_054_230_007, "Only files in Trash can be restored or permanently deleted.");
    ErrorCode FILE_STORAGE_NOT_ENOUGH = new ErrorCode(1_054_230_009, "Not enough drive space. Free some files and try again.");
    ErrorCode FILE_PERMISSION_NOT_EXISTS = new ErrorCode(1_054_230_008, "Share permission not found.");

    // ========== 工作汇报 1-054-240-000 ==========
    ErrorCode WORK_REPORT_NOT_EXISTS = new ErrorCode(1_054_240_000, "Work report not found.");
    ErrorCode WORK_REPORT_ACCESS_DENIED = new ErrorCode(1_054_240_001, "You do not have permission to view this work report.");
    ErrorCode WORK_REPORT_STATUS_INVALID = new ErrorCode(1_054_240_002, "This work-report status does not allow that action.");
    ErrorCode WORK_REPORT_NO_DUPLICATE = new ErrorCode(1_054_240_005, "Work report number already exists.");

    // ========== 会议室 1-054-250-000 ==========
    ErrorCode MEETING_ROOM_NOT_EXISTS = new ErrorCode(1_054_250_000, "Meeting room not found.");
    ErrorCode MEETING_ROOM_NOT_AVAILABLE = new ErrorCode(1_054_250_001, "The meeting room cannot be reserved now.");
    ErrorCode MEETING_ROOM_SCOPE_INVALID = new ErrorCode(1_054_250_002, "Specified member is required.");
    ErrorCode MEETING_ROOM_BOOKING_NOT_EXISTS = new ErrorCode(1_054_250_003, "Meeting-room reservation not found.");
    ErrorCode MEETING_ROOM_BOOKING_NOT_OWNER = new ErrorCode(1_054_250_004, "You do not have permission to change this reservation.");
    ErrorCode MEETING_ROOM_BOOKING_STATUS_INVALID = new ErrorCode(1_054_250_005, "This reservation status does not allow that action.");
    ErrorCode MEETING_ROOM_BOOKING_TIME_INVALID = new ErrorCode(1_054_250_006, "Meeting time is invalid.");
    ErrorCode MEETING_ROOM_BOOKING_TIME_CONFLICT = new ErrorCode(1_054_250_007, "The meeting room is already reserved in this time range.");
    ErrorCode MEETING_ROOM_HAS_BOOKING = new ErrorCode(1_054_250_009, "The meeting room has active reservations and cannot be deleted.");
    ErrorCode MEETING_ROOM_BOOKING_NO_DUPLICATE = new ErrorCode(1_054_250_010, "Meeting-room reservation number already exists.");

    // ========== 公文管理 1-054-260-000 ==========
    ErrorCode OFFICIAL_DOC_TEMPLATE_NOT_EXISTS = new ErrorCode(1_054_260_000, "Red-header template not found.");
    ErrorCode OFFICIAL_DOC_NOT_EXISTS = new ErrorCode(1_054_260_001, "Official document not found.");
    ErrorCode OFFICIAL_DOC_ACCESS_DENIED = new ErrorCode(1_054_260_002, "You do not have permission to change this official document.");
    ErrorCode OFFICIAL_DOC_STATUS_INVALID = new ErrorCode(1_054_260_003, "This official-document status does not allow that action.");
    ErrorCode OFFICIAL_DOC_PROCESS_MISMATCH = new ErrorCode(1_054_260_004, "The official document does not match the workflow instance.");
    ErrorCode OFFICIAL_DOC_TEMPLATE_DISABLED = new ErrorCode(1_054_260_005, "The red-header template is disabled.");
    ErrorCode OFFICIAL_DOC_SEND_NO_DUPLICATE = new ErrorCode(1_054_260_007, "Outbound document number already exists.");
    ErrorCode OFFICIAL_DOC_RECEIVE_NO_DUPLICATE = new ErrorCode(1_054_260_006, "Inbound document number already exists.");
    ErrorCode OFFICIAL_DOC_TEMPLATE_IN_USE = new ErrorCode(1_054_260_008, "The red-header template is used by documents and cannot be deleted.");
    ErrorCode OFFICIAL_DOC_SEND_DOCUMENT_NO_DUPLICATE = new ErrorCode(1_054_260_009, "Document issue number already exists.");

}
