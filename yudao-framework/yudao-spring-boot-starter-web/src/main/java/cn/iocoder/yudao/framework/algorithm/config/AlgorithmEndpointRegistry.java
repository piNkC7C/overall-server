package cn.iocoder.yudao.framework.algorithm.config;

import cn.hutool.core.util.StrUtil;

import java.util.Optional;

/**
 * 按名称解析算法端点。
 */
public class AlgorithmEndpointRegistry {

    public static final String ASSISTANT = "assistant";
    public static final String MONITOR = "monitor";

    private final AlgorithmEndpointProperties properties;

    public AlgorithmEndpointRegistry(AlgorithmEndpointProperties properties) {
        this.properties = properties;
    }

    public Optional<AlgorithmEndpointProperties.Endpoint> find(String name) {
        if (StrUtil.isBlank(name) || properties.getEndpoints() == null) {
            return Optional.empty();
        }
        AlgorithmEndpointProperties.Endpoint endpoint = properties.getEndpoints().get(name.trim());
        if (endpoint == null || StrUtil.isBlank(endpoint.getBaseUrl())) {
            return Optional.empty();
        }
        return Optional.of(endpoint);
    }

    public AlgorithmEndpointProperties.Endpoint require(String name) {
        return find(name).orElseThrow(() ->
                new IllegalStateException("Algorithm endpoint not configured: " + name));
    }

}
