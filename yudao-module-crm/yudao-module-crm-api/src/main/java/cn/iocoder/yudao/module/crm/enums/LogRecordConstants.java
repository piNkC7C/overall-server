package cn.iocoder.yudao.module.crm.enums;

/**
 * CRM 操作日志枚举
 * 目的：统一管理，也减少 Service 里各种“复杂”字符串
 *
 * @author HUIHUI
 */
public interface LogRecordConstants {

    // ======================= CRM_CLUE lead =======================

    String CRM_CLUE_TYPE = "CRM lead";
    String CRM_CLUE_CREATE_SUB_TYPE = "Create lead";
    String CRM_CLUE_CREATE_SUCCESS = "Created lead{{#clue.name}}";
    String CRM_CLUE_UPDATE_SUB_TYPE = "Update lead";
    String CRM_CLUE_UPDATE_SUCCESS = "Updated lead[{{#clueName}}]: {_DIFF{#updateReqVO}}";
    String CRM_CLUE_DELETE_SUB_TYPE = "Delete lead";
    String CRM_CLUE_DELETE_SUCCESS = "Deleted lead[{{#clueName}}]";
    String CRM_CLUE_TRANSFER_SUB_TYPE = "Transfer lead";
    String CRM_CLUE_TRANSFER_SUCCESS = "lead[{{#clue.name}}] owner from [{getAdminUserById{#clue.ownerUserId}}] to [{getAdminUserById{#reqVO.newOwnerUserId}}]";
    String CRM_CLUE_TRANSLATE_SUB_TYPE = "lead converted to customer";
    String CRM_CLUE_TRANSLATE_SUCCESS = "lead[{{#clueName}}] converted to customer";
    String CRM_CLUE_FOLLOW_UP_SUB_TYPE = "leadFollow up";
    String CRM_CLUE_FOLLOW_UP_SUCCESS = "leadFollow up [{{#clueName}}]";

    // ======================= CRM_CUSTOMER customer =======================

    String CRM_CUSTOMER_TYPE = "CRM customer";
    String CRM_CUSTOMER_CREATE_SUB_TYPE = "Create customer";
    String CRM_CUSTOMER_CREATE_SUCCESS = "Created customer{{#customer.name}}";
    String CRM_CUSTOMER_UPDATE_SUB_TYPE = "Update customer";
    String CRM_CUSTOMER_UPDATE_SUCCESS = "Updated customer[{{#customerName}}]: {_DIFF{#updateReqVO}}";
    String CRM_CUSTOMER_DELETE_SUB_TYPE = "Delete customer";
    String CRM_CUSTOMER_DELETE_SUCCESS = "Deleted customer[{{#customerName}}]";
    String CRM_CUSTOMER_TRANSFER_SUB_TYPE = "Transfer customer";
    String CRM_CUSTOMER_TRANSFER_SUCCESS = "customer[{{#customer.name}}] owner from [{getAdminUserById{#customer.ownerUserId}}] to [{getAdminUserById{#reqVO.newOwnerUserId}}]";
    String CRM_CUSTOMER_LOCK_SUB_TYPE = "{{#customer.lockStatus ? 'Unlock customer' : 'Lock customer'}}";
    String CRM_CUSTOMER_LOCK_SUCCESS = "{{#customer.lockStatus ? 'Unlocked customer [' + #customer.name + ']' : 'Locked customer [' + #customer.name + ']'}}";
    String CRM_CUSTOMER_POOL_SUB_TYPE = "Move customer to the pool";
    String CRM_CUSTOMER_POOL_SUCCESS = "customer[{{#customerName}}] moved to pool";
    String CRM_CUSTOMER_RECEIVE_SUB_TYPE = "{{#ownerUserName != null ? 'Assign customer' : 'Claim customer'}}";
    String CRM_CUSTOMER_RECEIVE_SUCCESS = "{{#ownerUserName != null ? 'Assigned customer [' + #customer.name + '] to [' + #ownerUserName + ']' : 'Claimed customer [' + #customer.name + ']'}}";
    String CRM_CUSTOMER_IMPORT_SUB_TYPE = "{{#isUpdate ? 'Import and update customer' : 'Import customer'}}";
    String CRM_CUSTOMER_IMPORT_SUCCESS = "{{#isUpdate ? 'Imported and updated customer ['+ #customer.name +']' : 'Imported customer ['+ #customer.name +']'}}";
    String CRM_CUSTOMER_UPDATE_DEAL_STATUS_SUB_TYPE = "Update customer deal status";
    String CRM_CUSTOMER_UPDATE_DEAL_STATUS_SUCCESS = "Updated deal status for customer [{{#customerName}}] to [{{#dealStatus ? 'Won' : 'Open'}}]";
    String CRM_CUSTOMER_FOLLOW_UP_SUB_TYPE = "customerFollow up";
    String CRM_CUSTOMER_FOLLOW_UP_SUCCESS = "customerFollow up [{{#customerName}}]";

    // ======================= CRM_CUSTOMER_LIMIT_CONFIG 客户限制配置 =======================

    String CRM_CUSTOMER_LIMIT_CONFIG_TYPE = "CRM customer limit setting";
    String CRM_CUSTOMER_LIMIT_CONFIG_CREATE_SUB_TYPE = "Create customer limit setting";
    String CRM_CUSTOMER_LIMIT_CONFIG_CREATE_SUCCESS = "Created [{{#limitType}}]Type customer limit setting";
    String CRM_CUSTOMER_LIMIT_CONFIG_UPDATE_SUB_TYPE = "Update customer limit setting";
    String CRM_CUSTOMER_LIMIT_CONFIG_UPDATE_SUCCESS = "Updated customer limit setting: {_DIFF{#updateReqVO}}";
    String CRM_CUSTOMER_LIMIT_CONFIG_DELETE_SUB_TYPE = "Delete customer limit setting";
    String CRM_CUSTOMER_LIMIT_CONFIG_DELETE_SUCCESS = "Deleted [{{#limitType}}]Type customer limit setting";

    // ======================= CRM_CUSTOMER_POOL_CONFIG 客户公海规则 =======================

    String CRM_CUSTOMER_POOL_CONFIG_TYPE = "CRM customer pool rule";
    String CRM_CUSTOMER_POOL_CONFIG_SUB_TYPE = "{{#isPoolConfigUpdate ? 'Update customer pool rule' : 'Create customer pool rule'}}";
    String CRM_CUSTOMER_POOL_CONFIG_SUCCESS = "{{#isPoolConfigUpdate ? 'Updated the customer pool rule' : 'Created the customer pool rule'}}";

    // ======================= CRM_CONTACT contact =======================

    String CRM_CONTACT_TYPE = "CRM contact";
    String CRM_CONTACT_CREATE_SUB_TYPE = "Create contact";
    String CRM_CONTACT_CREATE_SUCCESS = "Created contact{{#contact.name}}";
    String CRM_CONTACT_UPDATE_SUB_TYPE = "Update contact";
    String CRM_CONTACT_UPDATE_SUCCESS = "Updated contact[{{#contactName}}]: {_DIFF{#updateReqVO}}";
    String CRM_CONTACT_DELETE_SUB_TYPE = "Delete contact";
    String CRM_CONTACT_DELETE_SUCCESS = "Deleted contact[{{#contactName}}]";
    String CRM_CONTACT_TRANSFER_SUB_TYPE = "Transfer contact";
    String CRM_CONTACT_TRANSFER_SUCCESS = "contact[{{#contact.name}}] owner from [{getAdminUserById{#contact.ownerUserId}}] to [{getAdminUserById{#reqVO.newOwnerUserId}}]";
    String CRM_CONTACT_FOLLOW_UP_SUB_TYPE = "contactFollow up";
    String CRM_CONTACT_FOLLOW_UP_SUCCESS = "contactFollow up [{{#contactName}}]";
    String CRM_CONTACT_UPDATE_OWNER_USER_SUB_TYPE = "Update contactowner";
    String CRM_CONTACT_UPDATE_OWNER_USER_SUCCESS = "contact[{{#contact.name}}] owner from [{getAdminUserById{#contact.ownerUserId}}] to [{getAdminUserById{#ownerUserId}}]";

    // ======================= CRM_BUSINESS opportunity =======================

    String CRM_BUSINESS_TYPE = "CRM opportunity";
    String CRM_BUSINESS_CREATE_SUB_TYPE = "Create opportunity";
    String CRM_BUSINESS_CREATE_SUCCESS = "Created opportunity{{#business.name}}";
    String CRM_BUSINESS_UPDATE_SUB_TYPE = "Update opportunity";
    String CRM_BUSINESS_UPDATE_SUCCESS = "Updated opportunity[{{#businessName}}]: {_DIFF{#updateReqVO}}";
    String CRM_BUSINESS_DELETE_SUB_TYPE = "Delete opportunity";
    String CRM_BUSINESS_DELETE_SUCCESS = "Deleted opportunity[{{#businessName}}]";
    String CRM_BUSINESS_TRANSFER_SUB_TYPE = "Transfer opportunity";
    String CRM_BUSINESS_TRANSFER_SUCCESS = "opportunity[{{#business.name}}] owner from [{getAdminUserById{#business.ownerUserId}}] to [{getAdminUserById{#reqVO.newOwnerUserId}}]";
    String CRM_BUSINESS_FOLLOW_UP_SUB_TYPE = "opportunityFollow up";
    String CRM_BUSINESS_FOLLOW_UP_SUCCESS = "opportunityFollow up [{{#businessName}}]";
    String CRM_BUSINESS_UPDATE_STATUS_SUB_TYPE = "Update opportunitystatus";
    String CRM_BUSINESS_UPDATE_STATUS_SUCCESS = "Updated opportunity[{{#businessName}}] status from [{{#oldStatusName}}] to [{{#newStatusName}}]";

    // ======================= CRM_CONTRACT_CONFIG contractsetting =======================

    String CRM_CONTRACT_CONFIG_TYPE = "CRM contract setting";
    String CRM_CONTRACT_CONFIG_SUB_TYPE = "{{#isPoolConfigUpdate ? 'Update contract setting' : 'Create contract setting'}}";
    String CRM_CONTRACT_CONFIG_SUCCESS = "{{#isPoolConfigUpdate ? 'Updated the contract setting' : 'Created the contract setting'}}";

    // ======================= CRM_CONTRACT contract =======================

    String CRM_CONTRACT_TYPE = "CRM contract";
    String CRM_CONTRACT_CREATE_SUB_TYPE = "Create contract";
    String CRM_CONTRACT_CREATE_SUCCESS = "Created contract{{#contract.name}}";
    String CRM_CONTRACT_UPDATE_SUB_TYPE = "Update contract";
    String CRM_CONTRACT_UPDATE_SUCCESS = "Updated contract[{{#contractName}}]: {_DIFF{#updateReqVO}}";
    String CRM_CONTRACT_DELETE_SUB_TYPE = "Delete contract";
    String CRM_CONTRACT_DELETE_SUCCESS = "Deleted contract[{{#contractName}}]";
    String CRM_CONTRACT_TRANSFER_SUB_TYPE = "Transfer contract";
    String CRM_CONTRACT_TRANSFER_SUCCESS = "contract[{{#contract.name}}] owner from [{getAdminUserById{#contract.ownerUserId}}] to [{getAdminUserById{#reqVO.newOwnerUserId}}]";
    String CRM_CONTRACT_SUBMIT_SUB_TYPE = "Submit contract for approval";
    String CRM_CONTRACT_SUBMIT_SUCCESS = "Submit contract[{{#contractName}}] approval succeeded";
    String CRM_CONTRACT_FOLLOW_UP_SUB_TYPE = "contractFollow up";
    String CRM_CONTRACT_FOLLOW_UP_SUCCESS = "contractFollow up [{{#contractName}}]";

    // ======================= CRM_PRODUCT product =======================

    String CRM_PRODUCT_TYPE = "CRM product";
    String CRM_PRODUCT_CREATE_SUB_TYPE = "Create product";
    String CRM_PRODUCT_CREATE_SUCCESS = "Created product[{{#createReqVO.name}}]";
    String CRM_PRODUCT_UPDATE_SUB_TYPE = "Update product";
    String CRM_PRODUCT_UPDATE_SUCCESS = "Updated product[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String CRM_PRODUCT_DELETE_SUB_TYPE = "Delete product";
    String CRM_PRODUCT_DELETE_SUCCESS = "Deleted product[{{#product.name}}]";

    // ======================= CRM_PRODUCT_CATEGORY product category =======================

    String CRM_PRODUCT_CATEGORY_TYPE = "CRM product category";
    String CRM_PRODUCT_CATEGORY_CREATE_SUB_TYPE = "Create product category";
    String CRM_PRODUCT_CATEGORY_CREATE_SUCCESS = "Created product category[{{#createReqVO.name}}]";
    String CRM_PRODUCT_CATEGORY_UPDATE_SUB_TYPE = "Update product category";
    String CRM_PRODUCT_CATEGORY_UPDATE_SUCCESS = "Updated product category[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String CRM_PRODUCT_CATEGORY_DELETE_SUB_TYPE = "Delete product category";
    String CRM_PRODUCT_CATEGORY_DELETE_SUCCESS = "Deleted product category[{{#productCategory.name}}]";

    // ======================= CRM_RECEIVABLE collection =======================

    String CRM_RECEIVABLE_TYPE = "CRM collection";
    String CRM_RECEIVABLE_CREATE_SUB_TYPE = "Create collection";
    String CRM_RECEIVABLE_CREATE_SUCCESS = "Created collection for contract [{getContractById{#receivable.contractId}}] {{#period != null ? 'period ['+ #period +']' : 'no. ['+ #receivable.no +']'}}";
    String CRM_RECEIVABLE_UPDATE_SUB_TYPE = "Update collection";
    String CRM_RECEIVABLE_UPDATE_SUCCESS = "Updated collection for contract [{getContractById{#oldReceivable.contractId}}] {{#period != null ? 'period ['+ #period +']' : 'no. ['+ #oldReceivable.no +']'}}: {_DIFF{#updateReqVO}}";
    String CRM_RECEIVABLE_DELETE_SUB_TYPE = "Delete collection";
    String CRM_RECEIVABLE_DELETE_SUCCESS = "Deleted collection for contract [{getContractById{#receivable.contractId}}] {{#period != null ? 'period ['+ #period +']' : 'no. ['+ #receivable.no +']'}}";
    String CRM_RECEIVABLE_SUBMIT_SUB_TYPE = "Submit collection for approval";
    String CRM_RECEIVABLE_SUBMIT_SUCCESS = "Submitted no. [{{#receivableNo}}] collection approval succeeded";

    // ======================= CRM_RECEIVABLE_PLAN collectionplan =======================

    String CRM_RECEIVABLE_PLAN_TYPE = "CRM collection plan";
    String CRM_RECEIVABLE_PLAN_CREATE_SUB_TYPE = "Create collection plan";
    String CRM_RECEIVABLE_PLAN_CREATE_SUCCESS = "Created contract[{getContractById{#receivablePlan.contractId}}] #[{{#receivablePlan.period}}] period collection plan";
    String CRM_RECEIVABLE_PLAN_UPDATE_SUB_TYPE = "Update collection plan";
    String CRM_RECEIVABLE_PLAN_UPDATE_SUCCESS = "Updated contract[{getContractById{#receivablePlan.contractId}}] #[{{#receivablePlan.period}}] period collection plan: {_DIFF{#updateReqVO}}";
    String CRM_RECEIVABLE_PLAN_DELETE_SUB_TYPE = "Delete collection plan";
    String CRM_RECEIVABLE_PLAN_DELETE_SUCCESS = "Deleted contract[{getContractById{#receivablePlan.contractId}}] #[{{#receivablePlan.period}}] period collection plan";

}
