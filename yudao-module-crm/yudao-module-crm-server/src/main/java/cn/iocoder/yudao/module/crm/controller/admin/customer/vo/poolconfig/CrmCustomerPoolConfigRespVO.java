package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.poolconfig;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Customer pool rule response VO.")
@Data
public class CrmCustomerPoolConfigRespVO {

    @Schema(description = "Customer pool enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Customer pool enabled cannot be empty.")
    private Boolean enabled;

    @Schema(description = "Days in pool after no follow-up.", example = "2")
    private Integer contactExpireDays;

    @Schema(description = "Days in pool after no win.", example = "2")
    private Integer dealExpireDays;

    @Schema(description = "Early reminder enabled.", example = "true")
    private Boolean notifyEnabled;

    @Schema(description = "Reminder days.", example = "2")
    private Integer notifyDays;

}
