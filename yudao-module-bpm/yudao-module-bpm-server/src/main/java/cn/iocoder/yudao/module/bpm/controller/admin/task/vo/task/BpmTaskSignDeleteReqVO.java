package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - countersign task delete (remove countersign) request.")
@Data
public class BpmTaskSignDeleteReqVO {

    @Schema(description = "By remove countersign task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Countersignreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Need to need remove countersign.")
    @NotEmpty(message = "Countersignreason is required.")
    private String reason;

}
