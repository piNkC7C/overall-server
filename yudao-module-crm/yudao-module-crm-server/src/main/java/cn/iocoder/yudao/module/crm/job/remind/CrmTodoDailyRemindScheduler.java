package cn.iocoder.yudao.module.crm.job.remind;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.crm.service.remind.CrmTodoRemindService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地兜底：无 XXL-JOB 调度中心时，仍按每天 9:00（Asia/Shanghai）推送 CRM 待办。
 * 与 {@link CrmTodoDailyRemindJob} 共用 Redis 日去重，不会重复推送。
 */
@Component
@Slf4j
public class CrmTodoDailyRemindScheduler {

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private CrmTodoRemindService crmTodoRemindService;

    @Scheduled(cron = "0 0 9 * * ?", zone = "Asia/Shanghai")
    public void remindAtNine() {
        List<Long> tenantIds;
        try {
            tenantIds = tenantCommonApi.getTenantIdList().getCheckedData();
        } catch (Exception ex) {
            log.warn("[remindAtNine][获取租户列表失败]", ex);
            return;
        }
        if (CollUtil.isEmpty(tenantIds)) {
            return;
        }
        for (Long tenantId : tenantIds) {
            try {
                TenantUtils.execute(tenantId, () -> {
                    int count = crmTodoRemindService.sendDailyTodoRemind();
                    log.info("[remindAtNine][tenantId({}) sent={}]", tenantId, count);
                });
            } catch (Exception ex) {
                log.warn("[remindAtNine][tenantId({}) 推送失败]", tenantId, ex);
            }
        }
    }

}
