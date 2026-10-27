package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Personal reseller stats response VO.")
@Data
public class AppBrokerageUserMySummaryRespVO {

    @Schema(description = "Yesterday's commission in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer yesterdayPrice;

    @Schema(description = "Withdrawal commission, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer withdrawPrice;

    @Schema(description = "Available commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2408")
    private Integer brokeragePrice;

    @Schema(description = "Frozen commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "234")
    private Integer frozenPrice;

    @Schema(description = "Level-1 reseller user count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long firstBrokerageUserCount;

    @Schema(description = "Level-2 reseller user count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long secondBrokerageUserCount;

}
