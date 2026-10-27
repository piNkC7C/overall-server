package cn.iocoder.yudao.module.ai.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * AI 错误码枚举类
 * <p>
 * ai 系统，使用 1-040-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== API secret 1-040-000-000 ==========
    ErrorCode API_KEY_NOT_EXISTS = new ErrorCode(1_040_000_000, "API secret was not found.");
    ErrorCode API_KEY_DISABLE = new ErrorCode(1_040_000_001, "API secret is disabled!");
    ErrorCode API_CONFIG_PLACEHOLDER_NOT_RESOLVED = new ErrorCode(1_040_000_002, "AI setting ({}) cannot be parsed. Check environment variables or settings.");

    // ========== API model 1-040-001-000 ==========
    ErrorCode MODEL_NOT_EXISTS = new ErrorCode(1_040_001_000, "Model was not found!");
    ErrorCode MODEL_DISABLE = new ErrorCode(1_040_001_001, "Model({}) is disabled!");
    ErrorCode MODEL_DEFAULT_NOT_EXISTS = new ErrorCode(1_040_001_002, "The action failed, find not to default model.");
    ErrorCode MODEL_USE_TYPE_ERROR = new ErrorCode(1_040_001_003, "The action failed, this model model type is invalid.");

    // ========== API 聊天角色 1-040-002-000 ==========
    ErrorCode CHAT_ROLE_NOT_EXISTS = new ErrorCode(1_040_002_000, "Chat role not found.");
    ErrorCode CHAT_ROLE_DISABLE = new ErrorCode(1_040_001_001, "Chat role ({}) is disabled.");

    // ========== API 聊天会话 1-040-003-000 ==========
    ErrorCode CHAT_CONVERSATION_NOT_EXISTS = new ErrorCode(1_040_003_000, "Conversation not found.");
    ErrorCode CHAT_CONVERSATION_MODEL_ERROR = new ErrorCode(1_040_003_001, "The chat model setting is incomplete.");

    // ========== API 聊天消息 1-040-004-000 ==========
    ErrorCode CHAT_MESSAGE_NOT_EXIST = new ErrorCode(1_040_004_000, "Message was not found!");
    ErrorCode CHAT_STREAM_ERROR = new ErrorCode(1_040_004_001, "Conversation generation failed.");

    // ========== API 绘画 1-040-005-000 ==========
    ErrorCode IMAGE_NOT_EXISTS = new ErrorCode(1_040_005_000, "Image not found.");
    ErrorCode IMAGE_MIDJOURNEY_SUBMIT_FAIL = new ErrorCode(1_040_005_001, "Midjourney submit failed!: {}.");
    ErrorCode IMAGE_CUSTOM_ID_NOT_EXISTS = new ErrorCode(1_040_005_002, "Midjourney customId was not found! {}.");

    // ========== API 音乐 1-040-006-000 ==========
    ErrorCode MUSIC_NOT_EXISTS = new ErrorCode(1_040_006_000, "Music not found.");

    // ========== API 写作 1-040-007-000 ==========
    ErrorCode WRITE_NOT_EXISTS = new ErrorCode(1_040_007_000, "Writing not found.");
    ErrorCode WRITE_STREAM_ERROR = new ErrorCode(1_040_07_001, "Writing generation failed.");

    // ========== API 思维导图 1-040-008-000 ==========
    ErrorCode MIND_MAP_NOT_EXISTS = new ErrorCode(1_040_008_000, "Mind map not found.");

    // ========== API knowledge base 1-040-009-000 ==========
    ErrorCode KNOWLEDGE_NOT_EXISTS = new ErrorCode(1_040_009_000, "Knowledge base was not found!");

    ErrorCode KNOWLEDGE_DOCUMENT_NOT_EXISTS = new ErrorCode(1_040_009_101, "Document was not found!");
    ErrorCode KNOWLEDGE_DOCUMENT_FILE_EMPTY = new ErrorCode(1_040_009_102, "Document content is empty!");
    ErrorCode KNOWLEDGE_DOCUMENT_FILE_DOWNLOAD_FAIL = new ErrorCode(1_040_009_102, "File download failed.");
    ErrorCode KNOWLEDGE_DOCUMENT_FILE_READ_FAIL = new ErrorCode(1_040_009_102, "Document load failed.");

    ErrorCode KNOWLEDGE_SEGMENT_NOT_EXISTS = new ErrorCode(1_040_009_202, "Paragraph not found.");
    ErrorCode KNOWLEDGE_SEGMENT_CONTENT_TOO_LONG = new ErrorCode(1_040_009_203, "Content token count is {}, which exceeds the limit {}.");

    // ========== AI tool 1-040-010-000 ==========
    ErrorCode TOOL_NOT_EXISTS = new ErrorCode(1_040_010_000, "Tool was not found.");
    ErrorCode TOOL_NAME_NOT_EXISTS = new ErrorCode(1_040_010_001, "Tool({}) find not to Bean.");

    // ========== AI 工作流 1-040-011-000 ==========
    ErrorCode WORKFLOW_NOT_EXISTS = new ErrorCode(1_040_011_000, "Workflow not found.");
    ErrorCode WORKFLOW_CODE_EXISTS = new ErrorCode(1_040_011_001, "Workflow key already exists.");

}
