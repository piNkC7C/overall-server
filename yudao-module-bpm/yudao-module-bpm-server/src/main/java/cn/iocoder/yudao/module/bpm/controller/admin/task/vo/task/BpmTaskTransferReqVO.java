package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - workflow task transfer request.")
@Data
public class BpmTaskTransferReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "New approver user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "New approver user ID cannot be empty.")
    private Long assigneeUserId;

    @Schema(description = "Transferreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I cannot decide. Please take a look first.")
    @NotEmpty(message = "Transferreason is required.")
    private String reason;

}
