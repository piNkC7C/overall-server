package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line.MesWmReturnIssueLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line.MesWmReturnIssueLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line.MesWmReturnIssueLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.returnissue.MesWmReturnIssueLineDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.wm.returnissue.MesWmReturnIssueLineService;
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

@Tag(name = "Admin - MES production material return order line.")
@RestController
@RequestMapping("/mes/wm/return-issue-line")
@Validated
public class MesWmReturnIssueLineController {

    @Resource
    private MesWmReturnIssueLineService issueLineService;

    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create production material return order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:create')")
    public CommonResult<Long> createReturnIssueLine(@Valid @RequestBody MesWmReturnIssueLineSaveReqVO createReqVO) {
        return success(issueLineService.createReturnIssueLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit production material return order line.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:update')")
    public CommonResult<Boolean> updateReturnIssueLine(@Valid @RequestBody MesWmReturnIssueLineSaveReqVO updateReqVO) {
        issueLineService.updateReturnIssueLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete production material return order line.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:delete')")
    public CommonResult<Boolean> deleteReturnIssueLine(@RequestParam("id") Long id) {
        issueLineService.deleteReturnIssueLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get production material return order line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:query')")
    public CommonResult<MesWmReturnIssueLineRespVO> getReturnIssueLine(@RequestParam("id") Long id) {
        MesWmReturnIssueLineDO line = issueLineService.getReturnIssueLine(id);
        if (line == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(line)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get production material return order line page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:query')")
    public CommonResult<PageResult<MesWmReturnIssueLineRespVO>> getReturnIssueLinePage(
            @Valid MesWmReturnIssueLinePageReqVO pageReqVO) {
        PageResult<MesWmReturnIssueLineDO> pageResult = issueLineService.getReturnIssueLinePage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list-by-issue")
    @Operation(summary = "Get production return-material lines by return ID.")
    @Parameter(name = "issueId", description = "Material return order code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-issue:query')")
    public CommonResult<List<MesWmReturnIssueLineRespVO>> getReturnIssueLineListByIssueId(
            @RequestParam("issueId") Long issueId) {
        List<MesWmReturnIssueLineDO> list = issueLineService.getReturnIssueLineListByIssueId(issueId);
        return success(buildRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmReturnIssueLineRespVO> buildRespVOList(List<MesWmReturnIssueLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmReturnIssueLineDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmReturnIssueLineRespVO.class, vo -> {
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unitMeasure -> vo.setUnitMeasureName(unitMeasure.getName()));
            });
        });
    }

}
