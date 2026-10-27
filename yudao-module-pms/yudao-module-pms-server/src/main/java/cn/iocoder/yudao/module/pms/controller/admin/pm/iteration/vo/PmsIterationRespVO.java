package cn.iocoder.yudao.module.pms.controller.admin.pm.iteration.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS item sprint response.")
@Data
public class PmsIterationRespVO {

    @Schema(description = "Sprint code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long projectId;

    @Schema(description = "Sprint name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Phase 1")
    private String name;

    @Schema(description = "Owner person user ID.", example = "1")
    private Long ownerUserId;

    @Schema(description = "Sprint status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Owner person Name.", example = "Overall.")
    private String ownerUserName;

    @Schema(description = "Start time.")
    private LocalDateTime startTime;

    @Schema(description = "End time.")
    private LocalDateTime endTime;

    @Schema(description = "Sprint target.", example = "Finish the core workflow")
    private String target;

    @Schema(description = "Sprint Description.")
    private String description;

    @Schema(description = "Complete time.")
    private LocalDateTime finishTime;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Completion percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer progress;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
