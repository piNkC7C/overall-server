package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Reseller user info response VO.")
@Data
public class AppBrokerageUserRespVO {

    @Schema(description = "Has distribution eligibility.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean brokerageEnabled;

    @Schema(description = "Available commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2408")
    private Integer brokeragePrice;

    @Schema(description = "Frozen commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "234")
    private Integer frozenPrice;

}
