package cn.iocoder.yudao.module.infra.controller.admin.file.vo.config;

import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - filesetting response.")
@Data
public class FileConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Config name", requiredMode = Schema.RequiredMode.REQUIRED, example = "S3 - AWS")
    private String name;

    @Schema(description = "Storage, see FileStorageEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer storage;

    @Schema(description = "Primary config", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean master;

    @Schema(description = "Storage setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private FileClientConfig config;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
