package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Product reseller Amount response VO.")
@Data
public class AppBrokerageProductPriceRespVO {

    @Schema(description = "Is not enable.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Boolean enabled;

    @Schema(description = "Minimum reseller amount in cents.", example = "100")
    private Integer brokerageMinPrice;

    @Schema(description = "Maximum reseller amount in cents.", example = "100")
    private Integer brokerageMaxPrice;

}
