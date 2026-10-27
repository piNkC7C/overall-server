package cn.iocoder.yudao.module.infra.controller.admin.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Admin - setting create or update request.")
@Data
public class ConfigSaveReqVO {

    @Schema(description = "SettingNo.", example = "1024")
    private Long id;

    @Schema(description = "Parameter group.", requiredMode = Schema.RequiredMode.REQUIRED, example = "biz")
    @NotEmpty(message = "Parameter group is required.")
    @Size(max = 50, message = "Parameter name cannot exceed 50 characters.")
    private String category;

    @Schema(description = "Parameter name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Database name")
    @NotBlank(message = "Parameter name is required.")
    @Size(max = 100, message = "Parameter name cannot exceed 100 characters.")
    private String name;

    @Schema(description = "Config key", requiredMode = Schema.RequiredMode.REQUIRED, example = "yunai.db.username")
    @NotBlank(message = "Config key length is required.")
    @Size(max = 100, message = "Config key length cannot exceed 100 characters.")
    private String key;

    @Schema(description = "Config value", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotBlank(message = "Config value is required.")
    @Size(max = 500, message = "Config value length cannot exceed 500 characters.")
    private String value;

    @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Visible is required.")
    private Boolean visible;

    @Schema(description = "Notes.", example = "Just a cool note!")
    private String remark;

}
