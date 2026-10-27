package cn.iocoder.yudao.module.ai.framework.ai.core.webserch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AiWebSearchRequest {

    /**
     * 用户的搜索词
     */
    @NotEmpty(message = "Search term cannot be empty.")
    private String query;

    /**
     * 是否显示文本摘要
     *
     * true - 显示
     * false - 不显示（默认）
     */
    private Boolean summary;

    /**
     * 返回结果的条数
     */
    @NotNull(message = "Result count cannot be empty.")
    @Min(message = "Result count must be at least 1.", value = 1)
    @Max(message = "Result count cannot exceed 50.", value = 50)
    private Integer count;

}
