package cn.iocoder.yudao.module.crm.job.remind;

import org.springframework.stereotype.Component;

/**
 * 已废弃：CRM 待办站内信改为 {@link CrmEntityRemindJob} 事件驱动。
 * 保留空类避免旧 XXL-JOB 配置找不到 Bean；请将调度改为 crmEntityRemindJob。
 */
@Component
@Deprecated
public class CrmTodoDailyRemindJob {
}
