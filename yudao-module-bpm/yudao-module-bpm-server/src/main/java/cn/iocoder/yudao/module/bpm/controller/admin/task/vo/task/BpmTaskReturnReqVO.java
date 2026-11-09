package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "管理后台 - 退回流程任务的 Request VO")
@Data
public class BpmTaskReturnReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "退回到的任务 Key", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Return to task Key is required.")
    private String targetTaskDefinitionKey;

    @Schema(description = "退回意见", requiredMode = Schema.RequiredMode.REQUIRED, example = "I just want to reject this")
    @NotEmpty(message = "Return comment cannot be empty.")
    private String reason;

}
