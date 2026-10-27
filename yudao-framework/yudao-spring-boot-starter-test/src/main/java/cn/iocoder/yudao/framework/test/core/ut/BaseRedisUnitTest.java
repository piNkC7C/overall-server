package cn.iocoder.yudao.framework.test.core.ut;

import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.redis.config.YudaoRedisAutoConfiguration;
import cn.iocoder.yudao.framework.test.config.RedisTestConfiguration;
import org.redisson.spring.starter.RedissonAutoConfigurationV4;
import org.springframework.boot.data.redis.autoconfigure.DataRedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * 依赖内存 Redis 的单元测试
 *
 * 相比 {@link BaseDbUnitTest} 来说，从内存 DB 改成了内存 Redis
 *
 * @author 芋道源码
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseRedisUnitTest.Application.class)
@ActiveProfiles("unit-test") // Set used application-unit-test setting file
public class BaseRedisUnitTest {

    @Import({
            // Redis setting class
            RedisTestConfiguration.class, // Redis 测试配置类，用于启动 RedisServer
            DataRedisAutoConfiguration.class, // Spring Redis Autosetting class
            YudaoRedisAutoConfiguration.class, // Its own Redis setting class
            RedissonAutoConfigurationV4.class, // Redisson Autosetting class

            // Other setting class
            SpringUtil.class
    })
    public static class Application {
    }

}
