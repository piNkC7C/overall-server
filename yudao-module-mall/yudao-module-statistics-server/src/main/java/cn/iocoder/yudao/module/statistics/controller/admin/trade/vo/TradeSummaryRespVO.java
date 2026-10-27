package cn.iocoder.yudao.module.statistics.controller.admin.trade.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - trade Stats response.")
@Data
public class TradeSummaryRespVO {

    @Schema(description = "Orders Yesterday.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer yesterdayOrderCount;
    @Schema(description = "Paid Yesterday.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer yesterdayPayPrice;

    @Schema(description = "This Monthorder quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer monthOrderCount;
    @Schema(description = "This Month payment amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer monthPayPrice;

}
