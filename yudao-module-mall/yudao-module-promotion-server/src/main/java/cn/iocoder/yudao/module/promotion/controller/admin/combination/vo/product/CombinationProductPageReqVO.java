package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.product;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - group buy product page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationProductPageReqVO extends PageParam {

    @Schema(description = "Group buy campaign code.", example = "6829")
    private Long activityId;

    @Schema(description = "Product SPU code.", example = "18731")
    private Long spuId;

    @Schema(description = "Product SKU code.", example = "31675")
    private Long skuId;

    @Schema(description = "Group buy product status.", example = "2")
    private Integer activityStatus;

    @Schema(description = "Campaign start Time Point.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] activityStartTime;

    @Schema(description = "Campaign end Time Point.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] activityEndTime;

    @Schema(description = "Group buy Price, order characters Min.", example = "27682")
    private Integer activePrice;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
