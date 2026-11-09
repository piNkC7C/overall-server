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

    @Schema(description = "砍价活动名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "22690")
    @NotNull(message = "Bargain campaign name is required.")
    private Long activityId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "9430")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23622")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29950")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "砍价起始价格，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "31160")
    @NotNull(message = "Bargain start price, in cents cannot be empty.")
    private Integer bargainFirstPrice;

    @Schema(description = "当前砍价，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "22743")
    @NotNull(message = "Current bargain, order characters ：Min is required.")
    private Integer bargainPrice;

    @Schema(description = "砍价状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bargain status is required.")
    private Integer status;

    @Schema(description = "订单编号", example = "27845")
    private Long orderId;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

}
