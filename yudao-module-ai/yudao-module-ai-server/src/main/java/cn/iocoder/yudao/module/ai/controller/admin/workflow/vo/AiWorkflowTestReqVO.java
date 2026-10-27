package cn.iocoder.yudao.module.ai.controller.admin.workflow.vo;

import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

import java.util.Map;

@Schema(description = "AI workflow test request VO.")
@Data
public class AiWorkflowTestReqVO {

    @Schema(description = "Workflow ID.", example = "1024")
    private Long id;

    @Schema(description = "Workflow model.", example = "{}")
    private String graph;

    @Schema(description = "Parameter.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    private Map<String, Object> params;

    @AssertTrue(message = "Provide either a workflow or a model.")
    public boolean isGraphValid() {
        return id != null || StrUtil.isNotEmpty(graph);
    }

}
