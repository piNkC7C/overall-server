package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.recrod;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 砍价记录 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class BargainRecordBaseVO {

    @Schema(description = "Bargain campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22690")
    @NotNull(message = "Bargain campaign name is required.")
    private Long activityId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9430")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23622")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29950")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Bargain start price, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31160")
    @NotNull(message = "Bargain start price, in cents cannot be empty.")
    private Integer bargainFirstPrice;

    @Schema(description = "Current bargain, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22743")
    @NotNull(message = "Current bargain, order characters ：Min is required.")
    private Integer bargainPrice;

    @Schema(description = "Bargain status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bargain status is required.")
    private Integer status;

    @Schema(description = "Order code.", example = "27845")
    private Long orderId;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

}
