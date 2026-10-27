package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Database table definition response VO.")
@Data
public class DatabaseTableRespVO {

    @Schema(description = "Table name", requiredMode = Schema.RequiredMode.REQUIRED, example = "yuanma")
    private String name;

    @Schema(description = "Table comment", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String comment;

}
