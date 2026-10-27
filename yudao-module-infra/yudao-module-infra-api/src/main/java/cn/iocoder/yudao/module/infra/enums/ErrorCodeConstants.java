package cn.iocoder.yudao.module.infra.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Infra error codes.
 *
 * Infra uses the 1-001-000-000 range.
 */
public interface ErrorCodeConstants {

    // ========== Config 1-001-000-000 ==========
    ErrorCode CONFIG_NOT_EXISTS = new ErrorCode(1_001_000_001, "The setting was not found.");
    ErrorCode CONFIG_KEY_DUPLICATE = new ErrorCode(1_001_000_002, "A setting with this key already exists.");
    ErrorCode CONFIG_CAN_NOT_DELETE_SYSTEM_TYPE = new ErrorCode(1_001_000_003, "Built-in settings cannot be deleted.");
    ErrorCode CONFIG_GET_VALUE_ERROR_IF_VISIBLE = new ErrorCode(1_001_000_004, "This setting is hidden and cannot be read.");

    // ========== Scheduled jobs 1-001-001-000 ==========
    ErrorCode JOB_NOT_EXISTS = new ErrorCode(1_001_001_000, "The scheduled job was not found.");
    ErrorCode JOB_HANDLER_EXISTS = new ErrorCode(1_001_001_001, "A scheduled job with this handler already exists.");
    ErrorCode JOB_CHANGE_STATUS_INVALID = new ErrorCode(1_001_001_002, "The job status can only be set to enabled or disabled.");
    ErrorCode JOB_CHANGE_STATUS_EQUALS = new ErrorCode(1_001_001_003, "The scheduled job is already in that status.");
    ErrorCode JOB_UPDATE_ONLY_NORMAL_STATUS = new ErrorCode(1_001_001_004, "Only enabled jobs can be edited.");
    ErrorCode JOB_CRON_EXPRESSION_VALID = new ErrorCode(1_001_001_005, "The CRON expression is invalid.");
    ErrorCode JOB_HANDLER_BEAN_NOT_EXISTS = new ErrorCode(1_001_001_006, "The job handler bean was not found. Bean names are case-sensitive and usually start with a lowercase letter.");
    ErrorCode JOB_HANDLER_BEAN_TYPE_ERROR = new ErrorCode(1_001_001_007, "The job handler bean must implement JobHandler.");

    // ========== API error logs 1-001-002-000 ==========
    ErrorCode API_ERROR_LOG_NOT_FOUND = new ErrorCode(1_001_002_000, "The API error log was not found.");
    ErrorCode API_ERROR_LOG_PROCESSED = new ErrorCode(1_001_002_001, "This API error log was already processed.");

    // ========= Files 1-001-003-000 =================
    ErrorCode FILE_PATH_EXISTS = new ErrorCode(1_001_003_000, "A file with this path already exists.");
    ErrorCode FILE_NOT_EXISTS = new ErrorCode(1_001_003_001, "The file was not found.");
    ErrorCode FILE_IS_EMPTY = new ErrorCode(1_001_003_002, "The file is empty.");
    ErrorCode FILE_PATH_INVALID = new ErrorCode(1_001_003_003, "The file path is invalid.");
    ErrorCode FILE_TYPE_NOT_ALLOWED = new ErrorCode(1_001_003_004, "This file type is not allowed.");

    // ========== Code generator 1-001-004-000 ==========
    ErrorCode CODEGEN_TABLE_EXISTS = new ErrorCode(1_001_004_002, "This table definition already exists.");
    ErrorCode CODEGEN_IMPORT_TABLE_NULL = new ErrorCode(1_001_004_001, "The imported table was not found.");
    ErrorCode CODEGEN_IMPORT_COLUMNS_NULL = new ErrorCode(1_001_004_002, "The imported columns were not found.");
    ErrorCode CODEGEN_TABLE_NOT_EXISTS = new ErrorCode(1_001_004_004, "The table definition was not found.");
    ErrorCode CODEGEN_COLUMN_NOT_EXISTS = new ErrorCode(1_001_004_005, "The column definition was not found.");
    ErrorCode CODEGEN_SYNC_COLUMNS_NULL = new ErrorCode(1_001_004_006, "The columns to sync were not found.");
    ErrorCode CODEGEN_SYNC_NONE_CHANGE = new ErrorCode(1_001_004_007, "Sync failed because nothing changed.");
    ErrorCode CODEGEN_TABLE_INFO_TABLE_COMMENT_IS_NULL = new ErrorCode(1_001_004_008, "The database table comment is missing.");
    ErrorCode CODEGEN_TABLE_INFO_COLUMN_COMMENT_IS_NULL = new ErrorCode(1_001_004_009, "The comment for column ({}) is missing.");
    ErrorCode CODEGEN_MASTER_TABLE_NOT_EXISTS = new ErrorCode(1_001_004_010, "The primary table (id={}) was not found.");
    ErrorCode CODEGEN_SUB_COLUMN_NOT_EXISTS = new ErrorCode(1_001_004_011, "The child-table column (id={}) was not found.");
    ErrorCode CODEGEN_MASTER_GENERATION_FAIL_NO_SUB_TABLE = new ErrorCode(1_001_004_012, "Could not generate code for the primary table because it has no child tables.");
    ErrorCode CODEGEN_MASTER_TABLE_NAME_DUPLICATE = new ErrorCode(1_001_004_013,
            "The normalized class name ({}) is used by both the primary and child table. Change one of the class names.");
    ErrorCode CODEGEN_MASTER_TABLE_FIELD_DUPLICATE = new ErrorCode(1_001_004_014,
            "The property name ({}) is used more than once. Change the primary-table field, child-table class name, or relationship.");

    // ========== File config 1-001-006-000 ==========
    ErrorCode FILE_CONFIG_NOT_EXISTS = new ErrorCode(1_001_006_000, "The file storage setting was not found.");
    ErrorCode FILE_CONFIG_DELETE_FAIL_MASTER = new ErrorCode(1_001_006_001, "The primary file storage setting cannot be deleted. Uploads would stop working.");

    // ========== Data source config 1-001-007-000 ==========
    ErrorCode DATA_SOURCE_CONFIG_NOT_EXISTS = new ErrorCode(1_001_007_000, "The data source setting was not found.");
    ErrorCode DATA_SOURCE_CONFIG_NOT_OK = new ErrorCode(1_001_007_001, "Could not connect with this data source setting.");

    // ========== Demo 1-001-201-000 ==========
    ErrorCode DEMO01_CONTACT_NOT_EXISTS = new ErrorCode(1_001_201_000, "The sample contact was not found.");
    ErrorCode DEMO02_CATEGORY_NOT_EXISTS = new ErrorCode(1_001_201_001, "The sample category was not found.");
    ErrorCode DEMO02_CATEGORY_EXITS_CHILDREN = new ErrorCode(1_001_201_002, "This sample category has children, so it cannot be deleted.");
    ErrorCode DEMO02_CATEGORY_PARENT_NOT_EXITS = new ErrorCode(1_001_201_003, "The parent sample category was not found.");
    ErrorCode DEMO02_CATEGORY_PARENT_ERROR = new ErrorCode(1_001_201_004, "A sample category cannot be its own parent.");
    ErrorCode DEMO02_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_001_201_005, "A sample category with this name already exists.");
    ErrorCode DEMO02_CATEGORY_PARENT_IS_CHILD = new ErrorCode(1_001_201_006, "A sample category cannot use one of its children as its parent.");
    ErrorCode DEMO03_STUDENT_NOT_EXISTS = new ErrorCode(1_001_201_007, "The student was not found.");
    ErrorCode DEMO03_COURSE_NOT_EXISTS = new ErrorCode(1_001_201_008, "The student course was not found.");
    ErrorCode DEMO03_GRADE_NOT_EXISTS = new ErrorCode(1_001_201_009, "The student class was not found.");
    ErrorCode DEMO03_GRADE_EXISTS = new ErrorCode(1_001_201_010, "This student class already exists.");

}
