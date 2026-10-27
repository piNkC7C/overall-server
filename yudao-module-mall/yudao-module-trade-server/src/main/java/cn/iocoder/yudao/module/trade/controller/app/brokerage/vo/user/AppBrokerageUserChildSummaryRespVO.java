package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Downline reseller stats response VO.")
@Data
public class AppBrokerageUserChildSummaryRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

    @Schema(description = "Commission amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer brokeragePrice;

    @Schema(description = "Reseller order Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer brokerageOrderCount;

    @Schema(description = "DistributorQuantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Integer brokerageUserCount;

    @Schema(description = "Bind Promoter time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime brokerageTime;

}
