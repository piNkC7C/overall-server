package cn.iocoder.yudao.module.crm.job.customer;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.quartz.config.ConditionalOnXxlJobDisabled;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地兜底：无 XXL-JOB 时每日将超时客户掉入公海。
 * 与 {@link CrmCustomerAutoPutPoolJob} 共用 {@link CrmCustomerService#autoPutCustomerPool()}。
 */
@Component
@ConditionalOnXxlJobDisabled
@Slf4j
public class CrmCustomerAutoPutPoolScheduler {

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private CrmCustomerService customerService;

    @Scheduled(cron = "0 0 1 * * ?", zone = "Asia/Shanghai")
    public void putPoolDaily() {
        List<Long> tenantIds;
        try {
            tenantIds = tenantCommonApi.getTenantIdList().getCheckedData();
        } catch (Exception ex) {
            log.warn("[putPoolDaily][获取租户列表失败]", ex);
            return;
        }
        if (CollUtil.isEmpty(tenantIds)) {
            return;
        }
        for (Long tenantId : tenantIds) {
            try {
                TenantUtils.execute(tenantId, () -> {
                    int count = customerService.autoPutCustomerPool();
                    if (count > 0) {
                        log.info("[putPoolDaily][tenantId({}) moved={}]", tenantId, count);
                    }
                });
            } catch (Exception ex) {
                log.warn("[putPoolDaily][tenantId({}) 掉公海失败]", tenantId, ex);
            }
        }
    }

}
