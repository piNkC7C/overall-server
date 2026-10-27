package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.listener;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - BPM workflow listener response.")
@Data
public class BpmProcessListenerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13089")
    private Long id;

    @Schema(description = "Listener name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String name;

    @Schema(description = "Listener type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "execution")
    private String type;

    @Schema(description = "Listener status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Listen event.", requiredMode = Schema.RequiredMode.REQUIRED, example = "start")
    private String event;

    @Schema(description = "Listener value type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "class")
    private String valueType;

    @Schema(description = "Listener value.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String value;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}