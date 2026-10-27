package cn.iocoder.yudao.framework.common.exception.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * 全局错误码枚举
 * 0-999 系统异常编码保留
 *
 * 一般情况下，使用 HTTP 响应状态码 https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 * 虽然说，HTTP 响应状态码作为业务使用表达能力偏弱，但是使用在系统层面还是非常不错的
 * 比较特殊的是，因为之前一直使用 0 作为成功，就不使用 200 啦。
 *
 * @author 芋道源码
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(0, "Success");

    // ========== Client errors ==========

    ErrorCode BAD_REQUEST = new ErrorCode(400, "Invalid request.");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "Please sign in.");
    ErrorCode FORBIDDEN = new ErrorCode(403, "You do not have permission to do that.");
    ErrorCode NOT_FOUND = new ErrorCode(404, "The requested resource was not found.");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "This request method is not allowed.");
    ErrorCode LOCKED = new ErrorCode(423, "The request failed. Try again later."); // Concurrent request
    ErrorCode TOO_MANY_REQUESTS = new ErrorCode(429, "Too many requests. Try again later.");

    // ========== Server errors ==========

    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "A server error occurred.");
    ErrorCode NOT_IMPLEMENTED = new ErrorCode(501, "This feature is not implemented or is turned off.");
    ErrorCode ERROR_CONFIGURATION = new ErrorCode(502, "This setting is invalid.");

    // ========== Custom errors ==========
    ErrorCode REPEATED_REQUESTS = new ErrorCode(900, "Duplicate request. Try again later.");
    ErrorCode DEMO_DENY = new ErrorCode(901, "Demo mode is read-only.");

    ErrorCode UNKNOWN = new ErrorCode(999, "An unknown error occurred.");

}
