package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 文件创建 Request VO")
@Data
public class FileCreateReqVO {

    @NotNull(message = "Filesetting code is required.")
    @Schema(description = "文件配置编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    private Long configId;

    @NotNull(message = "File path is required.")
    @Schema(description = "文件路径", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String path;

    @NotNull(message = "Original file name cannot be empty.")
    @Schema(description = "原文件名", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String name;

    @NotNull(message = "File URL is required.")
    @Schema(description = "文件 URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/yudao.jpg")
    private String url;

    @Schema(description = "文件 MIME 类型", example = "application/octet-stream")
    private String type;

    @Schema(description = "文件大小", example = "2048", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long size;

}
