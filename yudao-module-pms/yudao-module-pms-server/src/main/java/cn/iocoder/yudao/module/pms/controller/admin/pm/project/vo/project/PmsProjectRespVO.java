package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS item response.")
@Data
public class PmsProjectRespVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Website rewrite")
    private String name;

    @Schema(description = "Item status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Item Priority.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer level;

    @Schema(description = "Item Description.", example = "Finish the website frontend and backend rewrite")
    private String description;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean openStatus;

    @Schema(description = "Item Icon.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ep:folder")
    private String icon;

    @Schema(description = "Start time.")
    private LocalDateTime startTime;

    @Schema(description = "Due time.")
    private LocalDateTime endTime;

    @Schema(description = "Archived")
    private LocalDateTime archiveTime;

    @Schema(description = "Trashed at.")
    private LocalDateTime recycleTime;

    @Schema(description = "Recentaccesstime.")
    private LocalDateTime accessTime;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Creator code.", example = "1")
    private String creator;

    @Schema(description = "Creator Name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Item adminName list.")
    private List<String> adminNames;

    @Schema(description = "Item member quantity.", example = "5")
    private Integer memberCount;

    @Schema(description = "Not start work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long pendingWorkItemCount;

    @Schema(description = "In progress work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long processingWorkItemCount;

    @Schema(description = "Completed work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long completedWorkItemCount;

    @Schema(description = "Current user is not is item admin.", example = "true")
    private Boolean adminStatus;

    @Schema(description = "Whether the current user is a project owner.", example = "true")
    private Boolean ownerStatus;

    @Schema(description = "Current user is not is item member.", example = "true")
    private Boolean memberStatus;

    @Schema(description = "Whether the current user can leave the project.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean exitStatus;

    @Schema(description = "Current user is not can edit item business data.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean writeStatus;

    @Schema(description = "Current user is not already Favorite.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean favoriteStatus;

}
