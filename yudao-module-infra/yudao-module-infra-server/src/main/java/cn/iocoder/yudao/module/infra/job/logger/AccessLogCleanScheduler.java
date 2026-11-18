package cn.iocoder.yudao.module.infra.job.logger;

import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.infra.service.logger.ApiAccessLogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 本地兜底：无 XXL-JOB 时清理过期访问日志。
 * 与 {@link AccessLogCleanJob} 同逻辑。
 */
@Component
@Slf4j
public class AccessLogCleanScheduler {

    private static final Integer JOB_CLEAN_RETAIN_DAY = 14;
    private static final Integer DELETE_LIMIT = 100;

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @Scheduled(cron = "0 30 3 * * ?", zone = "Asia/Shanghai")
    @TenantIgnore
    public void cleanDaily() {
        Integer count = apiAccessLogService.cleanAccessLog(JOB_CLEAN_RETAIN_DAY, DELETE_LIMIT);
        if (count != null && count > 0) {
            log.info("[cleanDaily][accessLog={}]", count);
        }
    }

}
