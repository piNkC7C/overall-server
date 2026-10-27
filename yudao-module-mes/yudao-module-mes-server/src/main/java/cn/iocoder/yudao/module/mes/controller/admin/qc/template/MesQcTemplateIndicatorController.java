package cn.iocoder.yudao.module.mes.controller.admin.qc.template;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator.MesQcTemplateIndicatorPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator.MesQcTemplateIndicatorRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.indicator.MesQcTemplateIndicatorSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.indicator.MesQcIndicatorDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.template.MesQcTemplateIndicatorDO;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.qc.indicator.MesQcIndicatorService;
import cn.iocoder.yudao.module.mes.service.qc.template.MesQcTemplateIndicatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES quality inspection plan - inspect metric item.")
@RestController
@RequestMapping("/mes/qc/template/indicator")
@Validated
public class MesQcTemplateIndicatorController {

    @Resource
    private MesQcTemplateIndicatorService templateIndicatorService;
    @Resource
    private MesQcIndicatorService indicatorService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create quality inspection plan - inspect metric item.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:create')")
    public CommonResult<Long> createTemplateIndicator(@Valid @RequestBody MesQcTemplateIndicatorSaveReqVO createReqVO) {
        return success(templateIndicatorService.createTemplateIndicator(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update quality inspection plan - inspect metric item.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:update')")
    public CommonResult<Boolean> updateTemplateIndicator(@Valid @RequestBody MesQcTemplateIndicatorSaveReqVO updateReqVO) {
        templateIndicatorService.updateTemplateIndicator(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete quality inspection plan - inspect metric item.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-template:update')")
    public CommonResult<Boolean> deleteTemplateIndicator(@RequestParam("id") Long id) {
        templateIndicatorService.deleteTemplateIndicator(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get quality inspection plan - inspect metric item.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:query')")
    public CommonResult<MesQcTemplateIndicatorRespVO> getTemplateIndicator(@RequestParam("id") Long id) {
        MesQcTemplateIndicatorDO indicator = templateIndicatorService.getTemplateIndicator(id);
        return success(buildIndicatorRespVOList(Collections.singletonList(indicator)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get quality inspection plan - inspect metric item page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:query')")
    public CommonResult<PageResult<MesQcTemplateIndicatorRespVO>> getTemplateIndicatorPage(
            @Valid MesQcTemplateIndicatorPageReqVO pageReqVO) {
        PageResult<MesQcTemplateIndicatorDO> pageResult = templateIndicatorService.getTemplateIndicatorPage(pageReqVO);
        return success(new PageResult<>(buildIndicatorRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    // ==================== 拼接 VO ====================

    private List<MesQcTemplateIndicatorRespVO> buildIndicatorRespVOList(List<MesQcTemplateIndicatorDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // Batch search quality inspection metric
        Map<Long, MesQcIndicatorDO> indicatorMap = indicatorService.getIndicatorMap(
                convertSet(list, MesQcTemplateIndicatorDO::getIndicatorId));
        // Batch search unit of measure
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(list, MesQcTemplateIndicatorDO::getUnitMeasureId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcTemplateIndicatorRespVO.class, vo -> {
            findAndThen(indicatorMap, vo.getIndicatorId(), indicator ->
                    vo.setIndicatorCode(indicator.getCode()).setIndicatorName(indicator.getName())
                            .setIndicatorType(indicator.getType()).setIndicatorTool(indicator.getTool()));
            findAndThen(unitMeasureMap, vo.getUnitMeasureId(),
                    unit -> vo.setUnitMeasureName(unit.getName()));
        });
    }

}
