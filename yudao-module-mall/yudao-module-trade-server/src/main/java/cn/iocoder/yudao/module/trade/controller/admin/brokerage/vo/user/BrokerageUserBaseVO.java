package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 分销用户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class BrokerageUserBaseVO {

    @Schema(description = "Promoter code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4587")
    @NotNull(message = "Promoter code is required.")
    private Long bindUserId;

    @Schema(description = "Promoter bind time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime bindUserTime;

    @Schema(description = "Promo Eligibility", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Promo Eligibility is required.")
    private Boolean brokerageEnabled;

    @Schema(description = "Became distributor time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime brokerageTime;

    @Schema(description = "Available commission.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11089")
    @NotNull(message = "Available commission cannot be empty.")
    private Integer price;

    @Schema(description = "Frozen commission.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30916")
    @NotNull(message = "Frozen commission cannot be empty.")
    private Integer frozenPrice;

}
