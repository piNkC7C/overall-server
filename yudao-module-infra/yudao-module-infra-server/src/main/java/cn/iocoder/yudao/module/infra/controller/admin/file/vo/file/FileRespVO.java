package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "File response VO.")
@Data
public class FileRespVO {

    @Schema(description = "File code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    private Long configId;

    @Schema(description = "File path", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String path;

    @Schema(description = "Original file name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao.jpg")
    private String name;

    @Schema(description = "File URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/yudao.jpg")
    private String url;

    @Schema(description = "FileMIME type.", example = "application/octet-stream")
    private String type;

    @Schema(description = "File size", example = "2048", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long size;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
