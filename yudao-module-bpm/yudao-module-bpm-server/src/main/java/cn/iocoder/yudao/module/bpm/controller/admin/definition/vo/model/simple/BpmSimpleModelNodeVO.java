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

@Schema(description = "管理后台 - 仿钉钉流程设计模型节点 VO")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BpmSimpleModelNodeVO {

    @Schema(description = "模型节点编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "StartEvent_1")
    @NotEmpty(message = "Model node code is required.")
    private String id;

    @Schema(description = "模型节点类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model node type is required.")
    @InEnum(BpmSimpleModelNodeTypeEnum.class)
    private Integer type;

    @Schema(description = "模型节点名称", example = "Manager approval")
    private String name;

    @Schema(description = "节点展示内容", example = "Specified member : Overall.")
    private String showText;

    @Schema(description = "子节点")
    private BpmSimpleModelNodeVO childNode; // 补充说明：在该模型下，子节点有且仅有一个，不会有多个

    @Schema(description = "候选人策略", example = "30")
    @InEnum(BpmTaskCandidateStrategyEnum.class)
    private Integer candidateStrategy; // 用于审批，抄送节点

    @Schema(description = "候选人参数")
    private String candidateParam; // 用于审批，抄送节点

    @Schema(description = "审批节点类型", example = "1")
    @InEnum(BpmUserTaskApproveTypeEnum.class)
    private Integer approveType; // At approval node

    @Schema(description = "多人审批方式", example = "1")
    @InEnum(BpmUserTaskApproveMethodEnum.class)
    private Integer approveMethod; // At approval node

    @Schema(description = "通过比例", example = "100")
    private Integer approveRatio; // 通过比例，当多人审批方式为：多人会签(按通过比例) 需要设置

    @Schema(description = "表单权限", example = "[]")
    private List<Map<String, String>> fieldsPermission;

    @Schema(description = "操作按钮设置", example = "[]")
    private List<OperationButtonSetting> buttonsSetting;  // At approval node

    @Schema(description = "是否需要签名", example = "false")
    private Boolean signEnable;

    @Schema(description = "是否填写审批意见", example = "false")
    private Boolean reasonRequire;

    @Schema(description = "跳过表达式", example = "{true}")
    private String skipExpression;  // At approval node

    /**
     * 审批节点拒绝处理
     */
    private RejectHandler rejectHandler;

    /**
     * 审批节点超时处理
     */
    private TimeoutHandler timeoutHandler;

    @Schema(description = "审批节点的审批人与发起人相同时，对应的处理类型", example = "1")
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

    @Schema(description = "延迟器设置", example = "{}")
    private DelaySetting delaySetting;

    @Schema(description = "条件节点")
    private List<BpmSimpleModelNodeVO> conditionNodes; // 补充说明：有且仅有条件、并行、包容分支会使用

    /**
     * 条件节点设置
     */
    private ConditionSetting conditionSetting; // 仅用于条件节点 BpmSimpleModelNodeTypeEnum.CONDITION_NODE

    @Schema(description = "路由分支组", example = "[]")
    private List<RouterSetting> routerGroups;

    @Schema(description = "路由分支默认分支 ID", example = "Flow_xxx", hidden = true) // 由后端生成（不从前端传递），所以 hidden = true
    @JsonIgnore
    private String routerDefaultFlowId; // 仅用于路由分支节点 BpmSimpleModelNodeType.ROUTER_BRANCH_NODE

    /**
     * 触发器节点设置
     */
    private TriggerSetting triggerSetting;

    @Schema(description = "附加节点 Id", example = "UserTask_xxx", hidden = true) // 由后端生成（不从前端传递），所以 hidden = true
    @JsonIgnore
    private String attachNodeId; // 目前用于触发器节点（HTTP 回调）。需要 UserTask 和 ReceiveTask（附加节点) 来完成

    /**
     * 子流程设置
     */
    private ChildProcessSetting childProcessSetting;

    @Schema(description = "任务监听器")
    @Valid
    @Data
    public static class ListenerHandler {

        @Schema(description = "是否开启任务监听器", example = "false")
        @NotNull(message = "Is not enable task listener is required.")
        private Boolean enable;

        @Schema(description = "请求路径", example = "http://xxxxx")
        private String path;

        @Schema(description = "请求头", example = "[]")
        private List<HttpRequestParam> header;

        @Schema(description = "请求体", example = "[]")
        private List<HttpRequestParam> body;

    }

    @Schema(description = "HTTP 请求参数设置")
    @Data
    public static class HttpRequestParam {

        @Schema(description = "值类型", example = "1")
        @InEnum(BpmHttpRequestParamTypeEnum.class)
        @NotNull(message = "Value type cannot be empty.")
        private Integer type;

        @Schema(description = "键", example = "xxx")
        @NotEmpty(message = "Key cannot be empty.")
        private String key;

        @Schema(description = "值", example = "xxx")
        @NotEmpty(message = "Value cannot be empty.")
        private String value;

    }

    @Schema(description = "审批节点拒绝处理策略")
    @Data
    public static class RejectHandler {

        @Schema(description = "拒绝处理类型", example = "1")
        @InEnum(BpmUserTaskRejectHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "任务拒绝后驳回的节点 Id", example = "Activity_1")
        private String returnNodeId;
    }

    @Schema(description = "审批节点超时处理策略")
    @Valid
    @Data
    public static class TimeoutHandler {

        @Schema(description = "是否开启超时处理", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Enable timeout handling cannot be empty.")
        private Boolean enable;

        @Schema(description = "任务超时未处理的行为", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Timeout action cannot be empty.")
        @InEnum(BpmUserTaskTimeoutHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "超时时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "PT6H")
        @NotEmpty(message = "Timeout cannot be empty.")
        private String timeDuration;

        @Schema(description = "最大提醒次数", example = "1")
        private Integer maxRemindCount;
    }

    @Schema(description = "空处理策略")
    @Data
    @Valid
    public static class AssignEmptyHandler {

        @Schema(description = "空处理类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Empty process type is required.")
        @InEnum(BpmUserTaskAssignEmptyHandlerTypeEnum.class)
        private Integer type;

        @Schema(description = "指定人员审批的用户编号数组", example = "1")
        private List<Long> userIds;
    }

    @Schema(description = "操作按钮设置")
    @Data
    @Valid
    public static class OperationButtonSetting {

        // TODO @jason：是不是按钮的标识？id 会和数据库的 id 自增有点模糊，key 标识会更合理一点点哈。
        @Schema(description = "按钮 Id", example = "1")
        private Integer id;

        @Schema(description = "显示名称", example = "Approval.")
        private String displayName;

        @Schema(description = "是否启用", example = "true")
        private Boolean enable;
    }

    @Schema(description = "条件设置")
    @Data
    @Valid
    // 仅用于条件节点 BpmSimpleModelNodeTypeEnum.CONDITION_NODE
    public static class ConditionSetting {

        @Schema(description = "条件类型", example = "1")
        @InEnum(BpmSimpleModeConditionTypeEnum.class)
        private Integer conditionType;

        @Schema(description = "条件表达式", example = "${day>3}")
        private String conditionExpression;

        @Schema(description = "是否默认条件", example = "true")
        private Boolean defaultFlow;

        /**
         * 条件组
         */
        private ConditionGroups conditionGroups;
    }

    @Schema(description = "条件组")
    @Data
    @Valid
    public static class ConditionGroups {

        @Schema(description = "条件组下的条件关系是否为与关系", example = "true")
        @NotNull(message = "Condition Relationship is required.")
        private Boolean and;

        @Schema(description = "条件组下的条件", example = "[]")
        @NotEmpty(message = "Condition is required.")
        private List<Condition> conditions;
    }

    @Schema(description = "条件")
    @Data
    @Valid
    public static class Condition {

        @Schema(description = "条件下的规则关系是否为与关系", example = "true")
        @NotNull(message = "Rule Relationship is required.")
        private Boolean and;

        @Schema(description = "条件下的规则", example = "[]")
        @NotEmpty(message = "Rule is required.")
        private List<ConditionRule> rules;
    }

    @Schema(description = "条件规则")
    @Data
    @Valid
    public static class ConditionRule {

        @Schema(description = "运行符号", example = "==")
        @NotEmpty(message = "Operator cannot be empty.")
        private String opCode;

        @Schema(description = "运算符左边的值,例如某个流程变量", example = "startUserId")
        @NotEmpty(message = "Left-hand value cannot be empty.")
        private String leftSide;

        @Schema(description = "运算符右边的值", example = "1")
        @NotEmpty(message = "Right-hand value cannot be empty.")
        private String rightSide;
    }

    @Schema(description = "延迟器")
    @Data
    @Valid
    public static class DelaySetting {

        @Schema(description = "延迟时间类型", example = "1")
        @NotNull(message = "Delay type cannot be empty.")
        @InEnum(BpmDelayTimerTypeEnum.class)
        private Integer delayType;

        @Schema(description = "延迟时间表达式", example = "PT1H,2025-01-01T00:00:00")
        @NotEmpty(message = "Delay expression cannot be empty.")
        private String delayTime;
    }

    @Schema(description = "路由分支")
    @Data
    @Valid
    public static class RouterSetting {

        @Schema(description = "节点 Id", example = "Activity_xxx") // 跳转到该节点
        @NotEmpty(message = "Node Id is required.")
        private String nodeId;

        @Schema(description = "条件类型", example = "1")
        @InEnum(BpmSimpleModeConditionTypeEnum.class)
        @NotNull(message = "Condition type is required.")
        private Integer conditionType;

        @Schema(description = "条件表达式", example = "${day>3}")
        private String conditionExpression;

        @Schema(description = "条件组", example = "{}")
        private ConditionGroups conditionGroups;
    }

    @Schema(description = "触发器节点配置")
    @Data
    @Valid
    public static class TriggerSetting {

        @Schema(description = "触发器类型", example = "1")
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

        @Schema(description = "http 请求触发器设置", example = "{}")
        @Data
        public static class HttpRequestTriggerSetting {

            @Schema(description = "请求路径", example = "http://127.0.0.1")
            @NotEmpty(message = "Request URL cannot be empty.")
            @URL(message = "Request URL format is invalid.")
            private String url;

            @Schema(description = "请求头参数设置", example = "[]")
            @Valid
            private List<HttpRequestParam> header;

            @Schema(description = "请求头参数设置", example = "[]")
            @Valid
            private List<HttpRequestParam> body;

            /**
             * 请求返回处理设置，用于修改流程表单值
             * <p>
             * key：表示要修改的流程表单字段名(name)
             * value：接口返回的字段名
             */
            @Schema(description = "请求返回处理设置", example = "[]")
            private List<KeyValue<String, String>> response;

            /**
             * Http 回调请求，需要指定回调任务 Key，用于回调执行
             */
            @Schema(description = "回调任务 Key", example = "xxx", hidden = true)
            private String callbackTaskDefineKey;

        }

        @Schema(description = "流程表单触发器设置", example = "{}")
        @Data
        public static class FormTriggerSetting {

            @Schema(description = "条件类型", example = "1")
            @InEnum(BpmSimpleModeConditionTypeEnum.class)
            private Integer conditionType;

            @Schema(description = "条件表达式", example = "${day>3}")
            private String conditionExpression;

            @Schema(description = "条件组", example = "{}")
            private ConditionGroups conditionGroups;

            @Schema(description = "修改的表单字段", example = "{}")
            private Map<String, Object> updateFormFields;

            @Schema(description = "删除表单字段", example = "[]")
            private Set<String> deleteFields;
        }
    }

    @Schema(description = "子流程节点配置")
    @Data
    @Valid
    public static class ChildProcessSetting {

        @Schema(description = "被调用流程", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx")
        @NotEmpty(message = "By call workflow is required.")
        private String calledProcessDefinitionKey;

        @Schema(description = "被调用流程名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx")
        @NotEmpty(message = "By call workflow name is required.")
        private String calledProcessDefinitionName;

        @Schema(description = "是否异步", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Is not Async is required.")
        private Boolean async;

        @Schema(description = "输入参数(主->子)", example = "[]")
        private List<IOParameter> inVariables;

        @Schema(description = "输出参数(子->主)", example = "[]")
        private List<IOParameter> outVariables;

        @Schema(description = "是否自动跳过子流程发起节点", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Skip the child-workflow start node cannot be empty.")
        private Boolean skipStartUserNode;

        @Schema(description = "子流程发起人配置", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        @NotNull(message = "Child workflowstart person setting is required.")
        private StartUserSetting startUserSetting;

        @Schema(description = "超时设置", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        private TimeoutSetting timeoutSetting;

        @Schema(description = "多实例设置", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
        private MultiInstanceSetting multiInstanceSetting;

        @Schema(description = "子流程发起人配置")
        @Data
        @Valid
        public static class StartUserSetting {

            @Schema(description = "子流程发起人类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Child workflowstart person type.")
            @InEnum(BpmChildProcessStartUserTypeEnum.class)
            private Integer type;

            @Schema(description = "表单", example = "xxx")
            private String formField;

            @Schema(description = "当子流程发起人为空时类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Action when child-workflow starter is empty cannot be empty.")
            @InEnum(BpmChildProcessStartUserEmptyTypeEnum.class)
            private Integer emptyType;

        }

        @Schema(description = "超时设置")
        @Data
        @Valid
        public static class TimeoutSetting {

            @Schema(description = "是否开启超时设置", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Enable timeout setting cannot be empty.")
            private Boolean enable;

            @Schema(description = "时间类型", example = "1")
            @InEnum(BpmDelayTimerTypeEnum.class)
            private Integer type;

            @Schema(description = "时间表达式", example = "PT1H,2025-01-01T00:00:00")
            private String timeExpression;

        }

        @Schema(description = "多实例设置")
        @Data
        @Valid
        public static class MultiInstanceSetting {

            @Schema(description = "是否开启多实例", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Enable multi-instance cannot be empty.")
            private Boolean enable;

            @Schema(description = "是否串行", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
            @NotNull(message = "Serial cannot be empty.")
            private Boolean sequential;

            @Schema(description = "完成比例", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
            @NotNull(message = "Completion ratio cannot be empty.")
            private Integer approveRatio;

            @Schema(description = "多实例来源类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Multi-instance source type cannot be empty.")
            @InEnum(BpmChildProcessMultiInstanceSourceTypeEnum.class)
            private Integer sourceType;

            @Schema(description = "多实例来源", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
            @NotNull(message = "Multi-instance source cannot be empty.")
            private String source;

        }

    }
}
