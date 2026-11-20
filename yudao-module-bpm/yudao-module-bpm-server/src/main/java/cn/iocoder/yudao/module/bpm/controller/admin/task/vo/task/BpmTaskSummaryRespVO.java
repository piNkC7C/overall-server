package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 流程任务汇总 Response VO")
@Data
public class BpmTaskSummaryRespVO {

    @Schema(description = "待办任务数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long todoCount;

    @Schema(description = "已办任务数", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long doneCount;

    @Schema(description = "抄送我的数", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long copyCount;

}
