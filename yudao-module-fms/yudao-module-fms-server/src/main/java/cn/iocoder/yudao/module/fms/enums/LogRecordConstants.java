package cn.iocoder.yudao.module.fms.enums;

/**
 * FMS 操作日志常量
 *
 * @author 芋道源码
 */
public interface LogRecordConstants {

    // ======================= FMS_ACCOUNT_SET books =======================

    String FMS_ACCOUNT_SET_TYPE = "FMS books";
    String FMS_ACCOUNT_SET_CREATE_SUB_TYPE = "Create books";
    String FMS_ACCOUNT_SET_CREATE_SUCCESS = "Created books[{{#createReqVO.companyName}}]";
    String FMS_ACCOUNT_SET_UPDATE_SUB_TYPE = "Update books";
    String FMS_ACCOUNT_SET_UPDATE_SUCCESS =
            "Updated books[{{#updateReqVO.companyName}}]: {_DIFF{#updateReqVO}}";
    String FMS_ACCOUNT_SET_INITIALIZE_SUB_TYPE = "Initialize books";
    String FMS_ACCOUNT_SET_INITIALIZE_SUCCESS = "Initialized books[{{#accountSet.companyName}}]";
    String FMS_ACCOUNT_SET_MEMBER_UPDATE_SUB_TYPE = "Update booksmember";
    String FMS_ACCOUNT_SET_MEMBER_UPDATE_SUCCESS =
            "Updated books[{{#accountSet.companyName}}] member access";

    // ======================= FMS_FINANCE_PARAMETER 财务参数 =======================

    String FMS_FINANCE_PARAMETER_TYPE = "FMS finance setting";
    String FMS_FINANCE_PARAMETER_UPDATE_SUB_TYPE = "Update finance setting";
    String FMS_FINANCE_PARAMETER_UPDATE_SUCCESS =
            "Updated books[{{#accountSet.companyName}}] finance settings: {_DIFF{#updateReqVO}}";

    // ======================= FMS_SUBJECT account =======================

    String FMS_SUBJECT_TYPE = "FMS account";
    String FMS_SUBJECT_CREATE_SUB_TYPE = "Create account";
    String FMS_SUBJECT_CREATE_SUCCESS = "Created account[{{#createReqVO.code}} {{#createReqVO.name}}]";
    String FMS_SUBJECT_UPDATE_SUB_TYPE = "Update account";
    String FMS_SUBJECT_UPDATE_SUCCESS = "Updated account[{{#updateReqVO.code}} {{#updateReqVO.name}}]";
    String FMS_SUBJECT_DELETE_SUB_TYPE = "Delete account";
    String FMS_SUBJECT_DELETE_SUCCESS = "Deleted [{{#subjects.size()}}] account";
    String FMS_SUBJECT_STATUS_SUB_TYPE = "Update accountstatus";
    String FMS_SUBJECT_STATUS_SUCCESS = "Updated accountstatus";

    // ======================= FMS_AUXILIARY auxiliary accounting =======================

    String FMS_AUXILIARY_TYPE = "FMS auxiliary accounting";
    String FMS_AUXILIARY_TYPE_CREATE_SUB_TYPE = "Create auxiliary category";
    String FMS_AUXILIARY_TYPE_CREATE_SUCCESS = "Created auxiliary category[{{#createReqVO.name}}]";
    String FMS_AUXILIARY_TYPE_UPDATE_SUB_TYPE = "Update auxiliary category";
    String FMS_AUXILIARY_TYPE_UPDATE_SUCCESS = "Updated auxiliary category[{{#updateReqVO.name}}]";
    String FMS_AUXILIARY_TYPE_DELETE_SUB_TYPE = "Delete auxiliary category";
    String FMS_AUXILIARY_TYPE_DELETE_SUCCESS = "Deleted auxiliary category[{{#auxiliaryType.name}}]";

    String FMS_AUXILIARY_ITEM_TYPE = "FMS auxiliary item";
    String FMS_AUXILIARY_ITEM_CREATE_SUB_TYPE = "Create auxiliary item";
    String FMS_AUXILIARY_ITEM_CREATE_SUCCESS = "Created auxiliary item[{{#createReqVO.code}} {{#createReqVO.name}}]";
    String FMS_AUXILIARY_ITEM_UPDATE_SUB_TYPE = "Update auxiliary item";
    String FMS_AUXILIARY_ITEM_UPDATE_SUCCESS = "Updated auxiliary item[{{#updateReqVO.code}} {{#updateReqVO.name}}]";
    String FMS_AUXILIARY_ITEM_DELETE_SUB_TYPE = "Delete auxiliary item";
    String FMS_AUXILIARY_ITEM_DELETE_SUCCESS = "Deleted auxiliary item[{{#auxiliaryItem.code}} {{#auxiliaryItem.name}}]";
    String FMS_AUXILIARY_ITEM_STATUS_SUB_TYPE = "Update auxiliary itemstatus";
    String FMS_AUXILIARY_ITEM_STATUS_SUCCESS = "Updated auxiliary itemstatus";

    // ======================= FMS_VOUCHER journal entry =======================

    String FMS_VOUCHER_TYPE = "FMS journal entry";
    String FMS_VOUCHER_CREATE_SUB_TYPE = "Create journal entry";
    String FMS_VOUCHER_CREATE_SUCCESS = "Created journal entry[{{#voucherId}}]";
    String FMS_VOUCHER_UPDATE_SUB_TYPE = "Update journal entry";
    String FMS_VOUCHER_UPDATE_SUCCESS = "Updated journal entry[{{#updateReqVO.id}}]";
    String FMS_VOUCHER_ATTACHMENT_UPDATE_SUB_TYPE = "Update journal entryattachments";
    String FMS_VOUCHER_ATTACHMENT_UPDATE_SUCCESS = "Updated journal entry[{{#updateReqVO.id}}] attachments";
    String FMS_VOUCHER_DELETE_SUB_TYPE = "Delete journal entry";
    String FMS_VOUCHER_DELETE_SUCCESS = "Deleted journal entry[{{#voucher.id}}]";
    String FMS_VOUCHER_REVIEW_SUB_TYPE = "Approve journal entry";
    String FMS_VOUCHER_REVIEW_SUCCESS = "Updated journal entryApprove status";
    String FMS_VOUCHER_TIDY_SUB_TYPE = "Tidy journal entry";
    String FMS_VOUCHER_TIDY_SUCCESS = "Tidied [{{#tidyReqVO.month}}] period journal entries";
    String FMS_VOUCHER_MOVE_SUB_TYPE = "Move journal entry";
    String FMS_VOUCHER_MOVE_SUCCESS = "[{{#moveReqVO.month}}] period [{{#moveReqVO.sourceNumber}}] journal entry moved before [{{#moveReqVO.targetNumber}}]";

    // ======================= FMS_VOUCHER_WORD journal entry character =======================

    String FMS_VOUCHER_WORD_TYPE = "FMS voucher word";
    String FMS_VOUCHER_WORD_CREATE_SUB_TYPE = "Create voucher word";
    String FMS_VOUCHER_WORD_CREATE_SUCCESS = "Created voucher word[{{#createReqVO.name}}]";
    String FMS_VOUCHER_WORD_UPDATE_SUB_TYPE = "Update voucher word";
    String FMS_VOUCHER_WORD_UPDATE_SUCCESS = "Updated voucher word[{{#updateReqVO.name}}]";
    String FMS_VOUCHER_WORD_DELETE_SUB_TYPE = "Delete voucher word";
    String FMS_VOUCHER_WORD_DELETE_SUCCESS = "Deleted voucher word[{{#voucherWord.name}}]";

    // ======================= FMS_VOUCHER_TEMPLATE journal entrytemplate =======================

    String FMS_VOUCHER_TEMPLATE_CATEGORY_TYPE = "FMS journal template category";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_CREATE_SUB_TYPE = "Create journal template category";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_CREATE_SUCCESS = "Created journal template category[{{#createReqVO.name}}]";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_UPDATE_SUB_TYPE = "Update journal template category";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_UPDATE_SUCCESS = "Updated journal template category[{{#updateReqVO.name}}]";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_DELETE_SUB_TYPE = "Delete journal template category";
    String FMS_VOUCHER_TEMPLATE_CATEGORY_DELETE_SUCCESS = "Deleted journal template category[{{#category.name}}]";

    String FMS_VOUCHER_TEMPLATE_TYPE = "FMS journal template";
    String FMS_VOUCHER_TEMPLATE_CREATE_SUB_TYPE = "Create journal template";
    String FMS_VOUCHER_TEMPLATE_CREATE_SUCCESS = "Created journal template[{{#createReqVO.name}}]";
    String FMS_VOUCHER_TEMPLATE_UPDATE_SUB_TYPE = "Update journal template";
    String FMS_VOUCHER_TEMPLATE_UPDATE_SUCCESS = "Updated journal template[{{#updateReqVO.name}}]";
    String FMS_VOUCHER_TEMPLATE_DELETE_SUB_TYPE = "Delete journal template";
    String FMS_VOUCHER_TEMPLATE_DELETE_SUCCESS = "Deleted journal template[{{#template.name}}]";

    // ======================= FMS_DIGEST 常用摘要 =======================

    String FMS_DIGEST_TYPE = "FMS common memo";
    String FMS_DIGEST_CREATE_SUB_TYPE = "Create common memo";
    String FMS_DIGEST_CREATE_SUCCESS = "Created common memo[{{#createReqVO.content}}]";
    String FMS_DIGEST_UPDATE_SUB_TYPE = "Update common memo";
    String FMS_DIGEST_UPDATE_SUCCESS = "Updated common memo[{{#updateReqVO.content}}]";
    String FMS_DIGEST_DELETE_SUB_TYPE = "Delete common memo";
    String FMS_DIGEST_DELETE_SUCCESS = "Deleted common memo[{{#digest.content}}]";

    // ======================= FMS_CURRENCY 币别 =======================

    String FMS_CURRENCY_TYPE = "FMS currency";
    String FMS_CURRENCY_CREATE_SUB_TYPE = "Create currency";
    String FMS_CURRENCY_CREATE_SUCCESS = "Created currency[{{#createReqVO.name}}]";
    String FMS_CURRENCY_UPDATE_SUB_TYPE = "Update currency";
    String FMS_CURRENCY_UPDATE_SUCCESS = "Updated currency[{{#updateReqVO.name}}]";
    String FMS_CURRENCY_DELETE_SUB_TYPE = "Delete currency";
    String FMS_CURRENCY_DELETE_SUCCESS = "Deleted currency[{{#currency.name}}]";

    // ======================= FMS_INITIAL_BALANCE 财务初始余额 =======================

    String FMS_INITIAL_BALANCE_TYPE = "FMS opening balance";
    String FMS_INITIAL_BALANCE_SAVE_SUB_TYPE = "Save opening balance";
    String FMS_INITIAL_BALANCE_SAVE_SUCCESS =
            "Saved books[{{#saveReqVO.accountSetId}}] [{{#saveReqVO.balances.size()}}] opening-balance items";
    String FMS_INITIAL_BALANCE_IMPORT_SUB_TYPE = "Import opening balance";
    String FMS_INITIAL_BALANCE_IMPORT_SUCCESS =
            "Imported [{{#_ret}}] opening-balance items into books [{{#accountSetId}}]";

    // ======================= FMS_CLOSING closing =======================

    String FMS_CLOSING_TYPE = "FMS Close period";
    String FMS_CLOSING_SCHEME_CREATE_SUB_TYPE = "Create closing plan";
    String FMS_CLOSING_SCHEME_CREATE_SUCCESS = "Created closing plan[{{#createReqVO.name}}]";
    String FMS_CLOSING_SCHEME_UPDATE_SUB_TYPE = "Update closing plan";
    String FMS_CLOSING_SCHEME_UPDATE_SUCCESS = "Updated closing plan[{{#updateReqVO.name}}]";
    String FMS_CLOSING_SCHEME_DELETE_SUB_TYPE = "Delete closing plan";
    String FMS_CLOSING_SCHEME_DELETE_SUCCESS = "Deleted closing plan[{{#id}}]";
    String FMS_CLOSING_TEMPLATE_CREATE_SUB_TYPE = "Create closing template";
    String FMS_CLOSING_TEMPLATE_CREATE_SUCCESS = "Created closing template[{{#createReqVO.name}}]";
    String FMS_CLOSING_TEMPLATE_UPDATE_SUB_TYPE = "Update closing template";
    String FMS_CLOSING_TEMPLATE_UPDATE_SUCCESS = "Updated closing template[{{#updateReqVO.name}}]";
    String FMS_CLOSING_TEMPLATE_DELETE_SUB_TYPE = "Delete closing template";
    String FMS_CLOSING_TEMPLATE_DELETE_SUCCESS = "Deleted closing template[{{#id}}]";
    String FMS_CLOSING_SETTINGS_UPDATE_SUB_TYPE = "Update closing setting";
    String FMS_CLOSING_SETTINGS_UPDATE_SUCCESS = "Updated books[{{#saveReqVO.accountSetId}}] closing setting";
    String FMS_CLOSING_SPECIAL_SETTINGS_UPDATE_SUCCESS =
            "Updated books[{{#updateReqVO.accountSetId}}] closing plan [{{#updateReqVO.id}}] setting";
    String FMS_CLOSING_VOUCHER_GENERATE_SUB_TYPE = "Generate closing journal entry";
    String FMS_CLOSING_PROFIT_LOSS_VOUCHER_GENERATE_SUCCESS =
            "Generated profit-and-loss closing journal entry [{{#_ret}}] for books [{{#generateReqVO.accountSetId}}] period {{#generateReqVO.month}}";
    String FMS_CLOSING_SCHEME_VOUCHER_GENERATE_SUCCESS =
            "Generated closing journal entry [{{#_ret}}] for books [{{#generateReqVO.accountSetId}}] period {{#generateReqVO.month}} plan [{{#generateReqVO.id}}]";
    String FMS_CLOSING_VOUCHER_BATCH_GENERATE_SUCCESS =
            "as books[{{#generateReqVO.accountSetId}}]{{#generateReqVO.month}} period batch-generated [{{#_ret.size()}}] closing journal entries";
    String FMS_CLOSING_PERIOD_CLOSE_SUB_TYPE = "Close period";
    String FMS_CLOSING_PERIOD_CLOSE_SUCCESS =
            "Closed books [{{#queryReqVO.accountSetId}}]{{#queryReqVO.month}} period close";
    String FMS_CLOSING_PERIOD_CANCEL_SUB_TYPE = "Reopen period";
    String FMS_CLOSING_PERIOD_CANCEL_SUCCESS =
            "Closed books [{{#queryReqVO.accountSetId}}]{{#queryReqVO.month}} period reopen";

    // ======================= FMS_CASH_FLOW_STATEMENT Cash Flow Statement =======================

    String FMS_CASH_FLOW_STATEMENT_TYPE = "FMS cash flow statement";
    String FMS_CASH_FLOW_STATEMENT_UPDATE_SUB_TYPE = "Adjust cash flow statement";
    String FMS_CASH_FLOW_STATEMENT_UPDATE_SUCCESS =
            "Adjusted books [{{#updateReqVO.accountSetId}}]{{#updateReqVO.startMonth}} to {{#updateReqVO.endMonth}} cash flow statement";
    String FMS_CASH_FLOW_ADJUSTMENT_UPDATE_SUB_TYPE = "Adjust cash flow support data";
    String FMS_CASH_FLOW_ADJUSTMENT_UPDATE_SUCCESS =
            "Adjusted books [{{#updateReqVO.accountSetId}}] [{{#updateReqVO.items.size()}}] cash flow support items";
    String FMS_CASH_FLOW_ADJUSTMENT_FORMULA_UPDATE_SUB_TYPE = "Update cash flow support formula";
    String FMS_CASH_FLOW_ADJUSTMENT_FORMULA_UPDATE_SUCCESS =
            "Updated books[{{#updateReqVO.accountSetId}}] cash flow support formula[{{#updateReqVO.id}}]";

}
