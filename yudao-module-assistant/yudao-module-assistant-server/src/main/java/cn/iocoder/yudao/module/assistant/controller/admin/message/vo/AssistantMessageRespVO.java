package cn.iocoder.yudao.module.assistant.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - AI 助手消息 Response VO")
@Data
public class AssistantMessageRespVO {

    @Schema(description = "消息编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "对话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long conversationId;

    @Schema(description = "角色，user 或 assistant", requiredMode = Schema.RequiredMode.REQUIRED, example = "assistant")
    private String role;

    @Schema(description = "正文")
    private String content;

    @Schema(description = "思考过程")
    private String reasoning;

    @Schema(description = "状态：0 生成中，1 完成，2 失败，3 已停止，4 等待确认", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "附件")
    private List<AssistantFileVO> files;

    @Schema(description = "流式扩展：segments / approval")
    private Object payload;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
