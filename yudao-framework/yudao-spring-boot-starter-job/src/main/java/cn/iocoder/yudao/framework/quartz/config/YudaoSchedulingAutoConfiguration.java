package cn.iocoder.yudao.framework.quartz.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 始终开启 Spring {@code @Scheduled}。
 * <p>
 * Overall 生产默认 {@code xxl.job.enabled=false}，不能依赖 {@link YudaoXxlJobAutoConfiguration}
 *（该配置带条件，关 XXL 时不会加载）。本地兜底 Scheduler 必须独立于此开关。
 */
@AutoConfiguration
@EnableScheduling
public class YudaoSchedulingAutoConfiguration {
}
