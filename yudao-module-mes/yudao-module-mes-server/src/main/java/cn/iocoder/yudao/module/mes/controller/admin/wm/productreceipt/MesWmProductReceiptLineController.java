package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line.MesWmProductReceiptLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line.MesWmProductReceiptLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line.MesWmProductReceiptLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.productreceipt.MesWmProductReceiptLineDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.wm.productreceipt.MesWmProductReceiptLineService;
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

@Tag(name = "Admin - MES product receiving order line.")
@RestController
@RequestMapping("/mes/wm/product-receipt-line")
@Validated
public class MesWmProductReceiptLineController {

    @Resource
    private MesWmProductReceiptLineService productReceiptLineService;

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct receiving order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:create')")
    public CommonResult<Long> createProductReceiptLine(@Valid @RequestBody MesWmProductReceiptLineSaveReqVO createReqVO) {
        return success(productReceiptLineService.createProductReceiptLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit product receiving order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:update')")
    public CommonResult<Boolean> updateProductReceiptLine(@Valid @RequestBody MesWmProductReceiptLineSaveReqVO updateReqVO) {
        productReceiptLineService.updateProductReceiptLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct receiving order line.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:delete')")
    public CommonResult<Boolean> deleteProductReceiptLine(@RequestParam("id") Long id) {
        productReceiptLineService.deleteProductReceiptLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product receiving order line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:query')")
    public CommonResult<MesWmProductReceiptLineRespVO> getProductReceiptLine(@RequestParam("id") Long id) {
        MesWmProductReceiptLineDO line = productReceiptLineService.getProductReceiptLine(id);
        if (line == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(line)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get product receiving order line page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:query')")
    public CommonResult<PageResult<MesWmProductReceiptLineRespVO>> getProductReceiptLinePage(
            @Valid MesWmProductReceiptLinePageReqVO pageReqVO) {
        PageResult<MesWmProductReceiptLineDO> pageResult = productReceiptLineService.getProductReceiptLinePage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmProductReceiptLineRespVO> buildRespVOList(List<MesWmProductReceiptLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmProductReceiptLineDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmProductReceiptLineRespVO.class, vo -> {
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unitMeasure -> vo.setUnitMeasureName(unitMeasure.getName()));
            });
        });
    }

}
