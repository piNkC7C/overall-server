package cn.iocoder.yudao.module.trade.controller.app.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "User App - trade setting response.")
@Data
public class AppTradeConfigRespVO {

    @Schema(description = "Tencent Map key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    private String tencentLbsKey;

    // ========== 配送相关 ==========

    @Schema(description = "Is not enable pickup.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable pickup is required.")
    private Boolean deliveryPickUpEnabled;

    // ========== 售后相关 ==========

    @Schema(description = "After-sales refund reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> afterSaleRefundReasons;

    @Schema(description = "After-sales return reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> afterSaleReturnReasons;

    // ========== 分销相关 ==========

    @Schema(description = "Distribution poster URLs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> brokeragePosterUrls;

    @Schema(description = "Commission freeze days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer brokerageFrozenDays;

    @Schema(description = "Minimum commission withdrawal amount in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer brokerageWithdrawMinPrice;

    @Schema(description = "Withdrawal method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    private List<Integer> brokerageWithdrawTypes;

}
