package cn.iocoder.yudao.module.bpm.enums.definition;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 仿钉钉的流程器设计器的模型节点类型
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
public enum BpmSimpleModelNodeTypeEnum implements ArrayValuable<Integer> {

    // 0 ~ 1 start and end
    START_NODE(0, "Start.", "startEvent"),
    END_NODE(1, "End.", "endEvent"),

    // 10 ~ 49 各种节点
    START_USER_NODE(10, "Starter", "userTask"), // 发起人节点。前端的开始节点，Id 固定
    APPROVE_NODE(11, "Approver", "userTask"),
    COPY_NODE(12, "Cc", "serviceTask"),
    TRANSACTOR_NODE(13, "Handle person", "userTask"),

    DELAY_TIMER_NODE(14, "Delay", "receiveTask"),
    TRIGGER_NODE(15, "Trigger", "serviceTask"),

    CHILD_PROCESS(20, "Child workflow.", "callActivity"),

    // 50 ~ 条件分支
    CONDITION_NODE(50, "Condition", "sequenceFlow"), // 用于构建流转条件的表达式
    CONDITION_BRANCH_NODE(51, "Condition branch", "exclusiveGateway"),
    PARALLEL_BRANCH_NODE(52, "Parallel branch", "inclusiveGateway"), // 并行分支使用包容网关实现，条件表达式结果设置为 true
    INCLUSIVE_BRANCH_NODE(53, "Inclusive branch", "inclusiveGateway"),
    ROUTER_BRANCH_NODE(54, "Route branch", "exclusiveGateway")
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmSimpleModelNodeTypeEnum::getType).toArray(Integer[]::new);

    private final Integer type;
    private final String name;
    private final String bpmnType;

    /**
     * 判断是否为分支节点
     *
     * @param type 节点类型
     */
    public static boolean isBranchNode(Integer type) {
        return Objects.equals(CONDITION_BRANCH_NODE.getType(), type)
                || Objects.equals(PARALLEL_BRANCH_NODE.getType(), type)
                || Objects.equals(INCLUSIVE_BRANCH_NODE.getType(), type)
                || Objects.equals(ROUTER_BRANCH_NODE.getType(), type);
    }

    public static BpmSimpleModelNodeTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(nodeType -> nodeType.getType().equals(type), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
