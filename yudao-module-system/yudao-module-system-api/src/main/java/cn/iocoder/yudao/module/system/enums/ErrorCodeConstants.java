package cn.iocoder.yudao.module.system.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * System 错误码枚举类
 *
 * system 系统，使用 1-002-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== AUTH 模块 1-002-000-000 ==========
    ErrorCode AUTH_LOGIN_BAD_CREDENTIALS = new ErrorCode(1_002_000_000, "Sign-in failed. Check your username and password.");
    ErrorCode AUTH_LOGIN_USER_DISABLED = new ErrorCode(1_002_000_001, "Sign-in failed. This account is disabled.");
    ErrorCode AUTH_LOGIN_CAPTCHA_CODE_ERROR = new ErrorCode(1_002_000_004, "Incorrect verification code: {}");
    ErrorCode AUTH_THIRD_LOGIN_NOT_BIND = new ErrorCode(1_002_000_005, "This account is not linked yet. Complete the link to continue.");
    ErrorCode AUTH_MOBILE_NOT_EXISTS = new ErrorCode(1_002_000_007, "That phone number was not found.");
    ErrorCode AUTH_REGISTER_CAPTCHA_CODE_ERROR = new ErrorCode(1_002_000_008, "Incorrect verification code: {}");
    ErrorCode AUTH_QRCODE_INVALID = new ErrorCode(1_002_000_009, "This QR code expired or the ticket is invalid. Scan again.");
    ErrorCode AUTH_QRCODE_ALREADY_CONFIRMED = new ErrorCode(1_002_000_010, "This QR code was already confirmed. Scan again.");

    // ========== 菜单模块 1-002-001-000 ==========
    ErrorCode MENU_NAME_DUPLICATE = new ErrorCode(1_002_001_000, "A menu with this name already exists.");
    ErrorCode MENU_PARENT_NOT_EXISTS = new ErrorCode(1_002_001_001, "The parent menu was not found.");
    ErrorCode MENU_PARENT_ERROR = new ErrorCode(1_002_001_002, "A menu cannot be its own parent.");
    ErrorCode MENU_NOT_EXISTS = new ErrorCode(1_002_001_003, "The menu was not found.");
    ErrorCode MENU_EXISTS_CHILDREN = new ErrorCode(1_002_001_004, "This menu has children, so it cannot be deleted.");
    ErrorCode MENU_PARENT_NOT_DIR_OR_MENU = new ErrorCode(1_002_001_005, "The parent must be a directory or a menu.");
    ErrorCode MENU_COMPONENT_NAME_DUPLICATE = new ErrorCode(1_002_001_006, "A menu with this component name already exists.");

    // ========== 角色模块 1-002-002-000 ==========
    ErrorCode ROLE_NOT_EXISTS = new ErrorCode(1_002_002_000, "The role was not found.");
    ErrorCode ROLE_NAME_DUPLICATE = new ErrorCode(1_002_002_001, "A role named [{}] already exists.");
    ErrorCode ROLE_CODE_DUPLICATE = new ErrorCode(1_002_002_002, "A role with the code [{}] already exists.");
    ErrorCode ROLE_CAN_NOT_UPDATE_SYSTEM_TYPE_ROLE = new ErrorCode(1_002_002_003, "Built-in system roles cannot be changed.");
    ErrorCode ROLE_IS_DISABLE = new ErrorCode(1_002_002_004, "The role [{}] is disabled.");
    ErrorCode ROLE_ADMIN_CODE_ERROR = new ErrorCode(1_002_002_005, "The code [{}] is reserved.");

    // ========== 用户模块 1-002-003-000 ==========
    ErrorCode USER_USERNAME_EXISTS = new ErrorCode(1_002_003_000, "This username is already taken.");
    ErrorCode USER_MOBILE_EXISTS = new ErrorCode(1_002_003_001, "This phone number is already in use.");
    ErrorCode USER_EMAIL_EXISTS = new ErrorCode(1_002_003_002, "This email address is already in use.");
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1_002_003_003, "The user was not found.");
    ErrorCode USER_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_002_003_004, "The import file has no users.");
    ErrorCode USER_PASSWORD_FAILED = new ErrorCode(1_002_003_005, "The password is incorrect.");
    ErrorCode USER_IS_DISABLE = new ErrorCode(1_002_003_006, "The user [{}] is disabled.");
    ErrorCode USER_COUNT_MAX = new ErrorCode(1_002_003_008, "Could not create the user. This tenant reached its user limit ({}).");
    ErrorCode USER_IMPORT_INIT_PASSWORD = new ErrorCode(1_002_003_009, "Set an initial password.");
    ErrorCode USER_MOBILE_NOT_EXISTS = new ErrorCode(1_002_003_010, "This phone number is not registered.");
    ErrorCode USER_REGISTER_DISABLED = new ErrorCode(1_002_003_011, "Registration is turned off.");
    ErrorCode USER_ADMIN_NOT_ALLOW_DISABLE = new ErrorCode(1_002_003_012, "The super admin or tenant admin account cannot be disabled.");
    ErrorCode USER_ADMIN_NOT_ALLOW_DELETE = new ErrorCode(1_002_003_013, "The super admin or tenant admin account cannot be deleted.");

    // ========== 部门模块 1-002-004-000 ==========
    ErrorCode DEPT_NAME_DUPLICATE = new ErrorCode(1_002_004_000, "A department with this name already exists.");
    ErrorCode DEPT_PARENT_NOT_EXITS = new ErrorCode(1_002_004_001,"The parent department was not found.");
    ErrorCode DEPT_NOT_FOUND = new ErrorCode(1_002_004_002, "The department was not found.");
    ErrorCode DEPT_EXITS_CHILDREN = new ErrorCode(1_002_004_003, "This department has children, so it cannot be deleted.");
    ErrorCode DEPT_PARENT_ERROR = new ErrorCode(1_002_004_004, "A department cannot be its own parent.");
    ErrorCode DEPT_NOT_ENABLE = new ErrorCode(1_002_004_006, "Department ({}) is not active, so it cannot be selected.");
    ErrorCode DEPT_PARENT_IS_CHILD = new ErrorCode(1_002_004_007, "A department cannot use one of its children as its parent.");
    ErrorCode DEPT_NOT_IN_SCOPE = new ErrorCode(1_002_004_008, "Department ({}) is outside your data scope.");

    // ========== 岗位模块 1-002-005-000 ==========
    ErrorCode POST_NOT_FOUND = new ErrorCode(1_002_005_000, "The job title was not found.");
    ErrorCode POST_NOT_ENABLE = new ErrorCode(1_002_005_001, "Job title ({}) is not active, so it cannot be selected.");
    ErrorCode POST_NAME_DUPLICATE = new ErrorCode(1_002_005_002, "A job title with this name already exists.");
    ErrorCode POST_CODE_DUPLICATE = new ErrorCode(1_002_005_003, "A job title with this code already exists.");

    // ========== 字典类型 1-002-006-000 ==========
    ErrorCode DICT_TYPE_NOT_EXISTS = new ErrorCode(1_002_006_001, "The dictionary type was not found.");
    ErrorCode DICT_TYPE_NOT_ENABLE = new ErrorCode(1_002_006_002, "This dictionary type is not active, so it cannot be selected.");
    ErrorCode DICT_TYPE_NAME_DUPLICATE = new ErrorCode(1_002_006_003, "A dictionary type with this name already exists.");
    ErrorCode DICT_TYPE_TYPE_DUPLICATE = new ErrorCode(1_002_006_004, "A dictionary type with this code already exists.");
    ErrorCode DICT_TYPE_HAS_CHILDREN = new ErrorCode(1_002_006_005, "This dictionary type still has values, so it cannot be deleted.");

    // ========== 字典数据 1-002-007-000 ==========
    ErrorCode DICT_DATA_NOT_EXISTS = new ErrorCode(1_002_007_001, "The dictionary value was not found.");
    ErrorCode DICT_DATA_NOT_ENABLE = new ErrorCode(1_002_007_002, "Dictionary value ({}) is not active, so it cannot be selected.");
    ErrorCode DICT_DATA_VALUE_DUPLICATE = new ErrorCode(1_002_007_003, "A dictionary value with this code already exists.");

    // ========== 通知公告 1-002-008-000 ==========
    ErrorCode NOTICE_NOT_FOUND = new ErrorCode(1_002_008_001, "The announcement was not found.");

    // ========== 短信渠道 1-002-011-000 ==========
    ErrorCode SMS_CHANNEL_NOT_EXISTS = new ErrorCode(1_002_011_000, "The SMS channel was not found.");
    ErrorCode SMS_CHANNEL_DISABLE = new ErrorCode(1_002_011_001, "This SMS channel is not active, so it cannot be selected.");
    ErrorCode SMS_CHANNEL_HAS_CHILDREN = new ErrorCode(1_002_011_002, "This SMS channel still has templates, so it cannot be deleted.");

    // ========== 短信模板 1-002-012-000 ==========
    ErrorCode SMS_TEMPLATE_NOT_EXISTS = new ErrorCode(1_002_012_000, "The SMS template was not found.");
    ErrorCode SMS_TEMPLATE_CODE_DUPLICATE = new ErrorCode(1_002_012_001, "An SMS template with the code [{}] already exists.");
    ErrorCode SMS_TEMPLATE_API_ERROR = new ErrorCode(1_002_012_002, "The SMS API template call failed: {}");
    ErrorCode SMS_TEMPLATE_API_AUDIT_CHECKING = new ErrorCode(1_002_012_003, "This SMS API template is still under review.");
    ErrorCode SMS_TEMPLATE_API_AUDIT_FAIL = new ErrorCode(1_002_012_004, "This SMS API template was rejected: {}");
    ErrorCode SMS_TEMPLATE_API_NOT_FOUND = new ErrorCode(1_002_012_005, "This SMS API template was not found.");

    // ========== 短信发送 1-002-013-000 ==========
    ErrorCode SMS_SEND_MOBILE_NOT_EXISTS = new ErrorCode(1_002_013_000, "That phone number was not found.");
    ErrorCode SMS_SEND_MOBILE_TEMPLATE_PARAM_MISS = new ErrorCode(1_002_013_001, "The template is missing parameter ({}).");
    ErrorCode SMS_SEND_TEMPLATE_NOT_EXISTS = new ErrorCode(1_002_013_002, "The SMS template was not found.");

    // ========== 短信验证码 1-002-014-000 ==========
    ErrorCode SMS_CODE_NOT_FOUND = new ErrorCode(1_002_014_000, "The verification code was not found.");
    ErrorCode SMS_CODE_EXPIRED = new ErrorCode(1_002_014_001, "The verification code expired.");
    ErrorCode SMS_CODE_USED = new ErrorCode(1_002_014_002, "This verification code was already used.");
    ErrorCode SMS_CODE_EXCEED_SEND_MAXIMUM_QUANTITY_PER_DAY = new ErrorCode(1_002_014_004, "Daily SMS limit reached.");
    ErrorCode SMS_CODE_SEND_TOO_FAST = new ErrorCode(1_002_014_005, "Please wait before requesting another SMS code.");

    // ========== 租户信息 1-002-015-000 ==========
    ErrorCode TENANT_NOT_EXISTS = new ErrorCode(1_002_015_000, "The tenant was not found.");
    ErrorCode TENANT_DISABLE = new ErrorCode(1_002_015_001, "The tenant [{}] is disabled.");
    ErrorCode TENANT_EXPIRE = new ErrorCode(1_002_015_002, "The tenant [{}] has expired.");
    ErrorCode TENANT_CAN_NOT_UPDATE_SYSTEM = new ErrorCode(1_002_015_003, "The system tenant cannot be edited or deleted.");
    ErrorCode TENANT_NAME_DUPLICATE = new ErrorCode(1_002_015_004, "A tenant named [{}] already exists.");
    ErrorCode TENANT_WEBSITE_DUPLICATE = new ErrorCode(1_002_015_005, "A tenant with the domain [{}] already exists.");

    // ========== 租户套餐 1-002-016-000 ==========
    ErrorCode TENANT_PACKAGE_NOT_EXISTS = new ErrorCode(1_002_016_000, "The tenant plan was not found.");
    ErrorCode TENANT_PACKAGE_USED = new ErrorCode(1_002_016_001, "A tenant is using this plan. Assign a different plan before deleting it.");
    ErrorCode TENANT_PACKAGE_DISABLE = new ErrorCode(1_002_016_002, "The tenant plan [{}] is disabled.");
    ErrorCode TENANT_PACKAGE_NAME_DUPLICATE = new ErrorCode(1_002_016_003, "A tenant plan with this name already exists.");

    // ========== 社交用户 1-002-018-000 ==========
    ErrorCode SOCIAL_USER_AUTH_FAILURE = new ErrorCode(1_002_018_000, "Social sign-in failed: {}");
    ErrorCode SOCIAL_USER_NOT_FOUND = new ErrorCode(1_002_018_001, "Social sign-in failed. The user was not found.");

    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_PHONE_CODE_ERROR = new ErrorCode(1_002_018_200, "Could not get the phone number.");
    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_QRCODE_ERROR = new ErrorCode(1_002_018_201, "Could not get the mini program code.");
    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_SUBSCRIBE_TEMPLATE_ERROR = new ErrorCode(1_002_018_202, "Could not get the mini program subscribe template.");
    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_SUBSCRIBE_MESSAGE_ERROR = new ErrorCode(1_002_018_203, "Could not send the mini program subscribe message.");
    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_ORDER_UPLOAD_SHIPPING_INFO_ERROR = new ErrorCode(1_002_018_204, "Could not upload WeChat mini program shipping info.");
    ErrorCode SOCIAL_CLIENT_WEIXIN_MINI_APP_ORDER_NOTIFY_CONFIRM_RECEIVE_ERROR = new ErrorCode(1_002_018_205, "Could not upload WeChat mini program delivery confirmation.");
    ErrorCode SOCIAL_CLIENT_NOT_EXISTS = new ErrorCode(1_002_018_210, "The social client was not found.");
    ErrorCode SOCIAL_CLIENT_UNIQUE = new ErrorCode(1_002_018_211, "This social client is already configured.");

    // ========== OAuth2 客户端 1-002-020-000 =========
    ErrorCode OAUTH2_CLIENT_NOT_EXISTS = new ErrorCode(1_002_020_000, "The OAuth2 client was not found.");
    ErrorCode OAUTH2_CLIENT_EXISTS = new ErrorCode(1_002_020_001, "An OAuth2 client with this ID already exists.");
    ErrorCode OAUTH2_CLIENT_DISABLE = new ErrorCode(1_002_020_002, "This OAuth2 client is disabled.");
    ErrorCode OAUTH2_CLIENT_AUTHORIZED_GRANT_TYPE_NOT_EXISTS = new ErrorCode(1_002_020_003, "This grant type is not supported.");
    ErrorCode OAUTH2_CLIENT_SCOPE_OVER = new ErrorCode(1_002_020_004, "The requested scope is too broad.");
    ErrorCode OAUTH2_CLIENT_REDIRECT_URI_NOT_MATCH = new ErrorCode(1_002_020_005, "Invalid redirect_uri: {}");
    ErrorCode OAUTH2_CLIENT_CLIENT_SECRET_ERROR = new ErrorCode(1_002_020_006, "Invalid client_secret: {}");

    // ========== OAuth2 授权 1-002-021-000 =========
    ErrorCode OAUTH2_GRANT_CLIENT_ID_MISMATCH = new ErrorCode(1_002_021_000, "The client_id does not match.");
    ErrorCode OAUTH2_GRANT_REDIRECT_URI_MISMATCH = new ErrorCode(1_002_021_001, "The redirect_uri does not match.");
    ErrorCode OAUTH2_GRANT_STATE_MISMATCH = new ErrorCode(1_002_021_002, "The state does not match.");

    // ========== OAuth2 授权 1-002-022-000 =========
    ErrorCode OAUTH2_CODE_NOT_EXISTS = new ErrorCode(1_002_022_000, "The authorization code was not found.");
    ErrorCode OAUTH2_CODE_EXPIRE = new ErrorCode(1_002_022_001, "The authorization code expired.");

    // ========== 邮箱账号 1-002-023-000 ==========
    ErrorCode MAIL_ACCOUNT_NOT_EXISTS = new ErrorCode(1_002_023_000, "The email account was not found.");
    ErrorCode MAIL_ACCOUNT_RELATE_TEMPLATE_EXISTS = new ErrorCode(1_002_023_001, "This email account still has templates, so it cannot be deleted.");

    // ========== 邮件模版 1-002-024-000 ==========
    ErrorCode MAIL_TEMPLATE_NOT_EXISTS = new ErrorCode(1_002_024_000, "The email template was not found.");
    ErrorCode MAIL_TEMPLATE_CODE_EXISTS = new ErrorCode(1_002_024_001, "An email template with the code ({}) already exists.");

    // ========== 邮件发送 1-002-025-000 ==========
    ErrorCode MAIL_SEND_TEMPLATE_PARAM_MISS = new ErrorCode(1_002_025_000, "The template is missing parameter ({}).");
    ErrorCode MAIL_SEND_MAIL_NOT_EXISTS = new ErrorCode(1_002_025_001, "The email address was not found.");

    // ========== 站内信模版 1-002-026-000 ==========
    ErrorCode NOTIFY_TEMPLATE_NOT_EXISTS = new ErrorCode(1_002_026_000, "The notification template was not found.");
    ErrorCode NOTIFY_TEMPLATE_CODE_DUPLICATE = new ErrorCode(1_002_026_001, "A notification template with the code [{}] already exists.");

    // ========== 站内信模版 1-002-027-000 ==========

    // ========== 站内信发送 1-002-028-000 ==========
    ErrorCode NOTIFY_SEND_TEMPLATE_PARAM_MISS = new ErrorCode(1_002_028_000, "The template is missing parameter ({}).");

}
