package cn.iocoder.yudao.module.assistant.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - AI 助手附件")
@Data
public class AssistantFileVO {

    @Schema(description = "文件名", requiredMode = Schema.RequiredMode.REQUIRED, example = "brief.pdf")
    @NotEmpty(message = "File name is required.")
    @Size(max = 255, message = "File name is required.")
    private String name;

    @Schema(description = "文件地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://example.com/brief.pdf")
    @NotEmpty(message = "File URL is required.")
    @Size(max = 1024, message = "File URL is required.")
    private String url;

    @Schema(description = "MIME 类型", example = "application/pdf")
    @Size(max = 127, message = "File URL is required.")
    private String mimeType;

    @Schema(description = "文件大小，单位字节", example = "1024")
    private Long size;

}
