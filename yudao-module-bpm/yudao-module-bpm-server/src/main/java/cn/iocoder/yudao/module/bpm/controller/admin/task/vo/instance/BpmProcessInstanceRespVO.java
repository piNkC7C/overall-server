package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.process.BpmProcessDefinitionRespVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - workflow instance response.")
@Data
public class BpmProcessInstanceRespVO {

    @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "WorkflowSummary.")
    private List<KeyValue<String, String>> summary; // Only workflow form, only then has Summary!

    @Schema(description = "Workflowcategory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String category;
    @Schema(description = "Workflowcategory name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Leave")
    private String categoryName;

    @Schema(description = "Workflow instance status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See BpmProcessInstanceStatusEnum enum

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Duration time.", example = "1000")
    private Long durationInMillis;

    @Schema(description = "Submitted form values.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> formVariables;

    @Schema(description = "Business unique key - for example, leave request Code.", example = "1")
    private String businessKey;

    /**
     * 发起流程的用户
     */
    private UserSimpleBaseVO startUser;

    @Schema(description = "Workflow definition code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private String processDefinitionId;
    /**
     * 流程定义
     */
    private BpmProcessDefinitionRespVO processDefinition;

    /**
     * 当前审批中的任务
     */
    private List<Task> tasks; // 仅在流程实例分页才返回

    @Schema(description = "Workflow task.")
    @Data
    public static class Task {

        @Schema(description = "Workflow task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private String id;

        @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String name;

        @Schema(description = "Task assign person code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2048")
        @JsonIgnore // 不返回，只是方便后续读取，赋值给 assigneeUser
        private Long assignee;

        @Schema(description = "Task assign person.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2048")
        private UserSimpleBaseVO assigneeUser;

    }

}
