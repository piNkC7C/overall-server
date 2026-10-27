package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 拼团活动 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class CombinationActivityBaseVO {

    @Schema(description = "Group buy name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Save more when you group-buy")
    @NotNull(message = "Group buy name is required.")
    private String name;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Group buy product is required.")
    private Long spuId;

    @Schema(description = "Total purchase limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16218")
    @NotNull(message = "Total purchase limit cannot be empty.")
    private Integer totalLimitCount;

    @Schema(description = "Per-order purchase limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28265")
    @NotNull(message = "Per-order purchase limit cannot be empty.")
    private Integer singleLimitCount;

    @Schema(description = "Campaign time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2022-07-01 23:59:59]")
    @NotNull(message = "Campaign time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Campaign time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2022-07-01 23:59:59]")
    @NotNull(message = "Campaign time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Group-buy start size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25222")
    @NotNull(message = "Group-buy start size cannot be empty.")
    private Integer userSize;

    @Schema(description = "Virtual group buy.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Virtual group buy cannot be empty.")
    private Boolean virtualGroup;

    @Schema(description = "Duration limit (hours).", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Duration limit cannot be empty.")
    private Integer limitDuration;

}
