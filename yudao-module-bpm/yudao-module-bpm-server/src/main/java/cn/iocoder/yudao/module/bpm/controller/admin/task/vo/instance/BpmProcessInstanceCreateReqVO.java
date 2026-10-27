package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - workflow instance create request.")
@Data
public class BpmProcessInstanceCreateReqVO {

    @Schema(description = "Workflow definition code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Workflow definition code is required.")
    private String processDefinitionId;

    @Schema(description = "Variable instance (dynamic form).")
    private Map<String, Object> variables;

    @Schema(description = "Approvers selected by the starter Map.", example = "{taskKey1: [1, 2]}")
    private Map<String, List<Long>> startUserSelectAssignees;

}
