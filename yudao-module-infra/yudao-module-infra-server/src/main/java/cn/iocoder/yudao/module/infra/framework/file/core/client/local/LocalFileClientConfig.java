package cn.iocoder.yudao.module.infra.framework.file.core.client.local;

import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientConfig;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * 本地文件客户端的配置类
 *
 * @author 芋道源码
 */
@Data
public class LocalFileClientConfig implements FileClientConfig {

    /**
     * 基础路径
     */
    @NotEmpty(message = "Base path cannot be empty.")
    private String basePath;

    /**
     * 自定义域名
     */
    @NotEmpty(message = "Domain is required.")
    @URL(message = "Domain must be URL format.")
    private String domain;

}
