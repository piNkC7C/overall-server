package cn.iocoder.yudao.module.infra.controller.admin.file.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "管理后台 - 文件配置创建/修改 Request VO")
@Data
public class FileConfigSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "配置名", requiredMode = Schema.RequiredMode.REQUIRED, example = "S3 - AWS")
    @NotNull(message = "Config name is required.")
    private String name;

    @Schema(description = "存储器，参见 FileStorageEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Storage is required.")
    private Integer storage;

    @Schema(description = "存储配置,配置是动态参数，所以使用 Map 接收", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Storage setting is required.")
    private Map<String, Object> config;

    @Schema(description = "备注", example = "Sample notes")
    private String remark;

}
