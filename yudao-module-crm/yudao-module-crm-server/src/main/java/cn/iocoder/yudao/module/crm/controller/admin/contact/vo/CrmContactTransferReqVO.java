package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "管理后台 - CRM 联系人转移 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmContactTransferReqVO {

    @Schema(description = "联系人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "Contact code is required.")
    private Long id;

    /**
     * 新负责人的用户编号
     */
    @Schema(description = "新负责人的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "New owner user ID cannot be empty.")
    private Long newOwnerUserId;

    /**
     * 老负责人加入团队后的权限级别。如果 null 说明移除
     *
     * 关联 {@link CrmPermissionLevelEnum}
     */
    @Schema(description = "老负责人加入团队后的权限级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer oldOwnerPermissionLevel;

}
