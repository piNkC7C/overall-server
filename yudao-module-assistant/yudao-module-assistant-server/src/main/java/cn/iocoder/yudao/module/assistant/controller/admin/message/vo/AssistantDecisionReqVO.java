package cn.iocoder.yudao.module.assistant.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Schema(description = "管理后台 - AI 助手确认/拒绝写操作 Request VO")
@Data
public class AssistantDecisionReqVO {

    @Schema(description = "对话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Conversation id cannot be empty")
    private Long conversationId;

    @Schema(description = "助手消息编号（当前等待确认的那条）", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Message id cannot be empty")
    private Long messageId;

    @Schema(description = "是否确认执行", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "approve cannot be empty")
    private Boolean approve;

    @Schema(description = "确认时可选：完整参数（含用户修改）")
    private Map<String, Object> args;

    @Schema(description = "拒绝时可选：原因")
    private String feedback;

}
