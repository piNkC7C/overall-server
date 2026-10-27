package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.task.BpmProcessInstanceStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - workflow instance page request.")
@Data
public class BpmProcessInstancePageReqVO extends PageParam {

    @Schema(description = "Workflow name.", example = "Overall.")
    private String name;

    @Schema(description = "Workflow definition key.", example = "2048")
    private String processDefinitionKey; // 精准匹配

    @Schema(description = "Workflow instance status.", example = "1")
    @InEnum(BpmProcessInstanceStatusEnum.class)
    private Integer status;

    @Schema(description = "Workflowcategory.", example = "1")
    private String category;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "End time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @Schema(description = "Start user ID.", example = "1024")
    private Long startUserId; // 注意，只有在【流程实例】菜单，才使用该参数

    @Schema(description = "Dynamic formfieldsearch JSON Str.", example = "{}")
    private String formFieldsParams; // SpringMVC 在 get 请求下，无法方便的定义 Map 类型的参数，所以通过 String 接收后，逻辑里面转换

}
