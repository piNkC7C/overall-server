package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES production task page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProTaskPageReqVO extends PageParam {

    @Schema(description = "Task code.", example = "PT202503150001")
    private String code;

    @Schema(description = "Task name.", example = "Injection-molding task")
    private String name;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Routing path code.", example = "1")
    private Long routeId;

    @Schema(description = "Operation code.", example = "1")
    private Long processId;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Task status.", example = "0")
    private Integer status;

    @Schema(description = "Task status list (IN search).", example = "[0, 1, 2]")
    private List<Integer> statuses;

    @Schema(description = "Is not quality inspection ( relation routing pathoperation).", example = "true")
    private Boolean checkFlag;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
