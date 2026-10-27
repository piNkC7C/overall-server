package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo;

import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.column.CodegenColumnSaveReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.CodegenTableSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "Codegen table and column update request VO.")
@Data
public class CodegenUpdateReqVO {

    @Valid // 校验内嵌的字段
    @NotNull(message = "Table definition cannot be empty.")
    private CodegenTableSaveReqVO table;

    @Valid // 校验内嵌的字段
    @NotNull(message = "Field definition cannot be empty.")
    private List<CodegenColumnSaveReqVO> columns;

}
