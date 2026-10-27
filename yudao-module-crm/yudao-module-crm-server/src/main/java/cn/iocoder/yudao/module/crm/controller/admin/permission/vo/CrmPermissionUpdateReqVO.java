package cn.iocoder.yudao.module.crm.controller.admin.permission.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - CRM data permission update request.")
@Data
public class CrmPermissionUpdateReqVO {

    @Schema(description = "Data permission code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotNull(message = "Data permission code list is required.")
    private List<Long> ids;

    @Schema(description = "Crm type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(CrmBizTypeEnum.class)
    @NotNull(message = "Crm type is required.")
    private Integer bizType;

    @Schema(description = "Crm type data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Crm type data code is required.")
    private Long bizId;

    @Schema(description = "Permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(CrmPermissionLevelEnum.class)
    @NotNull(message = "Permission level is required.")
    private Integer level;

}
