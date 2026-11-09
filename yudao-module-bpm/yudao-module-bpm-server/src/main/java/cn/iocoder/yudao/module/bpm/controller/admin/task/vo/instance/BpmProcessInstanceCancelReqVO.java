package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 流程实例的取消 Request VO")
@Data
public class BpmProcessInstanceCancelReqVO {

    @Schema(description = "流程实例的编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Workflow instance code is required.")
    private String id;

    @Schema(description = "取消原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Canceling the leave request!")
    @NotEmpty(message = "Cancelreason is required.")
    private String reason;

}
