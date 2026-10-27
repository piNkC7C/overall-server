package cn.iocoder.yudao.module.crm.controller.admin.permission.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Admin - CRM data permission response.")
@Data
public class CrmPermissionRespVO {

    @Schema(description = "Data permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "CRM type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(CrmBizTypeEnum.class)
    @NotNull(message = "CRM type is required.")
    private Integer bizType;

    @Schema(description = "CRM type data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "CRM type data code is required.")
    private Long bizId;

    @Schema(description = "Permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(CrmPermissionLevelEnum.class)
    @NotNull(message = "Permission level is required.")
    private Integer level;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Engineering.")
    private String deptName;

    @Schema(description = "Post nameArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[BOSS, Manager]")
    private Set<String> postNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-01-01 00:00:00")
    private LocalDateTime createTime;

}
