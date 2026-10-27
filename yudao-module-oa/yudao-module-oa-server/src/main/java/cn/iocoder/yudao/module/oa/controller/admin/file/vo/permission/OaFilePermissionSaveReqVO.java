package cn.iocoder.yudao.module.oa.controller.admin.file.vo.permission;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFilePermissionLevelEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFileSubjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Cloud-drive share permission request VO.")
@Data
public class OaFilePermissionSaveReqVO {

    @Schema(description = "Node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Node code is required.")
    private Long nodeId;

    @Schema(description = "Share subject.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Share target type cannot be empty.")
    @InEnum(value = OaFileSubjectTypeEnum.class, message = "Share target type must be {value}.")
    private Integer subjectType;

    @Schema(description = "Principal ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Principal ID cannot be empty.")
    private Long subjectId;

    @Schema(description = "Permission.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Permission level is required.")
    @InEnum(value = OaFilePermissionLevelEnum.class, message = "Permission level must be {value}.")
    private Integer level;

    @Schema(description = "Inherit to child folders and files.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Inherit cannot be empty.")
    private Boolean inherit;

    @Schema(description = "Expires.", type = "integer", format = "int64", example = "1789347600000")
    @Future(message = "Expiration must be later than now.")
    private LocalDateTime expireTime;

}
