package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - filecreate request.")
@Data
public class FileCreateReqVO {

    @NotNull(message = "Filesetting code is required.")
    @Schema(description = "Filesetting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    private Long configId;

    @NotNull(message = "File path is required.")
    @Schema(description = "File path", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String path;

    @NotNull(message = "Original file name cannot be empty.")
    @Schema(description = "Original file name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String name;

    @NotNull(message = "File URL is required.")
    @Schema(description = "File URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/yudao.jpg")
    private String url;

    @Schema(description = "File MIME type.", example = "application/octet-stream")
    private String type;

    @Schema(description = "File size", example = "2048", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long size;

}
