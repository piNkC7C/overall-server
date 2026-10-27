package cn.iocoder.yudao.module.wms.controller.admin.md.item;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand.WmsItemBrandPageReqVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand.WmsItemBrandRespVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand.WmsItemBrandSaveReqVO;
import cn.iocoder.yudao.module.wms.dal.dataobject.md.item.WmsItemBrandDO;
import cn.iocoder.yudao.module.wms.service.md.item.WmsItemBrandService;
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
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - WMS product brand.")
@RestController
@RequestMapping("/wms/item-brand")
@Validated
public class WmsItemBrandController {

    @Resource
    private WmsItemBrandService brandService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct brand.")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:create')")
    public CommonResult<Long> createItemBrand(@Valid @RequestBody WmsItemBrandSaveReqVO createReqVO) {
        return success(brandService.createItemBrand(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateproduct brand.")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:update')")
    public CommonResult<Boolean> updateItemBrand(@Valid @RequestBody WmsItemBrandSaveReqVO updateReqVO) {
        brandService.updateItemBrand(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct brand.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('wms:item-brand:delete')")
    public CommonResult<Boolean> deleteItemBrand(@RequestParam("id") Long id) {
        brandService.deleteItemBrand(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product brand.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:query')")
    public CommonResult<WmsItemBrandRespVO> getItemBrand(@RequestParam("id") Long id) {
        WmsItemBrandDO brand = brandService.getItemBrand(id);
        return success(BeanUtils.toBean(brand, WmsItemBrandRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get product brand page.")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:query')")
    public CommonResult<PageResult<WmsItemBrandRespVO>> getItemBrandPage(@Valid WmsItemBrandPageReqVO pageReqVO) {
        PageResult<WmsItemBrandDO> pageResult = brandService.getItemBrandPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, WmsItemBrandRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get product brand simple list.", description = "Used by frontend dropdowns.")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:query')")
    public CommonResult<List<WmsItemBrandRespVO>> getItemBrandSimpleList() {
        List<WmsItemBrandDO> list = brandService.getItemBrandList();
        return success(BeanUtils.toBean(list, WmsItemBrandRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportproduct brand Excel.")
    @PreAuthorize("@ss.hasPermission('wms:item-brand:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportItemBrandExcel(@Valid WmsItemBrandPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<WmsItemBrandDO> list = brandService.getItemBrandPage(pageReqVO).getList();
        ExcelUtils.write(response, "Product Brands.xls", "Data", WmsItemBrandRespVO.class,
                BeanUtils.toBean(list, WmsItemBrandRespVO.class));
    }

}
