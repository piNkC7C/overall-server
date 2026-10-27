package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - workflow model update BPMN XML request.")
@Data
public class BpmModeUpdateBpmnReqVO {

    @Schema(description = "Workflow code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Workflow code is required.")
    private String id;

    @Schema(description = "BPMN XML", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "BPMN XML is required.")
    private String bpmnXml;

}
