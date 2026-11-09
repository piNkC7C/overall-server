package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 流程任务的转办 Request VO")
@Data
public class BpmTaskTransferReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "新审批人的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "New approver user ID cannot be empty.")
    private Long assigneeUserId;

    @Schema(description = "转办原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "I cannot decide. Please take a look first.")
    @NotEmpty(message = "Transferreason is required.")
    private String reason;

}
