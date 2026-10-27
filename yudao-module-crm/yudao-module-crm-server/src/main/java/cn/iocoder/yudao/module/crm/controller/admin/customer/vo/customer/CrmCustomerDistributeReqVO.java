package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Assign pool customer to owner request VO.")
@Data
public class CrmCustomerDistributeReqVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1024]")
    @NotEmpty(message = "Customer code is required.")
    private List<Long> ids;

    @Schema(description = "Owner person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Owner person is required.")
    private Long ownerUserId;

}
