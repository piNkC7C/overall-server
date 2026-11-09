package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Schema(description = "管理后台 - 加签任务的创建（加签） Request VO")
@Data
public class BpmTaskSignCreateReqVO {

    @Schema(description = "需要加签的任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "加签的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @NotEmpty(message = "Countersignuser is required.")
    private Set<Long> userIds;

    @Schema(description = "加签类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "before")
    @NotEmpty(message = "Countersign type is required.")
    private String type; // See BpmTaskSignTypeEnum enum

    @Schema(description = "加签原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Need to need countersign.")
    @NotEmpty(message = "Countersignreason is required.")
    private String reason;

}
