package cn.iocoder.yudao.module.bpm.service.message.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * BPM 发送流程实例被不通过 Request DTO
 */
@Data
public class BpmMessageSendWhenProcessInstanceRejectReqDTO {

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
    @NotNull(message = "Start person user ID.")
    private Long startUserId;

    /**
     * 不通过理由
     */
    @NotEmpty(message = "Not via reason is required.")
    private String reason;

}
