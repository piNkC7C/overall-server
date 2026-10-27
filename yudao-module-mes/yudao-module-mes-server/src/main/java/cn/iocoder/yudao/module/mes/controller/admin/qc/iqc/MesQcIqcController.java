package cn.iocoder.yudao.module.mes.controller.admin.qc.iqc;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.iqc.vo.MesQcIqcPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.iqc.vo.MesQcIqcRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.iqc.vo.MesQcIqcSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.vendor.MesMdVendorDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.iqc.MesQcIqcDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.md.vendor.MesMdVendorService;
import cn.iocoder.yudao.module.mes.service.qc.iqc.MesQcIqcService;
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
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - MES Incoming inspection (IQC).")
@RestController
@RequestMapping("/mes/qc/iqc")
@Validated
public class MesQcIqcController {

    @Resource
    private MesQcIqcService iqcService;
    @Resource
    private MesMdVendorService vendorService;
    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createincoming inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:create')")
    public CommonResult<Long> createIqc(@Valid @RequestBody MesQcIqcSaveReqVO createReqVO) {
        return success(iqcService.createIqc(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateincoming inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:update')")
    public CommonResult<Boolean> updateIqc(@Valid @RequestBody MesQcIqcSaveReqVO updateReqVO) {
        iqcService.updateIqc(updateReqVO);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Complete Incoming inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:finish')")
    public CommonResult<Boolean> finishIqc(@RequestParam("id") Long id) {
        iqcService.finishIqc(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteincoming inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:delete')")
    public CommonResult<Boolean> deleteIqc(@RequestParam("id") Long id) {
        iqcService.deleteIqc(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Getincoming inspection.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:query')")
    public CommonResult<MesQcIqcRespVO> getIqc(@RequestParam("id") Long id) {
        MesQcIqcDO iqc = iqcService.getIqc(id);
        return success(buildIqcRespVOList(Collections.singletonList(iqc)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Getincoming inspectionpage.")
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:query')")
    public CommonResult<PageResult<MesQcIqcRespVO>> getIqcPage(@Valid MesQcIqcPageReqVO pageReqVO) {
        PageResult<MesQcIqcDO> pageResult = iqcService.getIqcPage(pageReqVO);
        return success(new PageResult<>(buildIqcRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportincoming inspection Excel.")
    @PreAuthorize("@ss.hasPermission('mes:qc-iqc:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportIqcExcel(@Valid MesQcIqcPageReqVO pageReqVO,
                               HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesQcIqcDO> list = iqcService.getIqcPage(pageReqVO).getList();
        List<MesQcIqcRespVO> voList = buildIqcRespVOList(list);
        ExcelUtils.write(response, "Incoming Inspection Orders.xls", "Data", MesQcIqcRespVO.class, voList);
    }

    // ==================== 拼接 VO ====================

    private List<MesQcIqcRespVO> buildIqcRespVOList(List<MesQcIqcDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // Batch searchsupplier
        Map<Long, MesMdVendorDO> vendorMap = vendorService.getVendorMap(
                convertSet(list, MesQcIqcDO::getVendorId));
        // Batch search material
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesQcIqcDO::getItemId));
        // Batch search unit of measure ( via material unitMeasureId)
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // Batch searchInspector
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesQcIqcDO::getInspectorUserId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcIqcRespVO.class, vo -> {
            findAndThen(vendorMap, vo.getVendorId(),
                    vendor -> vo.setVendorNickname(vendor.getNickname()));
            findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode());
                vo.setItemName(item.getName());
                vo.setItemSpecification(item.getSpecification());
                findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unit -> vo.setUnitName(unit.getName()));
            });
            findAndThen(userMap, vo.getInspectorUserId(),
                    user -> vo.setInspectorNickname(user.getNickname()));
        });
    }

}
