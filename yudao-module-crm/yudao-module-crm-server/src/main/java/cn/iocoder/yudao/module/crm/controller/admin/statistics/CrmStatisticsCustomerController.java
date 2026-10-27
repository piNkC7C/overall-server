package cn.iocoder.yudao.module.crm.controller.admin.statistics;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer.*;
import cn.iocoder.yudao.module.crm.service.statistics.CrmStatisticsCustomerService;
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

@Tag(name = "Admin - CRM customerStats.")
@RestController
@RequestMapping("/crm/statistics-customer")
@Validated
public class CrmStatisticsCustomerController {

    @Resource
    private CrmStatisticsCustomerService customerService;

    @GetMapping("/get-customer-summary-by-date")
    @Operation(summary = "Get customer-volume analysis (by date).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerSummaryByDateRespVO>> getCustomerSummaryByDate(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerSummaryByDate(reqVO));
    }

    @GetMapping("/get-customer-summary-by-user")
    @Operation(summary = "Get customer-volume analysis (by user).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerSummaryByUserRespVO>> getCustomerSummaryByUser(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerSummaryByUser(reqVO));
    }

    @GetMapping("/get-follow-up-summary-by-date")
    @Operation(summary = "Get customer follow-up count analysis (by date).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsFollowUpSummaryByDateRespVO>> getFollowupSummaryByDate(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getFollowUpSummaryByDate(reqVO));
    }

    @GetMapping("/get-follow-up-summary-by-user")
    @Operation(summary = "Get customer follow-up count analysis (by user).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsFollowUpSummaryByUserRespVO>> getFollowUpSummaryByUser(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getFollowUpSummaryByUser(reqVO));
    }

    @GetMapping("/get-follow-up-summary-by-type")
    @Operation(summary = "Get customer follow-up count analysis (by type).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsFollowUpSummaryByTypeRespVO>> getFollowUpSummaryByType(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getFollowUpSummaryByType(reqVO));
    }

    @GetMapping("/get-contract-summary")
    @Operation(summary = "Get each customer's first contract and collection.", description = "Used by the Customer Conversion page.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerContractSummaryRespVO>> getContractSummary(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getContractSummary(reqVO));
    }

    @GetMapping("/get-pool-summary-by-date")
    @Operation(summary = "Get pool-customer analysis (by date).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsPoolSummaryByDateRespVO>> getPoolSummaryByDate(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getPoolSummaryByDate(reqVO));
    }

    @GetMapping("/get-pool-summary-by-user")
    @Operation(summary = "Get pool-customer analysis (by user).")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsPoolSummaryByUserRespVO>> getPoolSummaryByUser(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getPoolSummaryByUser(reqVO));
    }

    @GetMapping("/get-customer-deal-cycle-by-date")
    @Operation(summary = "Get customer deal cycle by date.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerDealCycleByDateRespVO>> getCustomerDealCycleByDate(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerDealCycleByDate(reqVO));
    }

    @GetMapping("/get-customer-deal-cycle-by-user")
    @Operation(summary = "Customer win cycle by user.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerDealCycleByUserRespVO>> getCustomerDealCycleByUser(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerDealCycleByUser(reqVO));
    }

    @GetMapping("/get-customer-deal-cycle-by-area")
    @Operation(summary = "Customer win cycle by user.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerDealCycleByAreaRespVO>> getCustomerDealCycleByArea(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerDealCycleByArea(reqVO));
    }

    @GetMapping("/get-customer-deal-cycle-by-product")
    @Operation(summary = "Customer win cycle by user.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-customer:query')")
    public CommonResult<List<CrmStatisticsCustomerDealCycleByProductRespVO>> getCustomerDealCycleByProduct(@Valid CrmStatisticsCustomerReqVO reqVO) {
        return success(customerService.getCustomerDealCycleByProduct(reqVO));
    }

}
