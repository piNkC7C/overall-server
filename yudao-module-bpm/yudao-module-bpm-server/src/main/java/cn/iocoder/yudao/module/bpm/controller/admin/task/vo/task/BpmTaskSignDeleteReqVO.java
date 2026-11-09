package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "管理后台 - 加签任务的删除（减签） Request VO")
@Data
public class BpmTaskSignDeleteReqVO {

    @Schema(description = "被减签的任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "加签原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Need to need remove countersign.")
    @NotEmpty(message = "Countersignreason is required.")
    private String reason;

}
