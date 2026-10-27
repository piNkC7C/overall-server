package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Collection;

@Schema(description = "CC workflow task request VO.")
@Data
public class BpmTaskCopyReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "CC user IDs.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotEmpty(message = "Cc users cannot be empty.")
    private Collection<Long> copyUserIds;

    @Schema(description = "CC comment.", example = "Please take a look!")
    private String reason;
}
