package cn.iocoder.yudao.module.bpm.enums.definition;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * BPM 流程监听器的值类型
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmProcessListenerValueTypeEnum {

    CLASS("class", "Java class"),
    DELEGATE_EXPRESSION("delegateExpression", "Delegate Expression"),
    EXPRESSION("expression", "Expression");

    private final String type;
    private final String name;

}
