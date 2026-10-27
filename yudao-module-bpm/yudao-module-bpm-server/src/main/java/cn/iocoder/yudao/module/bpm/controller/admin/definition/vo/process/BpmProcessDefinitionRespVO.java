package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.process;

import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelMetaInfoVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - workflow definition response.")
@Data
public class BpmProcessDefinitionRespVO extends BpmModelMetaInfoVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Version.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer version;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Workflow key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "youdao")
    private String key;

    @Schema(description = "Workflowcategory.", example = "1")
    private String category;
    @Schema(description = "Workflowcategory name.", example = "Leave")
    private String categoryName;

    @Schema(description = "Workflow model type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer modelType; // See BpmModelTypeEnum enum class

    @Schema(description = "Workflow model code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ABC")
    private String modelId;

    @Schema(description = "Form setting-JSON String. in form type is {@link BpmModelFormTypeEnum#CUSTOM} time, must not Empty.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String formConf;
    @Schema(description = "Form item Array-JSON String Array. in form type is {@link BpmModelFormTypeEnum#CUSTOM} time, must not Empty.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> formFields;
    @Schema(description = "Form name.", example = "Leave form")
    private String formName;

    @Schema(description = "Suspension status. See the SuspensionState enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer suspensionState; // See SuspensionState enum

    @Schema(description = "Deploy time.")
    private LocalDateTime deploymentTime; // 需要从对应的 Deployment 读取，非必须返回

    @Schema(description = "BPMN XML")
    private String bpmnXml; // 需要从对应的 BpmnModel 读取，非必须返回

    @Schema(description = "Simple designer model JSON.")
    private String simpleModel; // 非必须返回

    @Schema(description = "Workflow definition sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long sort;

    @Schema(description = "BPMN UserTask user task.")
    @Data
    public static class UserTask {

        @Schema(description = "Task key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sudo")
        private String id;

        @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
        private String name;

    }

}
