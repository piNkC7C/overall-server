package cn.iocoder.yudao.module.mes.controller.admin.qc.rqc;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo.MesQcRqcPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo.MesQcRqcRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo.MesQcRqcSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.qc.rqc.MesQcRqcDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.qc.rqc.MesQcRqcService;
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

@Tag(name = "Admin - MES return inspection (RQC).")
@RestController
@RequestMapping("/mes/qc/rqc")
@Validated
public class MesQcRqcController {

    @Resource
    private MesQcRqcService rqcService;
    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create return inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:create')")
    public CommonResult<Long> createRqc(@Valid @RequestBody MesQcRqcSaveReqVO createReqVO) {
        return success(rqcService.createRqc(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update return inspection.")
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:update')")
    public CommonResult<Boolean> updateRqc(@Valid @RequestBody MesQcRqcSaveReqVO updateReqVO) {
        rqcService.updateRqc(updateReqVO);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Complete return inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:finish')")
    public CommonResult<Boolean> finishRqc(@RequestParam("id") Long id) {
        rqcService.finishRqc(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete return inspection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:delete')")
    public CommonResult<Boolean> deleteRqc(@RequestParam("id") Long id) {
        rqcService.deleteRqc(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get return inspection.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:query')")
    public CommonResult<MesQcRqcRespVO> getRqc(@RequestParam("id") Long id) {
        MesQcRqcDO rqc = rqcService.getRqc(id);
        return success(buildRqcRespVOList(Collections.singletonList(rqc)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get return inspection page.")
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:query')")
    public CommonResult<PageResult<MesQcRqcRespVO>> getRqcPage(@Valid MesQcRqcPageReqVO pageReqVO) {
        PageResult<MesQcRqcDO> pageResult = rqcService.getRqcPage(pageReqVO);
        return success(new PageResult<>(buildRqcRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export return inspection Excel.")
    @PreAuthorize("@ss.hasPermission('mes:qc-rqc:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRqcExcel(@Valid MesQcRqcPageReqVO pageReqVO,
                               HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesQcRqcDO> list = rqcService.getRqcPage(pageReqVO).getList();
        List<MesQcRqcRespVO> voList = buildRqcRespVOList(list);
        ExcelUtils.write(response, "Return Inspection Orders.xls", "Data", MesQcRqcRespVO.class, voList);
    }

    // ==================== 拼接 VO ====================

    private List<MesQcRqcRespVO> buildRqcRespVOList(List<MesQcRqcDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // Batch search material
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesQcRqcDO::getItemId));
        // Batch search unit of measure
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // Batch searchInspector
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesQcRqcDO::getInspectorUserId));
        // 拼装 VO
        return BeanUtils.toBean(list, MesQcRqcRespVO.class, vo -> {
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
