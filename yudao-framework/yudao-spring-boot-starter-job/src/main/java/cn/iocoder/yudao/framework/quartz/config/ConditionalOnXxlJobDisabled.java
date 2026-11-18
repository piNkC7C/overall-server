package cn.iocoder.yudao.framework.quartz.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 仅在关闭 XXL 执行器时生效（本地 {@code @Scheduled} 兜底）。
 * 生产打开 {@code xxl.job.enabled=true} 后不加载，避免与 XXL 双跑。
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnProperty(prefix = "xxl.job", name = "enabled", havingValue = "false")
public @interface ConditionalOnXxlJobDisabled {
}
