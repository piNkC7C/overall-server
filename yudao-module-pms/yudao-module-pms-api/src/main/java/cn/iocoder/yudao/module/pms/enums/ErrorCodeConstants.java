package cn.iocoder.yudao.module.pms.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * PMS 错误码常量
 *
 * PMS 系统，使用 1-053-000-000 段
 *
 * @author 芋道源码
 */
public interface ErrorCodeConstants {

    // ========== item 1-053-100-000 ==========
    ErrorCode PROJECT_NOT_EXISTS = new ErrorCode(1_053_100_000, "Project was not found.");
    ErrorCode PROJECT_ACCESS_DENIED = new ErrorCode(1_053_100_001, "Do not have permission access this project.");
    ErrorCode PROJECT_ADMIN_REQUIRED = new ErrorCode(1_053_100_002, "Only projectadmin can execute this action.");
    ErrorCode PROJECT_STATUS_INVALID = new ErrorCode(1_053_100_004, "Current project status is not allowed execute this action.");
    ErrorCode PROJECT_WRITE_ACCESS_DENIED = new ErrorCode(1_053_100_005, "Current projectrole no edit permission.");
    ErrorCode PROJECT_ANNOUNCEMENT_NOT_EXISTS = new ErrorCode(1_053_100_006, "Projectannouncement was not found.");
    ErrorCode PROJECT_OWNER_REQUIRED = new ErrorCode(1_053_100_007, "Only project owner can execute this action.");

    // ========== item member 1-053-105-000 ==========
    ErrorCode PROJECT_MEMBER_NOT_EXISTS = new ErrorCode(1_053_105_000, "Project member was not found.");
    ErrorCode PROJECT_MEMBER_CREATOR_CANNOT_REMOVE = new ErrorCode(1_053_105_001, "Project creator cannot remove project.");
    ErrorCode PROJECT_MEMBER_OWNER_LEVEL_CANNOT_ASSIGN = new ErrorCode(1_053_105_002,
            "Project owner level cannot directly assign.");
    ErrorCode PROJECT_MEMBER_OWNER_CANNOT_EXIT = new ErrorCode(1_053_105_003, "Project owner cannot leave project.");

    // ========== item group 1-053-110-000 ==========
    ErrorCode PROJECT_GROUP_NOT_EXISTS = new ErrorCode(1_053_110_000, "Project group was not found.");
    ErrorCode PROJECT_GROUP_NAME_DUPLICATE = new ErrorCode(1_053_110_001, "Project group name already exists.");
    ErrorCode PROJECT_GROUP_DEFAULT_CANNOT_MODIFY = new ErrorCode(1_053_110_002, "Default project group is not allowed edit.");
    ErrorCode PROJECT_GROUP_DEFAULT_CANNOT_DELETE = new ErrorCode(1_053_110_003, "Default project group is not alloweddelete.");

    // ========== item template 1-053-112-000 ==========
    ErrorCode PROJECT_TEMPLATE_NOT_EXISTS = new ErrorCode(1_053_112_000, "Projecttemplate was not found.");
    ErrorCode PROJECT_TEMPLATE_NAME_DUPLICATE = new ErrorCode(1_053_112_001, "The same project type template name already exists.");
    ErrorCode PROJECT_TEMPLATE_CONFIG_INVALID = new ErrorCode(1_053_112_002, "Projecttemplatesetting invalid ：{}.");

    // ========== item sprint 1-053-115-000 ==========
    ErrorCode ITERATION_NOT_EXISTS = new ErrorCode(1_053_115_000, "Project sprint was not found.");
    ErrorCode ITERATION_STATUS_INVALID = new ErrorCode(1_053_115_002, "Current sprint status is not allowed execute this action.");

    // ========== work item 1-053-120-000 ==========
    ErrorCode WORK_ITEM_NOT_EXISTS = new ErrorCode(1_053_120_000, "Work item was not found.");
    ErrorCode WORK_ITEM_TYPE_INVALID = new ErrorCode(1_053_120_001, "Current project not support this work item type.");
    ErrorCode WORK_ITEM_STATUS_NOT_EXISTS = new ErrorCode(1_053_120_002, "Work item status was not found.");
    ErrorCode WORK_ITEM_STATUS_INVALID = new ErrorCode(1_053_120_003, "Work item status and project or type does not match.");
    ErrorCode WORK_ITEM_TIME_INVALID = new ErrorCode(1_053_120_004, "Work item start time must earlier than due time.");
    ErrorCode WORK_ITEM_ITERATION_INVALID = new ErrorCode(1_053_120_005, "Belonging sprint and work item project does not match.");
    ErrorCode WORK_ITEM_PARENT_INVALID = new ErrorCode(1_053_120_006, "Parent work item and current work item does not match.");
    ErrorCode WORK_ITEM_RELATED_REQUIREMENT_INVALID = new ErrorCode(1_053_120_007, "Related requirement and current work item does not match.");
    ErrorCode WORK_ITEM_DEFECT_TYPE_INVALID = new ErrorCode(1_053_120_008, "Only defect work item can set defect type.");
    ErrorCode WORK_ITEM_SORT_INVALID = new ErrorCode(1_053_120_009, "Work item board sort data invalid.");
    ErrorCode WORK_ITEM_STATUS_NAME_DUPLICATE = new ErrorCode(1_053_120_010, "Work item status name already exists.");
    ErrorCode WORK_ITEM_STATUS_DEFAULT_CANNOT_DELETE = new ErrorCode(1_053_120_011, "Work item initial status cannot be deleted.");
    ErrorCode WORK_ITEM_STATUS_TRANSFER_INVALID = new ErrorCode(1_053_120_012, "Work item status transition target invalid.");
    ErrorCode WORK_ITEM_STATUS_SORT_INVALID = new ErrorCode(1_053_120_013, "Work item status sort data invalid.");
    ErrorCode WORK_ITEM_WORK_LOG_NOT_EXISTS = new ErrorCode(1_053_120_014, "Work item time spent record was not found.");
    ErrorCode WORK_ITEM_WORK_LOG_INVALID = new ErrorCode(1_053_120_015, "Time spent record and work item does not match.");
    ErrorCode WORK_ITEM_LABEL_NOT_EXISTS = new ErrorCode(1_053_120_016, "Work itemtag was not found.");
    ErrorCode WORK_ITEM_LABELS_INVALID = new ErrorCode(1_053_120_017, "Work itemtag data invalid.");
    ErrorCode WORK_ITEM_COMMENT_NOT_EXISTS = new ErrorCode(1_053_120_018, "Work item comment was not found.");
    ErrorCode WORK_ITEM_COMMENT_REPLY_INVALID = new ErrorCode(1_053_120_019, "Reply comment and work item does not match.");
    ErrorCode WORK_ITEM_COMMENT_ACCESS_DENIED = new ErrorCode(1_053_120_020, "Can only edit or delete its own comment.");
    ErrorCode WORK_ITEM_LIFECYCLE_STATUS_INVALID = new ErrorCode(1_053_120_021, "Work item current lifecycle status not support this action.");
    ErrorCode WORK_ITEM_DELETE_STATUS_INVALID = new ErrorCode(1_053_120_022, "Only recycle bin work item can permanently delete.");

    // ========== knowledge base 1-053-130-000 ==========
    ErrorCode KNOWLEDGE_LIBRARY_NOT_EXISTS = new ErrorCode(1_053_130_000, "Knowledge base was not found.");
    ErrorCode KNOWLEDGE_LIBRARY_ACCESS_DENIED = new ErrorCode(1_053_130_001, "Do not have permission access this knowledge base.");
    ErrorCode KNOWLEDGE_LIBRARY_WRITE_ACCESS_DENIED = new ErrorCode(1_053_130_002, "Do not have permission edit this knowledge base.");
    ErrorCode KNOWLEDGE_LIBRARY_ADMIN_REQUIRED = new ErrorCode(1_053_130_003, "Only knowledge base admin can execute this action.");
    ErrorCode KNOWLEDGE_LIBRARY_CREATOR_CANNOT_REMOVE = new ErrorCode(1_053_130_004, "Knowledge base creator cannot remove knowledge base.");
    ErrorCode KNOWLEDGE_LIBRARY_MEMBERS_INVALID = new ErrorCode(1_053_130_005, "Knowledge base member data invalid.");
    ErrorCode KNOWLEDGE_FOLDER_NOT_EXISTS = new ErrorCode(1_053_130_006, "Knowledge base folder was not found.");
    ErrorCode KNOWLEDGE_FOLDER_PARENT_INVALID = new ErrorCode(1_053_130_007, "Parent folder and knowledge base does not match.");
    ErrorCode KNOWLEDGE_FOLDER_MOVE_INVALID = new ErrorCode(1_053_130_008, "Folder cannot move to itself or its child folder.");
    ErrorCode KNOWLEDGE_DOCUMENT_NOT_EXISTS = new ErrorCode(1_053_130_009, "Knowledge basedocument was not found.");
    ErrorCode KNOWLEDGE_DOCUMENT_PARENT_INVALID = new ErrorCode(1_053_130_010, "Parent document and knowledge base does not match.");
    ErrorCode KNOWLEDGE_DOCUMENT_FOLDER_INVALID = new ErrorCode(1_053_130_011, "Document folder and knowledge base does not match.");
    ErrorCode KNOWLEDGE_DOCUMENT_MOVE_INVALID = new ErrorCode(1_053_130_012, "Document cannot move to itself or its child document.");
    ErrorCode KNOWLEDGE_DOCUMENT_STATUS_INVALID = new ErrorCode(1_053_130_013, "Document status invalid.");
    ErrorCode KNOWLEDGE_DOCUMENT_TYPE_INVALID = new ErrorCode(1_053_130_014, "Document type invalid.");
    ErrorCode KNOWLEDGE_DOCUMENT_MOVE_TARGET_INVALID = new ErrorCode(1_053_130_015, "Document move target can only select folder or parent document one of.");
    ErrorCode KNOWLEDGE_GROUP_NOT_EXISTS = new ErrorCode(1_053_130_020, "Knowledge base group was not found.");
    ErrorCode KNOWLEDGE_GROUP_NAME_DUPLICATE = new ErrorCode(1_053_130_021, "Knowledge base group name already exists.");
    ErrorCode KNOWLEDGE_GROUP_DEFAULT_CANNOT_MODIFY = new ErrorCode(1_053_130_022, "Default knowledge base group is not allowed edit.");
    ErrorCode KNOWLEDGE_GROUP_DEFAULT_CANNOT_DELETE = new ErrorCode(1_053_130_023, "Default knowledge base group is not alloweddelete.");
    ErrorCode KNOWLEDGE_GROUP_SORT_DUPLICATE = new ErrorCode(1_053_130_024, "Knowledge base group sort list exists duplicate group.");
    ErrorCode KNOWLEDGE_DOCUMENT_LABEL_NOT_EXISTS = new ErrorCode(1_053_130_030, "Knowledge basedocumenttag was not found.");
    ErrorCode KNOWLEDGE_RECYCLE_RECORD_NOT_EXISTS = new ErrorCode(1_053_130_040, "Knowledge base recycle bin record was not found.");
    ErrorCode KNOWLEDGE_RECYCLE_TYPE_INVALID = new ErrorCode(1_053_130_041, "Knowledge base recycle bin object type invalid.");
    ErrorCode KNOWLEDGE_INTERACTION_OBJECT_INVALID = new ErrorCode(1_053_130_050, "Knowledge object was not found or type does not match.");
    ErrorCode KNOWLEDGE_FAVORITE_DUPLICATE = new ErrorCode(1_053_130_051, "This knowledge object already follow.");
    ErrorCode KNOWLEDGE_DOCUMENT_SHARE_ALREADY_OPEN = new ErrorCode(1_053_130_060, "This document already enable share.");
    ErrorCode KNOWLEDGE_DOCUMENT_SHARE_INVALID = new ErrorCode(1_053_130_061, "Document share was not found or already expired.");
    ErrorCode KNOWLEDGE_CONTENT_PERMISSION_NOT_EXISTS = new ErrorCode(1_053_130_070, "Knowledge content collaboration permission was not found.");
    ErrorCode KNOWLEDGE_CONTENT_ACCESS_DENIED = new ErrorCode(1_053_130_071, "Do not have permission access this knowledge content.");
    ErrorCode KNOWLEDGE_CONTENT_WRITE_ACCESS_DENIED = new ErrorCode(1_053_130_072, "Do not have permission edit this knowledge content.");
    ErrorCode KNOWLEDGE_CONTENT_DELETE_ACCESS_DENIED = new ErrorCode(1_053_130_073, "Do not have permission delete this knowledge content.");
    ErrorCode KNOWLEDGE_CONTENT_PERMISSION_MEMBERS_INVALID = new ErrorCode(1_053_130_074, "Knowledge content collaborator data invalid.");
    ErrorCode KNOWLEDGE_DOCUMENT_COMMENT_NOT_EXISTS = new ErrorCode(1_053_130_080, "Knowledge base document comment was not found.");
    ErrorCode KNOWLEDGE_DOCUMENT_COMMENT_REPLY_INVALID = new ErrorCode(1_053_130_081, "Reply comment and document does not match.");
    ErrorCode KNOWLEDGE_DOCUMENT_COMMENT_ACCESS_DENIED = new ErrorCode(1_053_130_082, "Can only delete its own comment.");
    ErrorCode KNOWLEDGE_DOCUMENT_COMMENT_TYPE_INVALID = new ErrorCode(1_053_130_083, "Only rich text document support comment.");
    ErrorCode KNOWLEDGE_LIBRARY_TEMPLATE_NOT_EXISTS = new ErrorCode(1_053_130_084, "Knowledge basetemplate was not found.");
    ErrorCode KNOWLEDGE_LIBRARY_TEMPLATE_INVALID = new ErrorCode(1_053_130_085, "Knowledge basetemplatesetting invalid.");
    ErrorCode KNOWLEDGE_LIBRARY_DIRECT_MEMBER_NOT_EXISTS = new ErrorCode(1_053_130_086,
            "Current account is not this knowledge base directly member.");
    ErrorCode KNOWLEDGE_LIBRARY_TEMPLATE_NAME_DUPLICATE = new ErrorCode(1_053_130_087, "Knowledge basetemplate name already exists.");

}
