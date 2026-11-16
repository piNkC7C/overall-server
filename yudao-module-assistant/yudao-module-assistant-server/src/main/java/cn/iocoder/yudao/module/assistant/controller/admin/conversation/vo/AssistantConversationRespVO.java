package cn.iocoder.yudao.module.assistant.controller.admin.conversation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - AI 助手对话 Response VO")
@Data
public class AssistantConversationRespVO {

    @Schema(description = "对话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "帮我理一下方案")
    private String title;

    @Schema(description = "导航预览", example = "帮我理一下这个方案的风险")
    private String preview;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
