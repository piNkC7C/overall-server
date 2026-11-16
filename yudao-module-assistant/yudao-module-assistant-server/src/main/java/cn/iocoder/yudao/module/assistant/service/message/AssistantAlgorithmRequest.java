package cn.iocoder.yudao.module.assistant.service.message;

import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantFileVO;
import lombok.Data;

import java.util.List;

/**
 * 发给算法的一轮请求。
 * <p>
 * POST {baseUrl}{streamPath}
 * Accept: text/event-stream
 * Content-Type: application/json
 * <pre>
 * {
 *   "conversationId": 1,
 *   "messageId": 2,
 *   "content": "当前用户消息",
 *   "files": [{ "name": "a.pdf", "url": "https://...", "mimeType": "application/pdf", "size": 12 }],
 *   "messages": [{ "role": "user", "content": "更早的消息" }, { "role": "assistant", "content": "更早的回复" }]
 * }
 * </pre>
 * messages 只带当前这条之前的历史，content 是本轮用户输入。
 */
@Data
public class AssistantAlgorithmRequest {

    private Long conversationId;
    private Long messageId;
    private String content;
    private List<AssistantFileVO> files;
    private List<Turn> messages;

    @Data
    public static class Turn {
        private String role;
        private String content;
    }

}
