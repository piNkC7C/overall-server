package cn.iocoder.yudao.module.crm.controller.admin.business.vo.business;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.business.CrmBusinessEndStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - CRM opportunityupdate status request.")
@Data
public class CrmBusinessUpdateStatusReqVO {

    @Schema(description = "Opportunity code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32129")
    @NotNull(message = "Opportunity code is required.")
    private Long id;

    @Schema(description = "Status code.", example = "1")
    private Long statusId;

    @Schema(description = "End status.", example = "1")
    @InEnum(value = CrmBusinessEndStatusEnum.class)
    private Integer endStatus;

    @AssertTrue(message = "Status change is invalid.")
    public boolean isStatusValid() {
        return statusId != null || endStatus != null;
    }

}
