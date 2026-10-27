package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - returnworkflow task request.")
@Data
public class BpmTaskReturnReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Return to task Key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Return to task Key is required.")
    private String targetTaskDefinitionKey;

    @Schema(description = "Return comment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I just want to reject this")
    @NotEmpty(message = "Return comment cannot be empty.")
    private String reason;

}
