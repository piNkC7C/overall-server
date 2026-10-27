package cn.iocoder.yudao.module.infra.controller.admin.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - data sourcesetting response.")
@Data
public class DataSourceConfigRespVO {

    @Schema(description = "Primary key code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Data source name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    private String name;

    @Schema(description = "Data source connect.", requiredMode = Schema.RequiredMode.REQUIRED, example = "jdbc:mysql://127.0.0.1:3306/ruoyi-vue-pro")
    private String url;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "root")
    private String username;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
