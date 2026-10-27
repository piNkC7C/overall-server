package cn.iocoder.yudao.module.ai.tool.function;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN;

/**
 * 工具：查询指定城市的天气信息
 *
 * @author 芋道源码
 */
@Component("weather_query")
public class WeatherQueryToolFunction
        implements Function<WeatherQueryToolFunction.Request, WeatherQueryToolFunction.Response> {

    private static final String[] WEATHER_CONDITIONS = { "Sunny", "Cloudy", "Overcast", "Light rain", "Heavy rain", "Thunderstorm", "Light snow", "Heavy snow" };

    @Data
    @JsonClassDescription("Query weather for the specified city")
    public static class Request {

        /**
         * 城市名称
         */
        @JsonProperty(required = true, value = "city")
        @JsonPropertyDescription("City name, for example: New York, Chicago, Seattle")
        private String city;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        /**
         * 城市名称
         */
        private String city;

        /**
         * 天气信息
         */
        private WeatherInfo weatherInfo;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class WeatherInfo {

            /**
             * 温度（摄氏度）
             */
            private Integer temperature;

            /**
             * 天气状况
             */
            private String condition;

            /**
             * 湿度百分比
             */
            private Integer humidity;

            /**
             * 风速（km/h）
             */
            private Integer windSpeed;

            /**
             * 查询时间
             */
            private String queryTime;

        }

    }

    @Override
    public Response apply(Request request) {
        // 检查城市名称是否为空
        if (StrUtil.isBlank(request.getCity())) {
            return new Response("Unknown city", null);
        }

        // 获取天气数据
        String city = request.getCity();
        Response.WeatherInfo weatherInfo = generateMockWeatherInfo();
        return new Response(city, weatherInfo);
    }

    /**
     * 生成模拟的天气数据
     * 在实际应用中，应替换为真实 API 调用
     */
    private Response.WeatherInfo generateMockWeatherInfo() {
        int temperature = RandomUtil.randomInt(-5, 30);
        int humidity = RandomUtil.randomInt(1, 100);
        int windSpeed = RandomUtil.randomInt(1, 30);
        String condition = RandomUtil.randomEle(WEATHER_CONDITIONS);
        return new Response.WeatherInfo(temperature, condition, humidity, windSpeed,
                LocalDateTimeUtil.format(LocalDateTime.now(), NORM_DATETIME_PATTERN));
    }

}