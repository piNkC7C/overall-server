package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.worklog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS work item time spent record response.")
@Data
public class PmsWorkItemWorkLogRespVO {

    @Schema(description = "Time spent record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long workItemId;

    @Schema(description = "Work item title.", example = "Complete sign-in interface.")
    private String workItemName;

    @Schema(description = "Actual hours, in hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private Integer actualHours;

    @Schema(description = "Remaining hours after this log.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "8")
    private Integer remainingHours;

    @Schema(description = "Time spent Notes.", example = "Finish sign-in API integration")
    private String description;

    @Schema(description = "Logged-by user ID.", example = "1")
    private Long creatorUserId;

    @Schema(description = "Logged-by name.", example = "Overall.")
    private String creatorUserName;

    @Schema(description = "Logged time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
