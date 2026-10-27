package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.line.MesWmReturnSalesLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.line.MesWmReturnSalesLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.line.MesWmReturnSalesLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.returnsales.MesWmReturnSalesLineDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.wm.returnsales.MesWmReturnSalesLineService;
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

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES sales return line.")
@RestController
@RequestMapping("/mes/wm/return-sales-line")
@Validated
public class MesWmReturnSalesLineController {

    @Resource
    private MesWmReturnSalesLineService returnSalesLineService;
    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Createsales return line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:create')")
    public CommonResult<Long> createReturnSalesLine(@Valid @RequestBody MesWmReturnSalesLineSaveReqVO createReqVO) {
        return success(returnSalesLineService.createReturnSalesLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit sales return line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:update')")
    public CommonResult<Boolean> updateReturnSalesLine(@Valid @RequestBody MesWmReturnSalesLineSaveReqVO updateReqVO) {
        returnSalesLineService.updateReturnSalesLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletesales return line.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:delete')")
    public CommonResult<Boolean> deleteReturnSalesLine(@RequestParam("id") Long id) {
        returnSalesLineService.deleteReturnSalesLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get sales return line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:query')")
    public CommonResult<MesWmReturnSalesLineRespVO> getReturnSalesLine(@RequestParam("id") Long id) {
        MesWmReturnSalesLineDO line = returnSalesLineService.getReturnSalesLine(id);
        if (line == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(line)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get sales return line page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:query')")
    public CommonResult<PageResult<MesWmReturnSalesLineRespVO>> getReturnSalesLinePage(
            @Valid MesWmReturnSalesLinePageReqVO pageReqVO) {
        PageResult<MesWmReturnSalesLineDO> pageResult = returnSalesLineService.getReturnSalesLinePage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list-by-return-sales")
    @Operation(summary = "Get sales-return lines by return-order ID.")
    @Parameter(name = "returnId", description = "Return order code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-sales:query')")
    public CommonResult<List<MesWmReturnSalesLineRespVO>> getReturnSalesLineListByReturnId(
            @RequestParam("returnId") Long returnId) {
        List<MesWmReturnSalesLineDO> list = returnSalesLineService.getReturnSalesLineListByReturnId(returnId);
        return success(buildRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmReturnSalesLineRespVO> buildRespVOList(List<MesWmReturnSalesLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmReturnSalesLineDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmReturnSalesLineRespVO.class, vo ->
                MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                    vo.setItemCode(item.getCode()).setItemName(item.getName()).setItemSpecification(item.getSpecification());
                    MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                            unitMeasure -> vo.setItemUnit(unitMeasure.getName()));
        }));
    }

}
