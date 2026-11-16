package cn.iocoder.yudao.module.assistant.service.message;

import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 把算法的 SSE 帧解析成思考、正文、结束、错误。
 * <p>
 * 算法侧推荐：
 * <pre>
 * event: thinking
 * data: {"delta":"片段"}
 *
 * event: content
 * data: {"delta":"片段"}
 *
 * event: done
 * data: {}
 *
 * event: error
 * data: {"message":"原因"}
 * </pre>
 * 同时兼容 data 为 JSON 字符串、纯文本，以及 OpenAI chat.completion.chunk。
 */
public final class AssistantSseParser {

    public enum Kind {
        THINKING, CONTENT, DONE, ERROR
    }

    public static final class Chunk {
        private final Kind kind;
        private final String text;

        public Chunk(Kind kind, String text) {
            this.kind = kind;
            this.text = text == null ? "" : text;
        }

        public Kind getKind() {
            return kind;
        }

        public String getText() {
            return text;
        }
    }

    private AssistantSseParser() {
    }

    /**
     * 按行喂入 SSE，空行表示一帧结束。
     */
    public static final class FrameAssembler {
        private String event = "message";
        private final StringBuilder data = new StringBuilder();

        public List<Chunk> acceptLine(String rawLine) {
            if (rawLine == null) {
                return List.of();
            }
            String line = rawLine.endsWith("\r") ? rawLine.substring(0, rawLine.length() - 1) : rawLine;
            if (line.isEmpty()) {
                List<Chunk> chunks = parseEvent(event, data.toString());
                event = "message";
                data.setLength(0);
                return chunks;
            }
            if (line.startsWith(":")) {
                return List.of();
            }
            if (line.startsWith("event:")) {
                event = field(line, "event:");
                return List.of();
            }
            if (line.startsWith("data:")) {
                if (data.length() > 0) {
                    data.append('\n');
                }
                data.append(field(line, "data:"));
            }
            return List.of();
        }

        public List<Chunk> finish() {
            if (data.isEmpty() && "message".equals(event)) {
                return List.of();
            }
            return acceptLine("");
        }
    }

    public static List<Chunk> parseEvent(String eventName, String data) {
        String event = eventName == null || eventName.isBlank() ? "message" : eventName.trim();
        String payload = data == null ? "" : data.trim();
        if (payload.isEmpty()) {
            return "done".equals(event) ? List.of(done()) : List.of();
        }
        if ("[DONE]".equals(payload)) {
            return List.of(done());
        }
        if ("error".equals(event)) {
            return List.of(new Chunk(Kind.ERROR, errorText(payload)));
        }
        if ("done".equals(event)) {
            return List.of(done());
        }
        if ("thinking".equals(event) || "reasoning".equals(event)) {
            return textChunk(Kind.THINKING, deltaText(payload));
        }
        if ("content".equals(event)) {
            return textChunk(Kind.CONTENT, deltaText(payload));
        }
        if (JsonUtils.isJsonObject(payload)) {
            try {
                return parseObjectPayload(JsonUtils.parseTree(payload));
            } catch (RuntimeException ignored) {
                return List.of(new Chunk(Kind.CONTENT, payload));
            }
        }
        return List.of(new Chunk(Kind.CONTENT, unescapeJsonString(payload)));
    }

    private static List<Chunk> parseObjectPayload(JsonNode node) {
        List<Chunk> chunks = new ArrayList<>();
        JsonNode error = node.get("error");
        if (error != null && !error.isNull()) {
            String message = JsonUtils.getText(node, "message");
            if (message == null || message.isEmpty()) {
                message = error.isObject() || error.isArray() ? JsonUtils.getText(error, "message") : error.asText();
            }
            chunks.add(new Chunk(Kind.ERROR, message == null || message.isEmpty() ? "error" : message));
            return chunks;
        }
        JsonNode choices = node.get("choices");
        if (choices != null && choices.isArray() && choices.size() > 0) {
            JsonNode first = choices.get(0);
            JsonNode delta = first.get("delta");
            if (delta != null && delta.isObject()) {
                String reasoning = firstNonBlank(JsonUtils.getText(delta, "reasoning_content"),
                        JsonUtils.getText(delta, "reasoning"));
                String content = JsonUtils.getText(delta, "content");
                if (reasoning != null && !reasoning.isEmpty()) {
                    chunks.add(new Chunk(Kind.THINKING, reasoning));
                }
                if (content != null && !content.isEmpty()) {
                    chunks.add(new Chunk(Kind.CONTENT, content));
                }
            }
            String finish = JsonUtils.getText(first, "finish_reason");
            if (finish != null && !finish.isEmpty()) {
                chunks.add(done());
            }
            if (!chunks.isEmpty()) {
                return chunks;
            }
        }
        String delta = firstNonBlank(JsonUtils.getText(node, "delta"), JsonUtils.getText(node, "content"),
                JsonUtils.getText(node, "text"));
        if (delta != null && !delta.isEmpty()) {
            chunks.add(new Chunk(Kind.CONTENT, delta));
        }
        return chunks;
    }

    private static List<Chunk> textChunk(Kind kind, String text) {
        if (text == null || text.isEmpty()) {
            return List.of();
        }
        return List.of(new Chunk(kind, text));
    }

    private static Chunk done() {
        return new Chunk(Kind.DONE, "");
    }

    private static String deltaText(String payload) {
        if (JsonUtils.isJsonObject(payload)) {
            try {
                JsonNode node = JsonUtils.parseTree(payload);
                return firstNonBlank(JsonUtils.getText(node, "delta"), JsonUtils.getText(node, "content"),
                        JsonUtils.getText(node, "text"), "");
            } catch (RuntimeException ignored) {
                return payload;
            }
        }
        return unescapeJsonString(payload);
    }

    private static String unescapeJsonString(String payload) {
        if (payload.length() >= 2 && payload.charAt(0) == '"') {
            try {
                JsonNode node = JsonUtils.parseTree(payload);
                if (!node.isObject() && !node.isArray()) {
                    return node.asText();
                }
            } catch (RuntimeException ignored) {
                return payload;
            }
        }
        return payload;
    }

    private static String errorText(String payload) {
        if (!JsonUtils.isJsonObject(payload)) {
            return unescapeJsonString(payload);
        }
        try {
            JsonNode node = JsonUtils.parseTree(payload);
            String message = JsonUtils.getText(node, "message");
            if (message != null && !message.isEmpty()) {
                return message;
            }
            JsonNode error = node.get("error");
            if (error != null && !error.isNull()) {
                if (!error.isObject() && !error.isArray()) {
                    return error.asText();
                }
                String nested = JsonUtils.getText(error, "message");
                if (nested != null && !nested.isEmpty()) {
                    return nested;
                }
            }
        } catch (RuntimeException ignored) {
            return payload;
        }
        return payload;
    }

    private static String field(String line, String prefix) {
        String rest = line.substring(prefix.length());
        return rest.startsWith(" ") ? rest.substring(1) : rest;
    }

    private static String firstNonBlank(String... values) {
        if (values == null) {
            return null;
        }
        for (String value : values) {
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        return null;
    }

}
