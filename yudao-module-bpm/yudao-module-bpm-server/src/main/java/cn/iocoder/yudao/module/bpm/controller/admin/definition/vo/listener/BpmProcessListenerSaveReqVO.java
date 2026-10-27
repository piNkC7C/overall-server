package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.listener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - BPM workflow listener create / edit request.")
@Data
public class BpmProcessListenerSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13089")
    private Long id;

    @Schema(description = "Listener name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Listener name is required.")
    private String name;

    @Schema(description = "Listener type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "execution")
    @NotEmpty(message = "Listener type is required.")
    private String type;

    @Schema(description = "Listener status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Listener status is required.")
    private Integer status;

    @Schema(description = "Listen event.", requiredMode = Schema.RequiredMode.REQUIRED, example = "start")
    @NotEmpty(message = "Listen event cannot be empty.")
    private String event;

    @Schema(description = "Listener value type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "class")
    @NotEmpty(message = "Listener value type cannot be empty.")
    private String valueType;

    @Schema(description = "Listener value.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Listener value cannot be empty.")
    private String value;

}