package cn.iocoder.yudao.module.assistant.service.message;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.tenant.core.context.TenantContextHolder;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantDecisionReqVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantFileVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageRespVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageSendReqVO;
import cn.iocoder.yudao.module.assistant.dal.dataobject.conversation.AssistantConversationDO;
import cn.iocoder.yudao.module.assistant.dal.dataobject.message.AssistantMessageDO;
import cn.iocoder.yudao.module.assistant.dal.mysql.conversation.AssistantConversationMapper;
import cn.iocoder.yudao.module.assistant.dal.mysql.message.AssistantMessageMapper;
import cn.iocoder.yudao.module.assistant.service.conversation.AssistantConversationService;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageRoleEnum.ASSISTANT;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageRoleEnum.USER;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum.AWAITING;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum.DONE;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum.ERROR;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum.GENERATING;
import static cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum.STOPPED;
import static cn.iocoder.yudao.module.assistant.enums.ErrorCodeConstants.AGENT_SESSION_FAILED;
import static cn.iocoder.yudao.module.assistant.enums.ErrorCodeConstants.MESSAGE_REQUIRED;

/**
 * 助手消息：系统会话落库；算法仅转发 messages / decision，并透传登录 token + tenant-id。
 */
@Service
@Validated
@Slf4j
public class AssistantMessageServiceImpl implements AssistantMessageService {

    @Resource
    private AssistantMessageMapper messageMapper;
    @Resource
    private AssistantConversationMapper conversationMapper;
    @Resource
    private AssistantConversationService conversationService;
    @Resource
    private AssistantAlgorithmClient algorithmClient;

    private final ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable, "assistant-stream");
        thread.setDaemon(true);
        return thread;
    });
    private final ConcurrentHashMap<Long, AtomicBoolean> stops = new ConcurrentHashMap<>();

    @PreDestroy
    public void shutdown() {
        executor.shutdownNow();
    }

    @Override
    public List<AssistantMessageRespVO> getMyList(Long conversationId, Long userId) {
        conversationService.validateMy(conversationId, userId);
        List<AssistantMessageRespVO> result = new ArrayList<>();
        for (AssistantMessageDO message : messageMapper.selectListByConversationId(conversationId)) {
            result.add(toResp(message));
        }
        return result;
    }

    @Override
    public void stopMy(Long conversationId, Long userId) {
        conversationService.validateMy(conversationId, userId);
        AtomicBoolean stop = stops.get(conversationId);
        if (stop != null) {
            stop.set(true);
        }
        messageMapper.stopGenerating(conversationId);
    }

    @Override
    public SseEmitter sendStream(AssistantMessageSendReqVO reqVO, Long userId, String accessToken, String language) {
        String content = StrUtil.trim(reqVO.getContent());
        if (StrUtil.isEmpty(content)) {
            throw exception(MESSAGE_REQUIRED);
        }
        String lang = StrUtil.trim(language);
        boolean chinese = isChinese(lang);
        Long tenantId = TenantContextHolder.getTenantId();
        AssistantConversationDO conversation = prepareConversation(reqVO.getConversationId(), userId, content);
        String agentSessionId = ensureAgentSession(conversation, accessToken, tenantId, chinese);
        Long conversationId = conversation.getId();
        log.info("[sendStream][conversation({}) language={}]", conversationId, lang);

        AtomicBoolean stop = armStop(conversationId);
        messageMapper.stopGenerating(conversationId);

        AssistantMessageDO userMessage = new AssistantMessageDO();
        userMessage.setConversationId(conversationId);
        userMessage.setUserId(userId);
        userMessage.setRole(USER);
        userMessage.setContent(content);
        userMessage.setStatus(DONE);
        userMessage.setFiles(toJson(reqVO.getFiles()));
        messageMapper.insert(userMessage);

        AssistantMessageDO assistantMessage = new AssistantMessageDO();
        assistantMessage.setConversationId(conversationId);
        assistantMessage.setUserId(userId);
        assistantMessage.setRole(ASSISTANT);
        assistantMessage.setContent("");
        assistantMessage.setReasoning("");
        assistantMessage.setStatus(GENERATING);
        assistantMessage.setPayload(JsonUtils.toJsonString(Map.of("segments", List.of())));
        messageMapper.insert(assistantMessage);

        SseEmitter emitter = new SseEmitter(0L);
        Runnable task = () -> runAgentStream(emitter, conversationId, userMessage.getId(), assistantMessage.getId(),
                userId, stop, chinese, lang, accessToken, tenantId, agentSessionId, true, content, null);
        executor.execute(() -> {
            if (tenantId != null) {
                TenantUtils.execute(tenantId, task);
            } else {
                task.run();
            }
        });
        return emitter;
    }

    @Override
    public SseEmitter decisionStream(AssistantDecisionReqVO reqVO, Long userId, String accessToken, String language) {
        String lang = StrUtil.trim(language);
        boolean chinese = isChinese(lang);
        Long tenantId = TenantContextHolder.getTenantId();
        AssistantConversationDO conversation = conversationService.validateMy(reqVO.getConversationId(), userId);
        String agentSessionId = ensureAgentSession(conversation, accessToken, tenantId, chinese);
        AssistantMessageDO assistantMessage = messageMapper.selectById(reqVO.getMessageId());
        if (assistantMessage == null
                || !conversation.getId().equals(assistantMessage.getConversationId())
                || !ASSISTANT.equals(assistantMessage.getRole())) {
            throw exception(MESSAGE_REQUIRED);
        }
        log.info("[decisionStream][conversation({}) language={}]", conversation.getId(), lang);

        AtomicBoolean stop = armStop(conversation.getId());
        assistantMessage.setStatus(GENERATING);
        messageMapper.updateById(assistantMessage);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("approve", Boolean.TRUE.equals(reqVO.getApprove()));
        if (Boolean.TRUE.equals(reqVO.getApprove()) && reqVO.getArgs() != null) {
            body.put("args", reqVO.getArgs());
        }
        if (!Boolean.TRUE.equals(reqVO.getApprove()) && StrUtil.isNotBlank(reqVO.getFeedback())) {
            body.put("feedback", reqVO.getFeedback());
        }

        SseEmitter emitter = new SseEmitter(0L);
        Long conversationId = conversation.getId();
        Long assistantMessageId = assistantMessage.getId();
        Runnable task = () -> runAgentStream(emitter, conversationId, null, assistantMessageId,
                userId, stop, chinese, lang, accessToken, tenantId, agentSessionId, false, null, body);
        executor.execute(() -> {
            if (tenantId != null) {
                TenantUtils.execute(tenantId, task);
            } else {
                task.run();
            }
        });
        return emitter;
    }

    /** 仅用于平台本地错误文案；转发给算法的 language 保持 Body 原值 */
    private static boolean isChinese(String language) {
        return StrUtil.isNotBlank(language) && language.toLowerCase().startsWith("zh");
    }

    private AtomicBoolean armStop(Long conversationId) {
        AtomicBoolean stop = new AtomicBoolean(false);
        AtomicBoolean previous = stops.put(conversationId, stop);
        if (previous != null) {
            previous.set(true);
        }
        return stop;
    }

    private void runAgentStream(SseEmitter emitter, Long conversationId, Long userMessageId, Long assistantMessageId,
                                Long userId, AtomicBoolean stop, boolean chinese, String language, String accessToken, Long tenantId,
                                String agentSessionId, boolean sendMessage, String content, Map<String, Object> decisionBody) {
        StringBuilder reasoning = new StringBuilder();
        StringBuilder text = new StringBuilder();
        List<Map<String, Object>> segments = new ArrayList<>();
        AtomicReference<Object> approval = new AtomicReference<>(null);
        int[] status = {DONE};
        String[] error = {null};
        int[] ticks = {0};

        Map<String, Object> start = new HashMap<>();
        start.put("conversationId", conversationId);
        if (userMessageId != null) {
            start.put("userMessageId", userMessageId);
        }
        start.put("assistantMessageId", assistantMessageId);
        emit(emitter, "start", start);

        AssistantMessageDO existing = messageMapper.selectById(assistantMessageId);
        if (existing != null) {
            if (StrUtil.isNotBlank(existing.getReasoning())) {
                reasoning.append(existing.getReasoning());
            }
            if (StrUtil.isNotBlank(existing.getContent())) {
                text.append(existing.getContent());
            }
            Map<String, Object> payload = parsePayload(existing.getPayload());
            Object segs = payload.get("segments");
            if (segs instanceof List<?> list) {
                for (Object item : list) {
                    if (item instanceof Map<?, ?> map) {
                        segments.add(new LinkedHashMap<>((Map<String, Object>) map));
                    }
                }
            }
            if (payload.get("approval") != null) {
                approval.set(payload.get("approval"));
            }
        }

        try {
            AssistantAlgorithmClient.Listener listener = new AssistantAlgorithmClient.Listener() {
                @Override
                public void onEvent(String type, Object data) {
                    if (cancelled()) {
                        return;
                    }
                    switch (type) {
                        case "thinking" -> {
                            String delta = data == null ? "" : String.valueOf(data);
                            if (StrUtil.isBlank(delta)) {
                                return;
                            }
                            reasoning.append(delta);
                            emit(emitter, "thinking", delta);
                        }
                        case "content" -> {
                            String delta = data == null ? "" : String.valueOf(data);
                            if (StrUtil.isBlank(delta)) {
                                return;
                            }
                            appendTextSegment(segments, delta);
                            text.append(delta);
                            emit(emitter, "content", delta);
                        }
                        case "tool_call" -> {
                            Map<String, Object> tool = castMap(data);
                            segments.add(Map.of(
                                    "type", "tool",
                                    "tool", tool
                            ));
                            // 其后 text 另起一段
                            segments.add(newSegmentText(""));
                            approval.set(null);
                            emit(emitter, "tool_call", tool);
                        }
                        case "tool_result" -> {
                            Map<String, Object> resultEvent = castMap(data);
                            applyToolResult(segments, resultEvent);
                            if (approval.get() instanceof Map<?, ?> ap
                                    && String.valueOf(ap.get("id")).equals(String.valueOf(resultEvent.get("id")))) {
                                approval.set(null);
                            }
                            emit(emitter, "tool_result", resultEvent);
                        }
                        case "approval_required" -> {
                            Map<String, Object> card = castMap(data);
                            approval.set(card);
                            ensureToolForApproval(segments, card);
                            status[0] = AWAITING;
                            emit(emitter, "approval_required", card);
                        }
                        case "done" -> {
                            Map<String, Object> done = castMap(data);
                            if (Boolean.TRUE.equals(done.get("awaiting_approval"))) {
                                status[0] = AWAITING;
                            } else if (status[0] == GENERATING || status[0] == DONE) {
                                status[0] = DONE;
                            }
                            emit(emitter, "done", done.isEmpty() ? Map.of("stopped", false) : done);
                        }
                        case "error" -> {
                            status[0] = ERROR;
                            error[0] = data == null ? null : String.valueOf(data);
                            emit(emitter, "error", error[0]);
                        }
                        default -> {
                        }
                    }
                    maybeFlush(ticks, assistantMessageId, reasoning, text, segments, approval.get(),
                            status[0] == AWAITING ? AWAITING : GENERATING, userId);
                }

                @Override
                public boolean cancelled() {
                    return stop.get();
                }
            };

            if (sendMessage) {
                algorithmClient.streamMessages(agentSessionId, content, language, accessToken, tenantId, listener, chinese);
            } else {
                algorithmClient.streamDecision(agentSessionId, decisionBody, language, accessToken, tenantId, listener, chinese);
            }
            if (stop.get() && status[0] != ERROR && status[0] != AWAITING) {
                status[0] = STOPPED;
            }
            if (status[0] == GENERATING) {
                status[0] = DONE;
            }
        } catch (Exception ex) {
            log.warn("[runAgentStream][对话({}) 转发失败]", conversationId, ex);
            status[0] = ERROR;
            error[0] = chinese ? "算法服务调用失败，请重试。" : "The algorithm service failed. Try again.";
            emit(emitter, "error", error[0]);
        } finally {
            save(assistantMessageId, reasoning.toString(), text.toString(), segments, approval.get(), status[0], userId);
            if (status[0] != ERROR && status[0] != AWAITING) {
                // done 已在流中发出；停止时补一条
                if (status[0] == STOPPED) {
                    emit(emitter, "done", Map.of("stopped", true));
                }
            }
            stops.remove(conversationId, stop);
            try {
                emitter.complete();
            } catch (Exception ignored) {
                // browser left
            }
        }
    }

    private String ensureAgentSession(AssistantConversationDO conversation, String accessToken,
                                      Long tenantId, boolean chinese) {
        if (StrUtil.isNotBlank(conversation.getAgentSessionId())) {
            return conversation.getAgentSessionId();
        }
        try {
            String sessionId = algorithmClient.createSession(accessToken, tenantId, chinese);
            AssistantConversationDO update = new AssistantConversationDO();
            update.setId(conversation.getId());
            update.setAgentSessionId(sessionId);
            conversationMapper.updateById(update);
            conversation.setAgentSessionId(sessionId);
            return sessionId;
        } catch (Exception ex) {
            log.warn("[ensureAgentSession][conversation({}) 创建算法会话失败]", conversation.getId(), ex);
            throw exception(AGENT_SESSION_FAILED);
        }
    }

    private void maybeFlush(int[] ticks, Long messageId, StringBuilder reasoning, StringBuilder content,
                            List<Map<String, Object>> segments, Object approval, int status, Long userId) {
        if (++ticks[0] % 10 != 0) {
            return;
        }
        save(messageId, reasoning.toString(), content.toString(), segments, approval, status, userId);
    }

    private void save(Long messageId, String reasoning, String content, List<Map<String, Object>> segments,
                      Object approval, int status, Long userId) {
        try {
            Map<String, Object> payload = new LinkedHashMap<>();
            payload.put("segments", segments == null ? List.of() : segments);
            if (approval != null) {
                payload.put("approval", approval);
            }
            AssistantMessageDO update = new AssistantMessageDO();
            update.setId(messageId);
            update.setReasoning(reasoning);
            update.setContent(content);
            update.setStatus(status);
            update.setPayload(JsonUtils.toJsonString(payload));
            update.setUpdater(String.valueOf(userId));
            messageMapper.updateById(update);
        } catch (Exception ex) {
            log.warn("[save][消息({}) 回写失败]", messageId, ex);
        }
    }

    private AssistantConversationDO prepareConversation(Long conversationId, Long userId, String content) {
        if (conversationId == null) {
            AssistantConversationDO conversation = new AssistantConversationDO();
            conversation.setUserId(userId);
            conversation.setTitle(brief(content, 40));
            conversation.setPreview(brief(content, 200));
            conversationMapper.insert(conversation);
            return conversation;
        }
        AssistantConversationDO conversation = conversationService.validateMy(conversationId, userId);
        touchConversationTitle(conversation.getId(), content, userId);
        conversation.setTitle(brief(content, 40));
        conversation.setPreview(brief(content, 200));
        return conversation;
    }

    private void touchConversationTitle(Long conversationId, String content, Long userId) {
        if (conversationId == null || StrUtil.isBlank(content)) {
            return;
        }
        AssistantConversationDO update = new AssistantConversationDO();
        update.setId(conversationId);
        update.setTitle(brief(content, 40));
        update.setPreview(brief(content, 200));
        update.setUpdater(String.valueOf(userId));
        conversationMapper.updateById(update);
    }

    private static void appendTextSegment(List<Map<String, Object>> segments, String delta) {
        if (segments.isEmpty() || !"text".equals(segments.get(segments.size() - 1).get("type"))) {
            segments.add(newSegmentText(delta));
            return;
        }
        Map<String, Object> last = segments.get(segments.size() - 1);
        last.put("content", String.valueOf(last.getOrDefault("content", "")) + delta);
    }

    private static Map<String, Object> newSegmentText(String content) {
        Map<String, Object> seg = new LinkedHashMap<>();
        seg.put("type", "text");
        seg.put("content", content == null ? "" : content);
        return seg;
    }

    @SuppressWarnings("unchecked")
    private static void applyToolResult(List<Map<String, Object>> segments, Map<String, Object> resultEvent) {
        String id = String.valueOf(resultEvent.get("id"));
        for (Map<String, Object> seg : segments) {
            if (!"tool".equals(seg.get("type"))) {
                continue;
            }
            Object toolObj = seg.get("tool");
            if (!(toolObj instanceof Map<?, ?> toolMap)) {
                continue;
            }
            if (!id.equals(String.valueOf(toolMap.get("id")))) {
                continue;
            }
            Map<String, Object> tool = (Map<String, Object>) toolMap;
            tool.put("result", resultEvent.get("result"));
            Object result = resultEvent.get("result");
            if (result instanceof Map<?, ?> rm && Boolean.TRUE.equals(rm.get("rejected"))) {
                tool.put("state", "rejected");
            } else {
                tool.put("state", "done");
            }
            tool.remove("approval");
            return;
        }
    }

    @SuppressWarnings("unchecked")
    private static void ensureToolForApproval(List<Map<String, Object>> segments, Map<String, Object> card) {
        String id = String.valueOf(card.get("id"));
        for (Map<String, Object> seg : segments) {
            if (!"tool".equals(seg.get("type"))) {
                continue;
            }
            Object toolObj = seg.get("tool");
            if (toolObj instanceof Map<?, ?> toolMap && id.equals(String.valueOf(toolMap.get("id")))) {
                Map<String, Object> tool = (Map<String, Object>) toolMap;
                tool.put("approval", card);
                tool.put("state", "running");
                return;
            }
        }
        Map<String, Object> tool = new LinkedHashMap<>(card);
        tool.put("write", true);
        tool.put("state", "running");
        tool.put("approval", card);
        segments.add(Map.of("type", "tool", "tool", tool));
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> castMap(Object data) {
        if (data instanceof Map<?, ?> map) {
            return new LinkedHashMap<>((Map<String, Object>) map);
        }
        return new LinkedHashMap<>();
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> parsePayload(String json) {
        if (StrUtil.isBlank(json)) {
            return new LinkedHashMap<>();
        }
        try {
            Map<String, Object> map = JsonUtils.parseObject(json, Map.class);
            return map == null ? new LinkedHashMap<>() : map;
        } catch (RuntimeException ex) {
            return new LinkedHashMap<>();
        }
    }

    private AssistantMessageRespVO toResp(AssistantMessageDO message) {
        AssistantMessageRespVO resp = new AssistantMessageRespVO();
        resp.setId(message.getId());
        resp.setConversationId(message.getConversationId());
        resp.setRole(message.getRole());
        resp.setContent(message.getContent());
        resp.setReasoning(message.getReasoning());
        resp.setStatus(message.getStatus());
        resp.setFiles(parseFiles(message.getFiles()));
        resp.setPayload(parsePayload(message.getPayload()));
        resp.setCreateTime(message.getCreateTime());
        return resp;
    }

    private String toJson(List<AssistantFileVO> files) {
        if (CollUtil.isEmpty(files)) {
            return null;
        }
        return JsonUtils.toJsonString(files);
    }

    private List<AssistantFileVO> parseFiles(String json) {
        if (StrUtil.isBlank(json)) {
            return List.of();
        }
        try {
            List<AssistantFileVO> files = JsonUtils.parseArray(json, AssistantFileVO.class);
            return files == null ? List.of() : files;
        } catch (RuntimeException ex) {
            return List.of();
        }
    }

    private void emit(SseEmitter emitter, String event, Object data) {
        try {
            emitter.send(SseEmitter.event().name(event).data(JsonUtils.toJsonString(data)));
        } catch (Exception ignored) {
            // connection gone; keep writing DB
        }
    }

    private static String brief(String text, int max) {
        String normalized = text.strip().replaceAll("\\s+", " ");
        return normalized.length() <= max ? normalized : normalized.substring(0, max);
    }

}
