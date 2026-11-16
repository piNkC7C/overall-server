package cn.iocoder.yudao.module.assistant.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * AI 助手错误码，使用 1-070-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode CONVERSATION_NOT_FOUND = new ErrorCode(1_070_000_000, "This chat was not found.");
    ErrorCode MESSAGE_REQUIRED = new ErrorCode(1_070_001_000, "Message is required.");
    ErrorCode AGENT_SESSION_FAILED = new ErrorCode(1_070_002_000, "Failed to create agent session.");

}
