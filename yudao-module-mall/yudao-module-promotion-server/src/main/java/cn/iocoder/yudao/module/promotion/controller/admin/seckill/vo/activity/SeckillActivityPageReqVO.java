package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

@Schema(description = "Admin - flash sale campaign page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillActivityPageReqVO extends PageParam {

    @Schema(description = "Flash sale campaign name.", example = "9 PM flash sale")
    private String name;

    @Schema(description = "Campaign status.", example = "In progress.")
    private Integer status;

    @Schema(description = "Flash-sale slotid.", example = "1")
    private Long configId;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime[] createTime;

}
