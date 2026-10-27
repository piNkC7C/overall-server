package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.date.DateUtils;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.task.BpmTaskStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "Admin - workflow task page request.") // 待办、已办，都使用该分页
@Data
public class BpmTaskPageReqVO extends PageParam {

    @Schema(description = "Workflow task name.", example = "Overall.")
    private String name;

    @Schema(description = "Workflowcategory.", example = "1")
    private String category;

    @Schema(description = "Workflow definition key.", example = "2048")
    private String processDefinitionKey; // 精准匹配

    @Schema(description = "Approval status.", example = "1")
    @InEnum(BpmTaskStatusEnum.class)
    private Integer status; // 仅【已办】使用

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
