package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.line.MesQcIpqcLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.line.MesQcIpqcLineRespVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.indicator.MesQcIndicatorDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.ipqc.MesQcIpqcLineDO;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.qc.indicator.MesQcIndicatorService;
import cn.iocoder.yudao.module.mes.service.qc.ipqc.MesQcIpqcLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;

@Tag(name = "Admin - MES in-process inspection line.")
@RestController
@RequestMapping("/mes/qc/ipqc/line")
@Validated
public class MesQcIpqcLineController {

    @Resource
    private MesQcIpqcLineService ipqcLineService;
    @Resource
    private MesQcIndicatorService indicatorService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @GetMapping("/get")
    @Operation(summary = "Get in-process inspection line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:query')")
    public CommonResult<MesQcIpqcLineRespVO> getIpqcLine(@RequestParam("id") Long id) {
        MesQcIpqcLineDO line = ipqcLineService.getIpqcLine(id);
        return success(buildLineRespVOList(Collections.singletonList(line)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get in-process inspection line page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:query')")
    public CommonResult<PageResult<MesQcIpqcLineRespVO>> getIpqcLinePage(@Valid MesQcIpqcLinePageReqVO pageReqVO) {
        PageResult<MesQcIpqcLineDO> pageResult = ipqcLineService.getIpqcLinePage(pageReqVO);
        return success(new PageResult<>(buildLineRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    // ==================== 拼接 VO ====================

    private List<MesQcIpqcLineRespVO> buildLineRespVOList(List<MesQcIpqcLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // Batch search inspect metric
        Map<Long, MesQcIndicatorDO> indicatorMap = indicatorService.getIndicatorMap(
                convertSet(list, MesQcIpqcLineDO::getIndicatorId));
        // Batch search unit of measure
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(list, MesQcIpqcLineDO::getUnitMeasureId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcIpqcLineRespVO.class, vo -> {
            findAndThen(indicatorMap, vo.getIndicatorId(), indicator ->
                    vo.setIndicatorCode(indicator.getCode()).setIndicatorName(indicator.getName())
                            .setIndicatorType(indicator.getType()));
            findAndThen(unitMeasureMap, vo.getUnitMeasureId(),
                    unit -> vo.setUnitMeasureName(unit.getName()));
        });
    }

}
