package cn.iocoder.yudao.module.infra.framework.file.core.client.db;

import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientConfig;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * 基于 DB 存储的文件客户端的配置类
 *
 * @author 芋道源码
 */
@Data
public class DBFileClientConfig implements FileClientConfig {

    /**
     * 自定义域名
     */
    @NotEmpty(message = "Domain is required.")
    @URL(message = "Domain must be URL format.")
    private String domain;

}
