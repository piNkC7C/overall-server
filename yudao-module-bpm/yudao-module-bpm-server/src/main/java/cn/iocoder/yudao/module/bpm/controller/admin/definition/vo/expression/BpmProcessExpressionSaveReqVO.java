package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - BPM workflow expression create / edit request.")
@Data
public class BpmProcessExpressionSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3870")
    private Long id;

    @Schema(description = "Expression name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Expression name is required.")
    private String name;

    @Schema(description = "Expression status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Expression status is required.")
    private Integer status;

    @Schema(description = "Expression.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Expression is required.")
    private String expression;

}