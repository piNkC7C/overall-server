package cn.iocoder.yudao.module.iot.service.rule.scene.matcher.condition;

import cn.iocoder.yudao.module.iot.core.mq.message.IotDeviceMessage;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotSceneRuleDO;
import cn.iocoder.yudao.module.iot.enums.rule.IotSceneRuleConditionOperatorEnum;
import cn.iocoder.yudao.module.iot.enums.rule.IotSceneRuleConditionTypeEnum;
import cn.iocoder.yudao.module.iot.service.rule.scene.IotSceneRuleTimeHelper;
import cn.iocoder.yudao.module.iot.service.rule.scene.matcher.IotSceneRuleMatcherHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 当前时间条件匹配器：处理时间相关的子条件匹配逻辑
 *
 * @author HUIHUI
 */
@Component
@Slf4j
public class IotCurrentTimeConditionMatcher implements IotSceneRuleConditionMatcher {

    @Override
    public IotSceneRuleConditionTypeEnum getSupportedConditionType() {
        return IotSceneRuleConditionTypeEnum.CURRENT_TIME;
    }

    @Override
    public boolean matches(IotDeviceMessage message, IotSceneRuleDO.TriggerCondition condition) {
        // 1.1 基础参数校验
        if (!IotSceneRuleMatcherHelper.isBasicConditionValid(condition)) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Condition base parameters are invalid");
            return false;
        }

        // 1.2 修复条件匹配中忽略了产品和设备的一致性验证，2025.05.25 by panda
        if (IotSceneRuleMatcherHelper.productAndDeviceNotMatched(message, condition.getProductId(),condition.getDeviceId())){
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message,condition,"Product or device in the condition matcher does not match");
            return false;
        }

        // 1.3 检查操作符和参数是否有效
        if (!IotSceneRuleMatcherHelper.isConditionOperatorAndParamValid(condition)) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Operator or parameter is invalid");
            return false;
        }

        // 1.4 verify Operator is not is support timeOperator
        String operator = condition.getOperator();
        IotSceneRuleConditionOperatorEnum operatorEnum = IotSceneRuleConditionOperatorEnum.operatorOf(operator);
        if (operatorEnum == null) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Invalid operator: " + operator);
            return false;
        }

        // 1.5 验证操作符是否为时间相关的操作符
        if (IotSceneRuleTimeHelper.isTimeOperator(operatorEnum)) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Unsupported time operator: " + operator);
            return false;
        }

        // 2.1 execute time match
        boolean matched = IotSceneRuleTimeHelper.executeTimeMatching(operatorEnum, condition.getParam());

        // 2.2 record match result
        if (matched) {
            IotSceneRuleMatcherHelper.logConditionMatchSuccess(message, condition);
        } else {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Time condition does not match");
        }

        return matched;
    }

    @Override
    public int getPriority() {
        return 40; // 较低优先级
    }

}
