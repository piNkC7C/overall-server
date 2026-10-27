package cn.iocoder.yudao.module.member.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Member 错误码枚举类
 * <p>
 * member 系统，使用 1-004-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 用户相关  1-004-001-000 ============
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1_004_001_000, "User was not found.");
    ErrorCode USER_MOBILE_NOT_EXISTS = new ErrorCode(1_004_001_001, "Phone number not register user.");
    ErrorCode USER_MOBILE_USED = new ErrorCode(1_004_001_002, "Failed to change the phone number because ({}) is already used.");
    ErrorCode USER_POINT_NOT_ENOUGH = new ErrorCode(1_004_001_003, "User points balance is insufficient.");
    ErrorCode USER_EMAIL_USED = new ErrorCode(1_004_001_004, "Edit email failed, this email({}) already by used.");

    // ========== AUTH module 1-004-003-000 ==========
    ErrorCode AUTH_LOGIN_BAD_CREDENTIALS = new ErrorCode(1_004_003_000, "Sign-in failed. Check your username and password.");
    ErrorCode AUTH_LOGIN_USER_DISABLED = new ErrorCode(1_004_003_001, "Sign-in failed because the account is disabled.");
    ErrorCode AUTH_SOCIAL_USER_NOT_FOUND = new ErrorCode(1_004_003_005, "Sign-in failed because third-party sign-in data could not be parsed.");
    ErrorCode AUTH_MOBILE_USED = new ErrorCode(1_004_003_007, "Phone number already by used.");

    // ========== 用户收件地址 1-004-004-000 ==========
    ErrorCode ADDRESS_NOT_EXISTS = new ErrorCode(1_004_004_000, "Shipping address not found.");

    //========== usertag 1-004-006-000 ==========
    ErrorCode TAG_NOT_EXISTS = new ErrorCode(1_004_006_000, "Usertag was not found.");
    ErrorCode TAG_NAME_EXISTS = new ErrorCode(1_004_006_001, "Usertag already exists.");
    ErrorCode TAG_HAS_USER = new ErrorCode(1_004_006_002, "Usertag still has user, cannot delete.");

    //========== points setting 1-004-007-000 ==========

    //========== points record 1-004-008-000 ==========
    ErrorCode POINT_RECORD_BIZ_NOT_SUPPORT = new ErrorCode(1_004_008_000, "User points record business type not support.");

    //========== 签到配置 1-004-009-000 ==========
    ErrorCode SIGN_IN_CONFIG_NOT_EXISTS = new ErrorCode(1_004_009_000, "Check-in day rule not found.");
    ErrorCode SIGN_IN_CONFIG_EXISTS = new ErrorCode(1_004_009_001, "Check-in day rule already exists.");

    //========== 签到配置 1-004-010-000 ==========
    ErrorCode SIGN_IN_RECORD_TODAY_EXISTS = new ErrorCode(1_004_010_000, "You already checked in today.");

    //========== user level 1-004-011-000 ==========
    ErrorCode LEVEL_NOT_EXISTS = new ErrorCode(1_004_011_000, "User level was not found.");
    ErrorCode LEVEL_NAME_EXISTS = new ErrorCode(1_004_011_001, "User level name[{}] is already used by used.");
    ErrorCode LEVEL_VALUE_EXISTS = new ErrorCode(1_004_011_002, "User level value [{}] is already used by [{}] used.");
    ErrorCode LEVEL_EXPERIENCE_MIN = new ErrorCode(1_004_011_003, "Upgrade experience must large at one level [{}]set upgrade experience [{}].");
    ErrorCode LEVEL_EXPERIENCE_MAX = new ErrorCode(1_004_011_004, "Upgrade experience must small at next level [{}]set upgrade experience [{}].");
    ErrorCode LEVEL_HAS_USER = new ErrorCode(1_004_011_005, "User level still has user, cannot delete.");

    ErrorCode EXPERIENCE_BIZ_NOT_SUPPORT = new ErrorCode(1_004_011_201, "User experience business type not support.");

    //========== user group 1-004-012-000 ==========
    ErrorCode GROUP_NOT_EXISTS = new ErrorCode(1_004_012_000, "User group was not found.");
    ErrorCode GROUP_HAS_USER = new ErrorCode(1_004_012_001, "User group still has user, cannot delete.");

}
