package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.cc;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Workflow CC page Item response VO.")
@Data
public class BpmProcessInstanceCopyRespVO {

    @Schema(description = "CC ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Start person.", requiredMode = Schema.RequiredMode.REQUIRED)
    private UserSimpleBaseVO startUser;

    @Schema(description = "Workflow instance code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A233")
    private String processInstanceId;
    @Schema(description = "Workflow instance name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test")
    private String processInstanceName;
    @Schema(description = "Workflow instance start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime processInstanceStartTime;

    @Schema(description = "Workflowcampaign code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String activityId;
    @Schema(description = "Workflowcampaign name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String activityName;

    @Schema(description = "Workflowcampaign code.")
    private String taskId;

    @Schema(description = "CC comment.")
    private String reason;

    @Schema(description = "Creator.", requiredMode = Schema.RequiredMode.REQUIRED)
    private UserSimpleBaseVO createUser;

    @Schema(description = "CC time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "WorkflowSummary.", example = "[]")
    private List<KeyValue<String, String>> summary;

}
