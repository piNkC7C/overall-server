package cn.iocoder.yudao.module.crm.controller.admin.clue.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - lead transfer request.")
@Data
public class CrmClueTransferReqVO {

    @Schema(description = "Lead code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "Lead code is required.")
    private Long id;

    @Schema(description = "New owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "New owner user ID cannot be empty.")
    private Long newOwnerUserId;

    @Schema(description = "Permission level after the previous owner joins the team.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(value = CrmPermissionLevelEnum.class)
    private Integer oldOwnerPermissionLevel; // 老负责人加入团队后的权限级别。如果 null 说明移除

}
