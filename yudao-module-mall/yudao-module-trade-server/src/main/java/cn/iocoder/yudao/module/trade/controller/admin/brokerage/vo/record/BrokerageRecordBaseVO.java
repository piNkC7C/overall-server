package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 佣金记录 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class BrokerageRecordBaseVO {

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "25973")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "业务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23353")
    @NotEmpty(message = "Business code is required.")
    private String bizId;

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Title is required.")
    private String title;

    @Schema(description = "金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "28731")
    @NotNull(message = "Amount is required.")
    private Integer price;

    @Schema(description = "当前总佣金", requiredMode = Schema.RequiredMode.REQUIRED, example = "13226")
    @NotNull(message = "Current total commission cannot be empty.")
    private Integer totalPrice;

    @Schema(description = "说明", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    @NotNull(message = "Notes is required.")
    private String description;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "冻结时间（天）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Freeze time (Days) is required.")
    private Integer frozenDays;

    @Schema(description = "解冻时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unfreezeTime;

    @Schema(description = "来源用户等级")
    private Integer sourceUserLevel;

    @Schema(description = "来源用户编号")
    private Long sourceUserId;
}
