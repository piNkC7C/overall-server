package cn.iocoder.yudao.module.bpm.service.message.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * BPM 发送任务审批超时 Request DTO
 */
@Data
public class BpmMessageSendWhenTaskTimeoutReqDTO {

    /**
     * 流程实例的编号
     */
    @NotEmpty(message = "Workflow instance code is required.")
    private String processInstanceId;
    /**
     * 流程实例的名字
     */
    @NotEmpty(message = "Workflow instance name is required.")
    private String processInstanceName;

    /**
     * 流程任务的编号
     */
    @NotEmpty(message = "Workflow task code is required.")
    private String taskId;
    /**
     * 流程任务的名字
     */
    @NotEmpty(message = "Workflow task name is required.")
    private String taskName;

    /**
     * 审批人的用户编号
     */
    @NotNull(message = "Approver user ID is required.")
    private Long assigneeUserId;

}
