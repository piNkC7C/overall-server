package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - workflowcampaign response.")
@Data
public class BpmActivityRespVO {

    @Schema(description = "Workflowcampaign key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String key;
    @Schema(description = "Workflowcampaign type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "StartEvent")
    private String type;

    @Schema(description = "Workflowcampaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;
    @Schema(description = "Workflowcampaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Relation workflow task code.", example = "2048")
    private String taskId; // 关联的流程任务，只有 UserTask 等类型才有

}
