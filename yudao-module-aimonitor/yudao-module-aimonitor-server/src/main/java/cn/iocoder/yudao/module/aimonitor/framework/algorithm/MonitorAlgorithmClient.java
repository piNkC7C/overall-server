package cn.iocoder.yudao.module.aimonitor.framework.algorithm;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.algorithm.config.AlgorithmEndpointRegistry;
import cn.iocoder.yudao.framework.algorithm.core.AlgorithmHttpClient;
import cn.iocoder.yudao.framework.algorithm.core.AlgorithmHttpException;
import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.ALGORITHM_CALL_FAILED;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.ALGORITHM_NOT_CONFIGURED;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.ALGORITHM_PREFLIGHT_FAILED;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.ALGORITHM_PRIVATE_NETWORK_URL;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.PROJECT_ALREADY_EXISTS;

/**
 * AI 监测算法 HTTP 客户端。端点名 monitor。
 * 算法 detail 只用于映射/打日志，不直接拼进对用户文案（保持平台 ErrorCode 双语）。
 *
 * <p>长耗时接口按路径自适应覆盖 {@link AlgorithmHttpClient} 默认超时（约 2 分钟），
 * 与前端 {@code api/aimonitor/project.ts} 保持同档。
 */
@Component
@Slf4j
public class MonitorAlgorithmClient {

    /**
     * 抓站 / 公网资料预检：算法侧同步爬取，可能数分钟。
     * 对应 {@code POST /api/preflight}。
     */
    private static final Duration TIMEOUT_PREFLIGHT = Duration.ofMinutes(10);
    /**
     * 创建项目（常带 start_scan）：初始化问题集并入队基线扫描，偶发偏慢。
     * 对应 {@code POST /api/projects}。
     */
    private static final Duration TIMEOUT_CREATE_PROJECT = Duration.ofMinutes(5);
    /**
     * 发起扫描：HTTP 为 202 入队，但入队前可能做面板/校验，给足余量。
     * 对应 {@code POST /api/projects/{id}/scans}。
     */
    private static final Duration TIMEOUT_START_SCAN = Duration.ofMinutes(3);
    /**
     * 内容草稿同步生成：研究 → 提纲 → 初稿 → 评审，常 1–3 分钟，多渠道更久。
     * 对应 {@code POST …/content/briefs/{id}/generate}。
     */
    private static final Duration TIMEOUT_CONTENT_GENERATE = Duration.ofMinutes(10);

    @Resource
    private AlgorithmEndpointRegistry endpointRegistry;
    @Resource
    private AlgorithmHttpClient algorithmHttpClient;

    public void assertConfigured() {
        if (endpointRegistry.find(AlgorithmEndpointRegistry.MONITOR).isEmpty()) {
            throw exception(ALGORITHM_NOT_CONFIGURED);
        }
    }

    public JsonNode preflight(Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR, "/api/preflight",
                body, null, TIMEOUT_PREFLIGHT), true);
    }

    public JsonNode createProject(Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR, "/api/projects",
                body, null, TIMEOUT_CREATE_PROJECT));
    }

    public JsonNode patchProject(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.patch(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId), body));
    }

    public JsonNode getWorkspace(String algorithmProjectId, Integer days, Integer scanLimit) {
        Map<String, String> query = new LinkedHashMap<>();
        if (days != null) {
            query.put("days", String.valueOf(days));
        }
        if (scanLimit != null) {
            query.put("scan_limit", String.valueOf(scanLimit));
        }
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/workspace", query));
    }

    public JsonNode listScans(String algorithmProjectId, Integer limit) {
        Map<String, String> query = new LinkedHashMap<>();
        if (limit != null) {
            query.put("limit", String.valueOf(limit));
        }
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/scans", query));
    }

    public JsonNode createScan(String algorithmProjectId) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/scans", Map.of(),
                null, TIMEOUT_START_SCAN));
    }

    public JsonNode listEvidence(String algorithmProjectId, Map<String, String> query) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/evidence", query));
    }

    public JsonNode getSchedule(String algorithmProjectId) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/schedule"));
    }

    public JsonNode putSchedule(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.put(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/schedule", body));
    }

    public JsonNode getPromptPanel(String algorithmProjectId) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/prompt-panel"));
    }

    public JsonNode createCustomPromptPanel(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/prompt-panel/custom", body));
    }

    public JsonNode activatePromptPanel(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/prompt-panel/activate", body));
    }

    public JsonNode deletePromptPanelVersion(String algorithmProjectId, String versionId, Boolean force) {
        Map<String, String> query = new LinkedHashMap<>();
        if (force != null) {
            query.put("force", String.valueOf(force));
        }
        return call(() -> algorithmHttpClient.delete(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/prompt-panel/versions/" + encode(versionId),
                query));
    }

    public JsonNode getTrends(String algorithmProjectId, Integer days, String platform) {
        Map<String, String> query = new LinkedHashMap<>();
        if (days != null) {
            query.put("days", String.valueOf(days));
        }
        if (StrUtil.isNotBlank(platform)) {
            query.put("platform", platform);
        }
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/trends", query));
    }

    public JsonNode getChanges(String algorithmProjectId, Integer days, Integer limit, Boolean includeInfo) {
        Map<String, String> query = new LinkedHashMap<>();
        if (days != null) {
            query.put("days", String.valueOf(days));
        }
        if (limit != null) {
            query.put("limit", String.valueOf(limit));
        }
        if (includeInfo != null) {
            query.put("include_info", String.valueOf(includeInfo));
        }
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                "/api/projects/" + encode(algorithmProjectId) + "/changes", query));
    }

    public JsonNode listContentOpportunities(String algorithmProjectId) {
        // 与 X-Language 同档：Accept-Language → Locale → zh|en
        Map<String, String> query = new LinkedHashMap<>();
        query.put("language", AlgorithmHttpClient.resolveXLanguage());
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/opportunities"), query));
    }

    public JsonNode listContentBriefs(String algorithmProjectId) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/briefs")));
    }

    public JsonNode createContentBrief(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/briefs"), body));
    }

    public JsonNode getContentBrief(String algorithmProjectId, String briefId) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/briefs/" + encode(briefId))));
    }

    public JsonNode generateContentBrief(String algorithmProjectId, String briefId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/briefs/" + encode(briefId) + "/generate"),
                body, null, TIMEOUT_CONTENT_GENERATE));
    }

    public JsonNode listContentDrafts(String algorithmProjectId, String briefId) {
        Map<String, String> query = new LinkedHashMap<>();
        if (StrUtil.isNotBlank(briefId)) {
            query.put("brief_id", briefId);
        }
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/drafts"), query));
    }

    public JsonNode patchContentDraft(String algorithmProjectId, String draftId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.patch(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/drafts/" + encode(draftId)), body));
    }

    public JsonNode publishContentDraft(String algorithmProjectId, String draftId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/drafts/" + encode(draftId) + "/publish"), body));
    }

    public JsonNode listContentAssets(String algorithmProjectId) {
        return call(() -> algorithmHttpClient.get(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/assets")));
    }

    public JsonNode createContentAsset(String algorithmProjectId, Map<String, Object> body) {
        return call(() -> algorithmHttpClient.post(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/assets"), body));
    }

    public JsonNode deleteContentAsset(String algorithmProjectId, String assetId) {
        return call(() -> algorithmHttpClient.delete(AlgorithmEndpointRegistry.MONITOR,
                contentPath(algorithmProjectId, "/assets/" + encode(assetId))));
    }

    private static String contentPath(String algorithmProjectId, String suffix) {
        return "/api/projects/" + encode(algorithmProjectId) + "/content" + suffix;
    }

    private JsonNode call(Caller caller) {
        return call(caller, false);
    }

    private JsonNode call(Caller caller, boolean preflight) {
        assertConfigured();
        try {
            return caller.call();
        } catch (AlgorithmHttpException ex) {
            throwMapped(ex, preflight);
            return null; // unreachable
        }
    }

    private void throwMapped(AlgorithmHttpException ex, boolean preflight) {
        String detail = StrUtil.blankToDefault(ex.getDetail(), ex.getMessage());
        log.warn("[call][monitor algorithm HTTP {} detail={}]", ex.getStatusCode(), detail);
        ErrorCode mapped = mapDetail(detail);
        if (mapped != null) {
            throw exception(mapped);
        }
        throw exception(preflight ? ALGORITHM_PREFLIGHT_FAILED : ALGORITHM_CALL_FAILED);
    }

    /**
     * 将算法侧已知 detail（可能中文）映射为平台双语 ErrorCode；未知则返回 null。
     */
    private static ErrorCode mapDetail(String detail) {
        if (StrUtil.isBlank(detail)) {
            return null;
        }
        String text = detail.toLowerCase();
        if (detail.contains("不能访问本地或内网")
                || text.contains("private or local")
                || text.contains("local or private")
                || text.contains("private network")
                || text.contains("ssrf")) {
            return ALGORITHM_PRIVATE_NETWORK_URL;
        }
        // 算法 409：同一品牌、监测目标与地区已存在
        if (detail.contains("已存在")
                || text.contains("already exists")
                || text.contains("already exist")) {
            return PROJECT_ALREADY_EXISTS;
        }
        return null;
    }

    private static String encode(String value) {
        return java.net.URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8);
    }

    @FunctionalInterface
    private interface Caller {
        JsonNode call();
    }

}
