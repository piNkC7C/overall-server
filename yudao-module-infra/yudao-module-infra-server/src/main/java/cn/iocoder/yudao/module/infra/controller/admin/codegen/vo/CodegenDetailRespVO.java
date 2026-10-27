package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo;

import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.column.CodegenColumnRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.CodegenTableRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Codegen table and column detail response VO.")
@Data
public class CodegenDetailRespVO {

    @Schema(description = "Table definition.")
    private CodegenTableRespVO table;

    @Schema(description = "Field definition.")
    private List<CodegenColumnRespVO> columns;

}
