package cn.iocoder.yudao.module.trade.controller.admin.config.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageBindModeEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageEnabledConditionEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageWithdrawTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * 交易中心配置 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class TradeConfigBaseVO {

    // ========== 售后相关 ==========

    @Schema(description = "After-sales refund reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "After-sales refund reason is required.")
    private List<String> afterSaleRefundReasons;

    @Schema(description = "After-sales return reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "After-sales return reason is required.")
    private List<String> afterSaleReturnReasons;

    // ========== 配送相关 ==========

    /**
     * 是否启用全场包邮
     */
    @Schema(description = "Enable store-wide free shipping.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Enable store-wide free shipping cannot be empty.")
    private Boolean deliveryExpressFreeEnabled;

    @Schema(description = "Free-shipping minimum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Free-shipping minimum cannot be empty.")
    @PositiveOrZero(message = "Free-shipping minimum cannot be negative.")
    private Integer deliveryExpressFreePrice;

    @Schema(description = "Is not enable pickup.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable pickup is required.")
    private Boolean deliveryPickUpEnabled;

    // ========== 分销相关 ==========

    @Schema(description = "Enable commission.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Enable commission cannot be empty.")
    private Boolean brokerageEnabled;

    @Schema(description = "Commission mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Commission mode cannot be empty.")
    @InEnum(value = BrokerageEnabledConditionEnum.class, message = "Commission mode must be {value}.")
    private Integer brokerageEnabledCondition;

    @Schema(description = "Distribution bind mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Distribution bind mode cannot be empty.")
    @InEnum(value = BrokerageBindModeEnum.class, message = "Distribution bind mode must be {value}.")
    private Integer brokerageBindMode;

    @Schema(description = "Distribution poster URLs.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/yudao.jpg]")
    private List<String> brokeragePosterUrls;

    @Schema(description = "Level-1 commission rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Level-1 commission rate cannot be empty.")
    @Range(min = 0, max = 100, message = "Level-1 commission rate must be between 0 and 100.")
    private Integer brokerageFirstPercent;

    @Schema(description = "Level-2 commission rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Level-2 commission rate cannot be empty.")
    @Range(min = 0, max = 100, message = "Level-2 commission rate must be between 0 and 100.")
    private Integer brokerageSecondPercent;

    @Schema(description = "Minimum withdrawal amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Minimum withdrawal amount cannot be empty.")
    @PositiveOrZero(message = "Minimum withdrawal amount cannot be negative.")
    private Integer brokerageWithdrawMinPrice;

    @Schema(description = "Withdrawal fee percentage.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Withdrawal fee percentage cannot be empty.")
    @PositiveOrZero(message = "Withdrawal fee percentage cannot be negative.")
    private Integer brokerageWithdrawFeePercent;

    @Schema(description = "Commission freeze days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Commission freeze days cannot be empty.")
    @PositiveOrZero(message = "Commission freeze days cannot be negative.")
    private Integer brokerageFrozenDays;

    @Schema(description = "Withdrawal method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[0, 1]")
    @NotEmpty(message = "Withdrawal method is required.")
    @InEnum(value = BrokerageWithdrawTypeEnum.class, message = "Withdrawal method must be {value}.")
    private List<Integer> brokerageWithdrawTypes;

}
