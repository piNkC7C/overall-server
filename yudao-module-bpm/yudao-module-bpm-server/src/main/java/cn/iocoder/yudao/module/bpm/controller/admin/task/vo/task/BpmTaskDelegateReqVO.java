package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - delegateworkflow task request.")
@Data
public class BpmTaskDelegateReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Delegatee ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Delegatee ID is required.")
    private Long delegateUserId;

    @Schema(description = "Delegatereason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I cannot decide. Please take a look first.")
    @NotEmpty(message = "Delegatereason is required.")
    private String reason;

}
