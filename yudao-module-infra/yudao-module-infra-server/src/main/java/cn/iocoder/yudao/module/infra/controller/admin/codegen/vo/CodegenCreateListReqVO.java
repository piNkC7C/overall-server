package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "From the database schema, create codegen table and column definitions request VO.")
@Data
public class CodegenCreateListReqVO {

    @Schema(description = "Data sourcesetting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data sourcesetting code is required.")
    private Long dataSourceConfigId;

    @Schema(description = "Table names.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2, 3]")
    @NotNull(message = "Table names cannot be empty.")
    private List<String> tableNames;

}
