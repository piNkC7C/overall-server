package cn.iocoder.yudao.module.infra.controller.admin.codegen;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ZipUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.CodegenCreateListReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.CodegenDetailRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.CodegenPreviewRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.CodegenUpdateReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.CodegenTablePageReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.CodegenTableRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table.DatabaseTableRespVO;
import cn.iocoder.yudao.module.infra.convert.codegen.CodegenConvert;
import cn.iocoder.yudao.module.infra.dal.dataobject.codegen.CodegenColumnDO;
import cn.iocoder.yudao.module.infra.dal.dataobject.codegen.CodegenTableDO;
import cn.iocoder.yudao.module.infra.service.codegen.CodegenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserNickname;
import static cn.iocoder.yudao.module.infra.framework.file.core.utils.FileTypeUtils.writeAttachment;

@Tag(name = "Admin - codegen.")
@RestController
@RequestMapping("/infra/codegen")
@Validated
public class CodegenController {

    @Resource
    private CodegenService codegenService;

    @GetMapping("/db/table/list")
    @Operation(summary = "Get database built-in table definitions list.", description = "Filters out tables already imported into codegen.")
    @Parameters({
            @Parameter(name = "dataSourceConfigId", description = "Data sourcesetting code.", required = true, example = "1"),
            @Parameter(name = "name", description = "Table name. Fuzzy match.", example = "yudao"),
            @Parameter(name = "comment", description = "Description, fuzzy match.", example = "Overall.")
    })
    @PreAuthorize("@ss.hasPermission('infra:codegen:query')")
    public CommonResult<List<DatabaseTableRespVO>> getDatabaseTableList(
            @RequestParam(value = "dataSourceConfigId") Long dataSourceConfigId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "comment", required = false) String comment) {
        return success(codegenService.getDatabaseTableList(dataSourceConfigId, name, comment));
    }

    @GetMapping("/table/list")
    @Operation(summary = "GetTable definitionlist.")
    @Parameter(name = "dataSourceConfigId", description = "Data sourcesetting code.", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('infra:codegen:query')")
    public CommonResult<List<CodegenTableRespVO>> getCodegenTableList(@RequestParam(value = "dataSourceConfigId") Long dataSourceConfigId) {
        List<CodegenTableDO> list = codegenService.getCodegenTableList(dataSourceConfigId);
        return success(BeanUtils.toBean(list, CodegenTableRespVO.class));
    }

    @GetMapping("/table/page")
    @Operation(summary = "GetTable definitionpage.")
    @PreAuthorize("@ss.hasPermission('infra:codegen:query')")
    public CommonResult<PageResult<CodegenTableRespVO>> getCodegenTablePage(@Valid CodegenTablePageReqVO pageReqVO) {
        PageResult<CodegenTableDO> pageResult = codegenService.getCodegenTablePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CodegenTableRespVO.class));
    }

    @GetMapping("/detail")
    @Operation(summary = "Get table and column detail.")
    @Parameter(name = "tableId", description = "Table ID", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:codegen:query')")
    public CommonResult<CodegenDetailRespVO> getCodegenDetail(@RequestParam("tableId") Long tableId) {
        CodegenTableDO table = codegenService.getCodegenTable(tableId);
        List<CodegenColumnDO> columns = codegenService.getCodegenColumnListByTableId(tableId);
        // 拼装返回
        return success(CodegenConvert.INSTANCE.convert(table, columns));
    }

    @Operation(summary = "From the database schema, create codegen table and column definitions.")
    @PostMapping("/create-list")
    @PreAuthorize("@ss.hasPermission('infra:codegen:create')")
    public CommonResult<List<Long>> createCodegenList(@Valid @RequestBody CodegenCreateListReqVO reqVO) {
        return success(codegenService.createCodegenList(getLoginUserNickname(), reqVO));
    }

    @Operation(summary = "Update database table and column definitions.")
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:codegen:update')")
    public CommonResult<Boolean> updateCodegen(@Valid @RequestBody CodegenUpdateReqVO updateReqVO) {
        codegenService.updateCodegen(updateReqVO);
        return success(true);
    }

    @Operation(summary = "From the database schema, sync database table and column definitions.")
    @PutMapping("/sync-from-db")
    @Parameter(name = "tableId", description = "Table ID", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:codegen:update')")
    public CommonResult<Boolean> syncCodegenFromDB(@RequestParam("tableId") Long tableId) {
        codegenService.syncCodegenFromDB(tableId);
        return success(true);
    }

    @Operation(summary = "Delete database table and column definitions.")
    @DeleteMapping("/delete")
    @Parameter(name = "tableId", description = "Table ID", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:codegen:delete')")
    public CommonResult<Boolean> deleteCodegen(@RequestParam("tableId") Long tableId) {
        codegenService.deleteCodegen(tableId);
        return success(true);
    }

    @Operation(summary = "Batch delete database table and column definitions.")
    @DeleteMapping("/delete-list")
    @Parameter(name = "tableIds", description = "Table ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('infra:codegen:delete')")
    public CommonResult<Boolean> deleteCodegenList(@RequestParam("tableIds") List<Long> tableIds) {
        codegenService.deleteCodegenList(tableIds);
        return success(true);
    }

    @Operation(summary = "Preview generated code.")
    @GetMapping("/preview")
    @Parameter(name = "tableId", description = "Table ID", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:codegen:preview')")
    public CommonResult<List<CodegenPreviewRespVO>> previewCodegen(@RequestParam("tableId") Long tableId) {
        Map<String, String> codes = codegenService.generationCodes(tableId);
        return success(CodegenConvert.INSTANCE.convert(codes));
    }

    @Operation(summary = "Download generated code.")
    @GetMapping("/download")
    @Parameter(name = "tableId", description = "Table ID", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:codegen:download')")
    public void downloadCodegen(@RequestParam("tableId") Long tableId,
                                HttpServletResponse response) throws IOException {
        // 生成代码
        Map<String, String> codes = codegenService.generationCodes(tableId);
        // 构建 zip 包
        String[] paths = codes.keySet().toArray(new String[0]);
        ByteArrayInputStream[] ins = codes.values().stream().map(IoUtil::toUtf8Stream).toArray(ByteArrayInputStream[]::new);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipUtil.zip(outputStream, paths, ins);
        // 输出
        writeAttachment(response, "codegen.zip", outputStream.toByteArray());
    }

}
