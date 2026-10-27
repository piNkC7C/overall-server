package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.MesDvMachineryImportExcelVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.MesDvMachineryImportRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.MesDvMachineryPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.MesDvMachineryRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.MesDvMachinerySaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.machinery.MesDvMachineryDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.machinery.MesDvMachineryTypeDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkshopDO;
import cn.iocoder.yudao.module.mes.service.dv.machinery.MesDvMachineryService;
import cn.iocoder.yudao.module.mes.service.dv.machinery.MesDvMachineryTypeService;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkshopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES device ledger.")
@RestController
@RequestMapping("/mes/dv/machinery")
@Validated
public class MesDvMachineryController {

    @Resource
    private MesDvMachineryService machineryService;
    @Resource
    private MesDvMachineryTypeService machineryTypeService;
    @Resource
    private MesMdWorkshopService workshopService;

    @PostMapping("/create")
    @Operation(summary = "Createdevice.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:create')")
    public CommonResult<Long> createMachinery(@Valid @RequestBody MesDvMachinerySaveReqVO createReqVO) {
        return success(machineryService.createMachinery(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedevice.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:update')")
    public CommonResult<Boolean> updateMachinery(@Valid @RequestBody MesDvMachinerySaveReqVO updateReqVO) {
        machineryService.updateMachinery(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedevice.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:delete')")
    public CommonResult<Boolean> deleteMachinery(@RequestParam("id") Long id) {
        machineryService.deleteMachinery(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:query')")
    public CommonResult<MesDvMachineryRespVO> getMachinery(@RequestParam("id") Long id) {
        MesDvMachineryDO machinery = machineryService.getMachinery(id);
        if (machinery == null) {
            return success(null);
        }
        return success(buildMachineryRespVOList(Collections.singletonList(machinery)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get device page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:query')")
    public CommonResult<PageResult<MesDvMachineryRespVO>> getMachineryPage(@Valid MesDvMachineryPageReqVO pageReqVO) {
        PageResult<MesDvMachineryDO> pageResult = machineryService.getMachineryPage(pageReqVO);
        return success(new PageResult<>(buildMachineryRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportdevice Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMachineryExcel(@Valid MesDvMachineryPageReqVO pageReqVO,
                                      HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvMachineryDO> list = machineryService.getMachineryPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Equipment Ledger.xls", "Data", MesDvMachineryRespVO.class,
                buildMachineryRespVOList(list));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get device simple list.", description = "Used by frontend select options.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:query')")
    public CommonResult<List<MesDvMachineryRespVO>> getMachinerySimpleList() {
        List<MesDvMachineryDO> list = machineryService.getMachineryList();
        return success(BeanUtils.toBean(list, MesDvMachineryRespVO.class));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get deviceimporttemplate.")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<MesDvMachineryImportExcelVO> list = Collections.singletonList(
                MesDvMachineryImportExcelVO.builder().code("EQ-001").name("Sample Equipment")
                        .brand("Sample Brand").specification("Model A").machineryTypeCode("MT-001")
                        .workshopCode("WS-001").status(0).build()
        );
        // 输出
        ExcelUtils.write(response, "Equipment Import Template.xls", "Equipment", MesDvMachineryImportExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "Importdevice.")
    @Parameters({
            @Parameter(name = "file", description = "Excel file.", required = true),
            @Parameter(name = "updateSupport", description = "Is not support update, default is false.", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery:import')")
    public CommonResult<MesDvMachineryImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                                 @RequestParam(value = "updateSupport", required = false,
                                                                         defaultValue = "false") Boolean updateSupport) throws Exception {
        List<MesDvMachineryImportExcelVO> list = ExcelUtils.read(file, MesDvMachineryImportExcelVO.class);
        return success(machineryService.importMachineryList(list, updateSupport));
    }

    // ==================== 拼接 VO ====================

    private List<MesDvMachineryRespVO> buildMachineryRespVOList(List<MesDvMachineryDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get device type and workshop info
        Map<Long, MesDvMachineryTypeDO> machineryTypeMap = machineryTypeService.getMachineryTypeMap(
                convertSet(list, MesDvMachineryDO::getMachineryTypeId));
        Map<Long, MesMdWorkshopDO> workshopMap = workshopService.getWorkshopMap(
                convertSet(list, MesDvMachineryDO::getWorkshopId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesDvMachineryRespVO.class, vo -> {
            MapUtils.findAndThen(machineryTypeMap, vo.getMachineryTypeId(),
                    machineryType -> vo.setMachineryTypeName(machineryType.getName()));
            MapUtils.findAndThen(workshopMap, vo.getWorkshopId(),
                    workshop -> vo.setWorkshopName(workshop.getName()));
        });
    }

}
