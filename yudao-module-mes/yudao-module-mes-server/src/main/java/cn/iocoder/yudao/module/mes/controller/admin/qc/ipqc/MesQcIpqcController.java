package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.MesQcIpqcPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.MesQcIpqcRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.MesQcIpqcSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkstationDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.process.MesProProcessDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workorder.MesProWorkOrderDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.ipqc.MesQcIpqcDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkstationService;
import cn.iocoder.yudao.module.mes.service.pro.process.MesProProcessService;
import cn.iocoder.yudao.module.mes.service.pro.workorder.MesProWorkOrderService;
import cn.iocoder.yudao.module.mes.service.qc.ipqc.MesQcIpqcService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
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
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;

@Tag(name = "Admin - MES in-process inspection (IPQC).")
@RestController
@RequestMapping("/mes/qc/ipqc")
@Validated
public class MesQcIpqcController {

    @Resource
    private MesQcIpqcService ipqcService;
    @Resource
    private MesProWorkOrderService workOrderService;
    @Resource
    private MesMdWorkstationService workstationService;
    @Resource
    private MesProProcessService processService;
    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create in-process inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:create')")
    public CommonResult<Long> createIpqc(@Valid @RequestBody MesQcIpqcSaveReqVO createReqVO) {
        return success(ipqcService.createIpqc(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update in-process inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:update')")
    public CommonResult<Boolean> updateIpqc(@Valid @RequestBody MesQcIpqcSaveReqVO updateReqVO) {
        ipqcService.updateIpqc(updateReqVO);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Complete in-process inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:finish')")
    public CommonResult<Boolean> finishIpqc(@RequestParam("id") Long id) {
        ipqcService.finishIpqc(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete in-process inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:delete')")
    public CommonResult<Boolean> deleteIpqc(@RequestParam("id") Long id) {
        ipqcService.deleteIpqc(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get in-process inspection.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:query')")
    public CommonResult<MesQcIpqcRespVO> getIpqc(@RequestParam("id") Long id) {
        MesQcIpqcDO ipqc = ipqcService.getIpqc(id);
        return success(buildIpqcRespVOList(Collections.singletonList(ipqc)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get in-process inspection page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:query')")
    public CommonResult<PageResult<MesQcIpqcRespVO>> getIpqcPage(@Valid MesQcIpqcPageReqVO pageReqVO) {
        PageResult<MesQcIpqcDO> pageResult = ipqcService.getIpqcPage(pageReqVO);
        return success(new PageResult<>(buildIpqcRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export in-process inspection Excel.")
    @PreAuthorize("@ss.hasPermission('mes:qc-ipqc:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportIpqcExcel(@Valid MesQcIpqcPageReqVO pageReqVO,
                                HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesQcIpqcDO> list = ipqcService.getIpqcPage(pageReqVO).getList();
        List<MesQcIpqcRespVO> voList = buildIpqcRespVOList(list);
        ExcelUtils.write(response, "In-Process Inspection Orders.xls", "Data", MesQcIpqcRespVO.class, voList);
    }

    // ==================== 拼接 VO ====================

    private List<MesQcIpqcRespVO> buildIpqcRespVOList(List<MesQcIpqcDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // Batch searchwork order
        Map<Long, MesProWorkOrderDO> workOrderMap = workOrderService.getWorkOrderMap(
                convertSet(list, MesQcIpqcDO::getWorkOrderId));
        // 批量查询工位
        Map<Long, MesMdWorkstationDO> workstationMap = workstationService.getWorkstationMap(
                convertSet(list, MesQcIpqcDO::getWorkstationId));
        // Batch searchoperation
        Map<Long, MesProProcessDO> processMap = processService.getProcessMap(
                convertSet(list, MesQcIpqcDO::getProcessId));
        // Batch search material
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesQcIpqcDO::getItemId));
        // Batch search unit of measure (
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // Batch searchInspector
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesQcIpqcDO::getInspectorUserId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcIpqcRespVO.class, vo -> {
            findAndThen(workOrderMap, vo.getWorkOrderId(), workOrder -> vo
                    .setWorkOrderCode(workOrder.getCode()).setWorkOrderName(workOrder.getName()));
            findAndThen(workstationMap, vo.getWorkstationId(),
                    ws -> vo.setWorkstationName(ws.getName()));
            findAndThen(processMap, vo.getProcessId(),
                    process -> vo.setProcessName(process.getName()));
            findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setItemSpecification(item.getSpecification());
                findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unit -> vo.setUnitName(unit.getName()));
            });
            findAndThen(userMap, vo.getInspectorUserId(),
                    user -> vo.setInspectorNickname(user.getNickname()));
        });
    }

}
