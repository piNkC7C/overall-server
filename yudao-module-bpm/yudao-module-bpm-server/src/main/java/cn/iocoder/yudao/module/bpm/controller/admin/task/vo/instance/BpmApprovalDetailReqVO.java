package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

import java.util.Map;

@Schema(description = "Admin - approval details request.")
@Data
public class BpmApprovalDetailReqVO {

    @Schema(description = "Workflow definition code.", example = "1024")
    private String processDefinitionId; // 使用场景：发起流程时，传流程定义 ID

    @Schema(description = "Workflow variables.")
    private Map<String, Object> processVariables; // 使用场景：同 processDefinitionId，用于流程预测

    @Schema(description = "Workflow variables.")
    private String processVariablesStr; // 解决 GET 无法传递对象的问题，最终转换成 processVariables 变量

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;  // 使用场景：流程已发起时候传流程实例 ID

    // TODO @芋艿：如果未来 BPMN 增加流程图，它没有发起人节点，会有问题。
    @Schema(description = "Workflowcampaign code.", example = "StartUserNode")
    private String activityId; // 用于获取表单权限。1）发起流程时，传“发起人节点” activityId 可获取发起人的表单权限；2）从抄送列表界面进来时，传抄送的 activityId 可获取抄送人的表单权限；

    @Schema(description = "Workflow task code.", example = "95f2f08b-621b-11ef-bf39-00ff4722db8b")
    private String taskId; // 用于获取表单权限。1）从待审批/已审批界面进来时，传递 taskId 任务编号，可获取任务节点的变得权限

    @AssertTrue(message = "Workflow definition ID and instance ID cannot both be empty.")
    @JsonIgnore
    public boolean isValidProcessParam() {
        return StrUtil.isNotEmpty(processDefinitionId) || StrUtil.isNotEmpty(processInstanceId);
    }

}
