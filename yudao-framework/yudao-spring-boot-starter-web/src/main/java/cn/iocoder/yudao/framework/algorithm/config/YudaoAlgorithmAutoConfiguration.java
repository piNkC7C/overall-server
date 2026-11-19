package cn.iocoder.yudao.framework.algorithm.config;

import cn.iocoder.yudao.framework.algorithm.core.AlgorithmHttpClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(AlgorithmEndpointProperties.class)
public class YudaoAlgorithmAutoConfiguration {

    @Bean
    public AlgorithmEndpointRegistry algorithmEndpointRegistry(AlgorithmEndpointProperties properties) {
        return new AlgorithmEndpointRegistry(properties);
    }

    @Bean
    public AlgorithmHttpClient algorithmHttpClient(AlgorithmEndpointRegistry registry) {
        return new AlgorithmHttpClient(registry);
    }

}
