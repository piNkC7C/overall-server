package cn.iocoder.yudao.module.bpm.api.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Map;

@Schema(description = "RPC service - workflow instance create Request DTO.")
@Data
public class BpmProcessInstanceCreateReqDTO {

    @Schema(description = "Workflow definition key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "leave")
    @NotEmpty(message = "Workflow definition key is required.")
    private String processDefinitionKey;

    @Schema(description = "Variable instance.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> variables;

    @Schema(description = "Business unique key.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Business unique key is required.")
    private String businessKey; // 例如说，请假申请的编号。通过它，可以查询到对应的实例

    /**
     * 发起人自选审批人 Map
     *
     * key：taskKey 任务编码
     * value：审批人的数组
     * 例如：{ taskKey1 :[1, 2] }，则表示 taskKey1 这个任务，提前设定了，由 userId 为 1,2 的用户进行审批
     */
    @Schema(description = "Approvers selected by the starter Map.")
    private Map<String, List<Long>> startUserSelectAssignees;

}
