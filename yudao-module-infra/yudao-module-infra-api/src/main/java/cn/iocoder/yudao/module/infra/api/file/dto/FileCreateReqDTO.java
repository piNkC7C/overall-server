package cn.iocoder.yudao.module.infra.api.file.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "RPC service - filecreate Request DTO.")
@Data
public class FileCreateReqDTO {

    @Schema(description = "Original file name.", example = "xxx.png")
    private String name;

    @Schema(description = "File directory.", example = "xxx")
    private String directory;

    @Schema(description = "File MIME type.", example = "image/png")
    private String type;

    @Schema(description = "File content.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "File content is required.")
    private byte[] content;

}
