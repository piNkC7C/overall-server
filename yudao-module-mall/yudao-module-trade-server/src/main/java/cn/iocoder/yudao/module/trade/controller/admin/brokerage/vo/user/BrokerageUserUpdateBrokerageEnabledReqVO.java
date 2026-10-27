package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - distributor - updatepromoter request.")
@Data
@ToString(callSuper = true)
public class BrokerageUserUpdateBrokerageEnabledReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    @NotNull(message = "User ID is required.")
    private Long id;

    @Schema(description = "Promo Eligibility", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Promo Eligibility is required.")
    private Boolean enabled;

}
