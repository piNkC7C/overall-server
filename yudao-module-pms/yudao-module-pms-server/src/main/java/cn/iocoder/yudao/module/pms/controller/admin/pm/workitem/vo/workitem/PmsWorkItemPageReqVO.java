package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemLifecycleStatusEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemPriorityEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemStatusTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - PMS work item page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsWorkItemPageReqVO extends PageParam {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Work item type.", example = "3")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer type;

    @Schema(description = "Work item type list.", example = "[2, 3, 4]")
    private List<Integer> types;

    @Schema(description = "Work item title.", example = "Sign-in.")
    private String name;

    @Schema(description = "Semantic status", example = "1")
    @InEnum(PmsWorkItemStatusTypeEnum.class)
    private Integer status;

    @Schema(description = "Semantic status list.", example = "[1, 2]")
    private List<Integer> statuses;

    @Schema(description = "Priority", example = "2")
    @InEnum(PmsWorkItemPriorityEnum.class)
    private Integer priority;

    @Schema(description = "Priority list.", example = "[2, 3]")
    private List<Integer> priorities;

    @Schema(description = "Lifecycle: 1 normal, 2 archived, 3 trash.", example = "1")
    @InEnum(PmsWorkItemLifecycleStatusEnum.class)
    private Integer lifecycleStatus;

    @Schema(description = "Board status code.", example = "1024")
    private Long statusId;

    @Schema(description = "Sprint code.", example = "1024")
    private Long iterationId;

    @Schema(description = "Sprint code list.", example = "[1024, 2048]")
    private List<Long> iterationIds;

    @Schema(description = "Exclude sprint code list.", example = "[1024, 2048]")
    private List<Long> excludedIterationIds;

    @Schema(description = "Parent work item code.", example = "1024")
    private Long parentId;

    @Schema(description = "Tag code list.", example = "[1024, 2048]")
    private List<Long> labelIds;

    @Schema(description = "Whether to query only unplanned work items.", example = "true")
    private Boolean unplannedOnly;

    @Schema(description = "Backlog view. When true, only top-level work items are returned in plan order.", example = "true")
    private Boolean planningOnly;

    @Schema(description = "Whether to query only top-level work items.", example = "true")
    private Boolean rootOnly;

    @Schema(description = "Owner person user ID.", example = "1024")
    private Long assigneeUserId;

    @Schema(description = "Owner person user ID list.", example = "[1024, 2048]")
    private List<Long> assigneeUserIds;

}
