package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 委派流程任务的 Request VO")
@Data
public class BpmTaskDelegateReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "被委派人 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Delegatee ID is required.")
    private Long delegateUserId;

    @Schema(description = "委派原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "I cannot decide. Please take a look first.")
    @NotEmpty(message = "Delegatereason is required.")
    private String reason;

}
