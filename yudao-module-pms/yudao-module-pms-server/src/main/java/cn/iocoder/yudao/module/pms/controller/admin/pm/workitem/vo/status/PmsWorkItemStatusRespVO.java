package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - PMS work item board status response.")
@Data
public class PmsWorkItemStatusRespVO {

    @Schema(description = "Status code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long projectId;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer workItemType;

    @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Not start.")
    private String name;

    @Schema(description = "Semantic status", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer statusType;

    @Schema(description = "StatusDescription.", example = "Stories split. Waiting for development")
    private String description;

    @Schema(description = "Board column name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Process.")
    private String boardName;

    @Schema(description = "Is not initial status.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean defaultStatus;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

}
