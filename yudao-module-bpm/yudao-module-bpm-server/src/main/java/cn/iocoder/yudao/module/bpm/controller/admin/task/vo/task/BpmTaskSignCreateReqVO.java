package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Schema(description = "Admin - countersign task create (countersign) request.")
@Data
public class BpmTaskSignCreateReqVO {

    @Schema(description = "Need to need countersign task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Countersign user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @NotEmpty(message = "Countersignuser is required.")
    private Set<Long> userIds;

    @Schema(description = "Countersign type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "before")
    @NotEmpty(message = "Countersign type is required.")
    private String type; // See BpmTaskSignTypeEnum enum

    @Schema(description = "Countersignreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Need to need countersign.")
    @NotEmpty(message = "Countersignreason is required.")
    private String reason;

}
