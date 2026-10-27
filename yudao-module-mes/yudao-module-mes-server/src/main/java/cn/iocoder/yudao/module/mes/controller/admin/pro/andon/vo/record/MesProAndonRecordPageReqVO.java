package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "MES andon call record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProAndonRecordPageReqVO extends PageParam {

    @Schema(description = "Workstation code.", example = "100")
    private Long workstationId;

    @Schema(description = "Start user ID.", example = "1")
    private Long userId;

    @Schema(description = "Handle person code.", example = "1")
    private Long handlerUserId;

    @Schema(description = "Handle status.", example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
