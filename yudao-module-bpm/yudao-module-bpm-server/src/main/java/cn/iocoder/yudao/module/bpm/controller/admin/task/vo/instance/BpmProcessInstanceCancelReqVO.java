package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Admin - workflow instance cancel request.")
@Data
public class BpmProcessInstanceCancelReqVO {

    @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Workflow instance code is required.")
    private String id;

    @Schema(description = "Cancelreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Canceling the leave request!")
    @NotEmpty(message = "Cancelreason is required.")
    private String reason;

}
