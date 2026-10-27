package cn.iocoder.yudao.module.ai.controller.admin.workflow.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - AI workflow response.")
@Data
public class AiWorkflowRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Workflow key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FLOW")
    private String code;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workflow")
    private String name;

    @Schema(description = "Notes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workflow")
    private String remark;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Workflow model JSON.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    private String graph;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
