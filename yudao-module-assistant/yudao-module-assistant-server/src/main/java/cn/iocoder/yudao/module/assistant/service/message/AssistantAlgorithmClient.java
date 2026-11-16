package cn.iocoder.yudao.module.assistant.service.message;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.module.assistant.framework.config.AssistantAlgorithmProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 仅对接文档中的两个流式接口：messages / decision。
 * 请求头转发当前登录用户的 Authorization 与 tenant-id。
 */
@Component
@Slf4j
public class AssistantAlgorithmClient {

    public interface Listener {
        void onEvent(String type, Object data);

        boolean cancelled();
    }

    @Resource
    private AssistantAlgorithmProperties properties;

    private HttpClient httpClient;

    @PostConstruct
    public void init() {
        Duration timeout = properties.getConnectTimeout() == null
                ? Duration.ofSeconds(10) : properties.getConnectTimeout();
        httpClient = HttpClient.newBuilder().connectTimeout(timeout).build();
    }

    public boolean configured() {
        return StrUtil.isNotBlank(properties.getBaseUrl());
    }

    /** 内部创建算法会话，拿到 session id；不对前端暴露。 */
    public String createSession(String accessToken, Long tenantId, boolean chinese) throws Exception {
        if (!configured()) {
            return "mock-" + System.currentTimeMillis();
        }
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(join(properties.getCreateSessionPath()))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{}", StandardCharsets.UTF_8));
        applyAuth(builder, accessToken, tenantId);
        HttpResponse<String> response = httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        if (response.statusCode() >= 400) {
            throw new IllegalStateException(errorDetail(response.body(), chinese));
        }
        JsonNode node = JsonUtils.parseTree(response.body());
        String id = JsonUtils.getText(node, "id");
        if (StrUtil.isBlank(id)) {
            throw new IllegalStateException(chinese ? "算法会话创建失败。" : "Failed to create agent session.");
        }
        return id;
    }

    public void streamMessages(String sessionId, String content, String accessToken, Long tenantId,
                               Listener listener, boolean chinese) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("content", content);
        body.put("language", languageCode(chinese));
        stream(path(properties.getMessagesPath(), sessionId), body, accessToken, tenantId, listener, chinese);
    }

    public void streamDecision(String sessionId, Map<String, Object> body, String accessToken, Long tenantId,
                               Listener listener, boolean chinese) {
        Map<String, Object> payload = body == null ? new LinkedHashMap<>() : new LinkedHashMap<>(body);
        payload.put("language", languageCode(chinese));
        stream(path(properties.getDecisionPath(), sessionId), payload, accessToken, tenantId, listener, chinese);
    }

    /** 算法侧回复语言：zh-CN / en-US */
    private static String languageCode(boolean chinese) {
        return chinese ? "zh-CN" : "en-US";
    }

    private void stream(String path, Object body, String accessToken, Long tenantId,
                        Listener listener, boolean chinese) {
        if (!configured()) {
            if (properties.isMockWhenUnconfigured()) {
                mock(body, listener, chinese);
                return;
            }
            listener.onEvent("error", chinese ? "算法服务还没有配置。" : "The algorithm service is not configured.");
            return;
        }
        try {
            pull(path, body, accessToken, tenantId, listener, chinese);
        } catch (Exception ex) {
            log.warn("[stream][算法流式调用失败 path={}]", path, ex);
            if (!listener.cancelled()) {
                listener.onEvent("error", chinese ? "算法服务调用失败，请重试。" : "The algorithm service failed. Try again.");
            }
        }
    }

    private void pull(String path, Object body, String accessToken, Long tenantId,
                      Listener listener, boolean chinese) throws Exception {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(join(path))
                .header("Content-Type", "application/json")
                .header("Accept", "text/event-stream")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtils.toJsonString(body), StandardCharsets.UTF_8));
        applyAuth(builder, accessToken, tenantId);
        HttpResponse<InputStream> response = httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofInputStream());
        try (InputStream in = response.body();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            if (response.statusCode() >= 400) {
                String errorBody = reader.lines().limit(40).collect(Collectors.joining("\n"));
                log.warn("[pull][算法 HTTP {} body={}]", response.statusCode(), StrUtil.maxLength(errorBody, 500));
                listener.onEvent("error", errorDetail(errorBody, chinese));
                return;
            }
            String contentType = response.headers().firstValue("content-type").orElse("");
            if (!contentType.toLowerCase().contains("text/event-stream")) {
                String raw = reader.lines().collect(Collectors.joining("\n"));
                dispatchJsonLine(listener, raw);
                return;
            }
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (listener.cancelled()) {
                    return;
                }
                if (line.endsWith("\r")) {
                    line = line.substring(0, line.length() - 1);
                }
                if (line.isEmpty()) {
                    if (dispatchDataBlock(listener, data.toString())) {
                        return;
                    }
                    data.setLength(0);
                    continue;
                }
                if (line.startsWith(":")) {
                    continue;
                }
                if (line.startsWith("data:")) {
                    if (data.length() > 0) {
                        data.append('\n');
                    }
                    String rest = line.substring(5);
                    data.append(rest.startsWith(" ") ? rest.substring(1) : rest);
                }
            }
            dispatchDataBlock(listener, data.toString());
        }
    }

    /** @return true 表示流应结束 */
    private boolean dispatchDataBlock(Listener listener, String raw) {
        if (StrUtil.isBlank(raw)) {
            return false;
        }
        return dispatchJsonLine(listener, raw.trim());
    }

    private boolean dispatchJsonLine(Listener listener, String raw) {
        if (StrUtil.isBlank(raw)) {
            return false;
        }
        try {
            JsonNode node = JsonUtils.parseTree(raw);
            String type = JsonUtils.getText(node, "type");
            if (StrUtil.isBlank(type)) {
                listener.onEvent("content", firstNonBlank(JsonUtils.getText(node, "delta"), JsonUtils.getText(node, "content"), raw));
                return false;
            }
            switch (type) {
                case "reasoning" -> listener.onEvent("thinking", JsonUtils.getText(node, "delta"));
                case "text" -> listener.onEvent("content", JsonUtils.getText(node, "delta"));
                case "tool_call", "tool_result", "approval_required" ->
                        listener.onEvent(type, JsonUtils.parseObject(raw, Map.class));
                case "done" -> {
                    Map<String, Object> done = new LinkedHashMap<>();
                    if (node.get("awaiting_approval") != null && node.get("awaiting_approval").asBoolean()) {
                        done.put("awaiting_approval", true);
                    }
                    listener.onEvent("done", done);
                    return true;
                }
                case "error" -> {
                    listener.onEvent("error", firstNonBlank(JsonUtils.getText(node, "message"), "error"));
                    return true;
                }
                default -> listener.onEvent(type, JsonUtils.parseObject(raw, Map.class));
            }
        } catch (RuntimeException ex) {
            listener.onEvent("content", raw);
        }
        return false;
    }

    private void mock(Object body, Listener listener, boolean chinese) {
        String content = "";
        if (body instanceof Map<?, ?> map && map.get("content") != null) {
            content = String.valueOf(map.get("content"));
        }
        String thinking = chinese
                ? "先把问题过一遍。算法服务还在接入，这段思考是本地占位。"
                : "Looking this over. Local stand-in while the agent is not connected.";
        String reply = chinese
                ? "收到。算法 messages/decision 配置好后，这里会换成真实流式结果。\n\n你说：" + content
                : "Got it. Once messages/decision are wired, this becomes the real stream.\n\nYou said: " + content;
        for (String part : thinking.split("(?<=\\G.{18})")) {
            if (part.isEmpty() || listener.cancelled()) return;
            listener.onEvent("thinking", part);
            sleep();
        }
        for (String part : reply.split("(?<=\\G.{18})")) {
            if (part.isEmpty() || listener.cancelled()) return;
            listener.onEvent("content", part);
            sleep();
        }
        listener.onEvent("done", Map.of());
    }

    private void sleep() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void applyAuth(HttpRequest.Builder builder, String accessToken, Long tenantId) {
        if (StrUtil.isNotBlank(accessToken)) {
            String token = accessToken.startsWith("Bearer ") ? accessToken : "Bearer " + accessToken;
            builder.header("Authorization", token);
        }
        if (tenantId != null) {
            builder.header("tenant-id", String.valueOf(tenantId));
        }
    }

    private URI join(String path) {
        String base = StrUtil.removeSuffix(properties.getBaseUrl().trim(), "/");
        String p = path == null ? "" : path.trim();
        if (!p.startsWith("/")) {
            p = "/" + p;
        }
        return URI.create(base + p);
    }

    private String path(String template, String sessionId) {
        String t = StrUtil.blankToDefault(template, "/api/sessions/{id}/messages");
        return t.replace("{id}", sessionId);
    }

    private static String errorDetail(String body, boolean chinese) {
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
        return chinese ? "算法服务调用失败，请重试。" : "The algorithm service failed. Try again.";
    }

    private static String firstNonBlank(String... values) {
        if (values == null) {
            return "";
        }
        for (String value : values) {
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        return "";
    }

}
