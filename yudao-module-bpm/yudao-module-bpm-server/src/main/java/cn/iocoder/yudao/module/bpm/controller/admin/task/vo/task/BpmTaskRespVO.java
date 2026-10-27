package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - workflow task response.")
@Data
public class BpmTaskRespVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Duration time.", example = "1000")
    private Long durationInMillis;

    @Schema(description = "Task status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status; // See BpmTaskStatusEnum enum

    @Schema(description = "Approval reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private String reason;

    @Schema(description = "Signature.", example = "https://www.iocoder.cn/sign.png")
    private String signPicUrl;

    @Schema(description = "Attachment", example = "[https://test.yudao.iocoder.cn/20260609/test.txt]")
    private List<String> attachments;

    @Schema(description = "Task owner person code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2048")
    @JsonIgnore // 不返回，只是方便后续读取，赋值给 ownerUser
    private Long owner;
    /**
     * 负责人的用户信息
     */
    private UserSimpleBaseVO ownerUser;

    @Schema(description = "Task assign person code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2048")
    @JsonIgnore // 不返回，只是方便后续读取，赋值给 assigneeUser
    private Long assignee;
    /**
     * 审核的用户信息
     */
    private UserSimpleBaseVO assigneeUser;

    @Schema(description = "Task definition key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Activity_one")
    private String taskDefinitionKey;

    @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8888")
    private String processInstanceId;
    /**
     * 所属流程实例
     */
    private ProcessInstance processInstance;

    @Schema(description = "Parent task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String parentTaskId;
    @Schema(description = "Child tasks created by countersign.", requiredMode = Schema.RequiredMode.REQUIRED, example = "childrenTask")
    private List<BpmTaskRespVO> children; // 由加签生成，包含多层子任务

    @Schema(description = "Form code.", example = "1024")
    private Long formId;
    @Schema(description = "Form name.", example = "Leave form")
    private String formName;
    @Schema(description = "Form setting, JSON String.")
    private String formConf;
    @Schema(description = "Form item Array.")
    private List<String> formFields;
    @Schema(description = "Submitted form values.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> formVariables;
    @Schema(description = "Action button setting.")
    private Map<Integer, OperationButtonSetting> buttonsSetting;

    @Schema(description = "Is not need to need signature.", example = "false")
    private Boolean signEnable;

    @Schema(description = "Is not enter approval comment.", example = "false")
    private Boolean reasonRequire;

    @Schema(description = "Node type.", example = "10")
    private Integer nodeType; // See BpmSimpleModelNodeTypeEnum enum

    @Data
    @Schema(description = "Workflow instance.")
    public static class ProcessInstance {

        @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private String id;

        @Schema(description = "Workflow instance name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String name;

        @Schema(description = "Submit time.", requiredMode = Schema.RequiredMode.REQUIRED)
        private LocalDateTime createTime;

        @Schema(description = "Workflow definition code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private String processDefinitionId;

        @Schema(description = "WorkflowSummary.", example = "[]")
        private List<KeyValue<String, String>> summary; // Only workflow form, only then has Summary!

        /**
         * 发起人的用户信息
         */
        private UserSimpleBaseVO startUser;

    }

    @Data
    @Schema(description = "Actionset.")
    public static class OperationButtonSetting {

        @Schema(description = "Show name.", example = "Approval.")
        private String displayName;

        @Schema(description = "Is not Enabled.", example = "true")
        private Boolean enable;
    }

}
