package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES inspection and maintenance plan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvCheckPlanPageReqVO extends PageParam {

    @Schema(description = "Plan code.", example = "CHP001")
    private String code;

    @Schema(description = "Plan name.", example = "Injection-molding machine")
    private String name;

    @Schema(description = "Plan type.", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
