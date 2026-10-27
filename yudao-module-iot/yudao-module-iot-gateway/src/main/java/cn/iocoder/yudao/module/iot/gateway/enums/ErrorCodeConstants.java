package cn.iocoder.yudao.module.iot.gateway.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * iot gateway 错误码枚举类
 * <p>
 * iot 系统，使用 1-051-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== device auth 1-050-001-000 ============
    ErrorCode DEVICE_AUTH_FAIL = new ErrorCode(1_051_001_000, "Device authentication failed."); // 对应阿里云 20000
    ErrorCode DEVICE_TOKEN_EXPIRED = new ErrorCode(1_051_001_002, "Token expired. need to again call auth authentication, get token."); // 对应阿里云 20001

    // ========== device info 1-050-002-000 ============
    ErrorCode DEVICE_NOT_EXISTS = new ErrorCode(1_051_002_001, "Device({}/{}) was not found.");

}