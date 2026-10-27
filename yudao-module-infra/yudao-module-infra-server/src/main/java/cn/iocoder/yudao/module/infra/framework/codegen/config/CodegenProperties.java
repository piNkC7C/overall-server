package cn.iocoder.yudao.module.infra.framework.codegen.config;

import cn.iocoder.yudao.module.infra.enums.codegen.CodegenFrontTypeEnum;
import cn.iocoder.yudao.module.infra.enums.codegen.CodegenVOTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;

@ConfigurationProperties(prefix = "yudao.codegen")
@Validated
@Data
public class CodegenProperties {

    /**
     * 生成的 Java 代码的基础包
     */
    @NotNull(message = "Java base package cannot be empty.")
    private String basePackage;

    /**
     * 数据库名数组
     */
    @NotEmpty(message = "Database cannot be empty.")
    private Collection<String> dbSchemas;

    /**
     * 代码生成的前端类型（默认）
     *
     * 枚举 {@link CodegenFrontTypeEnum#getType()}
     */
    @NotNull(message = "Codegen frontend type cannot be empty.")
    private Integer frontType;

    /**
     * 代码生成的 VO 类型
     *
     * 枚举 {@link CodegenVOTypeEnum#getType()}
     */
    @NotNull(message = "Codegen VO type cannot be empty.")
    private Integer voType;

    /**
     * 是否生成批量删除接口
     */
    @NotNull(message = "Is not create batch delete interface is required.")
    private Boolean deleteBatchEnable;

    /**
     * 是否生成单元测试
     */
    @NotNull(message = "Generate unit tests cannot be empty.")
    private Boolean unitTestEnable;

    /**
     * 是否生成 Excel 导入接口
     */
    @NotNull(message = "Is not create Excel import interface is required.")
    private Boolean importEnable;

}
