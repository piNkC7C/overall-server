package cn.iocoder.yudao.module.mes.controller.admin.qc.template;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item.MesQcTemplateItemPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item.MesQcTemplateItemRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item.MesQcTemplateItemSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.template.MesQcTemplateItemDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.qc.template.MesQcTemplateItemService;
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

@Tag(name = "Admin - MES quality inspection plan -product relation.")
@RestController
@RequestMapping("/mes/qc/template/item")
@Validated
public class MesQcTemplateItemController {

    @Resource
    private MesQcTemplateItemService templateItemService;
    @Resource
    private MesMdItemService mdItemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create quality inspection plan -product relation.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:create')")
    public CommonResult<Long> createTemplateItem(@Valid @RequestBody MesQcTemplateItemSaveReqVO createReqVO) {
        return success(templateItemService.createTemplateItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update quality inspection plan -product relation.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:update')")
    public CommonResult<Boolean> updateTemplateItem(@Valid @RequestBody MesQcTemplateItemSaveReqVO updateReqVO) {
        templateItemService.updateTemplateItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete quality inspection plan -product relation.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-template:update')")
    public CommonResult<Boolean> deleteTemplateItem(@RequestParam("id") Long id) {
        templateItemService.deleteTemplateItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get quality inspection plan -product relation.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:query')")
    public CommonResult<MesQcTemplateItemRespVO> getTemplateItem(@RequestParam("id") Long id) {
        MesQcTemplateItemDO item = templateItemService.getTemplateItem(id);
        return success(buildItemRespVOList(Collections.singletonList(item)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get quality inspection plan -product relation page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-template:query')")
    public CommonResult<PageResult<MesQcTemplateItemRespVO>> getTemplateItemPage(
            @Valid MesQcTemplateItemPageReqVO pageReqVO) {
        PageResult<MesQcTemplateItemDO> pageResult = templateItemService.getTemplateItemPage(pageReqVO);
        return success(new PageResult<>(buildItemRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    // ==================== 拼接 VO ====================

    private List<MesQcTemplateItemRespVO> buildItemRespVOList(List<MesQcTemplateItemDO> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        // Batch search material
        Map<Long, MesMdItemDO> itemMap = mdItemService.getItemMap(
                convertSet(list, MesQcTemplateItemDO::getItemId));
        // Batch search unit of measure
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcTemplateItemRespVO.class, vo -> {
            findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setSpecification(item.getSpecification());
                findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unit -> vo.setUnitMeasureName(unit.getName()));
            });
        });
    }

}
