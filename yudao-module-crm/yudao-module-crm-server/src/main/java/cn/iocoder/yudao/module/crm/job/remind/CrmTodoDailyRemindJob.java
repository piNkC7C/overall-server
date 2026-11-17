package cn.iocoder.yudao.module.crm.job.remind;

import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.crm.service.remind.CrmTodoRemindService;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * CRM 待办每日提醒 Job（建议 XXL-JOB Cron：0 0 9 * * ?，每天 9:00）
 */
@Component
public class CrmTodoDailyRemindJob {

    @Resource
    private CrmTodoRemindService crmTodoRemindService;

    @XxlJob("crmTodoDailyRemindJob")
    @TenantJob
    public String execute() {
        int count = crmTodoRemindService.sendDailyTodoRemind();
        return String.format("Sent CRM todo remind to %s users", count);
    }

}
