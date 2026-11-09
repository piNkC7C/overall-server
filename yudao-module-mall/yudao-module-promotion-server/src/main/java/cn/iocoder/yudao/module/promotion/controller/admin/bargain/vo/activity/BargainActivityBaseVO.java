package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 砍价活动 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class BargainActivityBaseVO {

    @Schema(description = "砍价活动名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "The more you bargain, the more you save. Come join.")
    @NotNull(message = "Bargain name is required.")
    private String name;

    @Schema(description = "商品 SPU 编号", example = "1")
    @NotNull(message = "Bargain product is required.")
    private Long spuId;

    @Schema(description = "商品 skuId", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    @NotNull(message = "Product skuId is required.")
    private Long skuId;

    @Schema(description = "砍价起始价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    @NotNull(message = "Bargain start price cannot be empty.")
    private Integer bargainFirstPrice;

    @Schema(description = "砍价底价", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    @NotNull(message = "Bargain floor price cannot be empty.")
    private Integer bargainMinPrice;

    @Schema(description = "活动库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    @NotNull(message = "Campaigninventory is required.")
    private Integer stock;

    @Schema(description = "总限购数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "16218")
    @NotNull(message = "Total purchase limit cannot be empty.")
    private Integer totalLimitCount;

    @Schema(description = "活动开始时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2022-07-01 23:59:59]")
    @NotNull(message = "Campaign start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "活动结束时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2022-07-01 23:59:59]")
    @NotNull(message = "Campaign end time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "最大助力次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "25222")
    @NotNull(message = "Maximum boost count cannot be empty.")
    private Integer helpMaxCount;

    @Schema(description = "最大帮砍次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "25222")
    @NotNull(message = "Maximum bargain-help count cannot be empty.")
    private Integer bargainCount;

    @Schema(description = "用户每次砍价的最小金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "25222")
    @NotNull(message = "Minimum bargain amount per cut cannot be empty.")
    private Integer randomMinPrice;

    @Schema(description = "用户每次砍价的最大金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "25222")
    @NotNull(message = "Maximum bargain amount per cut cannot be empty.")
    private Integer randomMaxPrice;

}
