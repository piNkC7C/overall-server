package cn.iocoder.yudao.module.system.job.token;

import cn.iocoder.yudao.framework.quartz.config.ConditionalOnXxlJobDisabled;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.system.service.oauth2.OAuth2TokenService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 本地兜底：无 XXL-JOB 时清理过期 OAuth2 令牌。
 * 与 {@link TokenCleanJob} 同逻辑。
 */
@Component
@ConditionalOnXxlJobDisabled
@Slf4j
public class TokenCleanScheduler {

    private static final Integer JOB_CLEAN_RETAIN_DAY = 14;
    private static final Integer DELETE_LIMIT = 100;

    @Resource
    private OAuth2TokenService oauth2TokenService;

    @Scheduled(cron = "0 15 3 * * ?", zone = "Asia/Shanghai")
    @TenantIgnore
    public void cleanDaily() {
        Integer refreshCount = oauth2TokenService.cleanRefreshToken(JOB_CLEAN_RETAIN_DAY, DELETE_LIMIT);
        Integer accessCount = oauth2TokenService.cleanAccessToken(JOB_CLEAN_RETAIN_DAY, DELETE_LIMIT);
        if ((refreshCount != null && refreshCount > 0) || (accessCount != null && accessCount > 0)) {
            log.info("[cleanDaily][refresh={} access={}]", refreshCount, accessCount);
        }
    }

}
