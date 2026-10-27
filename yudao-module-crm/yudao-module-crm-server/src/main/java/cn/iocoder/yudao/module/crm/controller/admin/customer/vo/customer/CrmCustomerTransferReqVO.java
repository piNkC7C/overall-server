package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - CRM customer transfer request.")
@Data
public class CrmCustomerTransferReqVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "Customer code is required.")
    private Long id;

    /**
     * 新负责人的用户编号
     */
    @Schema(description = "New owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @NotNull(message = "New owner user ID cannot be empty.")
    private Long newOwnerUserId;

    /**
     * 老负责人加入团队后的权限级别。如果 null 说明移除
     *
     * 关联 {@link CrmPermissionLevelEnum}
     */
    @Schema(description = "Permission level after the previous owner joins the team.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer oldOwnerPermissionLevel;

    /**
     * 转移客户时，需要额外有【联系人】【商机】【合同】的 checkbox 选择。选中时，也一起转移
     */
    @Schema(description = "Transfer together.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    private List<Integer> toBizTypes;

}
