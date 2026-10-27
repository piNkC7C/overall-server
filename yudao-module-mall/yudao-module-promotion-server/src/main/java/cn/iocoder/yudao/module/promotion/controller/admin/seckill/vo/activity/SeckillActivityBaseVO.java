package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 秒杀活动基地签证官
 * 秒杀活动 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class SeckillActivityBaseVO {

    @Schema(description = "Flash sale campaignproduct id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[121,1212]")
    @NotNull(message = "Flash sale campaignproduct is required.")
    private Long spuId;

    @Schema(description = "Flash sale campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer Sale")
    @NotNull(message = "Flash sale campaign name is required.")
    private String name;

    @Schema(description = "Notes.", example = "Clearance sale")
    private String remark;

    @Schema(description = "Campaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Campaign start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Campaign end time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Flash-sale slot id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2,3]")
    @NotNull(message = "Flash-sale slot cannot be empty.")
    private List<Long> configIds;

    @Schema(description = "Total purchase limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12877")
    private Integer totalLimitCount;

    @Schema(description = "Per-order limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31683")
    private Integer singleLimitCount;

}
