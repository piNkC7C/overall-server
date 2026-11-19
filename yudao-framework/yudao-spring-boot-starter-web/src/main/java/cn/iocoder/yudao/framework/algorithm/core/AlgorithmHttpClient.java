package cn.iocoder.yudao.framework.algorithm.core;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.algorithm.config.AlgorithmEndpointProperties;
import cn.iocoder.yudao.framework.algorithm.config.AlgorithmEndpointRegistry;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import tools.jackson.databind.JsonNode;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 通用算法 JSON HTTP 客户端。按端点名取 base-url，业务模块只关心 path 与 body。
 */
public class AlgorithmHttpClient {

    private final AlgorithmEndpointRegistry registry;
    private final HttpClient httpClient;

    public AlgorithmHttpClient(AlgorithmEndpointRegistry registry) {
        this.registry = registry;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(15))
                .build();
    }

    public JsonNode get(String endpointName, String path) {
        return get(endpointName, path, null, null);
    }

    public JsonNode get(String endpointName, String path, Map<String, String> query) {
        return get(endpointName, path, query, null);
    }

    public JsonNode get(String endpointName, String path, Map<String, String> query,
                        Map<String, String> headers) {
        return exchange(endpointName, "GET", appendQuery(path, query), null, headers, null);
    }

    public JsonNode post(String endpointName, String path, Object body) {
        return post(endpointName, path, body, null, null);
    }

    public JsonNode post(String endpointName, String path, Object body, Map<String, String> headers) {
        return post(endpointName, path, body, headers, null);
    }

    public JsonNode post(String endpointName, String path, Object body, Map<String, String> headers,
                         Duration requestTimeout) {
        return exchange(endpointName, "POST", path, body, headers, requestTimeout);
    }

    public JsonNode put(String endpointName, String path, Object body) {
        return put(endpointName, path, body, null);
    }

    public JsonNode put(String endpointName, String path, Object body, Map<String, String> headers) {
        return exchange(endpointName, "PUT", path, body, headers, null);
    }

    public JsonNode patch(String endpointName, String path, Object body) {
        return patch(endpointName, path, body, null);
    }

    public JsonNode patch(String endpointName, String path, Object body, Map<String, String> headers) {
        return exchange(endpointName, "PATCH", path, body, headers, null);
    }

    public JsonNode delete(String endpointName, String path) {
        return delete(endpointName, path, null);
    }

    public JsonNode delete(String endpointName, String path, Map<String, String> query) {
        return exchange(endpointName, "DELETE", appendQuery(path, query), null, null, null);
    }

    public JsonNode exchange(String endpointName, String method, String path, Object body,
                             Map<String, String> headers) {
        return exchange(endpointName, method, path, body, headers, null);
    }

    public JsonNode exchange(String endpointName, String method, String path, Object body,
                             Map<String, String> headers, Duration requestTimeout) {
        AlgorithmEndpointProperties.Endpoint endpoint = registry.require(endpointName);
        Duration timeout = resolveRequestTimeout(endpoint, requestTimeout);
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(join(endpoint.getBaseUrl(), path))
                    .timeout(timeout)
                    .header("Accept", "application/json");
            // 监测等算法接口：按控制台用户语言传 X-Language（与前端 Accept-Language → Locale 一致）
            Map<String, String> mergedHeaders = withLanguageHeader(headers);
            mergedHeaders.forEach((k, v) -> {
                if (StrUtil.isNotBlank(k) && v != null) {
                    builder.header(k, v);
                }
            });
            String json = body == null ? null : JsonUtils.toJsonString(body);
            switch (method.toUpperCase()) {
                case "GET" -> builder.GET();
                case "DELETE" -> builder.DELETE();
                case "POST" -> {
                    builder.header("Content-Type", "application/json; charset=utf-8");
                    builder.POST(HttpRequest.BodyPublishers.ofString(
                            json == null ? "{}" : json, StandardCharsets.UTF_8));
                }
                case "PUT" -> {
                    builder.header("Content-Type", "application/json; charset=utf-8");
                    builder.PUT(HttpRequest.BodyPublishers.ofString(
                            json == null ? "{}" : json, StandardCharsets.UTF_8));
                }
                case "PATCH" -> {
                    builder.header("Content-Type", "application/json; charset=utf-8");
                    builder.method("PATCH", HttpRequest.BodyPublishers.ofString(
                            json == null ? "{}" : json, StandardCharsets.UTF_8));
                }
                default -> throw new IllegalArgumentException("Unsupported HTTP method: " + method);
            }
            HttpResponse<String> response = httpClient.send(builder.build(),
                    HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            String responseBody = response.body();
            if (response.statusCode() >= 400) {
                throw new AlgorithmHttpException(response.statusCode(), errorDetail(responseBody));
            }
            if (StrUtil.isBlank(responseBody) || response.statusCode() == 204) {
                return JsonUtils.parseTree("{}");
            }
            if (!JsonUtils.isJson(responseBody)) {
                return JsonUtils.parseTree("{\"raw\":" + JsonUtils.toJsonString(responseBody) + "}");
            }
            return JsonUtils.parseTree(responseBody);
        } catch (AlgorithmHttpException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new AlgorithmHttpException(502, StrUtil.blankToDefault(ex.getMessage(),
                    "Algorithm service call failed."));
        }
    }

    /**
     * 平台统一：前端只传 Accept-Language → LocaleContextHolder；
     * 再按各算法约定转成头或 Body（监测 X-Language；助手 Body language）。
     * 调用方已显式传 X-Language / X-API-Language 时不覆盖。
     */
    static Map<String, String> withLanguageHeader(Map<String, String> headers) {
        Map<String, String> merged = headers == null ? new LinkedHashMap<>() : new LinkedHashMap<>(headers);
        boolean hasLang = merged.keySet().stream().anyMatch(k ->
                "X-Language".equalsIgnoreCase(k) || "X-API-Language".equalsIgnoreCase(k));
        if (!hasLang) {
            merged.put("X-Language", resolveXLanguage());
        }
        return merged;
    }

    /** 控制台是否中文（Accept-Language → Locale） */
    public static boolean isChineseLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale == null) {
            return false;
        }
        String language = locale.getLanguage();
        return StrUtil.isNotBlank(language) && language.toLowerCase(Locale.ROOT).startsWith("zh");
    }

    /** 监测等算法：X-Language / 部分 query，取值 zh | en */
    public static String resolveXLanguage() {
        return isChineseLocale() ? "zh" : "en";
    }

    /** 助手算法 Body.language，取值 zh-CN | en-US（与算法契约一致） */
    public static String resolveAssistantLanguage() {
        return isChineseLocale() ? "zh-CN" : "en-US";
    }

    /** @deprecated 使用 {@link #resolveXLanguage()} */
    @Deprecated
    static String resolveAlgorithmLanguage() {
        return resolveXLanguage();
    }

    private static Duration resolveRequestTimeout(AlgorithmEndpointProperties.Endpoint endpoint,
                                                  Duration override) {
        if (override != null) {
            return override;
        }
        if (endpoint.getRequestTimeout() != null) {
            return endpoint.getRequestTimeout();
        }
        Duration connect = endpoint.getConnectTimeout() == null
                ? Duration.ofSeconds(30) : endpoint.getConnectTimeout();
        return connect.plusSeconds(120);
    }

    private static URI join(String baseUrl, String path) {
        String base = StrUtil.removeSuffix(baseUrl.trim(), "/");
        String p = path == null ? "" : path.trim();
        if (!p.startsWith("/")) {
            p = "/" + p;
        }
        return URI.create(base + p);
    }

    private static String appendQuery(String path, Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            return path;
        }
        StringJoiner joiner = new StringJoiner("&");
        query.forEach((k, v) -> {
            if (StrUtil.isBlank(k) || v == null) {
                return;
            }
            joiner.add(URLEncoder.encode(k, StandardCharsets.UTF_8) + "="
                    + URLEncoder.encode(v, StandardCharsets.UTF_8));
        });
        String qs = joiner.toString();
        if (StrUtil.isBlank(qs)) {
            return path;
        }
        return path + (path.contains("?") ? "&" : "?") + qs;
    }

    private static String errorDetail(String body) {
        if (StrUtil.isNotBlank(body) && JsonUtils.isJsonObject(body)) {
            try {
                JsonNode node = JsonUtils.parseTree(body);
                String detail = JsonUtils.getText(node, "detail");
                if (StrUtil.isNotBlank(detail)) {
                    return detail;
                }
            } catch (RuntimeException ignored) {
                // fall through
            }
        }
        return StrUtil.blankToDefault(StrUtil.maxLength(body, 300), "Algorithm service call failed.");
    }

}
