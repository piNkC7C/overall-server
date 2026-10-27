package cn.iocoder.yudao.module.iot.service.rule.scene.matcher.condition;


import cn.iocoder.yudao.module.iot.core.mq.message.IotDeviceMessage;
import cn.iocoder.yudao.module.iot.core.util.IotDeviceMessageUtils;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotSceneRuleDO;
import cn.iocoder.yudao.module.iot.enums.rule.IotSceneRuleConditionTypeEnum;
import cn.iocoder.yudao.module.iot.service.rule.scene.matcher.IotSceneRuleMatcherHelper;
import org.springframework.stereotype.Component;


/**
 * 设备属性条件匹配器：处理设备属性相关的子条件匹配逻辑
 *
 * @author HUIHUI
 */
@Component
public class IotDevicePropertyConditionMatcher implements IotSceneRuleConditionMatcher {

    @Override
    public IotSceneRuleConditionTypeEnum getSupportedConditionType() {
        return IotSceneRuleConditionTypeEnum.DEVICE_PROPERTY;
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

        // 1.3 check message is not include condition specified attribute identifier
        // 注意：属性上报可能同时上报多个属性，所以需要判断 condition.getIdentifier() 是否在 message 的 params 中
        if (IotDeviceMessageUtils.notContainsIdentifier(message, condition.getIdentifier())) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Message does not contain property: " + condition.getIdentifier());
            return false;
        }

        // 1.4 检查操作符和参数是否有效
        if (!IotSceneRuleMatcherHelper.isConditionOperatorAndParamValid(condition)) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Operator or parameter is invalid");
            return false;
        }

        // 2.1. 获取属性值 - 使用工具类方法正确提取属性值
        Object propertyValue = IotDeviceMessageUtils.extractPropertyValue(message, condition.getIdentifier());
        if (propertyValue == null) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Property value is empty or the specified property was not found");
            return false;
        }

        // 2.2 使用条件评估器进行匹配
        boolean matched = IotSceneRuleMatcherHelper.evaluateCondition(propertyValue, condition.getOperator(), condition.getParam());
        if (matched) {
            IotSceneRuleMatcherHelper.logConditionMatchSuccess(message, condition);
        } else {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Device property condition does not match");
        }
        return matched;
    }

    @Override
    public int getPriority() {
        return 25; // 中等优先级
    }

}
