package cn.iocoder.yudao.module.bpm.framework.flowable.core.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 任务的候选人策略枚举
 *
 * 例如说：分配给指定人审批
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmTaskCandidateStrategyEnum implements ArrayValuable<Integer> {

    ROLE(10, "Role"),
    DEPT_MEMBER(20, "Department members"),
    DEPT_LEADER(21, "Department lead"),
    MULTI_DEPT_LEADER_MULTI(23, "Multi-level department leads"),
    POST(22, "Post"),
    USER(30, "User"),
    APPROVE_USER_SELECT(34, "Selected by current approver"),
    START_USER_SELECT(35, "Selected by starter"),
    START_USER(36, "Starter"),
    START_USER_DEPT_LEADER(37, "Starter's department lead"),
    START_USER_DEPT_LEADER_MULTI(38, "Starter's multi-level department leads"),
    USER_GROUP(40, "User group"),
    FORM_USER(50, "Form user field"),
    FORM_DEPT_LEADER(51, "Department lead from the form"),
    EXPRESSION(60, "Process expression"),
    ASSIGN_EMPTY(1, "Approver is empty"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmTaskCandidateStrategyEnum::getStrategy).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer strategy;
    /**
     * 描述
     */
    private final String description;

    public static BpmTaskCandidateStrategyEnum valueOf(Integer strategy) {
        return ArrayUtil.firstMatch(o -> o.getStrategy().equals(strategy), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
