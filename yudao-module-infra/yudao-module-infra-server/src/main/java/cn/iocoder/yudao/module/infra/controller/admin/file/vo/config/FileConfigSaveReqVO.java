package cn.iocoder.yudao.module.infra.controller.admin.file.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "Admin - filesetting create or update request.")
@Data
public class FileConfigSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Config name", requiredMode = Schema.RequiredMode.REQUIRED, example = "S3 - AWS")
    @NotNull(message = "Config name is required.")
    private String name;

    @Schema(description = "Storage, see FileStorageEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Storage is required.")
    private Integer storage;

    @Schema(description = "Storage settings. Params are dynamic, so they are received as a Map.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Storage setting is required.")
    private Map<String, Object> config;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

}
