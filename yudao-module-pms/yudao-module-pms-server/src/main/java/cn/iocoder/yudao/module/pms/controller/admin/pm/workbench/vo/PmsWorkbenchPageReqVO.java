package cn.iocoder.yudao.module.pms.controller.admin.pm.workbench.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemPriorityEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - PMS workbenchpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsWorkbenchPageReqVO extends PageParam {

    @Schema(description = "Item code.", example = "1024")
    private Long projectId;

    @Schema(description = "Work item type.", example = "3")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer type;

    @Schema(description = "Name.", example = "Sign-in.")
    private String name;

    @Schema(description = "Status, work item is Semantic status, sprint is sprint status.", example = "2")
    private Integer status;

    @Schema(description = "Priority", example = "2")
    @InEnum(PmsWorkItemPriorityEnum.class)
    private Integer priority;

    @Schema(description = "Sprint code.", example = "1024")
    private Long iterationId;

    @Schema(description = "Due time range.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

}
