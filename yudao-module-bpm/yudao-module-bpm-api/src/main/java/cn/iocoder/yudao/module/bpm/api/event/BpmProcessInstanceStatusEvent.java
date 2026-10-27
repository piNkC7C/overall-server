package cn.iocoder.yudao.module.bpm.api.event;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 流程实例的状态（结果）发生变化的 Event
 *
 * @author 芋道源码
 */
@SuppressWarnings("ALL")
@Data
public class BpmProcessInstanceStatusEvent extends ApplicationEvent {

    /**
     * 流程实例的编号
     */
    @NotNull(message = "Workflow instance code is required.")
    private String id;
    /**
     * 流程实例的 key
     */
    @NotNull(message = "Workflow instance key is required.")
    private String processDefinitionKey;
    /**
     * 流程实例的结果
     */
    @NotNull(message = "Workflow instance status is required.")
    private Integer status;
    /**
     * 流程实例结束的原因
     */
    private String reason;

    /**
     * 流程实例对应的业务标识
     * 例如说，请假
     */
    private String businessKey;

    public BpmProcessInstanceStatusEvent() {
        // new Object() 保证非空
        super(new Object());
    }

    public BpmProcessInstanceStatusEvent(Object source) {
        super(source);
    }

}
