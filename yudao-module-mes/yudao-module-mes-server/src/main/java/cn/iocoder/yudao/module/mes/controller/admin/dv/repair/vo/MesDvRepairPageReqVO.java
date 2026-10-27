package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES repair work order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvRepairPageReqVO extends PageParam {

    @Schema(description = "Repair work order code.", example = "REP2024001")
    private String code;

    @Schema(description = "Repair work order name.", example = "Injection-molding machine repair")
    private String name;

    @Schema(description = "Device code.", example = "1")
    private Long machineryId;

    @Schema(description = "Maintenance result.", example = "1")
    private Integer result;

    @Schema(description = "Status.", example = "10")
    private Integer status;

    @Schema(description = "Repair date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] requireDate;

}
