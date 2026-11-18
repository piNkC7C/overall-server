package cn.iocoder.yudao.module.crm.job.remind;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.quartz.config.ConditionalOnXxlJobDisabled;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.crm.service.remind.CrmEntityRemindService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地兜底：无 XXL-JOB 时每分钟扫描 CRM 实体提醒（跟进 / 公海 / 合同到期）。
 * 与 {@link CrmEntityRemindJob} 共用 reminded 打标，不会重复推送。
 */
@Component
@ConditionalOnXxlJobDisabled
@Slf4j
public class CrmEntityRemindScheduler {

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private CrmEntityRemindService crmEntityRemindService;

    @Scheduled(cron = "0 * * * * ?", zone = "Asia/Shanghai")
    public void remindEveryMinute() {
        List<Long> tenantIds;
        try {
            tenantIds = tenantCommonApi.getTenantIdList().getCheckedData();
        } catch (Exception ex) {
            log.warn("[remindEveryMinute][获取租户列表失败]", ex);
            return;
        }
        if (CollUtil.isEmpty(tenantIds)) {
            return;
        }
        for (Long tenantId : tenantIds) {
            try {
                TenantUtils.execute(tenantId, () -> {
                    int count = crmEntityRemindService.sendDueEntityReminds();
                    if (count > 0) {
                        log.info("[remindEveryMinute][tenantId({}) sent={}]", tenantId, count);
                    }
                });
            } catch (Exception ex) {
                log.warn("[remindEveryMinute][tenantId({}) 推送失败]", tenantId, ex);
            }
        }
    }

}
