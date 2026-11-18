package cn.iocoder.yudao.module.infra.job.logger;

import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.infra.service.logger.ApiErrorLogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 本地兜底：无 XXL-JOB 时清理过期错误日志。
 * 与 {@link ErrorLogCleanJob} 同逻辑。
 */
@Component
@Slf4j
public class ErrorLogCleanScheduler {

    private static final Integer JOB_CLEAN_RETAIN_DAY = 14;
    private static final Integer DELETE_LIMIT = 100;

    @Resource
    private ApiErrorLogService apiErrorLogService;

    @Scheduled(cron = "0 45 3 * * ?", zone = "Asia/Shanghai")
    @TenantIgnore
    public void cleanDaily() {
        Integer count = apiErrorLogService.cleanErrorLog(JOB_CLEAN_RETAIN_DAY, DELETE_LIMIT);
        if (count != null && count > 0) {
            log.info("[cleanDaily][errorLog={}]", count);
        }
    }

}
