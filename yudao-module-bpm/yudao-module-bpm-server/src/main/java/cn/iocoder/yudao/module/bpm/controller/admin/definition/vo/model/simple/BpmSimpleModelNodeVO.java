package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.*;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.flowable.bpmn.model.IOParameter;
import org.hibernate.validator.constraints.URL;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Schema(description = "Simple workflow design model node VO.")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BpmSimpleModelNodeVO {

    @Schema(description = "Model node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "StartEvent_1")
    @NotEmpty(message = "Model node code is required.")
    private String id;

    @Schema(description = "Model node type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model node type is required.")
    @InEnum(BpmSimpleModelNodeTypeEnum.class)
    private Integer type;

    @Schema(description = "Model node name.", example = "Manager approval")
    private String name;

    @Schema(description = "Node display content.", example = "Specified member : Overall.")
    private String showText;

    @Schema(description = "Child node.")
    private BpmSimpleModelNodeVO childNode; // 补充说明：在该模型下，子节点有且仅有一个，不会有多个

    @Schema(description = "Candidate strategy.", example = "30")
    @InEnum(BpmTaskCandidateStrategyEnum.class)
    private Integer candidateStrategy; // 用于审批，抄送节点

    @Schema(description = "Candidate parameter.")
    private String candidateParam; // 用于审批，抄送节点

    @Schema(description = "Approval node type.", example = "1")
    @InEnum(BpmUserTaskApproveTypeEnum.class)
    private Integer approveType; // At approval node

    @Schema(description = "Multi-approver mode.", example = "1")
    @InEnum(BpmUserTaskApproveMethodEnum.class)
    private Integer approveMethod; // At approval node

    @Schema(description = "Pass ratio.", example = "100")
    private Integer approveRatio; // 通过比例，当多人审批方式为：多人会签(按通过比例) 需要设置

    @Schema(description = "Form permission.", example = "[]")
    private List<Map<String, String>> fieldsPermission;

    @Schema(description = "Actionset.", example = "[]")
    private List<OperationButtonSetting> buttonsSetting;  // At approval node

    @Schema(description = "Is not need to need signature.", example = "false")
    private Boolean signEnable;

    @Schema(description = "Is not enter approval comment.", example = "false")
    private Boolean reasonRequire;

    @Schema(description = "Skip expression.", example = "{true}")
    private String skipExpression;  // At approval node

    /**
     * 审批节点拒绝处理
     */
    private RejectHandler rejectHandler;

    /**
     * 审批节点超时处理
     */
    private TimeoutHandler timeoutHandler;

    @Schema(description = "Approval node approver and start person the same time, a matching process type.", example = "1")
    @InEnum(BpmUserTaskAssignStartUserHandlerTypeEnum.class)
    private Integer assignStartUserHandlerType;

    /**
     * 空处理策略
     */
    private AssignEmptyHandler assignEmptyHandler;

    /**
     * 创建任务监听器
     */
    private ListenerHandler taskCreateListener;
    /**
     * 指派任务监听器
     */
    private ListenerHandler taskAssignListener;
    /**
     * 完成任务监听器
     */
    private ListenerHandler taskCompleteListener;

    @Schema(description = "Delay setting.", example = "{}")
    private DelaySetting delaySetting;

    @Schema(description = "Condition node.")
    private List<BpmSimpleModelNodeVO> conditionNodes; // 补充说明：有且仅有条件、并行、包容分支会使用

    /**
     * 条件节点设置
     */
    private ConditionSetting conditionSetting; // 仅用于条件节点 BpmSimpleModelNodeTypeEnum.CONDITION_NODE

    @Schema(description = "Route branch group.", example = "[]")
    private List<RouterSetting> routerGroups;

    @Schema(description = "Default route branch ID.", example = "Flow_xxx", hidden = true) // 由后端生成（不从前端传递），所以 hidden = true
    @JsonIgnore
    private String routerDefaultFlowId; // 仅用于路由分支节点 BpmSimpleModelNodeType.ROUTER_BRANCH_NODE

    /**
     * 触发器节点设置
     */
    private TriggerSetting triggerSetting;

    @Schema(description = "Extra node ID.", example = "UserTask_xxx", hidden = true) // 由后端生成（不从前端传递），所以 hidden = true
    @JsonIgnore
    private String attachNodeId; // 目前用于触发器节点（HTTP 回调）。需要 UserTask 和 ReceiveTask（附加节点) 来完成

    /**
     * 子流程设置
     */
    private ChildProcessSetting childProcessSetting;

    @Schema(description = "Task listener.")
    @Valid
    @Data
    public static class ListenerHandler {

        @Schema(description = "Is not enable task listener.", example = "false")
        @NotNull(message = "Is not enable task listener is required.")
        private Boolean enable;

        @Schema(description = "Request path.", example = "http://xxxxx")
        private String path;

        @Schema(description = "Request Header", example = "[]")
        private List<HttpRequestParam> header;

        @Schema(description = "Request body.", example = "[]")
        private List<HttpRequestParam> body;

    }

    @Schema(description = "HTTP request params set.")
    @Data
    public static class HttpRequestParam {

        @Schema(description = "Value type.", example = "1")
        @InEnum(BpmHttpRequestParamTypeEnum.class)
        @NotNull(message = "Value type cannot be empty.")
        private Integer type;

        @Schema(description = "Key.", example = "xxx")
        @NotEmpty(message = "Key cannot be empty.")
        private String key;

        @Schema(description = "Value.", example = "xxx")
        @NotEmpty(message = "Value cannot be empty.")
        private String value;

    }

    @Schema(description = "Reject handling policy.")
    @Data
    public static class RejectHandler {

        @Schema(description = "Reject process type.", example = "1")
        @InEnum(BpmUserTaskRejectHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "Reject-to node ID.", example = "Activity_1")
        private String returnNodeId;
    }

    @Schema(description = "Timeout handling policy.")
    @Valid
    @Data
    public static class TimeoutHandler {

        @Schema(description = "Enable timeout handling.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Enable timeout handling cannot be empty.")
        private Boolean enable;

        @Schema(description = "Timeout action.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Timeout action cannot be empty.")
        @InEnum(BpmUserTaskTimeoutHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "Timeout.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PT6H")
        @NotEmpty(message = "Timeout cannot be empty.")
        private String timeDuration;

        @Schema(description = "Max reminder count.", example = "1")
        private Integer maxRemindCount;
    }

    @Schema(description = "Empty-handler policy.")
    @Data
    @Valid
    public static class AssignEmptyHandler {

        @Schema(description = "Empty process type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Empty process type is required.")
        @InEnum(BpmUserTaskAssignEmptyHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "Specified approver user IDs.", example = "1")
        private List<Long> userIds;
    }

    @Schema(description = "Actionset.")
    @Data
    @Valid
    public static class OperationButtonSetting {

        // TODO @jason：是不是按钮的标识？id 会和数据库的 id 自增有点模糊，key 标识会更合理一点点哈。
        @Schema(description = "Id.", example = "1")
        private Integer id;

        @Schema(description = "Show name.", example = "Approval.")
        private String displayName;

        @Schema(description = "Is not Enabled.", example = "true")
        private Boolean enable;
    }

    @Schema(description = "Condition set.")
    @Data
    @Valid
    // 仅用于条件节点 BpmSimpleModelNodeTypeEnum.CONDITION_NODE
    public static class ConditionSetting {

        @Schema(description = "Condition type.", example = "1")
        @InEnum(BpmSimpleModeConditionTypeEnum.class)
        private Integer conditionType;

        @Schema(description = "Condition expression.", example = "${day>3}")
        private String conditionExpression;

        @Schema(description = "Is not default condition.", example = "true")
        private Boolean defaultFlow;

        /**
         * 条件组
         */
        private ConditionGroups conditionGroups;
    }

    @Schema(description = "Condition group.")
    @Data
    @Valid
    public static class ConditionGroups {

        @Schema(description = "Condition group condition Relationship is not is and Relationship.", example = "true")
        @NotNull(message = "Condition Relationship is required.")
        private Boolean and;

        @Schema(description = "Condition group condition.", example = "[]")
        @NotEmpty(message = "Condition is required.")
        private List<Condition> conditions;
    }

    @Schema(description = "Condition.")
    @Data
    @Valid
    public static class Condition {

        @Schema(description = "Condition rule Relationship is not is and Relationship.", example = "true")
        @NotNull(message = "Rule Relationship is required.")
        private Boolean and;

        @Schema(description = "Condition rule.", example = "[]")
        @NotEmpty(message = "Rule is required.")
        private List<ConditionRule> rules;
    }

    @Schema(description = "Condition rule.")
    @Data
    @Valid
    public static class ConditionRule {

        @Schema(description = "Operator.", example = "==")
        @NotEmpty(message = "Operator cannot be empty.")
        private String opCode;

        @Schema(description = "Left-hand value, for example a process variable.", example = "startUserId")
        @NotEmpty(message = "Left-hand value cannot be empty.")
        private String leftSide;

        @Schema(description = "Right-hand value.", example = "1")
        @NotEmpty(message = "Right-hand value cannot be empty.")
        private String rightSide;
    }

    @Schema(description = "Delay.")
    @Data
    @Valid
    public static class DelaySetting {

        @Schema(description = "Delay type.", example = "1")
        @NotNull(message = "Delay type cannot be empty.")
        @InEnum(BpmDelayTimerTypeEnum.class)
        private Integer delayType;

        @Schema(description = "Delay expression.", example = "PT1H,2025-01-01T00:00:00")
        @NotEmpty(message = "Delay expression cannot be empty.")
        private String delayTime;
    }

    @Schema(description = "Route branch.")
    @Data
    @Valid
    public static class RouterSetting {

        @Schema(description = "Node Id.", example = "Activity_xxx") // 跳转到该节点
        @NotEmpty(message = "Node Id is required.")
        private String nodeId;

        @Schema(description = "Condition type.", example = "1")
        @InEnum(BpmSimpleModeConditionTypeEnum.class)
        @NotNull(message = "Condition type is required.")
        private Integer conditionType;

        @Schema(description = "Condition expression.", example = "${day>3}")
        private String conditionExpression;

        @Schema(description = "Condition group.", example = "{}")
        private ConditionGroups conditionGroups;
    }

    @Schema(description = "Trigger node setting.")
    @Data
    @Valid
    public static class TriggerSetting {

        @Schema(description = "Trigger type.", example = "1")
        @InEnum(BpmTriggerTypeEnum.class)
        @NotNull(message = "Trigger type cannot be empty.")
        private Integer type;

        /**
         * http 请求触发器设置
         */
        @Valid
        private HttpRequestTriggerSetting httpRequestSetting;

        /**
         * 流程表单触发器设置
         */
        private List<FormTriggerSetting> formSettings;

        @Schema(description = "HTTP trigger setting.", example = "{}")
        @Data
        public static class HttpRequestTriggerSetting {

            @Schema(description = "Request path.", example = "http://127.0.0.1")
            @NotEmpty(message = "Request URL cannot be empty.")
            @URL(message = "Request URL format is invalid.")
            private String url;

            @Schema(description = "Request Header parameter set.", example = "[]")
            @Valid
            private List<HttpRequestParam> header;

            @Schema(description = "Request Header parameter set.", example = "[]")
            @Valid
            private List<HttpRequestParam> body;

            /**
             * 请求返回处理设置，用于修改流程表单值
             * <p>
             * key：表示要修改的流程表单字段名(name)
             * value：接口返回的字段名
             */
            @Schema(description = "Response-handling setting.", example = "[]")
            private List<KeyValue<String, String>> response;

            /**
             * Http 回调请求，需要指定回调任务 Key，用于回调执行
             */
            @Schema(description = "Callback task key.", example = "xxx", hidden = true)
            private String callbackTaskDefineKey;

        }

        @Schema(description = "Workflow form trigger setting.", example = "{}")
        @Data
        public static class FormTriggerSetting {

            @Schema(description = "Condition type.", example = "1")
            @InEnum(BpmSimpleModeConditionTypeEnum.class)
            private Integer conditionType;

            @Schema(description = "Condition expression.", example = "${day>3}")
            private String conditionExpression;

            @Schema(description = "Condition group.", example = "{}")
            private ConditionGroups conditionGroups;

            @Schema(description = "Edit form field.", example = "{}")
            private Map<String, Object> updateFormFields;

            @Schema(description = "Deleteform field.", example = "[]")
            private Set<String> deleteFields;
        }
    }

    @Schema(description = "Child workflow nodesetting.")
    @Data
    @Valid
    public static class ChildProcessSetting {

        @Schema(description = "By call workflow.", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx")
        @NotEmpty(message = "By call workflow is required.")
        private String calledProcessDefinitionKey;

        @Schema(description = "By call workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx")
        @NotEmpty(message = "By call workflow name is required.")
        private String calledProcessDefinitionName;

        @Schema(description = "Is not Async.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Is not Async is required.")
        private Boolean async;

        @Schema(description = "Input params (parent to child).", example = "[]")
        private List<IOParameter> inVariables;

        @Schema(description = "Output params (child to parent).", example = "[]")
        private List<IOParameter> outVariables;

        @Schema(description = "Skip the child-workflow start node.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Skip the child-workflow start node cannot be empty.")
        private Boolean skipStartUserNode;

        @Schema(description = "Child workflowstart person setting.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        @NotNull(message = "Child workflowstart person setting is required.")
        private StartUserSetting startUserSetting;

        @Schema(description = "Timeout setting.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        private TimeoutSetting timeoutSetting;

        @Schema(description = "Multi-instance setting.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        private MultiInstanceSetting multiInstanceSetting;

        @Schema(description = "Child workflowstart person setting.")
        @Data
        @Valid
        public static class StartUserSetting {

            @Schema(description = "Child workflowstart person type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Child workflowstart person type.")
            @InEnum(BpmChildProcessStartUserTypeEnum.class)
            private Integer type;

            @Schema(description = "Form.", example = "xxx")
            private String formField;

            @Schema(description = "Action when child-workflow starter is empty.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Action when child-workflow starter is empty cannot be empty.")
            @InEnum(BpmChildProcessStartUserEmptyTypeEnum.class)
            private Integer emptyType;

        }

        @Schema(description = "Timeout setting.")
        @Data
        @Valid
        public static class TimeoutSetting {

            @Schema(description = "Enable timeout setting.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Enable timeout setting cannot be empty.")
            private Boolean enable;

            @Schema(description = "Time type.", example = "1")
            @InEnum(BpmDelayTimerTypeEnum.class)
            private Integer type;

            @Schema(description = "Time expression.", example = "PT1H,2025-01-01T00:00:00")
            private String timeExpression;

        }

        @Schema(description = "Multi-instance setting.")
        @Data
        @Valid
        public static class MultiInstanceSetting {

            @Schema(description = "Enable multi-instance.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Enable multi-instance cannot be empty.")
            private Boolean enable;

            @Schema(description = "Serial.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Serial cannot be empty.")
            private Boolean sequential;

            @Schema(description = "Completion ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
            @NotNull(message = "Completion ratio cannot be empty.")
            private Integer approveRatio;

            @Schema(description = "Multi-instance source type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Multi-instance source type cannot be empty.")
            @InEnum(BpmChildProcessMultiInstanceSourceTypeEnum.class)
            private Integer sourceType;

            @Schema(description = "Multi-instance source.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Multi-instance source cannot be empty.")
            private String source;

        }

    }
}
