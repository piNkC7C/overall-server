package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple.BpmSimpleModelNodeVO;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task.BpmTaskRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Schema(description = "Workflow instance BPMN view response VO.")
@Data
public class BpmProcessInstanceBpmnModelViewRespVO {

    // ========== Basic Info ==========

    @Schema(description = "Workflow instance info.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BpmProcessInstanceRespVO processInstance;

    @Schema(description = "Task list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BpmTaskRespVO> tasks;

    @Schema(description = "BPMN XML", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bpmnXml;

    @Schema(description = "SIMPLE model.")
    private BpmSimpleModelNodeVO simpleModel;

    // ========== progress info ==========

    @Schema(description = "In-progress activity node IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> unfinishedTaskActivityIds; // 只包括 UserTask

    @Schema(description = "Completed activity node IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> finishedTaskActivityIds; // 包括 UserTask、Gateway 等，不包括 SequenceFlow

    @Schema(description = "Completed sequence-flow node IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> finishedSequenceFlowActivityIds; // 只包括 SequenceFlow

    @Schema(description = "Rejected activity node IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> rejectedTaskActivityIds; // 只包括 UserTask

}
