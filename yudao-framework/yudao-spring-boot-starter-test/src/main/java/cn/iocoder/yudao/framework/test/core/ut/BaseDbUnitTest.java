package cn.iocoder.yudao.framework.test.core.ut;

import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.datasource.config.YudaoDataSourceAutoConfiguration;
import cn.iocoder.yudao.framework.mybatis.config.YudaoMybatisAutoConfiguration;
import cn.iocoder.yudao.framework.test.config.SqlInitializationTestConfiguration;
import com.alibaba.druid.spring.boot4.autoconfigure.DruidDataSourceAutoConfigure;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.github.yulichang.autoconfigure.MybatisPlusJoinAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

/**
 * 依赖内存 DB 的单元测试
 *
 * 注意，Service 层同样适用。对于 Service 层的单元测试，我们针对自己模块的 Mapper 走的是 H2 内存数据库，针对别的模块的 Service 走的是 Mock 方法
 *
 * @author 芋道源码
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseDbUnitTest.Application.class)
@ActiveProfiles("unit-test") // Set used application-unit-test setting file
@Sql(scripts = "/sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD) // 每个单元测试结束后，清理 DB
public class BaseDbUnitTest {

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
            MybatisPlusJoinAutoConfiguration.class, // MyBatis Joinsetting class

            // Other setting class
            SpringUtil.class
    })
    public static class Application {
    }

}
