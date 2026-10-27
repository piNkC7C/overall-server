package cn.iocoder.yudao.module.iot.service.rule.scene.matcher.condition;

import cn.iocoder.yudao.module.iot.core.mq.message.IotDeviceMessage;
import cn.iocoder.yudao.module.iot.core.util.IotDeviceMessageUtils;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotSceneRuleDO;
import cn.iocoder.yudao.module.iot.enums.rule.IotSceneRuleConditionTypeEnum;
import cn.iocoder.yudao.module.iot.service.rule.scene.matcher.IotSceneRuleMatcherHelper;
import org.springframework.stereotype.Component;

/**
 * 设备状态条件匹配器：处理设备状态相关的子条件匹配逻辑
 *
 * @author HUIHUI
 */
@Component
public class IotDeviceStateConditionMatcher implements IotSceneRuleConditionMatcher {

    @Override
    public IotSceneRuleConditionTypeEnum getSupportedConditionType() {
        return IotSceneRuleConditionTypeEnum.DEVICE_STATE;
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

        // 2.1 获取设备状态值 - 使用工具类方法正确提取状态值
        // 对于设备状态条件，状态值通过 getIdentifier 获取（实际是从 params.state 字段）
        String stateValue = IotDeviceMessageUtils.getIdentifier(message);
        if (stateValue == null) {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Device state value in the message is empty");
            return false;
        }

        // 2.2 使用条件评估器进行匹配
        boolean matched = IotSceneRuleMatcherHelper.evaluateCondition(stateValue, condition.getOperator(), condition.getParam());
        if (matched) {
            IotSceneRuleMatcherHelper.logConditionMatchSuccess(message, condition);
        } else {
            IotSceneRuleMatcherHelper.logConditionMatchFailure(message, condition, "Device state condition does not match");
        }
        return matched;
    }

    @Override
    public int getPriority() {
        return 30; // 中等优先级
    }

}
