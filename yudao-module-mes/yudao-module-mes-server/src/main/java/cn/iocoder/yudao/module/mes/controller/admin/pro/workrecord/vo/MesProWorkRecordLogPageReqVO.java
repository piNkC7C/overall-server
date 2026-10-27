package cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Clock-on/off ledger page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProWorkRecordLogPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Action type (1 clock in, 2 clock out).", example = "1")
    private Integer type;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
