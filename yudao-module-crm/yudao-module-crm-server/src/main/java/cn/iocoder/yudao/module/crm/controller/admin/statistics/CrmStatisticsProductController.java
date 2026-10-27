package cn.iocoder.yudao.module.crm.controller.admin.statistics;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product.CrmStatisticsProductCategoryRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product.CrmStatisticsProductReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product.CrmStatisticsProductSalesRespVO;
import cn.iocoder.yudao.module.crm.service.statistics.CrmStatisticsProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - CRM productStats.")
@RestController
@RequestMapping("/crm/statistics-product")
@Validated
public class CrmStatisticsProductController {

    @Resource
    private CrmStatisticsProductService productService;

    @GetMapping("/get-product-sales-list")
    @Operation(summary = "Get product sales stats.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-product:query')")
    public CommonResult<List<CrmStatisticsProductSalesRespVO>> getProductSalesList(@Valid CrmStatisticsProductReqVO reqVO) {
        return success(productService.getProductSalesList(reqVO));
    }

    @GetMapping("/get-product-category-summary")
    @Operation(summary = "Get product-category sales analysis.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-product:query')")
    public CommonResult<List<CrmStatisticsProductCategoryRespVO>> getProductCategorySummary(@Valid CrmStatisticsProductReqVO reqVO) {
        return success(productService.getProductCategorySummary(reqVO));
    }

}
