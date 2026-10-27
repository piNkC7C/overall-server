package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Lock or unlock customer request VO.")
@Data
public class CrmCustomerLockReqVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long id;

    @Schema(description = "Customer lock status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Boolean lockStatus;

}
