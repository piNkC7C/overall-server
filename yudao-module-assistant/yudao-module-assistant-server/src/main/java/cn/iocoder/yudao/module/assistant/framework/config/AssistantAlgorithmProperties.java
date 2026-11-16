package cn.iocoder.yudao.module.assistant.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * CRM 智能体（算法）连接。前端不直连；后端仅转发 messages / decision 两个流式接口。
 * 首次对话时后端会调用一次 POST /api/sessions 拿到 session id（不对前端暴露）。
 */
@Component
@ConfigurationProperties(prefix = "yudao.assistant.algorithm")
@Data
public class AssistantAlgorithmProperties {

    /** 例如 http://192.168.110.45:8600 */
    private String baseUrl = "";
    /** 发送消息 */
    private String messagesPath = "/api/sessions/{id}/messages";
    /** 确认 / 拒绝写操作 */
    private String decisionPath = "/api/sessions/{id}/decision";
    /** 内部创建会话（不对前端暴露） */
    private String createSessionPath = "/api/sessions";
    private Duration connectTimeout = Duration.ofSeconds(10);
    /** 未配置 base-url 时是否本地占位流 */
    private boolean mockWhenUnconfigured = true;

}
