package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES device inspection record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvCheckRecordPageReqVO extends PageParam {

    @Schema(description = "Inspection plan code.", example = "1")
    private Long planId;

    @Schema(description = "Device code.", example = "1")
    private Long machineryId;

    @Schema(description = "Inspection person code.", example = "1")
    private Long userId;

    @Schema(description = "Status.", example = "10")
    private Integer status;

    @Schema(description = "Inspection time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] checkTime;

}
