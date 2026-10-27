package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model;

import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple.BpmSimpleModelNodeVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - workflow model save request.")
@Data
public class BpmModelSaveReqVO extends BpmModelMetaInfoVO {

    @Schema(description = "Code.", example = "1024")
    private String id;

    @Schema(description = "Workflow key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "process_yudao")
    @NotEmpty(message = "Workflow key is required.")
    private String key;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Workflow name is required.")
    private String name;

    @Schema(description = "Workflowcategory.", example = "1")
    private String category;

    @Schema(description = "BPMN XML")
    private String bpmnXml;

    @Schema(description = "Simple workflow model.")
    @Valid
    private BpmSimpleModelNodeVO simpleModel;

}
