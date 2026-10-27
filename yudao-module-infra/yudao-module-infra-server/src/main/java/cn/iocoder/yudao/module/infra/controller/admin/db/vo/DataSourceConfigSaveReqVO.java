package cn.iocoder.yudao.module.infra.controller.admin.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - data sourcesetting create or update request.")
@Data
public class DataSourceConfigSaveReqVO {

    @Schema(description = "Primary key code.", example = "1024")
    private Long id;

    @Schema(description = "Data source name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @NotNull(message = "Data source name is required.")
    private String name;

    @Schema(description = "Data source connect.", requiredMode = Schema.RequiredMode.REQUIRED, example = "jdbc:mysql://127.0.0.1:3306/ruoyi-vue-pro")
    @NotNull(message = "Data source connect is required.")
    private String url;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "root")
    @NotNull(message = "Username is required.")
    private String username;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "Password is required.")
    private String password;

}
