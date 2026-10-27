package cn.iocoder.yudao.module.oa.controller.admin.file.vo.permission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Cloud-drive share permission response VO.")
@Data
public class OaFilePermissionRespVO {

    @Schema(description = "Permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long nodeId;

    @Schema(description = "Subject type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer subjectType;

    @Schema(description = "Principal ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long subjectId;

    @Schema(description = "Permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Inherit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean inherit;

    @Schema(description = "Expires.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime expireTime;

}
