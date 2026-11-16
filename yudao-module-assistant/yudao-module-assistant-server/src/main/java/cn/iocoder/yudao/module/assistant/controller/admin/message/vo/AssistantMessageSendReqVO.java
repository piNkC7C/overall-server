package cn.iocoder.yudao.module.assistant.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - AI 助手发送消息 Request VO")
@Data
public class AssistantMessageSendReqVO {

    @Schema(description = "对话编号，空则新建", example = "1024")
    private Long conversationId;

    @Schema(description = "消息内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "帮我理一下这个方案")
    @NotEmpty(message = "Message is required.")
    @Size(max = 8000, message = "Message is too long.")
    private String content;

    @Schema(description = "附件列表")
    @Size(max = 5, message = "Too many files.")
    @Valid
    private List<AssistantFileVO> files;

    @Schema(description = "回复语言，取自前端界面语言", example = "zh-CN")
    private String language;

}
