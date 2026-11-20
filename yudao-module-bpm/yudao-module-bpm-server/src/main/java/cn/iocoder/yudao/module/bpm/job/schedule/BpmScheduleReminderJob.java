package cn.iocoder.yudao.module.bpm.job.schedule;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.bpm.service.schedule.BpmScheduleService;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * BPM 我的日程提醒 Job
 */
@Component
public class BpmScheduleReminderJob {

    @Resource
    private BpmScheduleService scheduleService;

    @XxlJob("bpmScheduleReminderJob")
    @TenantJob
    public String execute() {
        int count = scheduleService.sendScheduleReminders();
        return StrUtil.format("Sent {} schedule reminders", count);
    }

}
