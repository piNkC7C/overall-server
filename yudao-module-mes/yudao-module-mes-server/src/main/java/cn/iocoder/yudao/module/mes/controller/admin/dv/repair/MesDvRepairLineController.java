package cn.iocoder.yudao.module.mes.controller.admin.dv.repair;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line.MesDvRepairLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line.MesDvRepairLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line.MesDvRepairLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.repair.MesDvRepairLineDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.subject.MesDvSubjectDO;
import cn.iocoder.yudao.module.mes.service.dv.repair.MesDvRepairLineService;
import cn.iocoder.yudao.module.mes.service.dv.subject.MesDvSubjectService;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES repair work order line.")
@RestController
@RequestMapping("/mes/dv/repair-line")
@Validated
public class MesDvRepairLineController {

    @Resource
    private MesDvRepairLineService repairLineService;
    @Resource
    private MesDvSubjectService subjectService;

    @PostMapping("/create")
    @Operation(summary = "Create repair work order line.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:create')")
    public CommonResult<Long> createRepairLine(@Valid @RequestBody MesDvRepairLineSaveReqVO createReqVO) {
        return success(repairLineService.createRepairLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update repair work order line.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:update')")
    public CommonResult<Boolean> updateRepairLine(@Valid @RequestBody MesDvRepairLineSaveReqVO updateReqVO) {
        repairLineService.updateRepairLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete repair work order line.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:delete')")
    public CommonResult<Boolean> deleteRepairLine(@RequestParam("id") Long id) {
        repairLineService.deleteRepairLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get repair work order line.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:query')")
    public CommonResult<MesDvRepairLineRespVO> getRepairLine(@RequestParam("id") Long id) {
        MesDvRepairLineDO repairLine = repairLineService.getRepairLine(id);
        if (repairLine == null) {
            return success(null);
        }
        return success(buildRepairLineRespVOList(Collections.singletonList(repairLine)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get repair work order line page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:query')")
    public CommonResult<PageResult<MesDvRepairLineRespVO>> getRepairLinePage(@Valid MesDvRepairLinePageReqVO pageReqVO) {
        PageResult<MesDvRepairLineDO> pageResult = repairLineService.getRepairLinePage(pageReqVO);
        return success(new PageResult<>(buildRepairLineRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list-by-repair-id")
    @Operation(summary = "Get specified repair work order detail list.")
    @Parameter(name = "repairId", description = "Repair work order code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:query')")
    public CommonResult<List<MesDvRepairLineRespVO>> getRepairLineListByRepairId(
            @RequestParam("repairId") Long repairId) {
        List<MesDvRepairLineDO> list = repairLineService.getRepairLineListByRepairId(repairId);
        return success(buildRepairLineRespVOList(list));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export repair work order line Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRepairLineExcel(@Valid MesDvRepairLinePageReqVO pageReqVO,
                                       HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvRepairLineDO> list = repairLineService.getRepairLinePage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Maintenance Work Order Lines.xls", "Data", MesDvRepairLineRespVO.class,
                buildRepairLineRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesDvRepairLineRespVO> buildRepairLineRespVOList(List<MesDvRepairLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get relation data
        Map<Long, MesDvSubjectDO> subjectMap = subjectService.getSubjectMap(
                convertSet(list, MesDvRepairLineDO::getSubjectId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesDvRepairLineRespVO.class, vo ->
                MapUtils.findAndThen(subjectMap, vo.getSubjectId(), subject -> vo
                        .setSubjectName(subject.getName()).setSubjectContent(subject.getContent())
                        .setSubjectStandard(subject.getStandard())));
    }

}
