package cn.iocoder.yudao.module.mes.controller.admin.qc.defect;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo.MesQcDefectPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo.MesQcDefectRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo.MesQcDefectSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.defect.MesQcDefectDO;
import cn.iocoder.yudao.module.mes.service.qc.defect.MesQcDefectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES defect type.")
@RestController
@RequestMapping("/mes/qc/defect")
@Validated
public class MesQcDefectController {

    @Resource
    private MesQcDefectService defectService;

    @PostMapping("/create")
    @Operation(summary = "Create defect type.")
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:create')")
    public CommonResult<Long> createDefect(@Valid @RequestBody MesQcDefectSaveReqVO createReqVO) {
        return success(defectService.createDefect(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update defect type.")
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:update')")
    public CommonResult<Boolean> updateDefect(@Valid @RequestBody MesQcDefectSaveReqVO updateReqVO) {
        defectService.updateDefect(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete defect type.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:delete')")
    public CommonResult<Boolean> deleteDefect(@RequestParam("id") Long id) {
        defectService.deleteDefect(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get defect type.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:query')")
    public CommonResult<MesQcDefectRespVO> getDefect(@RequestParam("id") Long id) {
        MesQcDefectDO defect = defectService.getDefect(id);
        return success(BeanUtils.toBean(defect, MesQcDefectRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get defect type page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:query')")
    public CommonResult<PageResult<MesQcDefectRespVO>> getDefectPage(@Valid MesQcDefectPageReqVO pageReqVO) {
        PageResult<MesQcDefectDO> pageResult = defectService.getDefectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesQcDefectRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get defect type simple list.", description = "Used by frontend select options.")
    public CommonResult<List<MesQcDefectRespVO>> getDefectSimpleList() {
        List<MesQcDefectDO> list = defectService.getDefectList();
        return success(BeanUtils.toBean(list, MesQcDefectRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export defect type Excel.")
    @PreAuthorize("@ss.hasPermission('mes:qc-defect:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDefectExcel(@Valid MesQcDefectPageReqVO pageReqVO,
                                  HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesQcDefectDO> list = defectService.getDefectPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Defect Types.xls", "Data", MesQcDefectRespVO.class,
                BeanUtils.toBean(list, MesQcDefectRespVO.class));
    }

}
