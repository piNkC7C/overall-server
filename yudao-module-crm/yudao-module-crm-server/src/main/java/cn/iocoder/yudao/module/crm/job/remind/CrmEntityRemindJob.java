package cn.iocoder.yudao.module.crm.job.remind;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.crm.service.remind.CrmEntityRemindService;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * CRM 实体事件提醒 Job（建议 XXL-JOB Cron：0 * * * * ?，每分钟）
 */
@Component
public class CrmEntityRemindJob {

    @Resource
    private CrmEntityRemindService crmEntityRemindService;

    @XxlJob("crmEntityRemindJob")
    @TenantJob
    public String execute() {
        int count = crmEntityRemindService.sendDueEntityReminds();
        return StrUtil.format("Sent {} CRM entity reminds", count);
    }

}
