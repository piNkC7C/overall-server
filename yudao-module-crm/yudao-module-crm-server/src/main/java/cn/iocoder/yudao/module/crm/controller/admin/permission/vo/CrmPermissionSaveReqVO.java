package cn.iocoder.yudao.module.crm.controller.admin.permission.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - CRM data permission create or update request.")
@Data
public class CrmPermissionSaveReqVO {

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

    /**
     * 添加客户团队成员时，需要额外有【联系人】【商机】【合同】的 checkbox 选择。
     * 选中时，同时添加对应的权限
     */
    @Schema(description = "Add together.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    private List<Integer> toBizTypes;

}
