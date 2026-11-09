package cn.iocoder.yudao.module.ai.controller.admin.workflow.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - AI 工作流新增/修改 Request VO")
@Data
public class AiWorkflowSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "工作流标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "FLOW")
    @NotEmpty(message = "Workflow key cannot be empty.")
    private String code;

    @Schema(description = "工作流名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workflow")
    @NotEmpty(message = "Workflow name cannot be empty.")
    private String name;

    @Schema(description = "备注", example = "FLOW")
    private String remark;

    @Schema(description = "工作流模型", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @NotEmpty(message = "Workflow model cannot be empty.")
    private String graph;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "FLOW")
    @NotNull(message = "Status is required.")
    private Integer status;

}
