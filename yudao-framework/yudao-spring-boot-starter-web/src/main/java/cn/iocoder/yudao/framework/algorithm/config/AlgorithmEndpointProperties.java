package cn.iocoder.yudao.framework.algorithm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 外部算法服务命名端点。助手、监测等业务按 name 取 base-url，避免各模块各写一套地址。
 */
@ConfigurationProperties(prefix = "yudao.algorithm")
@Data
public class AlgorithmEndpointProperties {

    /**
     * 端点名 → 连接配置。例如 assistant、monitor。
     */
    private Map<String, Endpoint> endpoints = new LinkedHashMap<>();

    @Data
    public static class Endpoint {

        /** 例如 http://192.168.110.39:8001 */
        private String baseUrl = "";

        /** TCP 连接超时 */
        private Duration connectTimeout = Duration.ofSeconds(10);

        /**
         * 单次 HTTP 请求超时（读响应）。未配时默认 connectTimeout + 120s。
         * 预检等长耗时可在调用处覆盖。
         */
        private Duration requestTimeout;

    }

}
