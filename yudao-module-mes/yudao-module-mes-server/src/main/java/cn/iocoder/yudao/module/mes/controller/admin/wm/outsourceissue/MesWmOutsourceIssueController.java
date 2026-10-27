package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.MesWmOutsourceIssuePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.MesWmOutsourceIssueRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.MesWmOutsourceIssueSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.vendor.MesMdVendorDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workorder.MesProWorkOrderDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.outsourceissue.MesWmOutsourceIssueDO;
import cn.iocoder.yudao.module.mes.service.md.vendor.MesMdVendorService;
import cn.iocoder.yudao.module.mes.service.pro.workorder.MesProWorkOrderService;
import cn.iocoder.yudao.module.mes.service.wm.outsourceissue.MesWmOutsourceIssueService;
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

@Tag(name = "Admin - MES subcontract issue order.")
@RestController
@RequestMapping("/mes/wm/outsource-issue")
@Validated
public class MesWmOutsourceIssueController {

    @Resource
    private MesWmOutsourceIssueService outsourceIssueService;
    @Resource
    private MesMdVendorService vendorService;
    @Resource
    private MesProWorkOrderService workOrderService;

    @PostMapping("/create")
    @Operation(summary = "Create subcontract issue order.")
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:create')")
    public CommonResult<Long> createOutsourceIssue(@Valid @RequestBody MesWmOutsourceIssueSaveReqVO createReqVO) {
        return success(outsourceIssueService.createOutsourceIssue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit subcontract issue order.")
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:update')")
    public CommonResult<Boolean> updateOutsourceIssue(@Valid @RequestBody MesWmOutsourceIssueSaveReqVO updateReqVO) {
        outsourceIssueService.updateOutsourceIssue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete subcontract issue order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:delete')")
    public CommonResult<Boolean> deleteOutsourceIssue(@RequestParam("id") Long id) {
        outsourceIssueService.deleteOutsourceIssue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get subcontract issue order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:query')")
    public CommonResult<MesWmOutsourceIssueRespVO> getOutsourceIssue(@RequestParam("id") Long id) {
        MesWmOutsourceIssueDO issue = outsourceIssueService.getOutsourceIssue(id);
        if (issue == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(issue)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get subcontract issue order page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:query')")
    public CommonResult<PageResult<MesWmOutsourceIssueRespVO>> getOutsourceIssuePage(
            @Valid MesWmOutsourceIssuePageReqVO pageReqVO) {
        PageResult<MesWmOutsourceIssueDO> pageResult = outsourceIssueService.getOutsourceIssuePage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export subcontract issue order Excel.")
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportOutsourceIssueExcel(@Valid MesWmOutsourceIssuePageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        PageResult<MesWmOutsourceIssueDO> pageResult = outsourceIssueService.getOutsourceIssuePage(pageReqVO);
        ExcelUtils.write(response, "Outsource Issue Orders.xls", "Data", MesWmOutsourceIssueRespVO.class,
                buildRespVOList(pageResult.getList()));
    }

    @PutMapping("/submit")
    @Operation(summary = "Submit to pending pick.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:update')")
    public CommonResult<Boolean> submitOutsourceIssue(@RequestParam("id") Long id) {
        outsourceIssueService.submitOutsourceIssue(id);
        return success(true);
    }

    @PutMapping("/stock")
    @Operation(summary = "Execute picking.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:update')")
    public CommonResult<Boolean> stockOutsourceIssue(@RequestParam("id") Long id) {
        outsourceIssueService.stockOutsourceIssue(id);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Complete subcontract issue outbound.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:finish')")
    public CommonResult<Boolean> finishOutsourceIssue(@RequestParam("id") Long id) {
        outsourceIssueService.finishOutsourceIssue(id);
        return success(true);
    }

    @PutMapping("/cancel")
    @Operation(summary = "Cancel subcontract issue order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:update')")
    public CommonResult<Boolean> cancelOutsourceIssue(@RequestParam("id") Long id) {
        outsourceIssueService.cancelOutsourceIssue(id);
        return success(true);
    }

    @GetMapping("/check-quantity")
    @Operation(summary = "Validate subcontract issue quantities.", description = "Validate that line-detail quantities sum to the issue quantity.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-outsource-issue:query')")
    public CommonResult<Boolean> checkOutsourceIssueQuantity(@RequestParam("id") Long id) {
        return success(outsourceIssueService.checkOutsourceIssueQuantity(id));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmOutsourceIssueRespVO> buildRespVOList(List<MesWmOutsourceIssueDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdVendorDO> vendorMap = vendorService.getVendorMap(
                convertSet(list, MesWmOutsourceIssueDO::getVendorId));
        Map<Long, MesProWorkOrderDO> workOrderMap = workOrderService.getWorkOrderMap(
                convertSet(list, MesWmOutsourceIssueDO::getWorkOrderId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmOutsourceIssueRespVO.class, vo -> {
            MapUtils.findAndThen(vendorMap, vo.getVendorId(), vendor ->
                    vo.setVendorCode(vendor.getCode()).setVendorName(vendor.getName()));
            MapUtils.findAndThen(workOrderMap, vo.getWorkOrderId(), workOrder ->
                    vo.setWorkOrderCode(workOrder.getCode()).setWorkOrderName(workOrder.getName()));
        });
    }

}
