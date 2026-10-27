package cn.iocoder.yudao.module.crm.controller.admin.statistics;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.rank.CrmStatisticsRankReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.rank.CrmStatisticsRankRespVO;
import cn.iocoder.yudao.module.crm.service.statistics.CrmStatisticsRankService;
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

@Tag(name = "Admin - CRM Rankings.")
@RestController
@RequestMapping("/crm/statistics-rank")
@Validated
public class CrmStatisticsRankController {

    @Resource
    private CrmStatisticsRankService rankService;

    @GetMapping("/get-contract-price-rank")
    @Operation(summary = "Get the contract-amount ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getContractPriceRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getContractPriceRank(rankingReqVO));
    }

    @GetMapping("/get-receivable-price-rank")
    @Operation(summary = "Get the collection-amount ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getReceivablePriceRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getReceivablePriceRank(rankingReqVO));
    }

    @GetMapping("/get-contract-count-rank")
    @Operation(summary = "Get the signed-contract ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getContractCountRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getContractCountRank(rankingReqVO));
    }

    @GetMapping("/get-product-sales-rank")
    @Operation(summary = "Get the product-sales ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getProductSalesRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getProductSalesRank(rankingReqVO));
    }

    @GetMapping("/get-customer-count-rank")
    @Operation(summary = "Get the new-customer ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getCustomerCountRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getCustomerCountRank(rankingReqVO));
    }

    @GetMapping("/get-contacts-count-rank")
    @Operation(summary = "Get the new-contact ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getContactsCountRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getContactsCountRank(rankingReqVO));
    }

    @GetMapping("/get-follow-count-rank")
    @Operation(summary = "Get the follow-up count ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getFollowCountRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getFollowCountRank(rankingReqVO));
    }

    @GetMapping("/get-follow-customer-count-rank")
    @Operation(summary = "Get the followed-customer ranking.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-rank:query')")
    public CommonResult<List<CrmStatisticsRankRespVO>> getFollowCustomerCountRank(@Valid CrmStatisticsRankReqVO rankingReqVO) {
        return success(rankService.getFollowCustomerCountRank(rankingReqVO));
    }

}
