package cn.iocoder.yudao.module.bpm.framework.flowable.core.candidate.strategy.form;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.candidate.strategy.dept.AbstractBpmTaskCandidateDeptLeaderStrategy;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * 表单内部门负责人 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author jason
 */
@Component
public class BpmTaskCandidateFormDeptLeaderStrategy extends AbstractBpmTaskCandidateDeptLeaderStrategy {

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.FORM_DEPT_LEADER;
    }

    @Override
    public void validateParam(String param) {
        // 参数格式: | 分隔：1）左边为表单内部门字段。2）右边为部门层级
        String[] params = param.split("\\|");
        Assert.isTrue(params.length == 2, "Parameter format does not match");
        Assert.notEmpty(param, "Department field in the form cannot be empty");
        int level = Integer.parseInt(params[1]);
        Assert.isTrue(level > 0, "Department level must be greater than 0");
    }

    @Override
    public Set<Long> calculateUsersByTask(DelegateExecution execution, String param) {
        String[] params = param.split("\\|");
        Object result = execution.getVariable(params[0]);
        int level = Integer.parseInt(params[1]);
        return super.getMultiLevelDeptLeaderIds(Convert.toList(Long.class, result), level);
    }

    @Override
    public Set<Long> calculateUsersByActivity(BpmnModel bpmnModel, String activityId,
                                              String param, Long startUserId, String processDefinitionId,
                                              Map<String, Object> processVariables) {
        String[] params = param.split("\\|");
        Object result = processVariables == null ? null : processVariables.get(params[0]);
        int level = Integer.parseInt(params[1]);
        return super.getMultiLevelDeptLeaderIds(Convert.toList(Long.class, result), level);
    }

}
