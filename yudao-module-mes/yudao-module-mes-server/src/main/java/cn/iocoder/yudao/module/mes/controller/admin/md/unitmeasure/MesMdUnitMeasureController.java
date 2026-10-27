package cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo.MesMdUnitMeasurePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo.MesMdUnitMeasureRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo.MesMdUnitMeasureSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - MES unit of measure.")
@RestController
@RequestMapping("/mes/md/unit-measure")
@Validated
public class MesMdUnitMeasureController {

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create unit of measure.")
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:create')")
    public CommonResult<Long> createUnitMeasure(@Valid @RequestBody MesMdUnitMeasureSaveReqVO createReqVO) {
        return success(unitMeasureService.createUnitMeasure(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update unit of measure.")
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:update')")
    public CommonResult<Boolean> updateUnitMeasure(@Valid @RequestBody MesMdUnitMeasureSaveReqVO updateReqVO) {
        unitMeasureService.updateUnitMeasure(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete unit of measure.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:delete')")
    public CommonResult<Boolean> deleteUnitMeasure(@RequestParam("id") Long id) {
        unitMeasureService.deleteUnitMeasure(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get unit of measure.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:query')")
    public CommonResult<MesMdUnitMeasureRespVO> getUnitMeasure(@RequestParam("id") Long id) {
        MesMdUnitMeasureDO unitMeasure = unitMeasureService.getUnitMeasure(id);
        return success(BeanUtils.toBean(unitMeasure, MesMdUnitMeasureRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get unit of measure page.")
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:query')")
    public CommonResult<PageResult<MesMdUnitMeasureRespVO>> getUnitMeasurePage(@Valid MesMdUnitMeasurePageReqVO pageReqVO) {
        PageResult<MesMdUnitMeasureDO> pageResult = unitMeasureService.getUnitMeasurePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesMdUnitMeasureRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get unit of measure simple list.", description = "Enabled units only. Used by frontend dropdowns.")
    public CommonResult<List<MesMdUnitMeasureRespVO>> getUnitMeasureSimpleList() {
        List<MesMdUnitMeasureDO> list = unitMeasureService.getUnitMeasureListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, unit -> new MesMdUnitMeasureRespVO()
                .setId(unit.getId()).setCode(unit.getCode()).setName(unit.getName())
                .setPrimaryFlag(unit.getPrimaryFlag()).setPrimaryId(unit.getPrimaryId())
                .setChangeRate(unit.getChangeRate()).setRemark(unit.getRemark())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export unit of measure Excel.")
    @PreAuthorize("@ss.hasPermission('mes:md-unit-measure:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportUnitMeasureExcel(@Valid MesMdUnitMeasurePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesMdUnitMeasureDO> list = unitMeasureService.getUnitMeasurePage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Units of Measure.xls", "Data", MesMdUnitMeasureRespVO.class,
                        BeanUtils.toBean(list, MesMdUnitMeasureRespVO.class));
    }

}
