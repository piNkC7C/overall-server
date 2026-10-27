package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - CRM contract transfer request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmContractTransferReqVO {

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "Contact code is required.")
    private Long id;

    @Schema(description = "New owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "New owner user ID cannot be empty.")
    private Long newOwnerUserId;

    @Schema(description = "Permission level after the previous owner joins the team.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(value = CrmPermissionLevelEnum.class)
    private Integer oldOwnerPermissionLevel;

}
