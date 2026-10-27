package cn.iocoder.yudao.framework.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.validation.constraints.NotEmpty;

/**
 * Swagger 配置属性
 *
 * @author 芋道源码
 */
@ConfigurationProperties("yudao.swagger")
@Data
public class SwaggerProperties {

    /**
     * 标题
     */
    @NotEmpty(message = "Title is required.")
    private String title;
    /**
     * 描述
     */
    @NotEmpty(message = "Description is required.")
    private String description;
    /**
     * 作者
     */
    @NotEmpty(message = "Author is required.")
    private String author;
    /**
     * 版本
     */
    @NotEmpty(message = "Version is required.")
    private String version;
    /**
     * url
     */
    @NotEmpty(message = "Scanned package cannot be empty.")
    private String url;
    /**
     * email
     */
    @NotEmpty(message = "Scanned email cannot be empty.")
    private String email;

    /**
     * license
     */
    @NotEmpty(message = "Scanned license cannot be empty.")
    private String license;

    /**
     * license-url
     */
    @NotEmpty(message = "Scanned license-url cannot be empty.")
    private String licenseUrl;

}
