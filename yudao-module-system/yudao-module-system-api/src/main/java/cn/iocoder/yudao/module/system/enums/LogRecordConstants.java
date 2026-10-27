package cn.iocoder.yudao.module.system.enums;

/**
 * System 操作日志枚举
 * 目的：统一管理，也减少 Service 里各种“复杂”字符串
 *
 * @author 芋道源码
 */
public interface LogRecordConstants {

    // ======================= SYSTEM_USER user =======================

    String SYSTEM_USER_TYPE = "SYSTEM user";
    String SYSTEM_USER_CREATE_SUB_TYPE = "Create user";
    String SYSTEM_USER_CREATE_SUCCESS = "Created user[{{#user.nickname}}]";
    String SYSTEM_USER_UPDATE_SUB_TYPE = "Update user";
    String SYSTEM_USER_UPDATE_SUCCESS = "Updated user[{{#user.nickname}}]: {_DIFF{#updateReqVO}}";
    String SYSTEM_USER_DELETE_SUB_TYPE = "Delete user";
    String SYSTEM_USER_DELETE_SUCCESS = "Deleted user[{{#user.nickname}}]";
    String SYSTEM_USER_UPDATE_PASSWORD_SUB_TYPE = "Reset user password";
    String SYSTEM_USER_UPDATE_PASSWORD_SUCCESS = "user[{{#user.nickname}}] password from [{{#user.password}}] to [{{#newPassword}}]";

    // ======================= SYSTEM_ROLE role =======================

    String SYSTEM_ROLE_TYPE = "SYSTEM role";
    String SYSTEM_ROLE_CREATE_SUB_TYPE = "Create role";
    String SYSTEM_ROLE_CREATE_SUCCESS = "Created role[{{#role.name}}]";
    String SYSTEM_ROLE_UPDATE_SUB_TYPE = "Update role";
    String SYSTEM_ROLE_UPDATE_SUCCESS = "Updated role[{{#role.name}}]: {_DIFF{#updateReqVO}}";
    String SYSTEM_ROLE_DELETE_SUB_TYPE = "Delete role";
    String SYSTEM_ROLE_DELETE_SUCCESS = "Deleted role[{{#role.name}}]";

}
