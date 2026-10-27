package cn.iocoder.yudao.module.crm.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * CRM 错误码枚举类
 * <p>
 * crm 系统，使用 1-020-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== contract admin 1-020-000-000 ==========
    ErrorCode CONTRACT_NOT_EXISTS = new ErrorCode(1_020_000_000, "Contract was not found.");
    ErrorCode CONTRACT_UPDATE_FAIL_NOT_DRAFT = new ErrorCode(1_020_000_001, "Contractupdate failed, : contract is not draft status.");
    ErrorCode CONTRACT_SUBMIT_FAIL_NOT_DRAFT = new ErrorCode(1_020_000_002, "Contract submit failed because it is not in draft.");
    ErrorCode CONTRACT_UPDATE_AUDIT_STATUS_FAIL_NOT_PROCESS = new ErrorCode(1_020_000_003, "Updatecontract approval status failed, : contract is not approval status.");
    ErrorCode CONTRACT_NO_EXISTS = new ErrorCode(1_020_000_004, "Createcontract serial number is duplicated, please retry.");
    ErrorCode CONTRACT_DELETE_FAIL = new ErrorCode(1_020_000_005, "Deletecontract failed, : has by collection used.");

    // ========== lead admin 1-020-001-000 ==========
    ErrorCode CLUE_NOT_EXISTS = new ErrorCode(1_020_001_000, "Lead was not found.");
    ErrorCode CLUE_TRANSFORM_FAIL_ALREADY = new ErrorCode(1_020_001_001, "This lead was already converted.");

    // ========== opportunity admin 1-020-002-000 ==========
    ErrorCode BUSINESS_NOT_EXISTS = new ErrorCode(1_020_002_000, "Opportunity was not found.");
    ErrorCode BUSINESS_DELETE_FAIL_CONTRACT_EXISTS = new ErrorCode(1_020_002_001, "Opportunity already related contract, cannot be deleted.");
    ErrorCode BUSINESS_UPDATE_STATUS_FAIL_END_STATUS = new ErrorCode(1_020_002_002, "Updateopportunity status failed, : already is end status.");
    ErrorCode BUSINESS_UPDATE_STATUS_FAIL_STATUS_EQUALS = new ErrorCode(1_020_002_003, "Updateopportunity status failed, : already is this status.");
    ErrorCode BUSINESS_CONTACT_CUSTOMER_NOT_MATCH = new ErrorCode(1_020_002_004, "Opportunity related contact does not belong to this customer.");

    // ========== contact admin 1-020-003-000 ==========
    ErrorCode CONTACT_NOT_EXISTS = new ErrorCode(1_020_003_000, "Contact was not found.");
    ErrorCode CONTACT_DELETE_FAIL_CONTRACT_LINK_EXISTS = new ErrorCode(1_020_003_002, "Contact already related contract, cannot be deleted.");
    ErrorCode CONTACT_UPDATE_OWNER_USER_FAIL = new ErrorCode(1_020_003_003, "Updatecontact owner person failed.");

    // ========== collection 1-020-004-000 ==========
    ErrorCode RECEIVABLE_NOT_EXISTS = new ErrorCode(1_020_004_000, "Collection was not found.");
    ErrorCode RECEIVABLE_UPDATE_FAIL_EDITING_PROHIBITED = new ErrorCode(1_020_004_001, "Payment collection cannot be edited.");
    ErrorCode RECEIVABLE_DELETE_FAIL = new ErrorCode(1_020_004_002, "Deletecollection failed, : by collectionplan used, is not alloweddelete.");
    ErrorCode RECEIVABLE_SUBMIT_FAIL_NOT_DRAFT = new ErrorCode(1_020_004_003, "Collection submit failed because it is not in draft.");
    ErrorCode RECEIVABLE_UPDATE_AUDIT_STATUS_FAIL_NOT_PROCESS = new ErrorCode(1_020_004_004, "Updatecollection approval status failed, : collection is not approval status.");
    ErrorCode RECEIVABLE_NO_EXISTS = new ErrorCode(1_020_004_005, "Createcollection serial number is duplicated, please retry.");
    ErrorCode RECEIVABLE_CREATE_FAIL_CONTRACT_NOT_APPROVE = new ErrorCode(1_020_004_006, "Createcollection failed, : contract is not approval via status.");
    ErrorCode RECEIVABLE_CREATE_FAIL_PRICE_EXCEEDS_LIMIT = new ErrorCode(1_020_004_007, "Collection amount exceeds the contract. Remaining: ${}.");
    ErrorCode RECEIVABLE_DELETE_FAIL_IS_APPROVE = new ErrorCode(1_020_004_008, "Deletecollection failed, : collection approval already via.");

    // ========== collectionplan 1-020-005-000 ==========
    ErrorCode RECEIVABLE_PLAN_NOT_EXISTS = new ErrorCode(1_020_005_000, "Collectionplan was not found.");
    ErrorCode RECEIVABLE_PLAN_UPDATE_FAIL = new ErrorCode(1_020_006_000, "Collection plan update failed because a repayment already exists.");
    ErrorCode RECEIVABLE_PLAN_EXISTS_RECEIVABLE = new ErrorCode(1_020_006_001, "Collectionplan already has a matching collection, cannot used.");

    // ========== customer admin 1_020_006_000 ==========
    ErrorCode CUSTOMER_NOT_EXISTS = new ErrorCode(1_020_006_000, "Customer was not found.");
    ErrorCode CUSTOMER_OWNER_EXISTS = new ErrorCode(1_020_006_001, "Customer[{}] already exists belonging owner person.");
    ErrorCode CUSTOMER_LOCKED = new ErrorCode(1_020_006_002, "Customer[{}] status already lock.");
    ErrorCode CUSTOMER_ALREADY_DEAL = new ErrorCode(1_020_006_003, "Customer already trade.");
    ErrorCode CUSTOMER_IN_POOL = new ErrorCode(1_020_006_004, "Cannot move customer [{}] to the pool: already in the pool.");
    ErrorCode CUSTOMER_LOCKED_PUT_POOL_FAIL = new ErrorCode(1_020_006_005, "Cannot move customer [{}] to the pool: the customer is locked.");
    ErrorCode CUSTOMER_UPDATE_OWNER_USER_FAIL = new ErrorCode(1_020_006_006, "Failed to update the owner of customer [{}] because of a system error.");
    ErrorCode CUSTOMER_LOCK_FAIL_IS_LOCK = new ErrorCode(1_020_006_007, "The customer is already locked.");
    ErrorCode CUSTOMER_UNLOCK_FAIL_IS_UNLOCK = new ErrorCode(1_020_006_008, "The customer is already unlocked.");
    ErrorCode CUSTOMER_LOCK_EXCEED_LIMIT = new ErrorCode(1_020_006_009, "Lock failed: the lock-rule limit was exceeded.");
    ErrorCode CUSTOMER_OWNER_EXCEED_LIMIT = new ErrorCode(1_020_006_010, "This action exceeds the customer ownership limit.");
    ErrorCode CUSTOMER_DELETE_FAIL_HAVE_REFERENCE = new ErrorCode(1_020_006_011, "Deletecustomer failed, has related {}.");
    ErrorCode CUSTOMER_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_020_006_012, "Importcustomer data is required!");
    ErrorCode CUSTOMER_CREATE_NAME_NOT_NULL = new ErrorCode(1_020_006_013, "Customer name is required!");
    ErrorCode CUSTOMER_NAME_EXISTS = new ErrorCode(1_020_006_014, "A customer named [{}] already exists.");
    ErrorCode CUSTOMER_UPDATE_DEAL_STATUS_FAIL = new ErrorCode(1_020_006_015, "Deal status is already set to this value.");

    // ========== permission admin 1_020_007_000 ==========
    ErrorCode CRM_PERMISSION_NOT_EXISTS = new ErrorCode(1_020_007_000, "Data permission was not found.");
    ErrorCode CRM_PERMISSION_DENIED = new ErrorCode(1_020_007_001, "{}The action failed, : do not have permission to.");
    ErrorCode CRM_PERMISSION_MODEL_TRANSFER_FAIL_OWNER_USER_EXISTS = new ErrorCode(1_020_007_003, "{}The action failed, : transfer object already is this owner person.");
    ErrorCode CRM_PERMISSION_DELETE_FAIL = new ErrorCode(1_020_007_004, "Bulk permission deletes must share the same bizId.");
    ErrorCode CRM_PERMISSION_DELETE_DENIED = new ErrorCode(1_020_007_006, "Delete data permission failed, : do not have permission to.");
    ErrorCode CRM_PERMISSION_DELETE_SELF_PERMISSION_FAIL_EXIST_OWNER = new ErrorCode(1_020_007_007, "Delete data permission failed, : cannot be deleted owner person.");
    ErrorCode CRM_PERMISSION_CREATE_FAIL = new ErrorCode(1_020_007_008, "The user already has this data permission.");
    ErrorCode CRM_PERMISSION_CREATE_FAIL_EXISTS = new ErrorCode(1_020_007_009, "User [{}] already has [{}] permission on module [{}] data [{}].");

    // ========== product 1_020_008_000 ==========
    ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(1_020_008_000, "Product was not found.");
    ErrorCode PRODUCT_NO_EXISTS = new ErrorCode(1_020_008_001, "Product code already exists.");
    ErrorCode PRODUCT_NOT_ENABLE = new ErrorCode(1_020_008_002, "Product[{}] is disabled.");
    ErrorCode PRODUCT_DELETE_FAIL_CONTRACT_EXISTS = new ErrorCode(1_020_008_003, "Product is already used by contract referenced, cannot delete.");
    ErrorCode PRODUCT_DELETE_FAIL_BUSINESS_EXISTS = new ErrorCode(1_020_008_004, "Product is already used by opportunity referenced, cannot delete.");

    // ========== product category 1_020_009_000 ==========
    ErrorCode PRODUCT_CATEGORY_NOT_EXISTS = new ErrorCode(1_020_009_000, "Product category was not found.");
    ErrorCode PRODUCT_CATEGORY_EXISTS = new ErrorCode(1_020_009_001, "Product category already exists.");
    ErrorCode PRODUCT_CATEGORY_USED = new ErrorCode(1_020_009_002, "Product category already related product.");
    ErrorCode PRODUCT_CATEGORY_PARENT_NOT_EXISTS = new ErrorCode(1_020_009_003, "Parent category was not found.");
    ErrorCode PRODUCT_CATEGORY_PARENT_NOT_FIRST_LEVEL = new ErrorCode(1_020_009_004, "Parent category cannot be second-level category.");
    ErrorCode PRODUCT_CATEGORY_EXISTS_CHILDREN = new ErrorCode(1_020_009_005, "Exists child category, cannot delete.");

    // ========== opportunity status 1_020_010_000 ==========
    ErrorCode BUSINESS_STATUS_TYPE_NOT_EXISTS = new ErrorCode(1_020_010_000, "Opportunity status group was not found.");
    ErrorCode BUSINESS_STATUS_TYPE_NAME_EXISTS = new ErrorCode(1_020_010_001, "Opportunity status group name already exists.");
    ErrorCode BUSINESS_STATUS_UPDATE_FAIL_USED = new ErrorCode(1_020_010_002, "Already by used opportunity status group, cannot update.");
    ErrorCode BUSINESS_STATUS_DELETE_FAIL_USED = new ErrorCode(1_020_010_002, "Already by used opportunity status group, cannot delete.");
    ErrorCode BUSINESS_STATUS_NOT_EXISTS = new ErrorCode(1_020_010_003, "Opportunity status was not found.");

    // ========== 客户公海规则设置 1_020_012_000 ==========
    ErrorCode CUSTOMER_LIMIT_CONFIG_NOT_EXISTS = new ErrorCode(1_020_012_001, "Customer limit setting not found.");

    // ========== Follow-uprecord 1_020_013_000 ==========
    ErrorCode FOLLOW_UP_RECORD_NOT_EXISTS = new ErrorCode(1_020_013_000, "Follow-up record not found.");
    ErrorCode FOLLOW_UP_RECORD_DELETE_DENIED = new ErrorCode(1_020_013_001, "You do not have permission to delete this follow-up.");

    // ========== 业绩目标配置 1_020_011_000 ==========
    ErrorCode PERFORMANCE_CONFIG_NOT_EXISTS = new ErrorCode(1_020_011_000, "Performance target setting not found.");
    ErrorCode PERFORMANCE_CONFIG_EXISTS = new ErrorCode(1_020_011_001, "A performance target for this object and year already exists.");
    ErrorCode PERFORMANCE_CONFIG_TYPE_INVALID = new ErrorCode(1_020_011_002, "Target object type is invalid.");

}
