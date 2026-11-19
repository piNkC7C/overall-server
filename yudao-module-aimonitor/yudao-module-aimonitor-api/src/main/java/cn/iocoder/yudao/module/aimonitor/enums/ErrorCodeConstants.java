package cn.iocoder.yudao.module.aimonitor.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * AI 监测错误码，使用 1-071-000-000 段。
 * 对外文案一律英文 ErrorCode + ErrorCodeI18n；禁止把算法侧中文 detail 原样塞进 {}。
 */
public interface ErrorCodeConstants {

    ErrorCode PROJECT_NOT_EXISTS = new ErrorCode(1_071_000_000, "Monitoring project was not found.");
    ErrorCode ALGORITHM_NOT_CONFIGURED = new ErrorCode(1_071_001_000, "AI monitoring algorithm is not configured.");
    /** 未映射的算法失败：不附带算法原文，避免中英混杂 */
    ErrorCode ALGORITHM_CALL_FAILED = new ErrorCode(1_071_002_000, "AI monitoring algorithm call failed.");
    ErrorCode ALGORITHM_PROJECT_ID_MISSING = new ErrorCode(1_071_003_000, "Algorithm project id is missing.");
    ErrorCode BRAND_NAME_REQUIRED = new ErrorCode(1_071_004_000, "Brand name is required.");
    ErrorCode ALGORITHM_PRIVATE_NETWORK_URL = new ErrorCode(1_071_005_000,
            "For security, private or local network URLs cannot be used.");
    ErrorCode ALGORITHM_PREFLIGHT_FAILED = new ErrorCode(1_071_006_000,
            "Brand preflight failed. Check the website URL and try again.");
    /** 对齐算法：品牌 + 官网 + 地区 唯一 */
    ErrorCode PROJECT_ALREADY_EXISTS = new ErrorCode(1_071_007_000,
            "A monitoring project with the same brand, website, and country already exists.");

}
