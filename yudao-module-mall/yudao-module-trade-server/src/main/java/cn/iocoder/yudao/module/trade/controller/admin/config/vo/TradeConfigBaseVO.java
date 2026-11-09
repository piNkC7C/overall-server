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

    @Schema(description = "售后的退款理由", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "After-sales refund reason is required.")
    private List<String> afterSaleRefundReasons;

    @Schema(description = "售后的退货理由", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "After-sales return reason is required.")
    private List<String> afterSaleReturnReasons;

    // ========== 配送相关 ==========

    /**
     * 是否启用全场包邮
     */
    @Schema(description = "是否启用全场包邮", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Enable store-wide free shipping cannot be empty.")
    private Boolean deliveryExpressFreeEnabled;

    @Schema(description = "全场包邮的最小金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Free-shipping minimum cannot be empty.")
    @PositiveOrZero(message = "Free-shipping minimum cannot be negative.")
    private Integer deliveryExpressFreePrice;

    @Schema(description = "是否开启自提", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable pickup is required.")
    private Boolean deliveryPickUpEnabled;

    // ========== 分销相关 ==========

    @Schema(description = "是否启用分佣", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Enable commission cannot be empty.")
    private Boolean brokerageEnabled;

    @Schema(description = "分佣模式", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Commission mode cannot be empty.")
    @InEnum(value = BrokerageEnabledConditionEnum.class, message = "Commission mode must be {value}.")
    private Integer brokerageEnabledCondition;

    @Schema(description = "分销关系绑定模式", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Distribution bind mode cannot be empty.")
    @InEnum(value = BrokerageBindModeEnum.class, message = "Distribution bind mode must be {value}.")
    private Integer brokerageBindMode;

    @Schema(description = "分销海报图地址数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/yudao.jpg]")
    private List<String> brokeragePosterUrls;

    @Schema(description = "一级返佣比例", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Level-1 commission rate cannot be empty.")
    @Range(min = 0, max = 100, message = "Level-1 commission rate must be between 0 and 100.")
    private Integer brokerageFirstPercent;

    @Schema(description = "二级返佣比例", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Level-2 commission rate cannot be empty.")
    @Range(min = 0, max = 100, message = "Level-2 commission rate must be between 0 and 100.")
    private Integer brokerageSecondPercent;

    @Schema(description = "用户提现最低金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Minimum withdrawal amount cannot be empty.")
    @PositiveOrZero(message = "Minimum withdrawal amount cannot be negative.")
    private Integer brokerageWithdrawMinPrice;

    @Schema(description = "用户提现手续费百分比", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Withdrawal fee percentage cannot be empty.")
    @PositiveOrZero(message = "Withdrawal fee percentage cannot be negative.")
    private Integer brokerageWithdrawFeePercent;

    @Schema(description = "佣金冻结时间(天)", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Commission freeze days cannot be empty.")
    @PositiveOrZero(message = "Commission freeze days cannot be negative.")
    private Integer brokerageFrozenDays;

    @Schema(description = "提现方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "[0, 1]")
    @NotEmpty(message = "Withdrawal method is required.")
    @InEnum(value = BrokerageWithdrawTypeEnum.class, message = "Withdrawal method must be {value}.")
    private List<Integer> brokerageWithdrawTypes;

}
