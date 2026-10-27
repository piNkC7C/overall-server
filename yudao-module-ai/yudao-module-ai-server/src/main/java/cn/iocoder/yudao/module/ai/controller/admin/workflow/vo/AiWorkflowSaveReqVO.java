package cn.iocoder.yudao.module.ai.controller.admin.workflow.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - AI workflowcreate/update request.")
@Data
public class AiWorkflowSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Workflow key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FLOW")
    @NotEmpty(message = "Workflow key cannot be empty.")
    private String code;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workflow")
    @NotEmpty(message = "Workflow name cannot be empty.")
    private String name;

    @Schema(description = "Notes.", example = "FLOW")
    private String remark;

    @Schema(description = "Workflow model.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @NotEmpty(message = "Workflow model cannot be empty.")
    private String graph;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FLOW")
    @NotNull(message = "Status is required.")
    private Integer status;

}
