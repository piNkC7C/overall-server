package cn.iocoder.yudao.module.bpm.enums.definition;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * BPM 流程监听器的类型
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmProcessListenerTypeEnum {

    EXECUTION("execution", "Execution listener"),
    TASK("task", "Task executor");

    private final String type;
    private final String name;

}
