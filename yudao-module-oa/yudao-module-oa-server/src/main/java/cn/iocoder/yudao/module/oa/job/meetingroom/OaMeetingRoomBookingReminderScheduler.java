package cn.iocoder.yudao.module.oa.job.meetingroom;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.oa.service.meetingroom.OaMeetingRoomBookingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 本地兜底：无 XXL-JOB 时每分钟处理会议室过期预定与开始提醒。
 * 与 {@link OaMeetingRoomBookingReminderJob} 共用同一 Service 方法。
 */
@Component
@Slf4j
public class OaMeetingRoomBookingReminderScheduler {

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private OaMeetingRoomBookingService meetingRoomBookingService;

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
                    int expired = meetingRoomBookingService.cancelExpiredMeetingRoomBookings();
                    int sent = meetingRoomBookingService.sendMeetingRoomBookingReminders();
                    if (expired > 0 || sent > 0) {
                        log.info("[remindEveryMinute][tenantId({}) expired={} sent={}]",
                                tenantId, expired, sent);
                    }
                });
            } catch (Exception ex) {
                log.warn("[remindEveryMinute][tenantId({}) 处理失败]", tenantId, ex);
            }
        }
    }

}
