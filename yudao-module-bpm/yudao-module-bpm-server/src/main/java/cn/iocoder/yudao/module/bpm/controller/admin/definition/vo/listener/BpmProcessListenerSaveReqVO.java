package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.listener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - BPM 流程监听器新增/修改 Request VO")
@Data
public class BpmProcessListenerSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13089")
    private Long id;

    @Schema(description = "监听器名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Listener name is required.")
    private String name;

    @Schema(description = "监听器类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "execution")
    @NotEmpty(message = "Listener type is required.")
    private String type;

    @Schema(description = "监听器状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Listener status is required.")
    private Integer status;

    @Schema(description = "监听事件", requiredMode = Schema.RequiredMode.REQUIRED, example = "start")
    @NotEmpty(message = "Listen event cannot be empty.")
    private String event;

    @Schema(description = "监听器值类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "class")
    @NotEmpty(message = "Listener value type cannot be empty.")
    private String valueType;

    @Schema(description = "监听器值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Listener value cannot be empty.")
    private String value;

}