package cn.iocoder.yudao.module.oa.controller.admin.file.vo.permission;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFilePermissionLevelEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFileSubjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 云盘共享权限 Request VO")
@Data
public class OaFilePermissionSaveReqVO {

    @Schema(description = "节点编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Node code is required.")
    private Long nodeId;

    @Schema(description = "共享主体", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Share target type cannot be empty.")
    @InEnum(value = OaFileSubjectTypeEnum.class, message = "Share target type must be {value}.")
    private Integer subjectType;

    @Schema(description = "主体编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Principal ID cannot be empty.")
    private Long subjectId;

    @Schema(description = "权限", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Permission level is required.")
    @InEnum(value = OaFilePermissionLevelEnum.class, message = "Permission level must be {value}.")
    private Integer level;

    @Schema(description = "是否继承到子目录及文件", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Inherit cannot be empty.")
    private Boolean inherit;

    @Schema(description = "到期时间", type = "integer", format = "int64", example = "1789347600000")
    @Future(message = "Expiration must be later than now.")
    private LocalDateTime expireTime;

}
