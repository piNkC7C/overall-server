package cn.iocoder.yudao.module.wms.controller.admin.md.merchant;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo.WmsMerchantListReqVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo.WmsMerchantPageReqVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo.WmsMerchantRespVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo.WmsMerchantSaveReqVO;
import cn.iocoder.yudao.module.wms.dal.dataobject.md.merchant.WmsMerchantDO;
import cn.iocoder.yudao.module.wms.service.md.merchant.WmsMerchantService;
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

@Tag(name = "Admin - WMS business partner.")
@RestController
@RequestMapping("/wms/merchant")
@Validated
public class WmsMerchantController {

    @Resource
    private WmsMerchantService merchantService;

    @PostMapping("/create")
    @Operation(summary = "Create business partner.")
    @PreAuthorize("@ss.hasPermission('wms:merchant:create')")
    public CommonResult<Long> createMerchant(@Valid @RequestBody WmsMerchantSaveReqVO createReqVO) {
        return success(merchantService.createMerchant(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update business partner.")
    @PreAuthorize("@ss.hasPermission('wms:merchant:update')")
    public CommonResult<Boolean> updateMerchant(@Valid @RequestBody WmsMerchantSaveReqVO updateReqVO) {
        merchantService.updateMerchant(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete business partner.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('wms:merchant:delete')")
    public CommonResult<Boolean> deleteMerchant(@RequestParam("id") Long id) {
        merchantService.deleteMerchant(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get business partner.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('wms:merchant:query')")
    public CommonResult<WmsMerchantRespVO> getMerchant(@RequestParam("id") Long id) {
        WmsMerchantDO merchant = merchantService.getMerchant(id);
        return success(BeanUtils.toBean(merchant, WmsMerchantRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get business partner page.")
    @PreAuthorize("@ss.hasPermission('wms:merchant:query')")
    public CommonResult<PageResult<WmsMerchantRespVO>> getMerchantPage(@Valid WmsMerchantPageReqVO pageReqVO) {
        PageResult<WmsMerchantDO> pageResult = merchantService.getMerchantPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, WmsMerchantRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get business partner simple list.", description = "Used by frontend dropdowns.")
    @PreAuthorize("@ss.hasPermission('wms:merchant:query')")
    public CommonResult<List<WmsMerchantRespVO>> getMerchantSimpleList(@Valid WmsMerchantListReqVO listReqVO) {
        List<WmsMerchantDO> list = merchantService.getMerchantList(listReqVO);
        return success(BeanUtils.toBean(list, WmsMerchantRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export business partner Excel.")
    @PreAuthorize("@ss.hasPermission('wms:merchant:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMerchantExcel(@Valid WmsMerchantPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<WmsMerchantDO> list = merchantService.getMerchantPage(pageReqVO).getList();
        ExcelUtils.write(response, "Business Partners.xls", "Data", WmsMerchantRespVO.class,
                BeanUtils.toBean(list, WmsMerchantRespVO.class));
    }

}
