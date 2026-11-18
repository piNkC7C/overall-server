package cn.iocoder.yudao.module.oa.job.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.oa.service.schedule.OaScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地兜底：无 XXL-JOB 时每分钟扫描 OA 日程提醒。
 * 与 {@link OaScheduleReminderJob} 共用 {@link OaScheduleService#sendScheduleReminders()}。
 */
@Component
@Slf4j
public class OaScheduleReminderScheduler {

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private OaScheduleService scheduleService;

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
                    int count = scheduleService.sendScheduleReminders();
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
