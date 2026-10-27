package cn.iocoder.yudao.module.infra.framework.file.core.client.sftp;

import cn.iocoder.yudao.module.infra.framework.file.core.client.FileClientConfig;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * Sftp 文件客户端的配置类
 *
 * @author 芋道源码
 */
@Data
public class SftpFileClientConfig implements FileClientConfig {

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

    /**
     * 主机地址
     */
    @NotEmpty(message = "Host is required.")
    private String host;
    /**
     * 主机端口
     */
    @NotNull(message = "Port is required.")
    private Integer port;
    /**
     * 用户名
     */
    @NotEmpty(message = "Username is required.")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "Password is required.")
    private String password;

}
