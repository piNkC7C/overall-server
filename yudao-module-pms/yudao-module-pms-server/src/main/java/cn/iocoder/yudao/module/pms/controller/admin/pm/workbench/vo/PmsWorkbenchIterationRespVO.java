package cn.iocoder.yudao.module.pms.controller.admin.pm.workbench.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS workbenchsprint response.")
@Data
public class PmsWorkbenchIterationRespVO {

    @Schema(description = "Sprint code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long projectId;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Shop item.")
    private String projectName;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer projectType;

    @Schema(description = "Sprint name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "First sprint")
    private String name;

    @Schema(description = "Sprint status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @Schema(description = "Start time.", example = "2026-01-01 00:00:00")
    private LocalDateTime startTime;

    @Schema(description = "End time.", example = "2026-01-31 23:59:59")
    private LocalDateTime endTime;

    @Schema(description = "Sprint target.", example = "Complete sign-in module.")
    private String target;

}
