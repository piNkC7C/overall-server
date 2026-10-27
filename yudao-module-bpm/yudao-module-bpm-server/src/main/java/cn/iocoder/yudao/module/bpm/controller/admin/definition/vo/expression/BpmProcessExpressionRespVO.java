package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - BPM workflow expression response.")
@Data
public class BpmProcessExpressionRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3870")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Expression name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Expression Name")
    private String name;

    @Schema(description = "Expression status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Expression.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String expression;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}