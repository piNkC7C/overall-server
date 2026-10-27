package cn.iocoder.yudao.module.fms.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * FMS 错误码常量
 *
 * @author 芋道源码
 */
public interface ErrorCodeConstants {

    // ========== books 1-052-100-000 ==========
    ErrorCode ACCOUNT_SET_NOT_EXISTS = new ErrorCode(1_052_100_000, "Books was not found.");
    ErrorCode ACCOUNT_SET_CODE_DUPLICATE = new ErrorCode(1_052_100_001, "Books code already exists.");
    ErrorCode ACCOUNT_SET_ACCESS_DENIED = new ErrorCode(1_052_100_002, "Do not have permission access this books.");
    ErrorCode ACCOUNT_SET_ALREADY_INITIALIZED = new ErrorCode(1_052_100_003, "The books are already initialized.");
    ErrorCode ACCOUNT_SET_NOT_INITIALIZED = new ErrorCode(1_052_100_005, "The books are not initialized yet.");
    ErrorCode ACCOUNT_SET_SETTINGS_RULE_INVALID = new ErrorCode(1_052_100_006, "Account coderule is invalid.");
    ErrorCode ACCOUNT_SET_SETTINGS_RULE_SHRINK = new ErrorCode(1_052_100_007, "Account level and code length cannot be reduced.");
    ErrorCode FINANCE_PARAMETER_NOT_EXISTS = new ErrorCode(1_052_100_008, "Finance setting not found.");

    // ========== account 1-052-101-000 ==========
    ErrorCode SUBJECT_NOT_EXISTS = new ErrorCode(1_052_101_000, "Account was not found.");
    ErrorCode SUBJECT_CODE_DUPLICATE = new ErrorCode(1_052_101_001, "Account code already exists.");
    ErrorCode SUBJECT_CATEGORY_INVALID = new ErrorCode(1_052_101_002, "Account class and account type does not match.");
    ErrorCode SUBJECT_PARENT_INVALID = new ErrorCode(1_052_101_003,
            "Level account does not belong to current books, or account type、 class do not match.");
    ErrorCode SUBJECT_CODE_RULE_INVALID = new ErrorCode(1_052_101_004, "The account code does not match the account-level rule.");
    ErrorCode SUBJECT_HAS_CHILDREN = new ErrorCode(1_052_101_005, "Account has child level account, cannot be deleted or edit code.");
    ErrorCode SUBJECT_QUANTITY_UNIT_REQUIRED = new ErrorCode(1_052_101_006, "Enable quantity accounting time quantity order is required.");
    ErrorCode SUBJECT_CURRENCY_INVALID = new ErrorCode(1_052_101_007, "Foreign-currency accounting cannot use the base currency.");
    ErrorCode SUBJECT_VOUCHER_ENTRY_IN_USE = new ErrorCode(1_052_101_008,
            "Account is already used by {} item journal entry entry used, cannot be deleted.");
    ErrorCode SUBJECT_VOUCHER_TEMPLATE_IN_USE = new ErrorCode(1_052_101_009,
            "Account is already used by {} journal entrytemplate used, cannot be deleted.");
    ErrorCode SUBJECT_INITIAL_BALANCE_IN_USE = new ErrorCode(1_052_101_010,
            "Account is already used by {} item initial balance used, cannot be deleted.");
    ErrorCode SUBJECT_AUXILIARY_COMBINATION_IN_USE = new ErrorCode(1_052_101_011,
            "The account is used by {} auxiliary accounting combinations and cannot be deleted.");
    ErrorCode SUBJECT_CLOSING_SCHEME_IN_USE = new ErrorCode(1_052_101_012,
            "Account is already used by {} closing plan used, cannot be deleted.");
    ErrorCode SUBJECT_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_052_101_013, "Importaccount data is required.");
    ErrorCode SUBJECT_USED_BALANCE_DIRECTION_IMMUTABLE = new ErrorCode(1_052_101_014,
            "The account has transactions, so the balance direction cannot change.");
    ErrorCode SUBJECT_USED_AUXILIARY_IMMUTABLE = new ErrorCode(1_052_101_015,
            "Account already has business data, cannot directly edit auxiliary accounting.");
    ErrorCode SUBJECT_NON_LEAF_CONFIG_IMMUTABLE = new ErrorCode(1_052_101_016,
            "Non-leaf accounts cannot change type, category, or auxiliary accounting.");
    ErrorCode SUBJECT_QUANTITY_ACCOUNTING_IN_USE = new ErrorCode(1_052_101_017,
            "Account already has quantity data, cannot disable quantity accounting.");
    ErrorCode SUBJECT_PARENT_IN_USE = new ErrorCode(1_052_101_018,
            "The parent account has transactions. Migrate history before adding a child.");
    ErrorCode SUBJECT_PARENT_CONFIG_INCOMPATIBLE = new ErrorCode(1_052_101_019,
            "Child account balance direction and accounting settings must match the parent during migration.");
    ErrorCode SUBJECT_AUXILIARY_MIGRATION_INVALID = new ErrorCode(1_052_101_020,
            "Choose a valid migration item for each auxiliary category when the account has transactions.");
    ErrorCode SUBJECT_CLOSING_TEMPLATE_IN_USE = new ErrorCode(1_052_101_021,
            "Account is already used by {} closing template used, cannot be deleted.");

    // ========== auxiliary accounting 1-052-102-000 ==========
    ErrorCode AUXILIARY_TYPE_NOT_EXISTS = new ErrorCode(1_052_102_000, "Auxiliary accounting class was not found.");
    ErrorCode AUXILIARY_TYPE_NAME_DUPLICATE = new ErrorCode(1_052_102_001, "Auxiliary accounting class name already exists.");
    ErrorCode AUXILIARY_TYPE_SYSTEM_NOT_EDITABLE = new ErrorCode(1_052_102_002, "System auxiliary accounting categories cannot be edited or deleted.");
    ErrorCode AUXILIARY_TYPE_HAS_ITEM = new ErrorCode(1_052_102_003,
            "Auxiliary accounting class has {} item, cannot be deleted.");
    ErrorCode AUXILIARY_ITEM_NOT_EXISTS = new ErrorCode(1_052_102_004, "Auxiliary accounting project was not found.");
    ErrorCode AUXILIARY_ITEM_CODE_DUPLICATE = new ErrorCode(1_052_102_005, "Auxiliary accounting project code already exists.");
    ErrorCode AUXILIARY_TYPE_SUBJECT_IN_USE = new ErrorCode(1_052_102_006,
            "Auxiliary accounting class is already used by {} account used, cannot be deleted.");
    ErrorCode AUXILIARY_ITEM_VOUCHER_IN_USE = new ErrorCode(1_052_102_007,
            "Auxiliary accounting project is already used by {} item journal entry entry used, cannot be deleted.");
    ErrorCode AUXILIARY_ITEM_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_052_102_008,
            "Import auxiliary accounting project data is required.");
    ErrorCode AUXILIARY_ITEM_VOUCHER_TEMPLATE_IN_USE = new ErrorCode(1_052_102_009,
            "Auxiliary accounting project is already used by {} journal entrytemplate used, cannot be deleted.");
    ErrorCode AUXILIARY_ITEM_INITIAL_BALANCE_IN_USE = new ErrorCode(1_052_102_010,
            "Auxiliary accounting item is already used by {} item initial balance used, cannot be deleted.");
    ErrorCode AUXILIARY_TYPE_VOUCHER_IN_USE = new ErrorCode(1_052_102_012,
            "Auxiliary accounting class is already used by {} item journal entry entry used, cannot be deleted.");
    ErrorCode AUXILIARY_TYPE_VOUCHER_TEMPLATE_IN_USE = new ErrorCode(1_052_102_013,
            "Auxiliary accounting class is already used by {} journal entrytemplate used, cannot be deleted.");
    ErrorCode AUXILIARY_TYPE_INITIAL_BALANCE_IN_USE = new ErrorCode(1_052_102_014,
            "Auxiliary accounting class is already used by {} item initial balance used, cannot be deleted.");

    // ========== journal entry 1-052-103-000 ==========
    ErrorCode VOUCHER_NOT_EXISTS = new ErrorCode(1_052_103_000, "Journal entry was not found.");
    ErrorCode VOUCHER_WORD_NOT_EXISTS = new ErrorCode(1_052_103_001, "Journal entry character was not found.");
    ErrorCode VOUCHER_NUMBER_DUPLICATE = new ErrorCode(1_052_103_002, "This period journal entry no. already exists.");
    ErrorCode VOUCHER_ENTRY_REQUIRED = new ErrorCode(1_052_103_003, "A voucher needs at least two valid lines.");
    ErrorCode VOUCHER_ENTRY_AMOUNT_INVALID = new ErrorCode(1_052_103_004, "A voucher line can have either a debit or a credit amount.");
    ErrorCode VOUCHER_AMOUNT_UNBALANCED = new ErrorCode(1_052_103_005, "Debits and credits are out of balance.");
    ErrorCode VOUCHER_APPROVED_NOT_EDITABLE = new ErrorCode(1_052_103_006, "Approvedjournal entry cannot edit or delete.");
    ErrorCode VOUCHER_STATUS_INVALID = new ErrorCode(1_052_103_007, "Invalid voucher status change.");
    ErrorCode VOUCHER_SUBJECT_DISABLED = new ErrorCode(1_052_103_008, "Journal entry entry used is disabledaccount.");
    ErrorCode VOUCHER_SUBJECT_HAS_CHILDREN = new ErrorCode(1_052_103_009, "Voucher lines must use leaf accounts.");
    ErrorCode VOUCHER_AUXILIARY_REQUIRED = new ErrorCode(1_052_103_010, "Auxiliary accounting items on the voucher line are incomplete.");
    ErrorCode VOUCHER_QUANTITY_INVALID = new ErrorCode(1_052_103_011, "Journal entry entry quantity accounting info is invalid.");
    ErrorCode VOUCHER_WORD_NAME_DUPLICATE = new ErrorCode(1_052_103_012, "Journal entry character already exists.");
    ErrorCode VOUCHER_WORD_DEFAULT_REQUIRED = new ErrorCode(1_052_103_013, "Keep at least one default voucher word.");
    ErrorCode VOUCHER_WORD_DEFAULT_NOT_DELETABLE = new ErrorCode(1_052_103_014, "Default journal entry character is not alloweddelete.");
    ErrorCode VOUCHER_WORD_IN_USE_NOT_EDITABLE = new ErrorCode(1_052_103_015, "Used journal entry character cannot edit.");
    ErrorCode VOUCHER_WORD_IN_USE_NOT_DELETABLE = new ErrorCode(1_052_103_016,
            "This voucher word is used by {} vouchers and cannot be deleted.");
    ErrorCode VOUCHER_TEMPLATE_CATEGORY_NOT_EXISTS = new ErrorCode(1_052_103_017, "Journal entrytemplatecategory was not found.");
    ErrorCode VOUCHER_TEMPLATE_CATEGORY_NAME_DUPLICATE = new ErrorCode(1_052_103_018, "Journal entrytemplatecategory already exists.");
    ErrorCode VOUCHER_TEMPLATE_CATEGORY_IN_USE = new ErrorCode(1_052_103_019, "Category still has journal entrytemplate, cannot be deleted.");
    ErrorCode VOUCHER_TEMPLATE_NOT_EXISTS = new ErrorCode(1_052_103_020, "Journal entrytemplate was not found.");
    ErrorCode DIGEST_NOT_EXISTS = new ErrorCode(1_052_103_021, "Common memo not found.");
    ErrorCode VOUCHER_STATISTICS_RANGE_INVALID = new ErrorCode(1_052_103_022, "Invalid voucher summary range.");
    ErrorCode VOUCHER_MOVE_RANGE_INVALID = new ErrorCode(1_052_103_023, "Move to journal entry no. must small at original journal entry no.");
    ErrorCode VOUCHER_MOVE_SOURCE_NOT_EXISTS = new ErrorCode(1_052_103_024, "Need move journal entry was not found.");
    ErrorCode VOUCHER_IMPORT_FILE_EMPTY = new ErrorCode(1_052_103_025, "Select need import journal entry file.");
    ErrorCode VOUCHER_IMPORT_FILE_TOO_LARGE = new ErrorCode(1_052_103_026, "Import file cannot exceeds 2MB.");
    ErrorCode VOUCHER_IMPORT_TEMPLATE_INVALID = new ErrorCode(1_052_103_027, "Journal entryimporttemplate format is invalid.");
    ErrorCode VOUCHER_CLOSING_GENERATED_NOT_EDITABLE = new ErrorCode(1_052_103_029, "Closing createjournal entry cannot edit 、 approval or delete.");
    ErrorCode VOUCHER_WORD_IN_USE_BY_CLOSING_SCHEME_NOT_DELETABLE = new ErrorCode(1_052_103_030,
            "This journal entry character is already used by {} closing plan used, cannot be deleted.");

    // ========== 账簿 1-052-104-000 ==========
    ErrorCode LEDGER_PERIOD_INVALID = new ErrorCode(1_052_104_000, "The start period cannot be later than the end period.");
    ErrorCode INITIAL_BALANCE_SUBJECT_NOT_LEAF = new ErrorCode(1_052_104_001, "Opening balances can be entered only on leaf accounts.");
    ErrorCode INITIAL_BALANCE_AUXILIARY_INVALID = new ErrorCode(1_052_104_002, "Auxiliary accounting project and accountsetting do not match.");
    ErrorCode INITIAL_BALANCE_PROFIT_LOSS_YEAR_OPENING_INVALID = new ErrorCode(1_052_104_003,
            "P&L accounts must have a zero beginning balance.");
    ErrorCode INITIAL_BALANCE_IMPORT_TEMPLATE_INVALID = new ErrorCode(1_052_104_006,
            "Initial balance importtemplate format is invalid.");
    ErrorCode INITIAL_BALANCE_IMPORT_ROW_INVALID = new ErrorCode(1_052_104_008,
            "Row {} import failed: {}.");
    ErrorCode INITIAL_BALANCE_PERIOD_CLOSED = new ErrorCode(1_052_104_009,
            "Books already closing, cannot edit initial balance.");
    ErrorCode LEDGER_PERIOD_BEFORE_ACCOUNT_START = new ErrorCode(1_052_104_010,
            "The start period cannot be earlier than the books start period.");

    // ========== closing 1-052-105-000 ==========
    ErrorCode CLOSING_PERIOD_CLOSED = new ErrorCode(1_052_105_000, "This accounting period is already closed.");
    ErrorCode CLOSING_PERIOD_NOT_CLOSED = new ErrorCode(1_052_105_001, "This accounting period is not closed yet.");
    ErrorCode CLOSING_NOT_LATEST_PERIOD = new ErrorCode(1_052_105_002, "Only the latest closed period can be reopened.");
    ErrorCode CLOSING_VOUCHER_PENDING_REVIEW = new ErrorCode(1_052_105_003, "Exists unapprovedjournal entry, cannot closing.");
    ErrorCode CLOSING_PROFIT_LOSS_NOT_TRANSFERRED = new ErrorCode(1_052_105_004, "P&L accounts still have a balance. Close P&L first.");
    ErrorCode CLOSING_BALANCE_SHEET_UNBALANCED = new ErrorCode(1_052_105_005, "The balance sheet is out of balance, so the period cannot close.");
    ErrorCode CLOSING_PROFIT_SUBJECT_INVALID = new ErrorCode(1_052_105_006, "The current-year profit account is invalid.");
    ErrorCode CLOSING_NO_PROFIT_LOSS_BALANCE = new ErrorCode(1_052_105_007, "Current period no need to close P&L.");
    ErrorCode CLOSING_SCHEME_NOT_EXISTS = new ErrorCode(1_052_105_008, "Closing plan was not found.");
    ErrorCode CLOSING_SCHEME_SUBJECT_INVALID = new ErrorCode(1_052_105_009, "Closing planaccount is invalid.");
    ErrorCode CLOSING_SCHEME_RATIO_INVALID = new ErrorCode(1_052_105_010, "Closing-plan debit and credit ratios must each equal 100%.");
    ErrorCode CLOSING_SCHEME_NO_BALANCE = new ErrorCode(1_052_105_011, "This closing voucher is not needed for the current period.");
    ErrorCode CLOSING_SCHEME_IN_USE = new ErrorCode(1_052_105_012, "Closing plan already createjournal entry, cannot be deleted.");
    ErrorCode CLOSING_NOT_CURRENT_PERIOD = new ErrorCode(1_052_105_013, "You can act only on the current accounting period.");
    ErrorCode CLOSING_PROFIT_LOSS_SETTINGS_INVALID = new ErrorCode(1_052_105_014, "Close P&L accountset is invalid.");
    ErrorCode CLOSING_PROFIT_LOSS_SETTINGS_NOT_EXISTS = new ErrorCode(1_052_105_015, "First complete close P&L parameter set.");
    ErrorCode CLOSING_SPECIAL_SETTINGS_INVALID = new ErrorCode(1_052_105_016, "Special closing settings are invalid.");
    ErrorCode CLOSING_SPECIAL_SUBJECT_NOT_EXISTS = new ErrorCode(1_052_105_017, "A required preset account for special closing is missing.");
    ErrorCode CLOSING_INITIAL_BALANCE_UNBALANCED = new ErrorCode(1_052_105_018, "The opening-balance trial is out of balance, so the period cannot close.");
    ErrorCode CLOSING_VOUCHER_NUMBER_DISCONTINUOUS = new ErrorCode(1_052_105_019,
            "This period has voucher number gaps. Renumber first.");
    ErrorCode CLOSING_PROFIT_LOSS_VOUCHER_MISSING = new ErrorCode(1_052_105_020,
            "This period has P&L activity. Generate the P&L closing voucher first.");
    ErrorCode CLOSING_INCOME_STATEMENT_UNBALANCED = new ErrorCode(1_052_105_021,
            "The income statement does not reconcile, so the period cannot close.");
    ErrorCode CLOSING_REPORT_SUBJECT_UNMAPPED = new ErrorCode(1_052_105_022,
            "Some accounts are missing from report formulas, so the period cannot close.");
    ErrorCode CLOSING_TEMPLATE_NOT_EXISTS = new ErrorCode(1_052_105_023, "Closing template was not found.");
    ErrorCode CLOSING_TEMPLATE_PRESET_INVALID = new ErrorCode(1_052_105_024, "Closing-template seed data is invalid.");
    ErrorCode CLOSING_TEMPLATE_PRESET_SUBJECT_NOT_EXISTS = new ErrorCode(1_052_105_025,
            "Closing template[{}] need to account[{}] was not found.");
    ErrorCode CLOSING_SCHEME_PRESET_SUBJECT_NOT_EXISTS = new ErrorCode(1_052_105_026,
            "Closing plan [{}] need to account[{}] was not found.");
    ErrorCode CLOSING_SCHEME_NOT_PERIOD_END = new ErrorCode(1_052_105_027,
            "This closing plan does not enable period-end closing.");

    // ========== report 1-052-106-000 ==========
    ErrorCode REPORT_CONFIG_NOT_EXISTS = new ErrorCode(1_052_106_000, "Reportproject was not found.");
    ErrorCode REPORT_CONFIG_NOT_EDITABLE = new ErrorCode(1_052_106_001, "This report item does not allow formula edits.");
    ErrorCode REPORT_FORMULA_SUBJECT_DUPLICATE = new ErrorCode(1_052_106_002, "Report-formula accounts cannot be duplicated.");
    ErrorCode REPORT_FORMULA_RULE_INVALID = new ErrorCode(1_052_106_003, "The report-formula fetch rule is invalid.");
    ErrorCode REPORT_FORMULA_OPERATOR_INVALID = new ErrorCode(1_052_106_004, "The report-formula operator is invalid.");
    ErrorCode REPORT_ADJUSTMENT_NOT_EXISTS = new ErrorCode(1_052_106_005, "Cash-flow auxiliary data not found.");
    ErrorCode REPORT_AMOUNT_NOT_ADJUSTABLE = new ErrorCode(1_052_106_006, "This cash-flow item does not allow amount adjustments.");

    // ========== 币种 1-052-107-000 ==========
    ErrorCode CURRENCY_NOT_EXISTS = new ErrorCode(1_052_107_000, "Currency not found.");
    ErrorCode CURRENCY_CODE_DUPLICATE = new ErrorCode(1_052_107_001, "Currency code already exists.");
    ErrorCode CURRENCY_STANDARD_NOT_DELETABLE = new ErrorCode(1_052_107_002, "The base currency cannot be deleted.");
    ErrorCode CURRENCY_IN_USE = new ErrorCode(1_052_107_003, "The currency is used by accounts and cannot be deleted.");

    // ========== Home 1-052-108-000 ==========
    ErrorCode HOME_METRIC_INVALID = new ErrorCode(1_052_108_001, "Home financial metrics are invalid.");

}
