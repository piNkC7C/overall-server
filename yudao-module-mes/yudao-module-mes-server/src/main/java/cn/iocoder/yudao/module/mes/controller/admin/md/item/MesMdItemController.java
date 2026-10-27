package cn.iocoder.yudao.module.mes.controller.admin.md.item;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.MesMdItemImportExcelVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.MesMdItemImportRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.MesMdItemPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.MesMdItemRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.MesMdItemSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemTypeDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemTypeService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
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

@Tag(name = "Admin - MES material product.")
@RestController
@RequestMapping("/mes/md/item")
@Validated
public class MesMdItemController {

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdItemTypeService itemTypeService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Create material product.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:create')")
    public CommonResult<Long> createItem(@Valid @RequestBody MesMdItemSaveReqVO createReqVO) {
        return success(itemService.createItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update material product.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:update')")
    public CommonResult<Boolean> updateItem(@Valid @RequestBody MesMdItemSaveReqVO updateReqVO) {
        itemService.updateItem(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Update material Product status.")
    @Parameters({
            @Parameter(name = "id", description = "Code.", required = true),
            @Parameter(name = "status", description = "Status.", required = true)
    })
    @PreAuthorize("@ss.hasPermission('mes:md-item:update')")
    public CommonResult<Boolean> updateItemStatus(@RequestParam("id") Long id,
                                                  @RequestParam("status") Integer status) {
        itemService.updateItemStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete material product.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-item:delete')")
    public CommonResult<Boolean> deleteItem(@RequestParam("id") Long id) {
        itemService.deleteItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get material product.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<MesMdItemRespVO> getItem(@RequestParam("id") Long id) {
        MesMdItemDO item = itemService.getItem(id);
        return success(buildItemVO(item));
    }

    @GetMapping("/page")
    @Operation(summary = "Get material product page.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<PageResult<MesMdItemRespVO>> getItemPage(@Valid MesMdItemPageReqVO pageReqVO) {
        PageResult<MesMdItemDO> pageResult = itemService.getItemPage(pageReqVO);
        return success(new PageResult<>(buildItemVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export material product Excel.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportItemExcel(@Valid MesMdItemPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        PageResult<MesMdItemDO> pageResult = itemService.getItemPage(pageReqVO);
        // Export Excel
        ExcelUtils.write(response, "Materials.xls", "Data", MesMdItemRespVO.class,
                buildItemVOList(pageResult.getList()));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get material importtemplate.")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<MesMdItemImportExcelVO> list = Collections.singletonList(
                MesMdItemImportExcelVO.builder().code("ITEM001").name("Screw").specification("M6*20")
                        .unitMeasureCode("PCS").itemTypeId(1L).status(0).build()
        );
        // 输出
        ExcelUtils.write(response, "Material Import Template.xls", "Materials", MesMdItemImportExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "Import material.")
    @Parameters({
            @Parameter(name = "file", description = "Excel file.", required = true),
            @Parameter(name = "updateSupport", description = "Is not support update, default is false.", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('mes:md-item:import')")
    public CommonResult<MesMdItemImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                           @RequestParam(value = "updateSupport", required = false,
                                                                   defaultValue = "false") Boolean updateSupport) throws Exception {
        List<MesMdItemImportExcelVO> list = ExcelUtils.read(file, MesMdItemImportExcelVO.class);
        return success(itemService.importItemList(list, updateSupport));
    }

    // ==================== 拼接 VO ====================

    private List<MesMdItemRespVO> buildItemVOList(List<MesMdItemDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        Map<Long, MesMdItemTypeDO> itemTypeMap = itemTypeService.getItemTypeMap(
                convertSet(list, MesMdItemDO::getItemTypeId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(list, MesMdItemDO::getUnitMeasureId));
        return BeanUtils.toBean(list, MesMdItemRespVO.class, item -> {
            MapUtils.findAndThen(itemTypeMap, item.getItemTypeId(),
                    itemType -> {
                        item.setItemTypeName(itemType.getName());
                        item.setItemOrProduct(itemType.getItemOrProduct());
                    });
            MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                    unitMeasure -> item.setUnitMeasureName(unitMeasure.getName()));
        });
    }

    private MesMdItemRespVO buildItemVO(MesMdItemDO item) {
       if (item == null) {
           return null;
       }
       return CollUtil.getFirst(buildItemVOList(Collections.singletonList(item)));
    }

}
