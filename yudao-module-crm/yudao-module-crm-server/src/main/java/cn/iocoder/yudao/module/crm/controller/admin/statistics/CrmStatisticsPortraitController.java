package cn.iocoder.yudao.module.crm.controller.admin.statistics;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.portrait.*;
import cn.iocoder.yudao.module.crm.service.statistics.CrmStatisticsPortraitService;
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

@Tag(name = "Admin - CRM Customer Portrait.")
@RestController
@RequestMapping("/crm/statistics-portrait")
@Validated
public class CrmStatisticsPortraitController {

    @Resource
    private CrmStatisticsPortraitService statisticsPortraitService;

    @GetMapping("/get-customer-area-summary")
    @Operation(summary = "Get Customer Region stats data.", description = "Used by the City Distribution page.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-portrait:query')")
    public CommonResult<List<CrmStatisticCustomerAreaRespVO>> getCustomerAreaSummary(@Valid CrmStatisticsPortraitReqVO reqVO) {
        return success(statisticsPortraitService.getCustomerSummaryByArea(reqVO));
    }

    @GetMapping("/get-customer-industry-summary")
    @Operation(summary = "Get IndustryStats data.", description = "Used for [ customer-industry analysis ] page.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-portrait:query')")
    public CommonResult<List<CrmStatisticCustomerIndustryRespVO>> getCustomerIndustrySummary(@Valid CrmStatisticsPortraitReqVO reqVO) {
        return success(statisticsPortraitService.getCustomerSummaryByIndustry(reqVO));
    }

    @GetMapping("/get-customer-level-summary")
    @Operation(summary = "Get customer level Stats data.", description = "Used for [ customer-level analysis ] page.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-portrait:query')")
    public CommonResult<List<CrmStatisticCustomerLevelRespVO>> getCustomerLevelSummary(@Valid CrmStatisticsPortraitReqVO reqVO) {
        return success(statisticsPortraitService.getCustomerSummaryByLevel(reqVO));
    }

    @GetMapping("/get-customer-source-summary")
    @Operation(summary = "Get customer source Stats data.", description = "Used for [ customer-source analysis ] page.")
    @PreAuthorize("@ss.hasPermission('crm:statistics-portrait:query')")
    public CommonResult<List<CrmStatisticCustomerSourceRespVO>> getCustomerSourceSummary(@Valid CrmStatisticsPortraitReqVO reqVO) {
        return success(statisticsPortraitService.getCustomerSummaryBySource(reqVO));
    }

}
