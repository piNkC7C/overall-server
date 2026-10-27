package cn.iocoder.yudao.module.pms.controller.admin.pm.workbench.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS workbenchwork item response.")
@Data
public class PmsWorkbenchWorkItemRespVO {

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long projectId;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Shop item.")
    private String projectName;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer projectType;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer type;

    @Schema(description = "Work item No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer serialNumber;

    @Schema(description = "Work item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Improve the sign-in page")
    private String name;

    @Schema(description = "Priority", example = "2")
    private Integer priority;

    @Schema(description = "Owner person user ID.", example = "1024")
    private Long assigneeUserId;

    @Schema(description = "Owner person Name.", example = "Overall.")
    private String assigneeUserName;

    @Schema(description = "Creator user ID.", example = "2048")
    private Long creatorUserId;

    @Schema(description = "Creator Name.", example = "Source")
    private String creatorUserName;

    @Schema(description = "Status code.", example = "1")
    private Long statusId;

    @Schema(description = "Status name.", example = "In progress.")
    private String statusName;

    @Schema(description = "Semantic status", example = "2")
    private Integer status;

    @Schema(description = "Progress.", example = "60")
    private Integer progress;

    @Schema(description = "Start time.", example = "2026-01-01 10:00:00")
    private LocalDateTime startTime;

    @Schema(description = "End time.", example = "2026-01-31 18:00:00")
    private LocalDateTime endTime;

    @Schema(description = "Is not can edit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean writeStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
