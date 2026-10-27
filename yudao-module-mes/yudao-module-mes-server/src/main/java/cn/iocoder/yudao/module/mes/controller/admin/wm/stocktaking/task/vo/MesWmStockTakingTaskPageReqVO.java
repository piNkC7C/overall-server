package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES stocktake task page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmStockTakingTaskPageReqVO extends PageParam {

    @Schema(description = "Task code.", example = "ST202603080001")
    private String code;

    @Schema(description = "Task name.", example = "Raw-warehouse monthly count")
    private String name;

    @Schema(description = "Stocktake type.", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Stocktake person ID.", example = "1")
    private Long userId;

    @Schema(description = "Source plan ID.", example = "1")
    private Long planId;

    @Schema(description = "Stocktake DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] takingDate;

}
