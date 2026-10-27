package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Schema(description = "PMS work-item activity response VO.")
@Data
@Accessors(chain = true)
public class PmsWorkItemActivityRespVO {

    @Schema(description = "Activity ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long workItemId;

    @Schema(description = "Action person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long operatorUserId;

    @Schema(description = "Action person Name.", example = "Overall.")
    private String operatorUserName;

    @Schema(description = "Action person Avatar.")
    private String operatorUserAvatar;

    @Schema(description = "Activity content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Updated the work item")
    private String content;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
