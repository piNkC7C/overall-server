package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line.MesWmProductIssueLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line.MesWmProductIssueLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line.MesWmProductIssueLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.productissue.MesWmProductIssueLineDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.wm.productissue.MesWmProductIssueLineService;
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

@Tag(name = "Admin - MES material issue outbound order line.")
@RestController
@RequestMapping("/mes/wm/product-issue-line")
@Validated
public class MesWmProductIssueLineController {

    @Resource
    private MesWmProductIssueLineService issueLineService;

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create material issue outbound order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:create')")
    public CommonResult<Long> createProductIssueLine(@Valid @RequestBody MesWmProductIssueLineSaveReqVO createReqVO) {
        return success(issueLineService.createProductIssueLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit material issue outbound order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:update')")
    public CommonResult<Boolean> updateProductIssueLine(@Valid @RequestBody MesWmProductIssueLineSaveReqVO updateReqVO) {
        issueLineService.updateProductIssueLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete material issue outbound order line.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:delete')")
    public CommonResult<Boolean> deleteProductIssueLine(@RequestParam("id") Long id) {
        issueLineService.deleteProductIssueLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get material issue outbound order line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:query')")
    public CommonResult<MesWmProductIssueLineRespVO> getProductIssueLine(@RequestParam("id") Long id) {
        MesWmProductIssueLineDO line = issueLineService.getProductIssueLine(id);
        if (line == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(line)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get material issue outbound order line page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:query')")
    public CommonResult<PageResult<MesWmProductIssueLineRespVO>> getProductIssueLinePage(
            @Valid MesWmProductIssueLinePageReqVO pageReqVO) {
        PageResult<MesWmProductIssueLineDO> pageResult = issueLineService.getProductIssueLinePage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list-by-issue")
    @Operation(summary = "Get material-pick lines by pick-order ID.")
    @Parameter(name = "issueId", description = "Material issue order code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-issue:query')")
    public CommonResult<List<MesWmProductIssueLineRespVO>> getProductIssueLineListByIssueId(
            @RequestParam("issueId") Long issueId) {
        List<MesWmProductIssueLineDO> list = issueLineService.getProductIssueLineListByIssueId(issueId);
        return success(buildRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmProductIssueLineRespVO> buildRespVOList(List<MesWmProductIssueLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmProductIssueLineDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmProductIssueLineRespVO.class, vo -> {
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unitMeasure -> vo.setUnitMeasureName(unitMeasure.getName()));
            });
        });
    }

}
