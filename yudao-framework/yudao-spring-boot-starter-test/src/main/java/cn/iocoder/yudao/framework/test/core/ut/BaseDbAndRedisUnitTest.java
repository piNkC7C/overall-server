package cn.iocoder.yudao.framework.test.core.ut;

import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.datasource.config.YudaoDataSourceAutoConfiguration;
import cn.iocoder.yudao.framework.mybatis.config.YudaoMybatisAutoConfiguration;
import cn.iocoder.yudao.framework.redis.config.YudaoRedisAutoConfiguration;
import cn.iocoder.yudao.framework.test.config.RedisTestConfiguration;
import cn.iocoder.yudao.framework.test.config.SqlInitializationTestConfiguration;
import com.alibaba.druid.spring.boot4.autoconfigure.DruidDataSourceAutoConfigure;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfigurationV4;
import org.springframework.boot.data.redis.autoconfigure.DataRedisAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

/**
 * 依赖内存 DB + Redis 的单元测试
 *
 * 相比 {@link BaseDbUnitTest} 来说，额外增加了内存 Redis
 *
 * @author 芋道源码
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseDbAndRedisUnitTest.Application.class)
@ActiveProfiles("unit-test") // Set used application-unit-test setting file
@Sql(scripts = "/sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD) // 每个单元测试结束后，清理 DB
public class BaseDbAndRedisUnitTest {

    @Import({
            // DB setting class
            YudaoDataSourceAutoConfiguration.class, // Its own DB setting class
            DataSourceAutoConfiguration.class, // Spring DB Autosetting class
            DataSourceTransactionManagerAutoConfiguration.class, // Spring 事务自动配置类
            DruidDataSourceAutoConfigure.class, // Druid Autosetting class
            SqlInitializationTestConfiguration.class, // SQL 初始化
            // MyBatis setting class
            YudaoMybatisAutoConfiguration.class, // Its own MyBatis setting class
            MybatisPlusAutoConfiguration.class, // MyBatis Autosetting class

            // Redis setting class
            RedisTestConfiguration.class, // Redis 测试配置类，用于启动 RedisServer
            YudaoRedisAutoConfiguration.class, // Its own Redis setting class
            DataRedisAutoConfiguration.class, // Spring Redis Autosetting class
            RedissonAutoConfigurationV4.class, // Redisson Autosetting class

            // Other setting class
            SpringUtil.class
    })
    public static class Application {
    }

}
