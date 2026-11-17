package cn.iocoder.yudao.module.crm.job.remind;

import org.springframework.stereotype.Component;

/**
 * 已废弃：不再每天 9:00 汇总推送；改由 {@link CrmEntityRemindScheduler} 分钟扫描。
 */
@Component
@Deprecated
public class CrmTodoDailyRemindScheduler {
}
